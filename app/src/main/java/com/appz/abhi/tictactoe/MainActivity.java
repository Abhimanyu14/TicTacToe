package com.appz.abhi.tictactoe;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView[] board;
    TextView textView1;
    Button button1;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;

    int[] arr;
    int mod;
    int loop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr = new int[10];
        board = new TextView[10];
        loop = 1;
        button1 = findViewById(R.id.button1);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        textView1 = findViewById(R.id.textView11);
        board[1] = findViewById(R.id.textView1);
        board[2] = findViewById(R.id.textView2);
        board[3] = findViewById(R.id.textView3);
        board[4] = findViewById(R.id.textView4);
        board[5] = findViewById(R.id.textView5);
        board[6] = findViewById(R.id.textView6);
        board[7] = findViewById(R.id.textView7);
        board[8] = findViewById(R.id.textView8);
        board[9] = findViewById(R.id.textView9);
        radioGroup = findViewById(R.id.radioGroup);

        for (int i = 1; i < 10; i++) {
            board[i].setEnabled(false);
        }

        for (int i = 1; i <= 9; i++) {
            board[i].setOnClickListener(this);
        }
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView1:
                if (arr[1] == 0) {
                    arr[1] = 1;
                    board[1].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView2:
                if (arr[2] == 0) {
                    arr[2] = 1;
                    board[2].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView3:
                if (arr[3] == 0) {
                    arr[3] = 1;
                    board[3].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView4:
                if (arr[4] == 0) {
                    arr[4] = 1;
                    board[4].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView5:
                if (arr[5] == 0) {
                    arr[5] = 1;
                    board[5].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView6:
                if (arr[6] == 0) {
                    arr[6] = 1;
                    board[6].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView7:
                if (arr[7] == 0) {
                    arr[7] = 1;
                    board[7].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView8:
                if (arr[8] == 0) {
                    arr[8] = 1;
                    board[8].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.textView9:
                if (arr[9] == 0) {
                    arr[9] = 1;
                    board[9].setText("X");
                    continue_move(view);
                }
                break;
            case R.id.button1:
                //  Reset board
                loop = 1;
                for (int i = 1; i < 10; i++) {
                    arr[i] = 0;
                    board[i].setText(" ");
                }
                textView1.setText(" ");
                for (int i = 1; i < 10; i++)
                    board[i].setEnabled(false);

                for (int i = 1; i < 10; i++)
                    board[i].setEnabled(true);
                if (radioGroup.getCheckedRadioButtonId() == radioButton2.getId())
                    makeMove(loop);
                break;
        }
    }

    public void continue_move(View view) {
        loop++;
        if (isCompleted() == 1) {
            textView1.setText("You Won");
            lock();
        } else if (isCompleted() == 2) {
            textView1.setText("System Won");
            lock();
        } else if (loop == 10) {
            textView1.setText("Game Draw");
            lock();
        }
        if (isCompleted() == -1) {
            makeMove(loop);
            if (isCompleted() == 1) {
                textView1.setText("You Won");
                lock();
            } else if (isCompleted() == 2) {
                textView1.setText("System Won");
                lock();
            } else if (loop == 10) {
                textView1.setText("Game Draw");
                lock();
            }
        }
    }

    public int isCompleted() {
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == arr[3 + i]) && (arr[i] != 0) && (arr[3 + i] != 0))
                if ((arr[i] == arr[6 + i]) && (arr[6 + i] != 0))
                    return arr[i];
        }
        for (int i = 1; i < 4; i++) {
            if ((arr[i * 3 - 2] == arr[i * 3 - 1]) && (arr[i * 3 - 2] != 0) && (arr[i * 3 - 1] != 0))
                if ((arr[i * 3 - 2] == arr[i * 3]) && (arr[i * 3] != 0))
                    return arr[i * 3 - 2];
        }
        if ((arr[1] == arr[5]) && (arr[1] != 0))
            if ((arr[1] == arr[9]))
                return arr[1];
        if ((arr[3] == arr[5]) && (arr[3] != 0))
            if ((arr[3] == arr[7]))
                return arr[3];
        return -1;
    }

    public void lock() {
        for (int i = 1; i < 10; i++)
            board[i].setEnabled(false);
    }

    public boolean makeWinningMove() {
        //      Column checking
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == 2) && (arr[3 + i] == 2) && (arr[6 + i] == 0)) {
                arr[6 + i] = 2;
                board[6 + i].setText("O");
                return true;
            } else if ((arr[i] == 2) && (arr[3 + i] == 0) && (arr[6 + i] == 2)) {
                arr[3 + i] = 2;
                board[3 + i].setText("O");
                return true;
            } else if ((arr[i] == 0) && (arr[3 + i] == 2) && (arr[6 + i] == 2)) {
                arr[i] = 2;
                board[i].setText("O");
                return true;
            }
        }
        //      Row checking
        for (int i = 1; i < 4; i++) {
            if ((arr[i * 3 - 2] == 2) && (arr[i * 3 - 1] == 2) && (arr[i * 3] == 0)) {
                arr[i * 3] = 2;
                board[i * 3].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 2) && (arr[i * 3 - 1] == 0) && (arr[i * 3] == 2)) {
                arr[i * 3 - 1] = 2;
                board[i * 3 - 1].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 0) && (arr[i * 3 - 1] == 2) && (arr[i * 3] == 2)) {
                arr[i * 3 - 2] = 2;
                board[i * 3 - 2].setText("O");
                return true;
            }
        }
        //      Diagonal checking
        if ((arr[1] == 2) && (arr[5] == 2) && (arr[9] == 0)) {
            arr[9] = 2;
            board[9].setText("O");
            return true;
        } else if ((arr[1] == 2) && (arr[5] == 0) && (arr[9] == 2)) {
            arr[5] = 2;
            board[5].setText("O");
            return true;
        } else if ((arr[1] == 0) && (arr[5] == 2) && (arr[9] == 2)) {
            arr[1] = 2;
            board[1].setText("O");
            return true;
        }
        if ((arr[3] == 2) && (arr[5] == 2) && (arr[7] == 0)) {
            arr[7] = 2;
            board[7].setText("O");
            return true;
        } else if ((arr[3] == 2) && (arr[5] == 0) && (arr[7] == 2)) {
            arr[5] = 2;
            board[5].setText("O");
            return true;
        } else if ((arr[3] == 0) && (arr[5] == 2) && (arr[7] == 2)) {
            arr[3] = 2;
            board[3].setText("O");
            return true;
        }
        return false;
    }

    public boolean makeSavingMove() {
        for (int i = 1; i < 4; i++) {
            if ((arr[i] == 1) && (arr[3 + i] == 1) && (arr[6 + i] == 0)) {
                arr[6 + i] = 2;
                board[6 + i].setText("O");
                return true;
            } else if ((arr[i] == 1) && (arr[3 + i] == 0) && (arr[6 + i] == 1)) {
                arr[3 + i] = 2;
                board[3 + i].setText("O");
                return true;
            } else if ((arr[i] == 0) && (arr[3 + i] == 1) && (arr[6 + i] == 1)) {
                arr[i] = 2;
                board[i].setText("O");
                return true;
            }
            if ((arr[i * 3 - 2] == 1) && (arr[i * 3 - 1] == 1) && (arr[i * 3] == 0)) {
                arr[i * 3] = 2;
                board[i * 3].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 1) && (arr[i * 3 - 1] == 0) && (arr[i * 3] == 1)) {
                arr[i * 3 - 1] = 2;
                board[i * 3 - 1].setText("O");
                return true;
            } else if ((arr[i * 3 - 2] == 0) && (arr[i * 3 - 1] == 1) && (arr[i * 3] == 1)) {
                arr[i * 3 - 2] = 2;
                board[i * 3 - 2].setText("O");
                return true;
            }
        }
        if ((arr[1] == 1) && (arr[5] == 1) && (arr[9] == 0)) {
            arr[9] = 2;
            board[9].setText("O");
            return true;
        } else if ((arr[1] == 1) && (arr[5] == 0) && (arr[9] == 1)) {
            arr[5] = 2;
            board[5].setText("O");
            return true;
        } else if ((arr[1] == 0) && (arr[5] == 1) && (arr[9] == 1)) {
            arr[1] = 2;
            board[1].setText("O");
            return true;
        }
        if ((arr[3] == 1) && (arr[5] == 1) && (arr[7] == 0)) {
            arr[7] = 2;
            board[7].setText("O");
            return true;
        } else if ((arr[3] == 1) && (arr[5] == 0) && (arr[7] == 1)) {
            arr[5] = 2;
            board[5].setText("O");
            return true;
        } else if ((arr[3] == 0) && (arr[5] == 1) && (arr[7] == 1)) {
            arr[3] = 2;
            board[3].setText("O");
            return true;
        }
        return false;
    }

    // Special moves
    public boolean makeMove1() {
        mod = (int) (Math.random() * 9);
        mod++;
        if ((arr[1] == 1) && (arr[9] == 1) && (arr[5] == 2)) {
            while (arr[mod] != 0 || (mod % 2 != 0)) {
                mod = (int) (Math.random() * 9);
            }
            arr[mod] = 2;
            board[mod].setText("O");
            return true;
        }
        if ((arr[3] == 1) && (arr[7] == 1) && (arr[5] == 2)) {
            while (arr[mod] != 0 || (mod % 2 != 0)) {
                mod = (int) (Math.random() * 9);
            }
            arr[mod] = 2;
            board[mod].setText("O");
            return true;
        }
        return false;
    }

    public boolean makeMove2() {
        mod = (int) (Math.random() * 9);
        mod++;
        if (((arr[2] == 2) || (arr[4] == 2) || (arr[6] == 2) || (arr[8] == 2)) && (arr[5] == 1)) {
            if ((arr[2] == 2))
                while (arr[mod] != 0 && mod != 8) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[4] == 2))
                while (arr[mod] != 0 && mod != 6) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[6] == 2))
                while (arr[mod] != 0 && mod != 4) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            else if ((arr[8] == 2))
                while (arr[mod] != 0 && mod != 2) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
            arr[mod] = 2;
            board[mod].setText("O");
            return true;
        }
        return false;
    }

    public void makeMove(int moveNo) {
        moveNo--;
        switch (moveNo) {
            case 0:
                mod = (int) (Math.random() * 9);
                mod++;
                arr[mod] = 2;
                board[mod].setText("O");
                loop++;
                break;
            case 1:
                mod = 5;
                while (arr[mod] != 0) {
                    mod = (int) (Math.random() * 9);
                    mod++;
                }
                arr[mod] = 2;
                board[mod].setText("O");
                loop++;
                break;
            case 2:
                if (!makeMove1()) {
                    if (!makeMove2()) {
                        mod = (int) (Math.random() * 9);
                        mod++;
                        while (arr[mod] != 0) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                        }
                        arr[mod] = 2;
                        board[mod].setText("O");
                    }
                }
                loop++;
                break;
            case 3:
                if (!makeWinningMove()) {
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            board[mod].setText("O");
                        }
                    }
                }
                loop++;
                break;
            case 4:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            board[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    textView1.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    textView1.setText("System Won");
                    lock();
                }
                loop++;
                break;
            case 5:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            board[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    textView1.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    textView1.setText("System Won");
                    lock();
                }
                loop++;
                break;
            case 6:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            board[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    textView1.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    textView1.setText("System Won");
                    lock();
                }
                loop++;
                break;
            case 7:
                if (!makeWinningMove())
                    if (!makeSavingMove()) {
                        if (!makeMove1()) {
                            mod = (int) (Math.random() * 9);
                            mod++;
                            while (arr[mod] != 0) {
                                mod = (int) (Math.random() * 9);
                                mod++;
                            }
                            arr[mod] = 2;
                            board[mod].setText("O");
                        }
                    }
                if (isCompleted() == 1) {
                    textView1.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    textView1.setText("System Won");
                    lock();
                }
                loop++;
                break;
            case 8:
                for (int i = 1; i < 10; i++)
                    if (arr[i] == 0) {
                        arr[i] = 2;
                        board[i].setText("O");
                    }
                if (isCompleted() == 1) {
                    textView1.setText("You Won");
                    lock();
                } else if (isCompleted() == 2) {
                    textView1.setText("System Won");
                    lock();
                } else {
                    textView1.setText("Game Draw");
                    lock();
                }
                loop++;
                break;
        }
    }
}
//  1 - User    2 - CPU
