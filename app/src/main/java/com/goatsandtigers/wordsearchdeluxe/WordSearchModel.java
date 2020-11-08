package com.goatsandtigers.wordsearchdeluxe;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchModel {

    private static final char EMPTY_CELL = '_';
    private static final char INVALID_CELL_COORDINATES = '-';

    private int width;
    private int height;
    private char[][] letters;
    private Map<String, WordBounds> wordBounds = new HashMap<>();

    public WordSearchModel(int width, int height, List<String> possibleWords) {
        this.width = width;
        this.height = height;
        Collections.shuffle(possibleWords);
        randomlyPopulateGrid(possibleWords);
        fillInGaps();
    }

    private void randomlyPopulateGrid(List<String> possibleWords) {
        letters = buildEmptyGrid();
        wordBounds = new HashMap<>();
        for (String word : possibleWords) {
            addWord(word);
        }
    }

    private char[][] buildEmptyGrid() {
        char[][] emptyGrid = new char[width][height];
        for (char[] row: emptyGrid)
            Arrays.fill(row, EMPTY_CELL);
        return emptyGrid;
    }

    private void addWord(String word) {
        int startX = (int)(Math.random() * width);
        int startY = (int)(Math.random() * height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int x = (i + startX) % width;
                int y = (j + startY) % height;
                WordBounds addedWordBounds = addWordAtPosition(word, x, y);
                if (addedWordBounds != null) {
                    wordBounds.put(word, addedWordBounds);
                    return;
                }
            }
        }
    }

    private WordBounds addWordAtPosition(String word, int startX, int startY) {
        next_direction:
        for (Direction direction : Direction.directionsInRandomOrder()) {
            for (int i = 0; i < word.length(); i++) {
                int x = startX + (i * direction.dx);
                int y = startY + (i * direction.dy);
                char letterAtPos = getCellContents(x, y);
                if (letterAtPos != EMPTY_CELL && letterAtPos != word.charAt(i)) {
                    continue next_direction;
                }
            }
            for (int i = 0; i < word.length(); i++) {
                int x = startX + (i * direction.dx);
                int y = startY + (i * direction.dy);
                letters[x][y] = word.charAt(i);
            }
            Point start = new Point(startY, startX);
            Point end = new Point(startY + (direction.dy * (word.length() - 1)), startX + (direction.dx * (word.length() - 1)));
            return new WordBounds(start, end);
        }
        return null;
    }

    public char getCellContents(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return INVALID_CELL_COORDINATES;
        } else {
            return letters[x][y];
        }
    }

    private enum Direction {

        UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

        public final int dx, dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public static List<Direction> directionsInRandomOrder() {
            List<Direction> directionsInRandomOrder = new ArrayList<>(Arrays.asList(Direction.values()));
            Collections.shuffle(directionsInRandomOrder);
            return directionsInRandomOrder;
        }
    }

    private class WordBounds {

        private Point start;
        private Point end;

        public WordBounds(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

    }

    private void fillInGaps() {
        for (int i = 0; i < width; i++) {
            for (int j =0 ; j < height; j++) {
                if (letters[i][j] == EMPTY_CELL) {
                    letters[i][j] = (char) ('A' + (char) (Math.random() * 26));
                }
            }
        }
    }

    public List<String> getWords() {
        List<String> words = new ArrayList<>(wordBounds.keySet());
        Collections.sort(words);
        return words;
    }

    public String getWordBetweenPoints(Point start, Point end) {
        for (Map.Entry<String, WordBounds> entry : wordBounds.entrySet()) {
            if ((entry.getValue().start.equals(start) && entry.getValue().end.equals(end)) ||
                    (entry.getValue().start.equals(end) && entry.getValue().end.equals(start))) {
                return entry.getKey();
            }
        }
        return null;
    }
}
