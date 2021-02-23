package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa obsługująca nową rozgrywkę
 */
public class NewGameActivity extends AppCompatActivity {


    /**
     * pole odnoszące się do obiektu bazy
     */
    DataBase dataBase=new DataBase();
    /**
     * pole przechowujące, ile pytań zostało wykorzystanych
     */
    static int whichquestion;
    /**
     * obiekt typu Timer
     */
    Timer timer = new Timer();
    /**
     * przechowuje wartość 1, gdy zostanie wciśnieta dowolna odpowiedz, zabezpiecza przed wciśnięciem
     * innej odpowiedzi
     */
    int stop;
    /**
     * przechowuje aktualny poziom gry
     */
    int licznik;
    /**
     * licznik wskazujący aktualną wartość w tablicy money
     */
    static int poziom=0;
    /**
     * wskazujczy czy koło ratunkowe zostało wykorzystane
     */
    private int phone=1;
    /**
     * wskazujczy czy koło ratunkowe zostało wykorzystane
     */
    private int half=1;
    /**
     * wskazujczy czy koło ratunkowe zostało wykorzystane
     */
    private int people=1;


    /**
     * Lista przechowująca numery wykorzystanych pytań
     */
    private List<Integer> random_number= new ArrayList<>();
    /**
     * Pole wskazujące czy wylosowane pytanie już się pojawiło
     */
    boolean ifnotRepeatQuestion=true;
    /**
     * Pole wskazujacę jedną z możliwych odpowiedzi po wyborze koła ratunkowego 50/50
     */
    int help;
    /**
     * Pole przechowujące pytanie
     */
    static String pytanie;
    /**
     * Pole przechowujące odpowiedź
     */
    static String odp1;
    /**
     * Pole przechowujące odpowiedź
     */
    static String odp2;
    /**
     * Pole przechowujące odpowiedź
     */
    static String odp3;
    /**
     * Pole przechowujące odpowiedź
     */
    static String odp4;
    /**
     * Pole wskazujący czy udzielono błędnej odpowiedzi
     */
    static int blad=0;
    /**
     * Utworzenie obiektu klasy DataBaseHelper
     */
    DataBaseHelper mDatabaseHelper=new DataBaseHelper(this);;


    /**
     * Metoda zwracająca atualne pytanie
     * @return zwraca numer pytania
     */
    static  int getKtorepyt() {
        return whichquestion;
    }

    /**
     * Tablica przechowująca wartośći pieniężne
     */
    static  String[] money={"0 zł","500 zł","1000 zł","2000 zł","5000 zł","10 000 zł","20 000 zł","40 000 zł","75 000 zł","125 000 zł","250 000 zł","500 000 zł","1 000 000 zł"};



