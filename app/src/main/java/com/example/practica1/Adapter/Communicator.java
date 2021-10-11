package com.example.practica1.Adapter;

import com.example.practica1.Data.Question;
import com.example.practica1.Fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Communicator {
    //Almacena la lista de preguntas y fragmentos que salen para poder mostrar las respuestas en la pantalla de resultados. También almacena los aciertos.
    private static List<Question> Qlist = new ArrayList<>();
    private static List<QuestionFragment> QFlist= new ArrayList<>();
    private static int hits=0;
    public static void setList(List<Question>  newQList) { Qlist = newQList; }
    public static List<Question>  getList() { return Qlist; }
    public static List<QuestionFragment> getQFlist() {return QFlist; }
    public static void setZero_QFList(){QFlist=new ArrayList<>();}
    public static void addFragment(QuestionFragment frag){QFlist.add(frag);}
    public static int getHits() {return hits;}
    public static void addHit(){hits++;}
}
