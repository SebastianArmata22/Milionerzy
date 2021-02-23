package com.example.project;

/**
 * Klasa opisująca obiekt pytanie i odpowiedź
 */
public class Question {
    /**
     * przechowuje wartość id
     */
    private int id;
    /**
     * przechowuje wartość pytania
     */
    private String question;
    /**
     * przechowuje wartość odpowiedź
     */
    private String odpoiwedz1;
    /**
     * przechowuje wartość czy odpowiedz jest poprawna
     */
    private int poprawna1;
    /**
     * przechowuje wartość odpowiedź
     */
    private String odpoiwedz2;
    /**
     * przechowuje wartość czy odpowiedz jest poprawna
     */
    private int poprawna2;
    /**
     * przechowuje wartość odpowiedź
     */
    private String odpoiwedz3;
    /**
     * przechowuje wartość czy odpowiedz jest poprawna
     */
    private int poprawna3;
    /**
     * przechowuje wartość odpowiedź
     */
    private String odpoiwedz4;
    /**
     * przechowuje wartość czy odpowiedz jest poprawna
     */
    private int poprawna4;

    /**
     * Metoda zapisująca wartości obiketu Question
     * @param id zawiera numer id
     * @param question zawiera wartość pytania
     * @param odpoiwedz1 zawiera wartość odpowiedzi
     * @param poprawna1 zawiera wartość poprawnej odpowiedzi
     * @param odpoiwedz2 zawiera wartość odpowiedzi
     * @param poprawna2 zawiera wartość poprawnej odpowiedzi
     * @param odpoiwedz3 zawiera wartość odpowiedzi
     * @param poprawna3 zawiera wartość poprawnej odpowiedzi
     * @param odpoiwedz4 zawiera wartość odpowiedzi
     * @param poprawna4 zawiera wartość poprawnej odpowiedzi
     */
    public Question(int id, String question, String odpoiwedz1, int poprawna1, String odpoiwedz2, int poprawna2, String odpoiwedz3, int poprawna3, String odpoiwedz4, int poprawna4) {
        this.id = id;
        this.question = question;
        this.odpoiwedz1 = odpoiwedz1;
        this.poprawna1 = poprawna1;
        this.odpoiwedz2 = odpoiwedz2;
        this.poprawna2 = poprawna2;
        this.odpoiwedz3 = odpoiwedz3;
        this.poprawna3 = poprawna3;
        this.odpoiwedz4 = odpoiwedz4;
        this.poprawna4 = poprawna4;
    }


    /**
     * Metoda zwracająca pytanie
     * @return zwraca pytanie
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Metoda zwracająca odpowiedź
     * @return zwraca wartość odpowiedzi
     */
    public String getOdpoiwedz1() {
        return odpoiwedz1;
    }


    /**
     * Metoda zwracająca wartość czy odpowiedź jest poprawna
     * @return zwraca wartość czy odpowiedź jest poprawna
     */
    public int getPoprawna1() {
        return poprawna1;
    }

    /**
     * Metoda zwracająca odpowiedź
     * @return zwraca wartość odpowiedzi
     */
    public String getOdpoiwedz2() {
        return odpoiwedz2;
    }


    /**
     * Metoda zwracająca wartość czy odpowiedź jest poprawna
     * @return zwraca wartość czy odpowiedź jest poprawna
     */
    public int getPoprawna2() {
        return poprawna2;
    }


    /**
     * Metoda zwracająca odpowiedź
     * @return zwraca wartość odpowiedzi
     */
    public String getOdpoiwedz3() {
        return odpoiwedz3;
    }

    /**
     * Metoda zwracająca wartość czy odpowiedź jest poprawna
     * @return zwraca wartość czy odpowiedź jest poprawna
     */
    public int getPoprawna3() {
        return poprawna3;
    }


    /**
     * Metoda zwracająca odpowiedź
     * @return zwraca wartość odpowiedzi
     */
    public String getOdpoiwedz4() {
        return odpoiwedz4;
    }


    /**
     * Metoda zwracająca wartość czy odpowiedź jest poprawna
     * @return zwraca wartość czy odpowiedź jest poprawna
     */
    public int getPoprawna4() {
        return poprawna4;
    }


}