    /**
     * Metoda  użyta do inicjalizacji Aktywności.
     *
     * @param savedInstanceState odwołanie do obiektu pakietu, który jest przekazywany do metody onCreate dla każdej aktywności systemu Android.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        licznik=11;
        poziom=0;
        dataBase.addquestion();
        read();
        mDatabaseHelper.deleteAll();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);



        final TextView question=(TextView) findViewById(R.id.question);
        final TextView moneyText=(TextView) findViewById(R.id.moneyText);

        moneyText.setText("Wygrana:\n "+money[poziom]);



        final Button answer1 = (Button) findViewById(R.id.answer1);
        final Button answer2 = (Button) findViewById(R.id.answer2);
        final Button answer3 = (Button) findViewById(R.id.answer3);
        final Button answer4= (Button) findViewById(R.id.answer4);



        answer1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if(stop==0)
                {
                    stop=1;
        answer1.setBackgroundResource(R.drawable.change_button);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(check1(whichquestion)==1){
                            blad=0;
                            answer1.setBackgroundResource(R.drawable.correct_answear);
                            moneyText.setText("Wygrana: \n"+getMoney());
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    stop=0;
                                    answer1.setBackgroundResource(R.drawable.custom_button);
                                    if(licznik==0){
                                        end();
                                        mDatabaseHelper.deleteAll();


                                    }
                                    else {
                                        licznik--;
                                        visible(answer1,answer2,answer3,answer4);


                                        game();
                                    }

                                }
                            }, 2*1000);
                        }
                        else {
                            answer1.setBackgroundResource(R.drawable.incorrect_answear);
                            blad=1;
                            end();
                            mDatabaseHelper.deleteAll();
                        }
                    }
                }, 2*1000);



            }}


            });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stop==0)
                {
                    stop=1;
                answer2.setBackgroundResource(R.drawable.change_button);

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(check2(whichquestion)==1){
                            blad=0;
                            answer2.setBackgroundResource(R.drawable.correct_answear);
                            moneyText.setText("Wygrana: \n"+getMoney());
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    stop=0;
                                    answer2.setBackgroundResource(R.drawable.custom_button);
                                    if(licznik==0){
                                        end();
                                        mDatabaseHelper.deleteAll();


                                    }
                                    else {
                                        licznik--;
                                        visible(answer1,answer2,answer3,answer4);


                                        game();
                                    }

                                }
                            }, 2*1000);
                        }
                        else{
                            answer2.setBackgroundResource(R.drawable.incorrect_answear);
                            blad=1;
                            end();
                            mDatabaseHelper.deleteAll();

                        }
                    }
                }, 2*1000);

            }}


        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stop==0)
                {
                    stop=1;
                    answer3.setBackgroundResource(R.drawable.change_button);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if(check3(whichquestion)==1){
                                blad=0;
                                answer3.setBackgroundResource(R.drawable.correct_answear);
                                moneyText.setText("Wygrana: \n"+getMoney());
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        stop=0;
                                        answer3.setBackgroundResource(R.drawable.custom_button);
                                        if(licznik==0){
                                            end();
                                            mDatabaseHelper.deleteAll();


                                        }
                                        else {
                                            licznik--;
                                            visible(answer1,answer2,answer3,answer4);

                                            game();
                                        }

                                    }
                                }, 2*1000);
                            }
                            else {
                                answer3.setBackgroundResource(R.drawable.incorrect_answear);
                                blad=1;
                                end();
                                mDatabaseHelper.deleteAll();

                            }
                        }
                    }, 2*1000);

                }
                }



        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stop==0){
                    stop=1;
                answer4.setBackgroundResource(R.drawable.change_button);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if(check4(whichquestion)==1){
                            blad=0;
                            answer4.setBackgroundResource(R.drawable.correct_answear);
                            moneyText.setText("Wygrana: \n"+getMoney());
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    stop=0;
                                    answer4.setBackgroundResource(R.drawable.custom_button);
                                    if(licznik==0){
                                        end();
                                        mDatabaseHelper.deleteAll();


                                    }
                                    else {
                                        licznik--;
                                        visible(answer1,answer2,answer3,answer4);

                                        game();
                                    }

                                }
                            }, 2*1000);
                        }
                        else {
                            answer4.setBackgroundResource(R.drawable.incorrect_answear);
                            blad=1;
                            end();
                            mDatabaseHelper.deleteAll();


                        }
                    }
                }, 2*1000);
            }}


        });
        final ImageView telefon = (ImageView) findViewById(R.id.telefon);
       telefon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               phone=0;
               telefon.setVisibility(View.INVISIBLE);
               firendhelp();
               AddData(whichquestion,poziom,licznik,phone,half,people);


           }
       });
        final ImageView pol = (ImageView) findViewById(R.id.pol);
        pol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pol.setVisibility(View.INVISIBLE);
                half=0;

                if(check1(whichquestion)==1){

                    Random r = new Random();
                    help= r.nextInt(4);
                    while(help==1 || help==0){
                        help=r.nextInt(4);
                    }
                    if(help==2){
                        answer3.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);
                    }
                    else if(help==3){
                        answer2.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);

                    }
                    else if(help==4){
                        answer2.setVisibility(View.INVISIBLE);
                        answer3.setVisibility(View.INVISIBLE);

                    }
                }
                else if(check2(whichquestion)==1){
                    Random r = new Random();
                    help = r.nextInt(4);
                    while(help==2 || help==0){
                        help=r.nextInt(4);
                    }
                    if(help==1){
                        answer3.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);
                    }
                    else if(help==3){
                        answer1.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);

                    }
                    else if(help==4){
                        answer1.setVisibility(View.INVISIBLE);
                        answer3.setVisibility(View.INVISIBLE);

                    }
                }
                else if(check3(whichquestion)==1){
                    Random r = new Random();
                    help = r.nextInt(4);
                    while(help==3 || help==0){
                        help=r.nextInt(4);
                    }
                    if(help==2){
                        answer1.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);
                    }
                    else if(help==1){
                        answer2.setVisibility(View.INVISIBLE);
                        answer4.setVisibility(View.INVISIBLE);

                    }
                    else if(help==4){
                        answer2.setVisibility(View.INVISIBLE);
                        answer1.setVisibility(View.INVISIBLE);

                    }
                }
                else if(check4(whichquestion)==1){
                    Random r = new Random();
                    help = r.nextInt(4);
                    while(help==4 || help==0){
                        help=r.nextInt(4);
                    }
                    if(help==2){
                        answer3.setVisibility(View.INVISIBLE);
                        answer1.setVisibility(View.INVISIBLE);
                    }
                    else if(help==3){
                        answer2.setVisibility(View.INVISIBLE);
                        answer1.setVisibility(View.INVISIBLE);

                    }
                    else if(help==1){
                        answer2.setVisibility(View.INVISIBLE);
                        answer3.setVisibility(View.INVISIBLE);

                    }
                }
                AddData(whichquestion,poziom,licznik,phone,half,people);

            }
        });
        final ImageView publicznosc = (ImageView) findViewById(R.id.publicznosc);

        publicznosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people=0;

                publicznosc.setVisibility(View.INVISIBLE);
                createPlainAlertDialog();
                AddData(whichquestion,poziom,licznik,phone,half,people);
            }

            });


        if(MainActivity.stan==1) {
            if (half == 0)
                pol.setVisibility(View.INVISIBLE);
            if (phone == 0)
                telefon.setVisibility(View.INVISIBLE);
            if (people == 0)
                publicznosc.setVisibility(View.INVISIBLE);
        }
        game();
}


    /**
     * Metoda pobierająca pytanie z bazy
     * @param random numer pytania
     * @return zwraca pytanie
     */
    public String getQuestion(int random){
        return dataBase.getQuestion().get(random).getQuestion();

}

