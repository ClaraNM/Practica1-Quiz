package com.example.practica1.Data;

import android.content.Context;

import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.R;

import java.util.List;

public class QuestionDataBase {

    private static List<Question> questionList;

    public static List<Question> getQuestionPool(int size, Context context) throws Exception {
        DbQuerys dbQuerys = new DbQuerys(context);
        questionList = dbQuerys.getQuestionPool(size);
        return questionList;
/*
        if(size > questionList.size())
            throw new Exception();
        else if (size == questionList.size())
            return  questionList;
        else{
            Random random = new Random();
            List<Question> questions = new ArrayList<Question>(size);
            List<Question> questionPool = new ArrayList<Question>(questionList);
            for (int i = 0; i < size; i++){
                questions.add(questionPool.remove(random.nextInt(questionList.size() - i)));
            }
            return questions;
        }*/
    }

    public static void InitializeDataBase(Context context){
        DbQuerys dbQuerys = new DbQuerys(context);
        dbQuerys.insertTextQuestion(new TextQuestion(0,"¿Qué juego ganó el GOTY en 2020?", "Death Stranding", "Sekiro: Shadows Die Twice", "Hollow Knight", "Smash Bros Ultimate", 0));
        dbQuerys.insertTextQuestion(new TextQuestion(1,"¿En qué generación de Pokémon se introdujo la distinción entre movimientos físicos y especiales?", "Tercera generación", "Cuarta generación", "Segunda generación", "Quinta generación", 1));
        dbQuerys.insertTextQuestion(new TextQuestion(2,"¿Cuál es el nombre del hijo de Kratos?", "Alexios", "Einar", "Atreus", "Sigurd", 2));
        dbQuerys.insertTextQuestion(new TextQuestion(3,"¿En qué videojuego spin-off de Mario apareció por primera vez Mario bebé", "Mario Kart", "Mario & Luigi: Compañeros en el Tiempo", "Mario Golf", "Yoshi Island", 3));
        dbQuerys.insertTextQuestion(new TextQuestion(4,"¿Qué juego ganó el premio a mejor juego independiente en 2019?", "Disco Elyseum", "Untitled Goose Game", "Hades", "Celeste", 0));
        dbQuerys.insertTextQuestion(new TextQuestion(5,"¿Con qué clase empieza tu personaje desnudo en Dark Souls 1?", "Desamparado", "Marginado", "Vagabundo", "Ermitaño", 1));
        dbQuerys.insertTextQuestion(new TextQuestion(6,"¿Qué personaje del LoL salió antes?", "Nasus", "Nidalee", "Morgana", "Hermendiger", 2));
        dbQuerys.insertTextQuestion(new TextQuestion(7,"¿Cuál de los siguientes minijuegos no es una final de Fall Guys?", "Club de salto", "Sopa de tropezones", "Hielo fino", "Telesilla", 3));

        dbQuerys.insertNumberQuestion(new NumberQuestion(0,"¿Cuántos personajes hay en el Smash Bros Ultimate incluyendo los DLCs?", 82));
        dbQuerys.insertNumberQuestion(new NumberQuestion(1,"Siguiendo la numeración de la saga principal de Metroid. ¿Qué número es el Metroid Dread?", 5));
        dbQuerys.insertNumberQuestion(new NumberQuestion(2,"¿Cuántas entregas de Gears of War hay? Sin contar spin-offs", 6));
        dbQuerys.insertNumberQuestion(new NumberQuestion(3,"¿Cuántos campeones de Demacia hay en el LoL?", 16));

        dbQuerys.insertImageQuestion(new ImageQuestion(0,"¿Quién es este personaje del Hollow Knight?", R.drawable.image_question_cornifer ,"Zote", "Tiso", "Cornifer", "Quirrel", 2));
        dbQuerys.insertImageQuestion(new ImageQuestion(1,"¿Cuál es el color característico de este personaje de Sonic?", R.drawable.image_question_amy_bnw, "Rosa", "Naranja", "Morado", "Amarillo", 0));
        dbQuerys.insertImageQuestion(new ImageQuestion(2,"¿Cómo se llama este jefe del Dark Souls III?", R.drawable.image_question_vigilantes, "Campeón Gundyr", "Caballero esclavo Gael", "Alma de Cenizas", "Los vigilantes del Abismo", 3));
        dbQuerys.insertImageQuestion(new ImageQuestion(3,"¿Quién es este personaje del Animal Crossing?", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1));

        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(0,"¿Cuál de estos pokemon tiene más defensa?", R.drawable.image_op_question_shuckle, R.drawable.image_op_question_celesteela, R.drawable.image_op_question_bastiodon, R.drawable.image_op_question_galarianstunkfish, 0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(1,"¿Quién sale en Resident Evil 2?", R.drawable.image_op_question_jill, R.drawable.image_op_question_adawong, R.drawable.image_op_question_mia, R.drawable.image_op_question_sheva,  1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(2,"¿Quién es Apollo Justice de la saga Ace Attorney?", R.drawable.image_op_question_godot, R.drawable.image_op_question_edgeworth, R.drawable.image_op_question_apollo, R.drawable.image_op_question_phoenix,  2));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(3,"¿Quién de estos personajes de Nier Automata es A2?", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3));

        dbQuerys.insertSoundQuestion(new SoundQuestion(0,"pregunta", "OP1", "OP2", "OP3", "OP4", 0, R.raw.song));

        dbQuerys.insertVideoQuestion(new VideoQuestion(0,"pregunta", "OP1", "OP2", "OP3", "OP4", 0, R.raw.video));

    }

}
