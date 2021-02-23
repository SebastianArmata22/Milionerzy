package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Klasa w której zaczyna się wykonywanie programu
 *
 * @author Sebastian Armata
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity {


    /**
     * Pole przechowujące informację czy zapisano stan gry
     */
    static int stan=0;

    /**
     * Metoda  użyta do inicjalizacji Aktywności.
     *
     * @param savedInstanceState odwołanie do obiektu pakietu, który jest przekazywany do metody onCreate dla każdej aktywności systemu Android.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Przycisk po wciśnięciu którego następuje wczytanie nowej gry
         */
        final Button NewGameButton = (Button) findViewById(R.id.button);
        NewGameButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Metoda, która wywołuje się po wciśnięciu przycisku
             * @param v jest obiektem pliku xml, do którego odwołuje się metoda onCreate
             */
            @Override
            public void onClick(View v) {
                stan=0;


                openNewGameActivity();



            }
        });
        /**
         * Przycisk po wciśnięciu którego następuje wyjście z programu
         */
        final Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
              onPause();
              System.exit(0);


            }
        });
        /**
         * Przycisk po wciśnięciu którego następuje wczytanie zapisanej gry
         */
        Button wznowgre = (Button) findViewById(R.id.wznow);
        wznowgre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    stan = 1;
                    openNewGameActivity();




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
