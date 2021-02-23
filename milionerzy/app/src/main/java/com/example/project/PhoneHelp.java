package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

/**
 * Klasa obsługująca koło ratunkowe telefon do przyjaciela
 */
public class PhoneHelp extends AppCompatDialogFragment {

    /**
     * Metoda tworząca okno dialogowe
     * @param savedInstanceState dwołanie do obiektu pakietu, który jest przekazywany do metody onCreate dla każdej aktywności systemu Android.
     * @return zwraca okno dialogowe
     */
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        if(NewGameActivity.phonenumberpop=='0')
        {
            builder.setTitle("Telefon do przyjaciela")
                    .setMessage("Ty:  Cześć, dostałem trudne pytanie. Czy mi pomożesz?\n" +
                            "P:  Jasne, słucham pytania.\n" +
                            "Ty:  " +NewGameActivity.pytanie+
                            "\n"+
                            "        A. "+NewGameActivity.odp1+"\n" +
                            "        B. "+NewGameActivity.odp2+"\n" +
                            "        C. "+NewGameActivity.odp3 +"\n" +
                            "        D. "+NewGameActivity.odp4+
                            "\n" +
                            "P:  Niestety nie umiem odpowiedzieć na to pytanie. Bardzo mi przykro. " +
                            "\n")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }
        else {
            builder.setTitle("Telefon do przyjaciela")
                    .setMessage("Ty:  Cześć, dostałem trudne pytanie. Czy mi pomożesz?\n" +
                            "P:  Jasne, słucham pytania.\n" +
                            "Ty:  " +NewGameActivity.pytanie+
                            "\n"+
                            "        A. "+NewGameActivity.odp1+"\n" +
                            "        B. "+NewGameActivity.odp2+"\n" +
                            "        C. "+NewGameActivity.odp3 +"\n" +
                            "        D. "+NewGameActivity.odp4+"\n"+
                            "P:  Nie jestem pewien, lecz wydaję mi sie, że prawidłowa będzie odpowedź " + NewGameActivity.phonenumberpop +
                            ".\n")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

        }
        return builder.create();
    }




}
