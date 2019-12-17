package com.yousef.owner.tictactoe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;
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
    TextView win;
    int forDraw = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HideAppbarAndNav();
        restartBtn = findViewById(R.id.restart);
        //restartBtn.setVisibility(View.INVISIBLE);
        win = findViewById(R.id.textView);
        one = findViewById(R.id.btn11);
        two = findViewById(R.id.btn12);
        three = findViewById(R.id.btn13);
        four = findViewById(R.id.btn21);
        five = findViewById(R.id.btn22);
        six = findViewById(R.id.btn23);
        seven = findViewById(R.id.btn31);
        eight = findViewById(R.id.btn32);
        nine = findViewById(R.id.btn33);
        btnX(seven);
        seven.setEnabled(false);
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
                turn = true;
                count = 1;
                int secs = 1; // Delay in seconds
                win.setText("");
                Utils.delay(secs, new Utils.DelayCallback() {
                    @Override
                    public void afterDelay() {
                        // Do something after delay
                        forDraw = 1;
                        btnX(seven);
                        seven.setEnabled(false);
                    }
                });


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
        playerTurn(one);
    }

    public void btn2(View view) {
        playerTurn(two);
    }

    public void btn3(View view) {
        playerTurn(three);

    }

    public void btn4(View view) {
        playerTurn(four);

    }

    public void btn5(View view) {
        playerTurn(five);

    }

    public void btn6(View view) {
        playerTurn(six);

    }

    public void btn7(View view) {
        playerTurn(seven);


    }

    public void btn8(View view) {
        playerTurn(eight);

    }

    public void btn9(View view) {
        playerTurn(nine);

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
                        seven.getText().toString().equals("O")) {
            win.setText("You Win");
            one.setEnabled(false);
            two.setEnabled(false);
            three.setEnabled(false);
            four.setEnabled(false);
            five.setEnabled(false);
            six.setEnabled(false);
            seven.setEnabled(false);
            eight.setEnabled(false);
            nine.setEnabled(false);

        } else if (one.getText().toString().equals("X") &&
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

            win.setText("Computer Win");
            one.setEnabled(false);
            two.setEnabled(false);
            three.setEnabled(false);
            four.setEnabled(false);
            five.setEnabled(false);
            six.setEnabled(false);
            seven.setEnabled(false);
            eight.setEnabled(false);
            nine.setEnabled(false);

        }

        forDraw++;
        if (forDraw == 9) {
            win.setText("Draw");
        }
    }

    public void playerTurn(Button btn) {

        if (!turn) {
            btn.setText("O");
            btn.setBackgroundResource(R.drawable.o);
            turn = true;
        }
        computerTurn();
        rules();

        btn.setEnabled(false);
    }

    public void btnX(Button btn) {
        btn.setText("X");
        btn.setBackgroundResource(R.drawable.x);
        btn.setEnabled(false);
        turn = false;
    }

    int count = 1;

    public void computerTurn() {
        //Check if X win
        //1+2=3
        if (one.getText().toString().equals("X") &&
                two.getText().toString().equals("X") &&
                three.getText().toString().equals("")) {
            btnX(three);
        }
        //1+3=2
        else if (one.getText().toString().equals("X") &&
                three.getText().toString().equals("X") &&
                two.getText().toString().equals("")) {
            btnX(two);
        }//3+2=1
        else if (two.getText().toString().equals("X") &&
                three.getText().toString().equals("X") &&
                one.getText().toString().equals("")) {
            btnX(one);
        }//1+4=7
        else if (one.getText().toString().equals("X") &&
                four.getText().toString().equals("X") &&
                seven.getText().toString().equals("")) {
            btnX(seven);
        }//4+7=1
        else if (four.getText().toString().equals("X") &&
                seven.getText().toString().equals("X") &&
                one.getText().toString().equals("")) {
            btnX(one);
        }//1+7=3
        else if (one.getText().toString().equals("X") &&
                seven.getText().toString().equals("X") &&
                four.getText().toString().equals("")) {
            btnX(four);
        }//2+5=8
        else if (two.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                eight.getText().toString().equals("")) {
            btnX(eight);
        }//2+8=5
        else if (two.getText().toString().equals("X") &&
                eight.getText().toString().equals("X") &&
                five.getText().toString().equals("")) {
            btnX(five);
        }//8+5=2
        else if (eight.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                two.getText().toString().equals("")) {
            btnX(two);
        }
        //3+6=9
        else if (three.getText().toString().equals("X") &&
                six.getText().toString().equals("X") &&
                nine.getText().toString().equals("")) {
            btnX(nine);
        }//3+9=6
        else if (three.getText().toString().equals("X") &&
                nine.getText().toString().equals("X") &&
                six.getText().toString().equals("")) {
            btnX(six);
        }//9+6=3
        else if (nine.getText().toString().equals("X") &&
                six.getText().toString().equals("X") &&
                three.getText().toString().equals("")) {
            btnX(three);
        }
        //4+5=6
        else if (four.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                six.getText().toString().equals("")) {
            btnX(six);
        }
        //9+6=3
        else if (nine.getText().toString().equals("X") &&
                six.getText().toString().equals("X") &&
                three.getText().toString().equals("")) {
            btnX(three);
        }
        //5+6=4
        else if (five.getText().toString().equals("X") &&
                six.getText().toString().equals("X") &&
                four.getText().toString().equals("")) {
            btnX(four);
        }
        //4+6=5
        else if (four.getText().toString().equals("X") &&
                six.getText().toString().equals("X") &&
                five.getText().toString().equals("")) {
            btnX(three);
        }
        //7+8=9
        else if (seven.getText().toString().equals("X") &&
                eight.getText().toString().equals("X") &&
                nine.getText().toString().equals("")) {
            btnX(nine);
        }
        //7+9=8
        else if (seven.getText().toString().equals("X") &&
                nine.getText().toString().equals("X") &&
                eight.getText().toString().equals("")) {
            btnX(eight);
        }
        //9+8=7
        else if (nine.getText().toString().equals("X") &&
                eight.getText().toString().equals("X") &&
                seven.getText().toString().equals("")) {
            btnX(seven);
        }
        //3+5=7
        else if (three.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                seven.getText().toString().equals("")) {
            btnX(seven);
        }
        //3+7=5
        else if (three.getText().toString().equals("X") &&
                seven.getText().toString().equals("X") &&
                five.getText().toString().equals("")) {
            btnX(five);
        }//7+5=3
        else if (seven.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                three.getText().toString().equals("")) {
            btnX(three);
        }//1+5=9
        else if (one.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                nine.getText().toString().equals("")) {
            btnX(nine);
        }
        //1+9=5
        else if (one.getText().toString().equals("X") &&
                nine.getText().toString().equals("X") &&
                five.getText().toString().equals("")) {
            btnX(five);
        }
        //9+5=1
        else if (nine.getText().toString().equals("X") &&
                five.getText().toString().equals("X") &&
                one.getText().toString().equals("")) {
            btnX(one);
        } else {

            //First step
            if (count == 1) {
                if (five.getText().toString().equals("O") ||
                        nine.getText().toString().equals("O") ||
                        eight.getText().toString().equals("O") ||
                        one.getText().toString().equals("O") ||
                        two.getText().toString().equals("O") ||
                        four.getText().toString().equals("O") ||
                        six.getText().toString().equals("O")) {
                    btnX(three);
                } else {
                    btnX(one);
                }

                count++;
            }

            //end first step
            // second step
            else if (count == 2) {
                //1+2
                if (one.getText().toString().equals("O") && two.getText().toString().equals("O")
                        && three.getText().toString().equals("")) {
                    btnX(three);
                }
                //1+3
                else if (one.getText().toString().equals("O") && three.getText().toString().equals("O")
                        && two.getText().toString().equals("")) {
                    btnX(two);
                }
                //1+4
                else if (one.getText().toString().equals("O") && four.getText().toString().equals("O")
                        && seven.getText().toString().equals("")) {
                    btnX(seven);
                }
                //1+5
                else if (one.getText().toString().equals("O") && five.getText().toString().equals("O")
                        && nine.getText().toString().equals("")) {
                    btnX(nine);
                } else if (two.getText().toString().equals("O") && five.getText().toString().equals("O")
                        && eight.getText().toString().equals("")) {
                    btnX(eight);
                }
                //6+5
                else if (six.getText().toString().equals("O") && five.getText().toString().equals("O")
                        && four.getText().toString().equals("")) {
                    btnX(four);
                }
                //4+5
                else if (four.getText().toString().equals("O") && five.getText().toString().equals("O")
                        && six.getText().toString().equals("")) {
                    btnX(six);
                }
                //7+8
                else if (seven.getText().toString().equals("O") && eight.getText().toString().equals("O")
                        && nine.getText().toString().equals("")) {
                    btnX(nine);
                }
                //7+3
                else if (seven.getText().toString().equals("O") && three.getText().toString().equals("O")
                        && five.getText().toString().equals("")) {
                    btnX(five);
                }
                //6+3
                else if (six.getText().toString().equals("O") && three.getText().toString().equals("O")
                        && nine.getText().toString().equals("")) {
                    btnX(nine);
                }
                //7+9
                else if (seven.getText().toString().equals("O") && nine.getText().toString().equals("O")
                        && eight.getText().toString().equals("")) {
                    btnX(eight);
                }
                //1+9
                else if (one.getText().toString().equals("O") && nine.getText().toString().equals("O")
                        && five.getText().toString().equals("")) {
                    btnX(five);
                }
                //1+7
                else if (one.getText().toString().equals("O") && seven.getText().toString().equals("O")
                        && four.getText().toString().equals("")) {
                    btnX(four);
                }
                //2+8
                else if (two.getText().toString().equals("O") && eight.getText().toString().equals("O")
                        && five.getText().toString().equals("")) {
                    btnX(five);
                }
                //3+9
                else if (three.getText().toString().equals("O") && nine.getText().toString().equals("O")
                        && six.getText().toString().equals("")) {
                    btnX(six);
                }
                //5+9
                else if (five.getText().toString().equals("O") && nine.getText().toString().equals("O")
                        && one.getText().toString().equals("")) {
                    btnX(one);
                }
                //5+3
                else if (five.getText().toString().equals("O") && three.getText().toString().equals("O")
                        && seven.getText().toString().equals("")) {
                    btnX(seven);
                }

                //5+8
                else if (five.getText().toString().equals("O") && eight.getText().toString().equals("O")
                        && two.getText().toString().equals("")) {
                    btnX(two);
                }
                //3+9
                else if (three.getText().toString().equals("O") && four.getText().toString().equals("O")
                        && nine.getText().toString().equals("")) {
                    btnX(nine);
                }
                //5+7
                else if (five.getText().toString().equals("O") && seven.getText().toString().equals("O")
                ) {
                    if (three.getText().toString().equals("")) {
                        btnX(three);
                    } else if (nine.getText().toString().equals("")) {
                        btnX(nine);
                    }

                }
            }


        }
        rules();

    }


}

class Utils {

    // Delay mechanism

    public interface DelayCallback {
        void afterDelay();
    }

    public static void delay(int secs, final DelayCallback delayCallback) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, secs * 1000); // afterDelay will be executed after (secs*1000) milliseconds.
    }
}