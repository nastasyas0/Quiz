package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        questionField = findViewById(R.id.question);//поле для вопроса

        //View v;
        getQuestionFromFile();
        //questionField.setText("Hello");
    }

    //берём вопрос из файла
    public void getQuestionFromFile()  {
        try{
            FileOutputStream f = openFileOutput("rus_10.txt", MODE_PRIVATE);//заполнение файла
            String d="Hello, world";
            f.write(d.getBytes());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(this,"Не получается обработать файл.", Toast.LENGTH_SHORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //чтение из файла
        String question;
        try{
            FileInputStream fileInput = openFileInput("rus_10.txt");//с каким файлом работаем
            InputStreamReader reader = new InputStreamReader(fileInput);//считали данные
            BufferedReader bufferedReader = new BufferedReader(reader);//преобразовали в нужный вид
            questionField.setText(bufferedReader.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}