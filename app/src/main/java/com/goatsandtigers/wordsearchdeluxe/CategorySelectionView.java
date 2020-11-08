package com.goatsandtigers.wordsearchdeluxe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategorySelectionView extends LinearLayout {

    private final CategorySelectionViewListener listener;

    public CategorySelectionView(Context context, CategorySelectionViewListener listener) {
        super(context);
        this.listener = listener;
        setPadding(20, 20, 20, 20);
        setOrientation(VERTICAL);
        for (WordList category : WordList.values()) {
            addView(buildRow(category));
        }
    }

    private LinearLayout buildRow(WordList category) {
        LinearLayout row = new LinearLayout(getContext());
        row.setPadding(0, 0, 20, 0);
        row.addView(buildCategoryImageView(category));
        row.addView(buildCategoryTextView(category));
        return row;
    }

    private TextView buildCategoryTextView(WordList category) {
        TextView label = new TextView(getContext());
        label.setText(category.getDisplayText());
        label.setTextSize(28);
        label.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCategorySelected(category);
            }
        });
        return label;
    }

    private ImageView buildCategoryImageView(WordList category) {
        ImageView imageView = new ImageView(getContext());
        int drawableId = WordList.getCategoryDrawable(category);
        imageView.setImageResource(drawableId);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
        return imageView;
    }

    public interface CategorySelectionViewListener {
        void onCategorySelected(WordList category);
    }
}
