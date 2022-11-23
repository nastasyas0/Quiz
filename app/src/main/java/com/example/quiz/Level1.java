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
                    if(Objects.equals(answer, a2)){
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
                    if(Objects.equals(answer, a3)){
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
            case "10": p.setText("10 баллов");break;
            case "20": p.setText("20 баллов");break;
            case "30": p.setText("30 баллов");break;
            case "40": p.setText("40 баллов");break;
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
            answer=question.split(";")[4];
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
            String d = "Укажите время выделенного глагола: «ВЫВЕЛА медведица своих медвежат в лес.»";
            f.write(d.getBytes());
            d=";Настоящее;Будущее;Прошедшее;Прошедшее;\n";
            f.write(d.getBytes());
            d = "Выберите глаголы 2 спряжения";
            f.write(d.getBytes());
            d=";Пилит, жарить, ходят, посмотрит;Расскажешь, найдут, откажет, живешь;Думаешь, смотрит, пьет, стоит;Пилит, жарить, ходят, посмотрит;\n";
            f.write(d.getBytes());
            d = "Укажите вариант ответа, где НЕ пишется слитно";
            f.write(d.getBytes());
            d=";О поездке (не) мечтай;(Не) годовал;(Не) хочется;(Не) годовал;\n";
            f.write(d.getBytes());
            d = "Найдите существительное в винительном падеже";
            f.write(d.getBytes());
            d=";Через мостик;Топором;О мебели;Через мостик;\n";
            f.write(d.getBytes());
            d = "Укажите существительное с окончанием -и";
            f.write(d.getBytes());
            d=";По алле…;К деревн…;В тетрад…;В тетрад…;\n";
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
            String d = "В каком предложении не нужны знаки препинания?";
            f.write(d.getBytes());
            d=";Разве только иногда глухо ухнет филин да неслышно пролетит подслеповатая сова.;Проехали семь верст и вдали показались невысокий дом и двор.;Вскоре после восхода набежала туча и брызнул короткий дождь.;Вскоре после восхода набежала туча и брызнул короткий дождь.;\n";
            f.write(d.getBytes());
            d = "Укажите сложносочиненное предложение с разделительным союзом";
            f.write(d.getBytes());
            d=";То хлопнуло где-то, то раздался вдруг вой, то словно кто-то по коридору прошел.;Потом все стихло, и только морская даль все так же монотонно, негромко шумела.;Месяц под косой блестит, а во лбу звезда горит.;То хлопнуло где-то, то раздался вдруг вой, то словно кто-то по коридору прошел.;\n";
            f.write(d.getBytes());
            d = "Укажите сложноподчиненное предложение с придаточным места";
            f.write(d.getBytes());
            d=";Родина слышит, Родина знает, где в облаках её сын пролетает.;Я давно мой край оставил, где цветут луча и чащи.;Нет истины, где нет любви.;Я давно мой край оставил, где цветут луча и чащи.;\n";
            f.write(d.getBytes());
            d = "Найдите слово с чередующейся гласной в корне слова";
            f.write(d.getBytes());
            d=";Расстроиться;Растереть;Примерять (платье);Растереть;\n";
            f.write(d.getBytes());
            d = "Укажите, какое средство речевой выразительности используется в предложении: «Филипп бросил недопитую чашку кофе, чего с ним никогда не случалось, выбежал навстречу другу, чего с ним тоже никогда не бывало.»";
            f.write(d.getBytes());
            d=";Метафора;Олицетворение;Лексический повтор;Лексический повтор;\n";
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
            String d = "Найдите сложноподчиненное предложение с пунктуационной ошибкой";
            f.write(d.getBytes());
            d=";Люблю, когда лиственный лес оденется и кругом тесно обступит елку.;Я приду и, если вы что-нибудь не поняли, объясню вам.;Я сказал, что пошутил, и, подойдя к своей постели юркнул с головой под одеяло.;Я сказал, что пошутил, и, подойдя к своей постели юркнул с головой под одеяло.;\n";
            f.write(d.getBytes());
            d = "Вставьте пропущенные буквы";
            f.write(d.getBytes());
            d=";КАсательная, предлОжение, кАрамель, загАрелый, излАгать;КАсательная, предлОжение, кАрамель, загОрелый, излАгать;КОсательная, предлОжение, кАрамель, загАрелый, излОгать;КАсательная, предлОжение, кАрамель, загОрелый, излАгать;\n";
            f.write(d.getBytes());
            d = "Вставьте пропущенные буквы";
            f.write(d.getBytes());
            d=";Кожаный, ветреный, торжественный, серебряный, глиняный;Кожаный, ветренный, торжественный, серебряный, глиняный;Кожаный, ветренный, торжественый, серебрянный, глинянный;Кожаный, ветреный, торжественный, серебряный, глиняный;\n";
            f.write(d.getBytes());
            d = "Укажите предложение, в котором средством выразительности речи является фразеологизм";
            f.write(d.getBytes());
            d=";Он глядел и чувствовал себя на верху блаженства.;На другой день Червяков надел новый вицмундир, постригся и пошел к Бризжалову объяснить…;Червяков сконфузился, глупо улыбнулся и начал глядеть на сцену.;Он глядел и чувствовал себя на верху блаженства.;\n";
            f.write(d.getBytes());
            d = "Укажите ряд, в котором верно выделены буквы, обозначающие ударные гласные звуки";
            f.write(d.getBytes());
            d=";ДОнельзя, врУчит, сливОвый, некролОг;ЕретИк, принУдить, чЕрпать, ободрИть;ОблилАсь, Оптовый, катАлог, вклЮчит;ЕретИк, принУдить, чЕрпать, ободрИть;\n";
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
            String d = "Выберите номера запятых, где они верно расставлены: «Я поднял голову вверх (1) и увидел (2) освещающие горизонт (3) молнии (4) которые отпечатывались на небе (5) оставляя яркие следы (6) и рвали (7) затянувшие всё небо (8) тучи.»";
            f.write(d.getBytes());
            d=";23457;456;2456;456;\n";
            f.write(d.getBytes());
            d = "В каком ряду во всех словах пропущена одна и та же буква?";
            f.write(d.getBytes());
            d=";Дириж..р, деш..вка, душ..нка, ш..рты;Беч..вка, ж..рдочка, реш..тка, пш..нка;Трущ..ба, туш..нка, ноч..вка, сч..т;Беч..вка, ж..рдочка, реш..тка, пш..нка;\n";
            f.write(d.getBytes());
            d = "Выберите ряд, где во всех словах пропущена безударная проверяемая гласная в корне";
            f.write(d.getBytes());
            d=";Просв..щение, ед..нение, бл..стящий, л..гичный;Об..зательный, осв..щение, прод..вец, пол..скать (бельё);Сист..матический, нар..диться, пл..вец, п..ровать;Об..зательный, осв..щение, прод..вец, пол..скать (бельё);\n";
            f.write(d.getBytes());
            d = "Укажите строчку, в которой все слова с НЕ пишутся раздельно";
            f.write(d.getBytes());
            d=";(Не) светлей ее волос, никому (не) известная страна, (не) рад, ничем (не) прикрытый;(Не) распустившийся цветок, шел (не) годуя, ошибка (не) отмечена, (не) чем гордиться;Неприятель (не) обнаружен, (не) замеченная ошибка, (не) глядя под ноги, (не) взошедшее солнце;(Не) светлей ее волос, никому (не) известная страна, (не) рад, ничем (не) прикрытый;\n";
            f.write(d.getBytes());
            d = "Укажите ряд, в котором во всех словах пропущена одна и та же буква";
            f.write(d.getBytes());
            d=";Пр..образование, непр..ложный, пр..дыстория, пр..клонить (колени);Чере..чур, бе..болезненный, ..десь, не..гораемый;Без..нициативный, вз..мать, пред..нфарктный, с..змала;Пр..образование, непр..ложный, пр..дыстория, пр..клонить (колени);\n";
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
            String d = "Укажите пару чисел, являющуюся решением уравнения 5у-х=1.";
            f.write(d.getBytes());
            d=";(2, 9);(1, 4);(4, 1);(4, 1);\n";
            f.write(d.getBytes());
            d = "Гипотенуза прямоугольного треугольника равна 82см, а его площадь – 720 см^2. Найдите катеты треугольника.";
            f.write(d.getBytes());
            d=";21 и 4;18 и 80;23 и 5;18 и 80;\n";
            f.write(d.getBytes());
            d = "Найдите ординату точки с абсциссой, равной 3 и принадлежащей графику уравнения х^2-2ху+2у^2+х-6у+6=0.";
            f.write(d.getBytes());
            d=";3;8;5;3;\n";
            f.write(d.getBytes());
            d = "Если (х,у) - решение системы уравнений 5х+у=20 и 2х-у=1, то х+у равно:";
            f.write(d.getBytes());
            d=";8;12;9;8;\n";
            f.write(d.getBytes());
            d = "Вычислите 7!";
            f.write(d.getBytes());
            d=";700;5030;5040;5040;\n";
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
            String d = "Вычислите: sin105°-sin75°.";
            f.write(d.getBytes());
            d=";1;0;1/2;0;\n";
            f.write(d.getBytes());
            d = "Записан рост (в сантиметрах) пяти учащихся: 132, 134, 130, 166, 158. На сколько отличается среднее арифметическое этого набора чисел от его медианы?";
            f.write(d.getBytes());
            d=";14;12;10;10;\n";
            f.write(d.getBytes());
            d = "В какой координатной четверти находится вершина параболы y = (x - 4)^2 - 3?";
            f.write(d.getBytes());
            d=";I;II;IV;IV;\n";
            f.write(d.getBytes());
            d = "У Алины 6 подруг: Таня, Даша, Лера, Алиса, Оля, Геля. Она решила двух из них пригласить в гости. Укажите сколько вариантов выбора подруг у Алины?";
            f.write(d.getBytes());
            d=";150;15;10;15;\n";
            f.write(d.getBytes());
            d = "Найдите значение выражения 10!/8!";
            f.write(d.getBytes());
            d=";180;900;90;90;\n";
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
            String d = "Записан рост пяти учащихся: 132, 134, 130, 166, 158. На сколько отличается среднее арифметическое этого набора чисел от его медианы?";
            f.write(d.getBytes());
            d=";50;40;36;50;\n";
            f.write(d.getBytes());
            d = "Сколько трехзначных чисел можно составить из цифр 0, 3, 5, 7, при условии, что цифры в записи числа не повторяются?";
            f.write(d.getBytes());
            d=";7;12;18;18;\n";
            f.write(d.getBytes());
            d = "Основания трапеции равны 4 см и 10 см. Диагональ трапеции делит среднюю линию на два отрезка. Найдите длину большего из них.";
            f.write(d.getBytes());
            d=";2;4;5;5;\n";
            f.write(d.getBytes());
            d = "Из 100 клавиатур для компьютера в среднем 12 неисправны. Какова вероятность того, что случайно выбранная клавиатура исправна?";
            f.write(d.getBytes());
            d=";0,88;0,98;0,78;0,88;\n";
            f.write(d.getBytes());
            d = "Решите уравнение cos(2x) = 0.";
            f.write(d.getBytes());
            d=";x=pi/2+pik;x=pi/4+pik/2;x=pi/4+pik;x=pi/4+pik/2;\n";
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
            String d = "Боковые стороны равнобедренного треугольника равны 20, основание равно 24. Найдите радиус описанной около треугольника окружности.";
            f.write(d.getBytes());
            d=";12,5;1;32;12,5;\n";
            f.write(d.getBytes());
            d = "Найдите точку минимума функции y = x^3 – 243x + 23.";
            f.write(d.getBytes());
            d=";-9;9sqrt(3);9;9;\n";
            f.write(d.getBytes());
            d = "Имеется два сплава. Первый содержит 10% никеля, второй — 25% никеля. Из этих двух сплавов получили третий сплав массой 105 кг, содержащий 20% никеля. На сколько килограммов масса первого сплава была меньше массы второго?";
            f.write(d.getBytes());
            d=";30;35;70;35;\n";
            f.write(d.getBytes());
            d = "В случайном эксперименте бросают 2 игральные кости. Найдите вероятность того, что в сумме выпадет 8 очков. Результат округлен до сотых.";
            f.write(d.getBytes());
            d=";0,11;0,14;0,19;0,14;\n";
            f.write(d.getBytes());
            d = "Пусть A={a, b, c, g, e}, B={a, c, e, f, r, m}. Тогда B\\A равно";
            f.write(d.getBytes());
            d=";{b, g};{f, r, m};{c, b, g};{f, r, m};\n";
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
            String d = "В одной из кодировок Unicode каждый символ кодируется 16 битами. Определите размер следующего предложения в данной кодировке: Я к вам пишу – чего же боле? Что я могу ещё сказать?";
            f.write(d.getBytes());
            d=";832 бит;104 бит;832 байт;832 бит;\n";
            f.write(d.getBytes());
            d = "Для какого из приведённых чисел ложно высказывание: НЕ (число > 50) ИЛИ (число чётное)?";
            f.write(d.getBytes());
            d=";56;9;123;123;\n";
            f.write(d.getBytes());
            d = "В каталоге Июнь хранился файл Отчет.doc. Позже этот каталог переместили в каталог Сданные, расположенный в корне диска D. Укажите полное имя этого файла после перемещения.";
            f.write(d.getBytes());
            d=";D:\\Сданные\\Июнь\\Отчет.doc;D:\\Сданные\\Отчет.doc;D:\\Июнь\\Отчет.doc;D:\\Сданные\\Июнь\\Отчет.doc;\n";
            f.write(d.getBytes());
            d = "Переведите число 487 из десятичной системы счисления в двоичную систему счисления.";
            f.write(d.getBytes());
            d=";111101011;111100111;111010111;111100111;\n";
            f.write(d.getBytes());
            d = "Файл размером 2000 Кбайт передаётся через некоторое соединение в течение 30 секунд. Определите размер файла (в Кбайт), который можно передать через это соединение за 12 секунд.";
            f.write(d.getBytes());
            d=";800;820;400;800;\n";
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
            String d = "Переведите число 4872 из десятичной системы счисления в шестнадцатеричную систему счисления.";
            f.write(d.getBytes());
            d=";1306;130A;1308;1308;\n";
            f.write(d.getBytes());
            d = "В одной из кодировок Unicode каждый символ кодируется 2 байтами. Ученик написал текст (в нём нет лишних пробелов): «Геометрия, физика, информатика, химия, биология, история, ИЗО - школьные предметы». Затем вычеркнул из списка название одного из предметов. Заодно он вычеркнул ставшие лишними запятые и пробелы – два пробела не должны идти подряд. При этом размер нового предложения в данной кодировке оказался на 128 бит меньше, чем размер исходного предложения. Какой предмет вычеркнул ученик.";
            f.write(d.getBytes());
            d=";История;Физика;Химия;Физика;\n";
            f.write(d.getBytes());
            d = "Среди трёх чисел: 23(16), 32(8), 11110(2), записанных в различных системах счисления, найдите максимальное.";
            f.write(d.getBytes());
            d=";23(16);32(8);11110(2);23(16);\n";
            f.write(d.getBytes());
            d = "Для какого из указанных значений числа X ложно высказывание: (X > 3) ИЛИ НЕ((X < 4) И (X > 2))?";
            f.write(d.getBytes());
            d=";1;2;3;3;\n";
            f.write(d.getBytes());
            d = "У исполнителя Омега две команды, которым присвоены номера: 1. прибавь 3. 2. раздели на b (b - неизвестное натуральное число, b >= 2). Программа для исполнителя Омега - это последовательность номеров команд. Известно, что программа 11211 переводит число 30 в число 12. Определите значение b.";
            f.write(d.getBytes());
            d=";3;6;36;6;\n";
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
            String d = "Для хранения растрового изображения размером 32*32 пикселя отвели 512 байтов памяти. Каково максимально возможное число цветов в палитре изображения?";
            f.write(d.getBytes());
            d=";16;8;4;16;\n";
            f.write(d.getBytes());
            d = "Представьте число -81 в двоичном виде в восьмибитовом представлении в формате целого со знаком.";
            f.write(d.getBytes());
            d=";01010001;00101111;10101111;10101111;\n";
            f.write(d.getBytes());
            d = "Сколько слов (с точки зрения текстового редактора) содержится в следующем тексте, содержащем ряд ошибок: Раз,два, три, четыре, пять. Вышел зайчик по гулять. В друг охотник вы бегает.";
            f.write(d.getBytes());
            d=";13;12;11;13;\n";
            f.write(d.getBytes());
            d = "При регистрации в компьютерной системе каждому пользователю выдаётся пароль, состоящий из 10 символов. В качестве символов используют прописные буквы латинского алфавита(26 различных символов). В базе данных для хранения каждого пароля отведено одинаковое и минимально возможное целое число байт. При этом используют посимвольное кодирование паролей, все символы кодируют одинаковым и минимально возможным количеством бит. Определите объём памяти (в байтах), необходимый для хранения данных о 50 пользователях.";
            f.write(d.getBytes());
            d=";250 байт;350 байт;280 байт;350 байт;\n";
            f.write(d.getBytes());
            d = "В бутыли, стакане, кувшине и банке находятся молоко, лимонад, квас и вода. Известно, что: вода и молоко не в бутыли. А сосуд с лимонадом стоит между кувшином и сосудом с квасом. Также сказано, что в банке не лимонад и не вода, а стакан стоит между банкой и сосудом с молоком. В каком сосуде находится квас?";
            f.write(d.getBytes());
            d=";В бутыли;В кувшине;В банке;В банке;\n";
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
            String d = "При регистрации в компьютерной системе каждому пользователю выдаётся пароль, состоящий из 15 символов и содержащий только символы из 12-символьного набора: А, В, C, D, Е, F, G, H, K, L, M, N. В базе данных для хранения сведений о каждом пользователе отведено одинаковое и минимально возможное целое число байт. При этом используют посимвольное кодирование паролей, все символы кодируют одинаковым и минимально возможным количеством бит. Кроме собственно пароля, для каждого пользователя в системе хранятся дополнительные сведения, для чего отведено 12 байт на одного пользователя. Определите объём памяти (в байтах), необходимый для хранения сведений о 100 пользователях.";
            f.write(d.getBytes());
            d=";2000 байт;800 байт;1200 байт;2000 байт;\n";
            f.write(d.getBytes());
            d = "Если маска подсети 255.255.240.0 и IP-адрес компьютера в сети 232.126.150.18, то номер компьютера в сети равен:";
            f.write(d.getBytes());
            d=";1556;1554;1552;1554;\n";
            f.write(d.getBytes());
            d = "По каналу связи передаются сообщения, содержащие только шесть букв: А, B, C, D, E, F. Для передачи используется неравномерный двоичный код, удовлетворяющий условию Фано. Для букв A, B, C используются такие кодовые слова: А - 11, B - 101, C - 0. Укажите кодовое слово наименьшей возможной длины, которое можно использовать для буквы F. Если таких слов несколько, укажите то из них, которое соответствует наименьшему возможному двоичному числу.";
            f.write(d.getBytes());
            d=";1000;100;1001;1000;\n";
            f.write(d.getBytes());
            d = "По каналу связи передаются сообщения, содержащие только семь букв: А, Б, И, К, Л, С, Ц. Для передачи используется двоичный код, удовлетворяющий условию Фано. Кодовые слова для некоторых букв известны: Б - 00, К - 010, Л - 111. Какое наименьшее количество двоичных знаков потребуется для кодирования слова АБСЦИССА?";
            f.write(d.getBytes());
            d=";24;20;22;22;\n";
            f.write(d.getBytes());
            d = "Автомат получает на вход четырёхзначное число (число не может начинаться с нуля). По этому числу строится новое число по следующим правилам: 1. Складываются отдельно первая и вторая, вторая и третья, третья и четвёртая цифры заданного числа. 2. Наименьшая из полученных трёх сумм удаляется. 3. Оставшиеся две суммы записываются друг за другом в порядке неубывания без разделителей. Укажите наименьшее число, при обработке которого автомат выдаёт результат 1215.";
            f.write(d.getBytes());
            d=";1396;1669;1369;1396;\n";
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
            String d = "Выберите правильную временную форму: When she came back from work, her sister _____ the flat.";
            f.write(d.getBytes());
            d=";already cleaned;had already cleaned;has already cleaned;had already cleaned;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: We were sure the idea _____ successful.";
            f.write(d.getBytes());
            d=";would be;will be;be;would be;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: If she _____ the driving test she’ll go to work by bus.";
            f.write(d.getBytes());
            d=";doesn’t pass;won’t pass;didn’t pass;doesn’t pass;\n";
            f.write(d.getBytes());
            d = "Вставьте подходящее слово: Don’t worry! It is ok to _____ mistakes.";
            f.write(d.getBytes());
            d=";do;make;has made;make;\n";
            f.write(d.getBytes());
            d = "Вставьте подходящее слово: Are there _____ new pupils in your class?";
            f.write(d.getBytes());
            d=";some;any;much;any;\n";
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
            String d = "Вставьте подходящее слово: Send pictures to your friends. A picture is still _____ than a thousand words.";
            f.write(d.getBytes());
            d=";better;good;worth;better;\n";
            f.write(d.getBytes());
            d = "Вставьте правильный предлог: Wait _____ the end of the street and I’ll come and meet you.";
            f.write(d.getBytes());
            d=";to;in;at;at;\n";
            f.write(d.getBytes());
            d = "Вставьте правильный предлог: Have you seen the new building _____ front of the school?";
            f.write(d.getBytes());
            d=";at;in;on;in;\n";
            f.write(d.getBytes());
            d = "Вставьте подходящее слово: May I _____ to the manager, please?";
            f.write(d.getBytes());
            d=";start;call;speak;speak;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: When we got to the airport, I realised I _____ my passport at home!";
            f.write(d.getBytes());
            d=";was left;had left;left;had left;\n";
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
            String d = "Выберите правильный модальный глагол: You _____ do the job if you didn't speak Chinese fluently.";
            f.write(d.getBytes());
            d=";may not;won’t be able to;can’t;can’t;\n";
            f.write(d.getBytes());
            d = "Вставьте правильный предлог: We drove all night and finally arrived _____ Lisbon at eight o'clock.";
            f.write(d.getBytes());
            d=";at;to;in;at;\n";
            f.write(d.getBytes());
            d = "Вставьте правильный предлог: He reminds me _____ someone I know in the army.";
            f.write(d.getBytes());
            d=";from;of;about;of;\n";
            f.write(d.getBytes());
            d = "Выберите правильную форму: I've made _____ mistakes now than I made last time.";
            f.write(d.getBytes());
            d=";few;fewer;less;fewer;\n";
            f.write(d.getBytes());
            d = "Выберите правильную временную форму: Unfortunately, I got stuck in a traffic jam and when I _____ there was only a couple of Jane’s friends left.";
            f.write(d.getBytes());
            d=";arrived;had arrived;has arrived;arrived;\n";
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