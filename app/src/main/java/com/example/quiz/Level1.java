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
import java.util.ArrayList;
import java.util.Objects;



public class Level1 extends AppCompatActivity {


    private TextView questionField, answ1, answ2, answ3, subj, p;//поле для вопроса
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
        subj = findViewById(R.id.subject);//предмет (тема)
        p = findViewById(R.id.points);//баллы

        putQuestionInFile();//запись в файл
        getQuestionFromFile();//вывод из файла


        // Кнопка выбора ответа 1
        answ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = getIntent();//переданный параметр из другой activity счётчик
                    int counter = intent.getIntExtra("counter",0);//полученные данные
                    String new_name = intent.getStringExtra("name");//полученные данные
                    if(Objects.equals(answer, a1)){
                        answ1.setText("right");
                        counter=counter+1;
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ1.setText("false");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);
                        startActivity(intent2);
                        finish();
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
                    Intent intent = getIntent();//переданный параметр из другой activity счётчик
                    int counter = intent.getIntExtra("counter",0);//полученные данные
                    String new_name = intent.getStringExtra("name");//полученные данные
                    if(answer==a2){
                        counter=counter+1;
                        answ2.setText("right");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);//test
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ2.setText("false");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);//test
                        startActivity(intent2);
                        finish();
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
                    Intent intent = getIntent();//переданный параметр из другой activity счётчик
                    int counter = intent.getIntExtra("counter",0);//полученные данные
                    String new_name = intent.getStringExtra("name");//полученные данные
                    if(answer==a3){
                        counter=counter+1;
                        answ3.setText("right");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);//test
                        startActivity(intent2);
                        finish();
                    }
                    else{
                        answ3.setText("false");
                        Intent intent2 = new Intent(Level1.this, GameLevels.class);
                        intent2.putExtra("counter",counter);//передаем нужный параметр
                        intent2.putExtra("new_name",new_name);//test
                        startActivity(intent2);
                        finish();
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
        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
    public void putQuestionInFile(){
        Intent intent = getIntent();//переданный параметр из другой activity(название файла)
        String name = intent.getStringExtra("name");//полученные данные
        switch (name){
            case "rus_10.txt":  inputInFileR1(name);break;
            case "rus_20.txt":  inputInFileR2(name);break;
            case "rus_30.txt":  inputInFileR3(name);break;
            case "rus_40.txt":  inputInFileR4(name);break;
            case "math_10.txt":  inputInFileM1(name);break;
            case "math_20.txt":  inputInFileM2(name);break;
            case "math_30.txt":  inputInFileM3(name);break;
            case "math_40.txt":  inputInFileM4(name);break;
            case "inf_10.txt":  inputInFileI1(name);break;
            case "inf_20.txt":  inputInFileI2(name);break;
            case "inf_30.txt":  inputInFileI3(name);break;
            case "inf_40.txt":  inputInFileI4(name);break;
            case "eng_10.txt":  inputInFileE1(name);break;
            case "eng_20.txt":  inputInFileE2(name);break;
            case "eng_30.txt":  inputInFileE3(name);break;
            case "eng_40.txt":  inputInFileE4(name);break;
        }
    }

    //берём вопрос из файла
    public void getQuestionFromFile(){
        ///data/data/com.example.quiz/files/eng_10.txt
        Intent intent = getIntent();//переданный параметр из другой activity(название файла)
        String name = intent.getStringExtra("name");//полученные данные
        String n="";
        switch (name.substring(0, 3)){
            case "rus": subj.setText("Русский язык"); n = name.substring(4,6);break;
            case "mat": subj.setText("Математика");n = name.substring(5,7);break;
            case "inf": subj.setText("Информатика");n = name.substring(4,6);break;
            case "eng": subj.setText("Английский язык");n = name.substring(4,6);break;
        }

        switch (n){
            case "10": p.setText("10");break;
            case "20": p.setText("20");break;
            case "30": p.setText("30");break;
            case "40": p.setText("40");break;
        }

        //чтение из файла
        try {
            FileInputStream fileInput = openFileInput(name);//с каким файлом работаем
            InputStreamReader reader = new InputStreamReader(fileInput);//считали данные
            BufferedReader bufferedReader = new BufferedReader(reader);//преобразовали в нужный вид
            String question="";//поле для вопроса
            ArrayList<String> arrayList=new ArrayList<>();//список вопросов
            while((question=bufferedReader.readLine())!=null){
                arrayList.add(question);//заполнение
            }
            int num=(int) (Math.random()*arrayList.size());
            question=arrayList.get(num);//выбираем рандомный вопрос
            questionField.setText(question.split(";")[0]);
            a1=question.split(";")[1];
            a2=question.split(";")[2];
            a3=question.split(";")[3];
            answer=bufferedReader.readLine();
            answ1.setText(a1);
            answ2.setText(a2);
            answ3.setText(a3);
            //сравнение ответов с правильным
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileR1(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "Казалось(1) что кто-то тихо вздыхал среди глубокой(2) холодной ночи(3) и клубы пара(4) вылетавшие из гигантской груди(5) бесшумно проносились по небу от края (6) и затем тихо угасали в глубокой синеве.";
            f.write(d.getBytes());
            d=";145;2456;1345;145;\n";
            f.write(d.getBytes());
            d = "И если тебе(1) мой читатель(2) посчастливится побывать когда-нибудь в Кавказском заповеднике(3) и пройти по тропе(4) у которой(5) стоит такой обелиск(6) низко поклонись памяти защитников нашей Родины (7) отдавших свои жизни за то (8) чтобы сегодня мы жили в мире.";
            f.write(d.getBytes());
            d=";2456;124678;1234678;124678;\n";
            f.write(d.getBytes());
            d = "Впереди еще долгие жаркие(1) знойные (2)и просто теплые приятные деньки(3) когда солнце просыпается рано(4) а заходит очень нескоро(5) давая вволю нагуляться(6) прежде чем (7)погрузиться в сумерки.";
            f.write(d.getBytes());
            d=";2456;12467;13456;13456;\n";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileR2(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileR3(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileR4(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileM1(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileM2(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileM3(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileM4(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileI1(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileI2(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileI3(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inputInFileI4(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileE1(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileE2(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileE3(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
            f.write(d.getBytes());
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void inputInFileE4(String name){
        try {
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = "question1;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question2;first;second;third;first;\n";
            f.write(d.getBytes());
            d = "question3;first;second;third;first;";
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