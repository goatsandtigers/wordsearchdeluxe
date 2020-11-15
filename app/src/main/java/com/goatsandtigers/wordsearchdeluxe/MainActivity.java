package com.goatsandtigers.wordsearchdeluxe;

import static com.goatsandtigers.wordsearchdeluxe.CategorySelectionView.CategorySelectionViewListener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            loadAd();
        } catch (Exception ignore) {
        }
        resizeComponentsOnLayout();
    }

    private void loadAd() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void resizeComponentsOnLayout() {
        onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                getWordsToFindView().post(new Runnable() {
                    @Override
                    public void run() {
                        updateWordsToFind();
                        newGame();
                        if (Build.VERSION.SDK_INT < 16) {
                            getWordsToFindView().getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListener);
                        } else {
                            getWordsToFindView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
                        }
                    }
                });
            }
        };
        getWordsToFindView().getViewTreeObserver().addOnGlobalLayoutListener (onGlobalLayoutListener);
    }

    private void updateWordsToFind() {
        List<String> words = getWordSearchView().getWords();
        getWordsToFindView().setWords(words);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.new_game) {
            confirmNewGame();
            return true;
        } else if (id == R.id.choose_category) {
            showChooseCategoryDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void confirmNewGame() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Generate a new puzzle?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        newGame();
                    }
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void newGame() {
        getWordSearchView().newGame();
        updateWordsToFind();
    }

    private WordSearchView getWordSearchView() {
        return findViewById(R.id.wordSearchView);
    }

    private WordsToFindView getWordsToFindView() {
        return findViewById(R.id.wordsToFindView);
    }

    private void showChooseCategoryDialog() {
        CategorySelectionView categorySelectionView = new CategorySelectionView(this, new CategorySelectionViewListener() {
            @Override
            public void onCategorySelected(WordList category) {
                WordList.setCategory(MainActivity.this, category);
                newGame();
            }
        });
        new AlertDialog.Builder(this)
                .setView(categorySelectionView)
                .setNegativeButton("Close", null)
                .show();
    }

    private void chooseCategory() {

    }

    public void onWordFound(String word) {
        strikeOutWord(word);
        if (getWordsToFindView().isSolved()) {
            showVictoryMsg();
        }
    }

    private void strikeOutWord(String word) {
        getWordsToFindView().strikeOutWord(word);
    }

    private void showVictoryMsg() {
        String title = "Well done!";
        String msg = "All words found.";
        int iconId = WordList.getCategoryDrawable(WordList.getCategory(this));
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("New game", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        newGame();
                    }
                })
                .setIcon(iconId)
                .show();
    }
}
