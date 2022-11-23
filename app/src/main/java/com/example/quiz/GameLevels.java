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
    private boolean b1=true,b2=true,b3=true,b4=true,b5=true,b6=true,b7=true,b8=true,b9=true,b10=true,b11=true,b12=true,b13=true,b14=true,b15=true,b16=true;
    //для сообщения
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

        // Кнопка для перехода на 1 уровень викторины - начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(b1){
                        String name = "rus_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b2){
                        String name = "rus_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b3){
                        String name = "rus_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b4){
                        String name = "rus_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b5){
                        String name = "math_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b6){
                        String name = "math_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b7){
                        String name = "math_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if (b8) {
                        String name = "math_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b9){
                        String name = "inf_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b10){
                        String name = "inf_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b11){
                        String name = "inf_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b12){
                        String name = "inf_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b13){
                        String name = "eng_10.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b14){
                        String name = "eng_20.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b15){
                        String name = "eng_30.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
                    if(b16){
                        String name = "eng_40.txt";//параметр для нового activity
                        Intent intent = new Intent(GameLevels.this, Level1.class);
                        intent.putExtra("name",name);//передаем нужный параметр
                        intent.putExtra("counter",counter);//передаем нужный параметр
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
        if(new_name!=null){
            switch (new_name){
                case "rus_10.txt":  b1=false;break;
                case "rus_20.txt":  b2=false;break;
                case "rus_30.txt":  b3=false;break;
                case "rus_40.txt":  b4=false;break;
                case "math_10.txt":  b5=false;break;
                case "math_20.txt":  b6=false;break;
                case "math_30.txt":  b7=false;break;
                case "math_40.txt":  b8=false;break;
                case "inf_10.txt":  b9=false;break;
                case "inf_20.txt":  b10=false;break;
                case "inf_30.txt":  b11=false;break;
                case "inf_40.txt":  b12=false;break;
                case "eng_10.txt":  b13=false;break;
                case "eng_20.txt":  b14=false;break;
                case "eng_30.txt":  b15=false;break;
                case "eng_40.txt":  b16=false;break;
            }
        }
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