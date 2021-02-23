package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Random;

/**
 * Klasa obsługująca koło ratunkowe publiczność
 */
public class PeopleHelp extends AppCompatDialogFragment {

    /**
     * przechowuję wartość wskazująca na ile procent dana odpowiedź jest poprawna
     */
   private int a;
    /**
     * przechowuję wartość wskazująca na ile procent dana odpowiedź jest poprawna
     */
   private int b;
    /**
     * przechowuję wartość wskazująca na ile procent dana odpowiedź jest poprawna
     */
   private int c;
    /**
     * przechowuję wartość wskazująca na ile procent dana odpowiedź jest poprawna
     */
    private int d;

    /**
     * Metoda zapisująca wartość na ile procent dana odpowiedź jest poprawna
     * @param a wskazuje na ile procent dana odpowiedź jest poprawna
     * @param b wskazuje na ile procent dana odpowiedź jest poprawna
     * @param c wskazuje na ile procent dana odpowiedź jest poprawna
     * @param d wskazuje na ile procent dana odpowiedź jest poprawna
     */
    public  void set(int a,int b,int c,int d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }


    /**
     * Metoda tworząca okno dialogowe
     * @param savedInstanceState dwołanie do obiektu pakietu, który jest przekazywany do metody onCreate dla każdej aktywności systemu Android.
     * @return zwraca okno dialogowe
     */
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Społeczność")
                .setMessage("Społecznosć wskazała poprawną odpowiedź:\n \n"+"A. na "+a+"%"+"\n"+"B. na "+b+"%"+"\n"+"C. na "+c+"%"+"\n"+"D. na "+d+"%"+"\n \n Powodzenia !!!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }


}
