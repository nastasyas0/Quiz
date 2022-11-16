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

public class Level1 extends AppCompatActivity {

    private TextView questionField;//поле для вопроса

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

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



        questionField = findViewById(R.id.question);//поле для вопроса

        putQuestionInFile();
        getQuestionFromFile();
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
    }
    public void putQuestionInFile(){
        Intent intent = getIntent();//переданный параметр из другой activity(название файла)
        try {
            String name = intent.getStringExtra("name");//полученные данные
            FileOutputStream f = openFileOutput(name, MODE_PRIVATE);//заполнение файла
            String d = name;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}