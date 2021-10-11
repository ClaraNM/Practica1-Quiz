package com.example.practica1.Adapter;

import com.example.practica1.Data.Question;
import com.example.practica1.Fragment.QuestionFragment;

import java.util.LinkedList;
import java.util.List;

public class Communicator {
    private static List<Question> Qlist = null;
    private static List<QuestionFragment> QFlist= new LinkedList<>();
    private static int hits=0;
    public static void setList(List<Question>  newQList) { Qlist = newQList; }
    public static List<Question>  getList() { return Qlist; }
    public static List<QuestionFragment> getQFlist() {return QFlist; }
    public static void addFragment(QuestionFragment frag){QFlist.add(frag);}
    public static int getHits() {return hits;}
    public static void addHit(){hits++;}
}
