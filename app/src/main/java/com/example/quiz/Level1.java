package com.example.quiz;

import static com.example.quiz.GameLevels.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;



public class Level1 extends AppCompatActivity {


    private TextView questionField, answ1, answ2, answ3;//поле для вопроса
    private String a1 = "",a2="", a3="", answer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец

        //кнопка перехода к списку вопросов
        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Команда для кнопки "Назад"
                try{
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
            }
        });


        //работа с файлом
        questionField = findViewById(R.id.question);//поле для вопроса
        answ1 = findViewById(R.id.var1);//поле для ответа 1
        answ2 = findViewById(R.id.var2);//поле для ответа 2
        answ3 = findViewById(R.id.var3);//поле для ответа 3

        putQuestionInFile();//запись в файл
        getQuestionFromFile();//вывод из файла


        // Кнопка выбора ответа 1
        answ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(Objects.equals(answer, a1)){
                        Intent intent = getIntent();//переданный параметр из другой activity счётчик
                        int counter = intent.getIntExtra("counter",0);//полученные данные
                        counter=counter+1;
                        answ1.setText("right");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ1.setText("false");
                    }
                } catch(Exception e) {

                }
            }
        });

        // Кнопка выбора ответа 2
        answ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(answer==a2){
                        Intent intent = getIntent();//переданный параметр из другой activity счётчик
                        int counter = intent.getIntExtra("counter",0);//полученные данные
                        counter=counter+1;
                        answ2.setText("right");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ2.setText("false");
                    }
                } catch(Exception e) {

                }
            }
        });

        // Кнопка выбора ответа 3
        answ3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(answer==a3){
                        Intent intent = getIntent();//переданный параметр из другой activity счётчик
                        int counter = intent.getIntExtra("counter",0);//полученные данные
                        counter=counter+1;
                        answ3.setText("right");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ3.setText("false");
                    }
                } catch(Exception e) {

                }
            }
        });


    }
    //Системная кнопка "Назад" - список вопросов
    // Возвращение на экран с вопросами по нажатию системной кнопки "Назад"
    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }

    public void putQuestionInFile(){
        Intent intent = getIntent();//переданный параметр из другой activity(название файла)
        try {
            String name = intent.getStringExtra("name");//полученные данные
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = name;
            f.write(d.getBytes());
            d="\n";
            f.write(d.getBytes());
            d="first\n";
            f.write(d.getBytes());
            d="second\n";
            f.write(d.getBytes());
            d="third\n";
            f.write(d.getBytes());
            d="first\n";//ответ
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //берём вопрос из файла
    public void getQuestionFromFile() {
        ///data/data/com.example.quiz/files/eng_10.txt
        Intent intent = getIntent();//переданный параметр из другой activity(название файла)
        String name = intent.getStringExtra("name");//полученные данные
        //чтение из файла
        try {
            FileInputStream fileInput = openFileInput(name);//с каким файлом работаем
            InputStreamReader reader = new InputStreamReader(fileInput);//считали данные
            BufferedReader bufferedReader = new BufferedReader(reader);//преобразовали в нужный вид
            questionField.setText(bufferedReader.readLine());
            a1=bufferedReader.readLine();
            a2=bufferedReader.readLine();
            a3=bufferedReader.readLine();
            answer=bufferedReader.readLine();
            answ1.setText(a1);
            answ2.setText(a2);
            answ3.setText(a3);
            //сравнение ответов с правильным
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}