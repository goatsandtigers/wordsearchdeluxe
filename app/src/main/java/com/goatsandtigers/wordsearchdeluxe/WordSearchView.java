package com.goatsandtigers.wordsearchdeluxe;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordSearchView extends GridLayout {

    private WordSearchModel model;
    private List<Point> touchPoints = Collections.emptyList();
    private List<List<Point>> foundWordLines = new ArrayList<>();
    private Paint userDragLinePaint = buildUserDragLinePaint();
    private int letterWidth;
    private int letterHeight;

    public WordSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        newGame();
    }

    public void newGame() {
        updateBackgroundForCategory();
        touchPoints.clear();
        foundWordLines.clear();
        removeAllViews();

        int numCols = getNumCols();
        int numRows = getNumRows();
        model = new WordSearchModel(numCols, numRows, WordList.loadWords(getContext()));
        setColumnCount(numCols);
        setRowCount(numRows);
        removeAllViews();
        boolean isTablet = WordsToFindView.isTablet(getContext());
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                char letter = model.getCellContents(i, j);
                TextView letterView = buildLetterView(letter, isTablet);
                addView(letterView);
            }
        }
        setLetterViewSizes();
        invalidate();
    }

    private void updateBackgroundForCategory() {
        WordList category = WordList.getCategory(getContext());
        int backgroundId = WordList.getCategoryDrawable(category);
        setBackgroundResource(backgroundId);
        getBackground().setAlpha(120);
    }

    private TextView buildLetterView(char letter, boolean isTablet) {
        String text = String.valueOf(letter);
        TextView tv = new TextView(getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, isTablet ? 48 : 72);
        tv.setText(text);
        return tv;
    }

    private int getNumCols() {
        return 10;
    }

    private int getNumRows() {
        return 10;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() ==  MotionEvent.ACTION_DOWN) {
            touchPoints = new ArrayList<>();
            touchPoints.add(new Point((int) event.getX(), (int) event.getY()));
            invalidate();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            touchPoints.add(new Point((int) event.getX(), (int) event.getY()));
            invalidate();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            Point wordStart = convertScreenPosToGridCoords(touchPoints.get(0));
            Point wordEnd = convertScreenPosToGridCoords(new Point((int) event.getX(), (int) event.getY()));
            String selectedWord = model.getWordBetweenPoints(wordStart, wordEnd);
            if (selectedWord != null) {
                foundWordLines.add(new ArrayList<Point>(touchPoints));
                ((MainActivity) getContext()).onWordFound(selectedWord);
            } else {
                touchPoints.clear();
            }
            invalidate();
        }
        return true;
    }

    private Point convertScreenPosToGridCoords(Point p) {
        int colWidth = getWidth() / getNumCols();
        int rowHeight = getHeight() / getNumRows();
        int x = p.x / colWidth;
        int y = p.y / rowHeight;
        return new Point(x, y);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawLines(canvas, touchPoints);
        for (List<Point> foundWordLine : foundWordLines) {
            drawLines(canvas, foundWordLine);
        }
    }

    private void drawLines(Canvas canvas, List<Point> points) {
        if (points.size() < 2) {
            return;
        }
        for (int i = 0; i < points.size() - 1; i++) {
            Point start = points.get(i);
            Point end = points.get(i + 1);
            canvas.drawLine(start.x, start.y, end.x, end.y, userDragLinePaint);
        }
    }

    private Paint buildUserDragLinePaint() {
        Paint paint = new Paint(0);
        paint.setStrokeWidth(5);
        return paint;
    }

    public List<String> getWords() {
        return model.getWords();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        letterWidth = w / getNumCols();
        letterHeight = h / getNumRows();
        setLetterViewSizes();
    }

    private void setLetterViewSizes() {
        populateLetterWidthAndHeight();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child instanceof TextView) {
                TextView tv = (TextView) child;
                ViewGroup.LayoutParams lp = tv.getLayoutParams();
                lp.width = letterWidth;
                lp.height = letterHeight;
            }
        }
    }

    private void populateLetterWidthAndHeight() {
        if (letterWidth == 0 || letterHeight == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int width = displayMetrics.widthPixels;
            int height = displayMetrics.heightPixels;
            height *= getWordSearchViewLayoutWeight();
            letterWidth = width / getNumCols();
            letterHeight = height / getNumRows();
        }
    }

    private double getWordSearchViewLayoutWeight() {
        return 0.7;
    }
}