    /**
     * Metoda pobierająca odpowiedź z bazy
     * @param random numer odpowiedzi
     * @return zwraca odpowiedź
     */
    public String getAnswear1(int random){
        return dataBase.getQuestion().get(random).getOdpoiwedz1();

    }
    /**
     * Metoda pobierająca odpowiedź z bazy
     * @param random numer odpowiedzi
     * @return zwraca odpowiedź
     */
    public String getAnswear2(int random){
        return dataBase.getQuestion().get(random).getOdpoiwedz2();

    }
    /**
     * Metoda pobierająca odpowiedź z bazy
     * @param random numer odpowiedzi
     * @return zwraca odpowiedź
     */
    public String getAnswear3(int random){
        return dataBase.getQuestion().get(random).getOdpoiwedz3();

    }
    /**
     * Metoda pobierająca odpowiedź z bazy
     * @param random numer odpowiedzi
     * @return zwraca odpowiedź
     */
    public String getAnswear4(int random){
        return dataBase.getQuestion().get(random).getOdpoiwedz4();

    }

    /**
     * Metoda sprawdzająca czy odpowiedź jest poprawna
     * @param random numer odpowiedzi
     * @return zwraca wartość określająca czy odpowiedź jest poprawna
     */
    public int check1(int random){
        return dataBase.getQuestion().get(random).getPoprawna1();
    }
    /**
     * Metoda sprawdzająca czy odpowiedź jest poprawna
     * @param random numer odpowiedzi
     * @return zwraca wartość określająca czy odpowiedź jest poprawna
     */
    public int check2(int random){
        return dataBase.getQuestion().get(random).getPoprawna2();
    }
    /**
     * Metoda sprawdzająca czy odpowiedź jest poprawna
     * @param random numer odpowiedzi
     * @return zwraca wartość określająca czy odpowiedź jest poprawna
     */
    public int check3(int random){
        return dataBase.getQuestion().get(random).getPoprawna3();
    }
    /**
     * Metoda sprawdzająca czy odpowiedź jest poprawna
     * @param random numer odpowiedzi
     * @return zwraca wartość określająca czy odpowiedź jest poprawna
     */
    public int check4(int random){
        return dataBase.getQuestion().get(random).getPoprawna4();
    }

