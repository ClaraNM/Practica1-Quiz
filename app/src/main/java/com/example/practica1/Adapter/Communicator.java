package com.example.practica1.Adapter;

import com.example.practica1.Data.AccountProfile;
import com.example.practica1.Data.Profile;
import com.example.practica1.Data.Question;
import com.example.practica1.Fragment.QuestionFragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Communicator {

    //Almacena la lista de preguntas y fragmentos que salen para poder mostrar las respuestas en la pantalla de resultados. También almacena los aciertos.
    private static List<Question> Qlist = new ArrayList<>();
    private static List<QuestionFragment> QFlist= new ArrayList<>();
    private static Profile newProfile= new Profile(null,0, null);
    private static AccountProfile accountProfile = null;
    public static int selectedProfileId = -1;
    private static int hits=0;
    public static void setList(List<Question>  newQList) { Qlist = newQList; }
    public static List<Question> getList() { return Qlist; }
    public static List<QuestionFragment> getQFlist() {return QFlist; }
    public static void setZero_QFList(){QFlist=new ArrayList<>();}
    public static void addFragment(QuestionFragment frag){QFlist.add(frag);}
    public static int getHits() {return hits;}
    public static void setZero_Hits(){hits=0;}
    public static void addHit(){hits++;}

    //Pasa la info del perfil del jugador
    public static void setNewProfile(Profile profile){
        newProfile=profile;
    }
    public static Profile getNewProfile() {
        return newProfile;
    }

    // Información del perfil de la cuenta del jugador
    public static void setAccountProfile(AccountProfile profile){ accountProfile = profile; }
    public static AccountProfile getAccountProfile(){ return accountProfile;}
    public static int getSelectedProfileId(){ return selectedProfileId; }

}
