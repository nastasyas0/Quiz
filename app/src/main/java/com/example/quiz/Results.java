package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.ArrayList;

public class Results extends AppCompatActivity {
    private TextView points, mems;//поле для результа
    private String name="jokes.txt";//имя файла с анекдотами
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        Button button_close = (Button)findViewById(R.id.button_close);

        points = findViewById(R.id.points);//баллы
        mems = findViewById(R.id.mems);//для анекдота

        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Команда для кнопки "Закрыть"
                try{
                    Intent intent = new Intent(Results.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e) {

                }
            }
        });

        inputInFileJokes(name);//запись в файл анекдота

        //Развернуть игру на весь экран - начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //Развернуть игру на весь экран - конец

        try {
            printCounter(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Системная кнопка "Назад" - начало
    // Возвращение на главный экран по нажатию системной кнопки "Назад"
    @Override
    public void onBackPressed() {
        try{
            Intent intent = new Intent(Results.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e) {

        }
    }
    // Системная кнопка "Назад" - конец

    //вывод результатов
    public void printCounter(String name) throws IOException {
        Intent intent = getIntent();//переданный параметр из другой activity счётчик правильных ответов
        int counter = intent.getIntExtra("counter",0);
        String s = "Баллы:" + Integer.toString(counter);
        points.setText(s);//вывод количества заработанных баллов
        //приготовление к выводу анекдота
        FileInputStream fileInput = openFileInput(name);//с каким файлом работаем
        InputStreamReader reader = new InputStreamReader(fileInput);//считали данные
        BufferedReader bufferedReader = new BufferedReader(reader);//преобразовали в нужный вид
        String joke="";//поле для анекдота
        ArrayList<String> arrayList=new ArrayList<>();//список анекдотов
            while((joke=bufferedReader.readLine())!=null){
                arrayList.add(joke);//заполнение
            }
            int num=(int) (Math.random()*arrayList.size());
            joke=arrayList.get(num);//выбираем рандомный анекдот
        mems.setText(joke);
    }
    //анекдоты
    private void inputInFileJokes(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "Выберите правильный вариант ответа: He usually had dinner at 4 p.m., _____?";
            f.write(d.getBytes());
            d=";hadn't he;did he;didn't he;didn't he;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: When the phone rang, I _____ dinner.";
            f.write(d.getBytes());
            d=";was cooking;had been cooking;have been cooking;was cooking;\n";
            f.write(d.getBytes());
            d = "Выберите правильное неопределенное местоимение: Did you read _____ English books at school?";
            f.write(d.getBytes());
            d=";some;any;much;any;\n";
            f.write(d.getBytes());
            d = "Выберите правильный фразовый глагол: Tom will have to _____ an excuse for not writing his essay.";
            f.write(d.getBytes());
            d=";dream uo;drop out;beat;dream up;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: Jerry believed that Sally _____ the book since Monday, but she had read only fifty pages so far.";
            f.write(d.getBytes());
            d=";was reading;had been reading;had read;had been reading;\n";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}