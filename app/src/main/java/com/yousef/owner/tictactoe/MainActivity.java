package com.yousef.owner.tictactoe;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton restartBtn;
    ImageButton[][] imageButtons = new ImageButton[4][4];
    boolean turn = true;
    int count;
    String btnID = "";
    private View decoreView;
//Yousef
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideAppbarAndNav();
        restartBtn = findViewById(R.id.restart);
        restartBtn.setVisibility(View.INVISIBLE);
        try {
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    btnID = "btn" + i + j;
                    int resID = getResources().getIdentifier(btnID, "id", getPackageName());
                    imageButtons[i][j] = findViewById(resID);
                    imageButtons[i][j].setOnClickListener(this);

                }
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error Loop", Toast.LENGTH_SHORT).show();
        }


    }


    //Start Hide appBar and Nav
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decoreView.setSystemUiVisibility(hideSystemBar());
        }
    }

    private int hideSystemBar() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    private void HideAppbarAndNav() {
        decoreView = getWindow().getDecorView();
        decoreView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0)
                    decoreView.setSystemUiVisibility(hideSystemBar());
            }
        });
    }

    @Override
    public void onClick(View view) {
//        if (imageButtons[3][3].getBackground() == null) {
//            Toast.makeText(getApplicationContext(), "empty", Toast.LENGTH_SHORT).show();
//
//        }else {
//            Toast.makeText(getApplicationContext(), "not empty", Toast.LENGTH_SHORT).show();
//
//        }

        if(turn){
            ((ImageButton) view).setBackgroundResource(R.drawable.x);

        }else {
            ((ImageButton) view).setBackgroundResource(R.drawable.o);
        }
        turn=!turn;
    }
    //End Hide appBar and Nav
}