    /**
     * Metoda losująca nr. pytania oraz pokazujca aktualne pytanie i odpowiedź
     */
    void game(){
        final Button answer1 = (Button) findViewById(R.id.answer1);
        final Button answer2 = (Button) findViewById(R.id.answer2);
        final Button answer3 = (Button) findViewById(R.id.answer3);
        final Button answer4 = (Button) findViewById(R.id.answer4);
        final TextView question=(TextView) findViewById(R.id.question);


        boolean selected=false;
        while(!selected) {
            selected = true;
            ifnotRepeatQuestion=true;
            Random r = new Random();
            whichquestion = r.nextInt(20);
            if (random_number.size() == 0) {
                question.setText(getQuestion(whichquestion));
                answer1.setText("A.  "+getAnswear1(whichquestion));
                answer2.setText("B.  "+getAnswear2(whichquestion));
                answer3.setText("C.  "+getAnswear3(whichquestion));
                answer4.setText("D.  "+getAnswear4(whichquestion));
                ifnotRepeatQuestion=false;
                MainActivity.stan=0;
            } else {

                if(MainActivity.stan==1)
                {
                    MainActivity.stan=0;
                    System.out.println("stan po znowieniu: "+whichquestion);
                    whichquestion=random_number.get(random_number.size()-1);
                    System.out.println("stan po znowieniu: "+whichquestion);

                }else {
                    for (int i = 0; i < random_number.size(); i++) {
                        if (random_number.get(i) == whichquestion) {
                            selected = false;
                            ifnotRepeatQuestion = false;
                            break;
                        }

                    }
                }

                if(ifnotRepeatQuestion) {
                    question.setText(getQuestion(whichquestion));
                    answer1.setText("A.  "+getAnswear1(whichquestion));
                    answer2.setText("B.  "+getAnswear2(whichquestion));
                    answer3.setText("C.  "+getAnswear3(whichquestion));
                    answer4.setText("D.  "+getAnswear4(whichquestion));
                }

            }
        }
     //   writeToFile(a);

        poziom++;
        random_number.add(whichquestion);
        mDatabaseHelper.deleteAll();
        for(int i=0;i<random_number.size();i++)
        AddData(random_number.get(i),poziom,licznik,phone,half,people);



    }

    /**
     * Metoda zwracająca aktualną wartość pienieżną
     * @return zwraca aktualną wygraną
     */
    public String getMoney(){
        System.out.println("poziom "+ poziom);
        return money[poziom];

    }


