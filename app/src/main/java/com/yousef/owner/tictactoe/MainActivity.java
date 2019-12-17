package com.yousef.owner.tictactoe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button restartBtn;
    private View decoreView;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Boolean turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideAppbarAndNav();
        restartBtn = findViewById(R.id.restart);
        //restartBtn.setVisibility(View.INVISIBLE);

        one = findViewById(R.id.btn11);
        two = findViewById(R.id.btn12);
        three = findViewById(R.id.btn13);
        four = findViewById(R.id.btn21);
        five = findViewById(R.id.btn22);
        six = findViewById(R.id.btn23);
        seven = findViewById(R.id.btn31);
        eight = findViewById(R.id.btn32);
        nine = findViewById(R.id.btn33);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset(one);
                reset(two);
                reset(three);
                reset(four);
                reset(five);
                reset(six);
                reset(seven);
                reset(eight);
                reset(nine);

            }
        });

    }

    public void reset(Button btn) {
        btn.setText("");
        btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn.setEnabled(true);
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

    //End Hide appBar and Nav


    public void btn1(View view) {
        if (turn == true) {
            one.setText("O");
            one.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            one.setText("X");
            one.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        one.setEnabled(false);
    }

    public void btn2(View view) {
        if (turn == true) {
            two.setText("O");
            turn = false;
            two.setBackgroundResource(R.drawable.o);

        } else {
            two.setText("X");
            two.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        two.setEnabled(false);

    }

    public void btn3(View view) {
        if (turn == true) {
            three.setText("O");
            three.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            three.setText("X");
            three.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        three.setEnabled(false);

    }

    public void btn4(View view) {
        if (turn == true) {
            four.setText("O");
            four.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            four.setText("X");
            four.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        four.setEnabled(false);

    }

    public void btn5(View view) {
        if (turn == true) {
            five.setText("O");
            five.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            five.setText("X");
            five.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        five.setEnabled(false);

    }

    public void btn6(View view) {
        if (turn == true) {
            six.setText("O");
            six.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            six.setText("X");
            six.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        six.setEnabled(false);

    }

    public void btn7(View view) {
        if (turn == true) {
            seven.setText("O");
            seven.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            seven.setText("X");
            seven.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        seven.setEnabled(false);


    }

    public void btn8(View view) {
        if (turn == true) {
            eight.setText("O");
            eight.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            eight.setText("X");
            eight.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        eight.setEnabled(false);

    }

    public void btn9(View view) {
        if (turn == true) {
            nine.setText("O");
            nine.setBackgroundResource(R.drawable.o);
            turn = false;
        } else {
            nine.setText("X");
            nine.setBackgroundResource(R.drawable.x);
            turn = true;
        }
        rules();
        nine.setEnabled(false);

    }

    public void rules() {
        if (one.getText().toString().equals("O") &&
                two.getText().toString().equals("O") &&
                three.getText().toString().equals("O") ||
                four.getText().toString().equals("O") &&
                        five.getText().toString().equals("O") &&
                        six.getText().toString().equals("O") ||
                seven.getText().toString().equals("O") &&
                        eight.getText().toString().equals("O") &&
                        nine.getText().toString().equals("O") ||
                one.getText().toString().equals("O") &&
                        four.getText().toString().equals("O") &&
                        seven.getText().toString().equals("O") ||
                two.getText().toString().equals("O") &&
                        five.getText().toString().equals("O") &&
                        eight.getText().toString().equals("O") ||
                three.getText().toString().equals("O") &&
                        six.getText().toString().equals("O") &&
                        nine.getText().toString().equals("O") ||
                one.getText().toString().equals("O") &&
                        five.getText().toString().equals("O") &&
                        nine.getText().toString().equals("O") ||
                three.getText().toString().equals("O") &&
                        five.getText().toString().equals("O") &&
                        seven.getText().toString().equals("O") ||


                one.getText().toString().equals("X") &&
                        two.getText().toString().equals("X") &&
                        three.getText().toString().equals("X") ||
                four.getText().toString().equals("X") &&
                        five.getText().toString().equals("X") &&
                        six.getText().toString().equals("X") ||
                seven.getText().toString().equals("X") &&
                        eight.getText().toString().equals("X") &&
                        nine.getText().toString().equals("X") ||
                one.getText().toString().equals("X") &&
                        four.getText().toString().equals("X") &&
                        seven.getText().toString().equals("X") ||
                two.getText().toString().equals("X") &&
                        five.getText().toString().equals("X") &&
                        eight.getText().toString().equals("X") ||
                three.getText().toString().equals("X") &&
                        six.getText().toString().equals("X") &&
                        nine.getText().toString().equals("X") ||
                one.getText().toString().equals("X") &&
                        five.getText().toString().equals("X") &&
                        nine.getText().toString().equals("X") ||
                three.getText().toString().equals("X") &&
                        five.getText().toString().equals("X") &&
                        seven.getText().toString().equals("X")) {
            Toast.makeText(getApplicationContext(), "YOU WIN", Toast.LENGTH_LONG).show();
        }
    }
}
