package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Klasa obsługująca koniec gry
 */
public class End extends AppCompatActivity {

    /**
     * Metoda  użyta do inicjalizacji Aktywności.
     *
     * @param savedInstanceState odwołanie do obiektu pakietu, który jest przekazywany do metody onCreate dla każdej aktywności systemu Android.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        /**
         * Pole pokazujące aktualną wygranę
         */
        final TextView winText=(TextView) findViewById(R.id.winText);

        if(NewGameActivity.poziom-1<=1){
            winText.setText("Twoja wygrana to:\n 0zł ");

        }else if(NewGameActivity.poziom-1<7 && NewGameActivity.poziom-1>1){
        winText.setText("Twoja wygrana to:\n 1 000 zł.");
        }
        else if(NewGameActivity.poziom-1>=7 && NewGameActivity.poziom-1<11){
            winText.setText("Twoja wygrana to:\n 40 000 zł.");}
        else
            winText.setText("Twoja wygrana to:\n 1 000 000 zł.");


        /**
         * Przycisk po wciśnięciu którego następuje wczytanie nowej gry
         */
        Button newgame = (Button) findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.stan=0;
                openNewGameActivity();


            }
        });
        /**
         * Przycisk po wciśnięciu którego następuje wyjście do menu
         */
        Button endgame = (Button) findViewById(R.id.endgame);
        endgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }
    /**
     * Metoda wczytująca nową aktywność związaną z wczytaniem nowej rozgrywki
     */
    public void  openNewGameActivity()
    {
        Intent intent = new Intent(this, NewGameActivity.class );
        startActivity(intent);
    }
}