    /**
     * Metoda ustawiająca widoczność przycisków odpowiedzi
     * @param answer1 Przycisk wykorzystywany do ustawienia jego widoczności
     * @param answer2 Przycisk wykorzystywany do ustawienia jego widoczności
     * @param answer3 Przycisk wykorzystywany do ustawienia jego widoczności
     * @param answer4 Przycisk wykorzystywany do ustawienia jego widoczności
     */
    private void visible(final Button answer1, final Button answer2, final Button answer3, final Button answer4){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                answer1.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.VISIBLE);
                answer4.setVisibility(View.VISIBLE);
            }
        });
    }


    /**
     * Metoda tworząca okno dialogowe dla koła ratunkowego publiczność
     */
    private void createPlainAlertDialog() {
        int i =NewGameActivity.getKtorepyt();
        int poprawna1=dataBase.getQuestion().get(i).getPoprawna1();
        int poprawna2=dataBase.getQuestion().get(i).getPoprawna2();
        int poprawna3=dataBase.getQuestion().get(i).getPoprawna3();
        int poprawna4=dataBase.getQuestion().get(i).getPoprawna4();
        PeopleHelp peopleHelp=new PeopleHelp();

            Random r = new Random();
            int  pop = r.nextInt(50)+40;
            int los1=r.nextInt(100-pop);
            int los2=r.nextInt(100-pop-los1);
            int los3=100-pop-los1-los2;
            if(poprawna1==1)
            {
                peopleHelp.set(pop,los1,los2,los3) ;
            }
            if(poprawna2==1)
            {
                peopleHelp.set(los1,pop,los2,los3) ;
            }
            if(poprawna3==1)
            {
                peopleHelp.set(los1,los2,pop,los3) ;
            }
            if(poprawna4==1)
            {
                peopleHelp.set(los1,los2,los3,pop) ;
            }



        peopleHelp.show(getSupportFragmentManager(),"przyklad");
    }

    static  char phonenumberpop;

    /**
     *Metoda tworząca okno dialogowe dla koła ratunkowego telefon do Przyjaciela
     */
    public void firendhelp(){
        int i =NewGameActivity.getKtorepyt();
        int poprawna1=dataBase.getQuestion().get(i).getPoprawna1();
        int poprawna2=dataBase.getQuestion().get(i).getPoprawna2();
        int poprawna3=dataBase.getQuestion().get(i).getPoprawna3();
        int poprawna4=dataBase.getQuestion().get(i).getPoprawna4();
        Random r = new Random();
        int  pop = r.nextInt(100);

        if(pop>20) {
            if (poprawna1 == 1) {
                phonenumberpop = 'A';

            } else if (poprawna2 == 1) {
                phonenumberpop = 'B';
            } else if (poprawna3 == 1) {
                phonenumberpop = 'C';
            } else
                 {
                phonenumberpop = 'D';
            }
        }
        else{
            phonenumberpop='0';

        }
        pytanie=getQuestion(whichquestion);
        odp1=getAnswear1(whichquestion);
        odp2=getAnswear2(whichquestion);
        odp3=getAnswear3(whichquestion);
        odp4=getAnswear4(whichquestion);


        PhoneHelp phoneHelp=new PhoneHelp();
        phoneHelp.show(getSupportFragmentManager(),"friendhelp");


    }

    /**
     * Metoda wczytująca stan gry po wznowieniu
     */
    public void read(){
        if(MainActivity.stan==1)
        {
            Cursor data=mDatabaseHelper.getData();

            while(data.moveToNext()){
                random_number.add(data.getInt(1));
                System.out.println(getQuestion(data.getInt(1)));
                System.out.println(data.getInt(1));
                poziom=data.getInt(2)-1;
                licznik=data.getInt(3);
                phone=data.getInt(4);
                half=data.getInt(5);
                people=data.getInt(6);

            }

        }
    }

    /**
     * Metoda zapisująca stan gry do bazy
     * @param number numer pytania
     * @param nrmoney indeks dla tablicy przechowująca wartości pieniężne
     * @param degree zawiera aktualny poziom gry
     * @param phone parametr wskazujący czy wykorzystano koło ratunkowe
     * @param half parametr wskazujący czy wykorzystano koło ratunkowe
     * @param people parametr wskazujący czy wykorzystano koło ratunkowe
     */
 public void AddData(int number,int nrmoney, int degree, int phone, int half, int people){
     mDatabaseHelper.addData(number,nrmoney,degree,phone,half,people);

 }

    /**
     * Metoda wczytująca interfejs końca gry
     */
 public void end(){
     Intent intent = new Intent(this, End.class );
     startActivity(intent);
 }



}
