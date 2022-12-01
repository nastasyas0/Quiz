package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class GameLevels extends AppCompatActivity {
    int counter = 0;//общий счётчик правильных ответов

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Команда для кнопки "Назад"
                try{
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
            }
        });

        Intent intent0 = getIntent();//переданный параметр из другой activity
        boolean[] b = intent0.getBooleanArrayExtra("b");//массив для управления ограничением кнопок

        // Кнопка для перехода на 1 уровень викторины - начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[0]){
                        String name = "rus_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });

        // Кнопка для перехода на 2 уровень викторины - конец
        // Кнопка для перехода на 2 уровень викторины - начало
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[1]){
                        String name = "rus_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 2 уровень викторины - конец
        // Кнопка для перехода на 3 уровень викторины - начало
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[2]){
                        String name = "rus_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 3 уровень викторины - конец
        // Кнопка для перехода на 4 уровень викторины - начало
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[3]){
                        String name = "rus_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 4 уровень викторины - конец

        //новый предмет математика
        // Кнопка для перехода на 5 уровень викторины - начало
        TextView textView5 = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[4]){
                        String name = "math_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 5 уровень викторины - конец

        // Кнопка для перехода на 6 уровень викторины - начало
        TextView textView6 = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[5]){
                        String name = "math_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 6 уровень викторины - конец

        // Кнопка для перехода на 7 уровень викторины - начало
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[6]){
                        String name = "math_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 7 уровень викторины - конец

        // Кнопка для перехода на 8 уровень викторины - начало
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (b[7]) {
                        String name = "math_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 8 уровень викторины - конец
        //новый предмет информатика

        // Кнопка для перехода на 9 уровень викторины - начало
        TextView textView9 = (TextView)findViewById(R.id.textView9);
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[8]){
                        String name = "inf_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 9 уровень викторины - конец
        // Кнопка для перехода на 10 уровень викторины - начало
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[9]){
                        String name = "inf_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 10 уровень викторины - конец
        // Кнопка для перехода на 11 уровень викторины - начало
        TextView textView11 = (TextView)findViewById(R.id.textView11);
        textView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[10]){
                        String name = "inf_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 11 уровень викторины - конец
        // Кнопка для перехода на 12 уровень викторины - начало
        TextView textView12 = (TextView)findViewById(R.id.textView12);
        textView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[11]){
                        String name = "inf_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 12 уровень викторины - конец
        //новый предмет английский
        // Кнопка для перехода на 13 уровень викторины - начало
        TextView textView13 = (TextView)findViewById(R.id.textView13);
        textView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[12]){
                        String name = "eng_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 13 уровень викторины - конец
        // Кнопка для перехода на 14 уровень викторины - начало
        TextView textView14 = (TextView)findViewById(R.id.textView14);
        textView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[13]){
                        String name = "eng_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 14 уровень викторины - конец

        // Кнопка для перехода на 15 уровень викторины - начало
        TextView textView15 = (TextView)findViewById(R.id.textView15);
        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[14]){
                        String name = "eng_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 15 уровень викторины - конец
        // Кнопка для перехода на 16 уровень викторины - начало
        TextView textView16 = (TextView)findViewById(R.id.textView16);
        textView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b[15]){
                        String name = "eng_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
                        intent.putExtra("b",b);
                        startActivity(intent);
                        finish();
                    }
                    else getMessage();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для перехода на 16 уровень викторины - конец

        // Кнопка для завершения викторины - начало
        Button button_finish_game = (Button)findViewById(R.id.button_finish_game);
        button_finish_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, Results.class);
                    intent.putExtra("counter",counter);
                    startActivity(intent);finish();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для завершения викторины - конец

        getCounter();
    }
    public void getCounter(){
        Intent intent1 = getIntent();//переданный параметр из другой activity счётчик правильных ответов
        counter = intent1.getIntExtra("counter",0);
        String new_name = intent1.getStringExtra("new_name");
        }

    // Системная кнопка "Назад" - начало
    // Возвращение на главный экран по нажатию системной кнопки "Назад"
    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }
    }
    // Системная кнопка "Назад" - конец

    public void getMessage(){
        backToast = Toast.makeText(getBaseContext(), "Ставки сделаны, ставок больше нет", Toast.LENGTH_SHORT);
        backToast.show();
        backPressedTime = System.currentTimeMillis();
    }
}