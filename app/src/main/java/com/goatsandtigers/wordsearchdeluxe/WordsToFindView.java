package com.goatsandtigers.wordsearchdeluxe;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.List;

public class WordsToFindView extends GridLayout {

    public WordsToFindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setWords(List<String> words) {
        populate(words);
    }

    private void populate(List<String> words) {
        removeAllViews();
        int numCols = 3;
        int numRows = Math.round(words.size() / numCols);
        setColumnCount(numCols);
        setRowCount(numRows);
        boolean isTablet = isTablet(getContext());
        for (String word : words) {
            addView(buildTextView(word, isTablet));
        }
    }

    private TextView buildTextView(String word, boolean isTablet) {
        TextView tv = new TextView(getContext());
        tv.setText(word);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, isTablet ? 32 : 56);
        tv.setPadding(0, 0, 40, 0);
        return tv;
    }

    public void strikeOutWord(String word) {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                if (tv.getText().equals(word)) {
                    tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
            }
        }
    }

    public boolean isSolved() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                TextView tv = (TextView) view;
                if ((tv.getPaintFlags() & Paint.STRIKE_THRU_TEXT_FLAG) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isTablet(Context context) {
        try {
            // Compute screen size
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            float screenWidth = dm.widthPixels / dm.xdpi;
            float screenHeight = dm.heightPixels / dm.ydpi;
            double size = Math.sqrt(Math.pow(screenWidth, 2) + Math.pow(screenHeight, 2));

            // Tablet devices should have a screen size greater than 6 inches
            return size >= 6;
        } catch (Throwable t) {
            return false;
        }
    }
}
