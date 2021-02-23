package com.example.project;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa służąca do przechowywania i wczytywania pytań
 */
public class DataBase {

    /**
     * Lista do przechowywania pytań
     */
    private List<Question> question=new ArrayList<Question>();

    /**
     * Metoda do wczytywania pytań do listy
     */
    public void addquestion(){
        question.add(new Question(1,"Kiedy nastąpiła katastrofa elektrowni jądrowej w Czarnobylu?","1. grudnia 1988",0,"3. stycznia 1990",0,"12. maja 1999",0,"26. kwietnia 1986",1));
        question.add(new Question(2,"kim był Tadeusz Rejtan?","Szlachcicem",1,"Rycerzem",0,"Prezydentem",0,"Premierem",0));
        question.add(new Question(3,"W którym roku odbył się chrzest Polski?","1290",0,"1320",0,"966",1,"996",0));
        question.add(new Question(4,"Co jest stolicą Polski?","Poznań",0,"Warszawa",1,"Kraków",0,"Kielce",0));
        question.add(new Question(5,"Największy ocean to:","Ocean Atlantycki",0,"Ocean Indyjski",0,"Ocean Spokojny",1,"Ocean Arktyczny",0));
        question.add(new Question(6,"Kto wynalazł żarówkę?","Ferdynand Magellan",0,"Jeremi Wiśniowiecki",0,"Joseph Goebbels",0,"Thomas Edison",1));
        question.add(new Question(7,"W którym roku odbyły się pierwsze igrzyska olimpijskie?","776 p.n.e.",1,"772 p.n.e.",0,"780 p.n.e.",0,"786 p.n.e.",0));
        question.add(new Question(8,"Stolicą Armeni jest:","Ankara",0,"Erywań",1,"Astana",0,"Skopje",0));
        question.add(new Question(9,"Kiedy był pierwszy rozbiór Polski?","1770",0,"1792",0,"1794",0,"1772",1));
        question.add(new Question(10,"Nadymka to:","kwiat",0,"ptak",0,"ryba",1,"owad",0));
        question.add(new Question(11,"Założyciel firmy 'Amazon'  to:","Jeff Bezos",1,"Bernard Arnault",0,"Warren Buffett",0,"Elon Musk",0));
        question.add(new Question(12,"Najwyższy szczyt Europy to:","Kilimandżaro",0,"Mount Everest",0,"Mont Blanc",1,"Gerlach",0));
        question.add(new Question(13,"Ile państw znajduje się w Europie?","55",0,"28",0,"60",0,"46",1));
        question.add(new Question(14,"Ile planet znajduje się w układzie słonecznym?","8",1,"7",0,"6",0,"9",0));
        question.add(new Question(15,"Ile sekund potrzeba aby światło dotarło ze Słońca do Ziemi?","ok 15s.",0,"ok 2s.",0,"ok. 8.5s.",1,"30s.",0));
        question.add(new Question(16,"Jaki symbol ma potas?","Cl",0,"K",1,"Li",0,"Mg",0));
        question.add(new Question(17,"Z ilu atomów tlenu składa się cząsteczka wody?","1",1,"2",0,"woda nie posiada atomów tlenu",0,"3",0));
        question.add(new Question(18,"kto opracował układ okresowy pierwiastków?","Henry Moseley",0,"Lothar Meyer",0,"Dmitrij Mendelejew",1,"John Newlands",0));
        question.add(new Question(19,"Ile przekątnych ma sześciokąt foremny?","6",0,"9",1,"8",0,"12",0));
        question.add(new Question(20,"Ile gwiazd znajduję się na fladze USA?","49",0,"48",0,"52",0,"50",1));









    }

    /**
     * Metoda zwracająca obiekty pytań
     * @return zwraca pytania
     */
    public List<Question> getQuestion() {
        return question;
    }
}
