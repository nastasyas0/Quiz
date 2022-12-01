package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private boolean[] b= new boolean[16];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Команда для кнопки "Назад"
                try{
                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
                    intent.putExtra("b",b);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });

        //инициализация массива дя кнопок
        for (int i=0; i<16; i++){
            b[i]=true;
        }

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Кнопка для просмотра результатов - начало
        Button buttonResult = (Button)findViewById(R.id.buttonResult);
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Results.class);
                    startActivity(intent);finish();
                } catch(Exception e) {

                }
            }
        });
        // Кнопка для просмотра результатов - конец
    }
    // Системная кнопка "Назад" - начало
    // Выход из приложения по нажатию системной кнопки "Назад"
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else {
            backToast = Toast.makeText(getBaseContext(), "Жмакните еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    // Системная кнопка "Назад" - конец
}