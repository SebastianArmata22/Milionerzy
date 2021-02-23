package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Klasa do tworzenia oraz obsługi bazy danych
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    /**
     * Przechowuje nazwę tabeli bazy
     */
    private static final String TABLE_NAME="Question";
    /**
     * Przechowuje wersję bazy
     */
    private static final int DATABASE_VERSION=1;
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col1="ID";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col2="nrquestion";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col3="nrmoney";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col4="degree";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col5="phone";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col6="half";
    /**
     * Przechowuje nazwę kolumny bazy
     */
    private static final String col7="people";



    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }


    /**
     * Wywoływana, gdy baza danych jest tworzona po raz pierwszy. W tym miejscu powinno się tworzyć tabele.
     * @param db obiekt bazy danych
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="CREATE TABLE " +TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+col2+" NUMBER, "+col3+" NUMBER, "+col4+" NUMBER, "+col5+" NUMBER, "+col6+" NUMBER, "+col7+" NUMBER)";
        db.execSQL(createTable);

    }

    /**
     * Wywoływana, gdy baza danych wymaga aktualizacji.
     * @param db obiekt bazy danych
     * @param oldVersion wartość starszej wersji bazy danych
     * @param newVersion wartosć nowszej wersji bazy danych
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    /**
     * Wywoływana, gdy do bazy danych dodawane są nowe rekordy
     * @param number numer pyatnia
     * @param nrmoney numer indeksu w tablicy wskazujący aktualną wartość pieniężną
     * @param degree wskazuje aktualny stan gry
     * @param phone wartość wskazująca czy koło ratunkowe telefon do przyjaciela zostało wykorzystane
     * @param half wartość wskazująca czy koło ratunkowe 50/50 zostało wykorzystane
     * @param people wartość wskazująca czy koło ratunkowe publiczność zostało wykorzystane
     */
    public void addData(int number, int nrmoney, int degree, int phone, int half, int people){
        SQLiteDatabase db =this.getReadableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(col2,number);
        contentValues.put(col3,nrmoney);
        contentValues.put(col4,degree);
        contentValues.put(col5,phone);
        contentValues.put(col6,half);
        contentValues.put(col7,people);

        try {
            db.insert(TABLE_NAME, null, contentValues);

        }catch (SQLException e){
            Log.i("Error write",e.getMessage());
        }


    }

    /**
     * metoda wywoływana w momencie pobierania danych z bazy
     * @return zwraca dane z bazy
     */
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;



    }

    /**
     * Metoda wywoływana w momencie usuwania danych z bazy
     */
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(TABLE_NAME,null,null);
        db.close();
    }
}
