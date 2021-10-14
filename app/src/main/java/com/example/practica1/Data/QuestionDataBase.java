package com.example.practica1.Data;

import com.example.practica1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionDataBase {

    private static List<Question> questionList;

    public static List<Question> getQuestionPool(int size) throws Exception {

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
        }
    }

    public static void InitializeDataBase(){

        questionList = new ArrayList<>();

        questionList.add(new TextQuestion("¿Qué juego ganó el GOTY en 2020?", "Death Stranding", "Sekiro: Shadows Die Twice", "Hollow Knight", "Smash Bros Ultimate", 0));
        questionList.add(new TextQuestion("¿En qué generación de Pokémon se introdujo la distinción entre movimientos físicos y especiales?", "Tercera generación", "Cuarta generación", "Segunda generación", "Quinta generación", 1));
        questionList.add(new TextQuestion("¿Cuál es el nombre del hijo de Kratos?", "Alexios", "Einar", "Atreus", "Sigurd", 2));
        questionList.add(new TextQuestion("¿En qué videojuego spin-off de Mario apareció por primera vez Mario bebé", "Mario Kart", "Mario & Luigi: Compañeros en el Tiempo", "Mario Golf", "Yoshi's Island", 3));
        questionList.add(new TextQuestion("¿Qué juego ganó el premio a mejor juego independiente en 2019?", "Disco Elyseum", "Untitled Goose Game", "Hades", "Celeste", 0));
        questionList.add(new TextQuestion("¿Con qué clase empieza tu personaje desnudo en Dark Souls 1?", "Desamparado", "Marginado", "Vagabundo", "Ermitaño", 1));
        questionList.add(new TextQuestion("¿Qué personaje del LoL salió antes?", "Nasus", "Nidalee", "Morgana", "Hermendiger", 2));
        questionList.add(new TextQuestion("¿Cuál de los siguientes minijuegos no es una final de Fall Guys?", "Club de salto", "Sopa de tropezones", "Hielo fino", "Telesilla", 3));

        questionList.add(new ImageOptionsQuestion("¿Cuál de estos pokemon tiene más defensa?", R.drawable.image_op_question_shuckle, R.drawable.image_op_question_celesteela, R.drawable.image_op_question_bastiodon, R.drawable.image_op_question_galarianstunkfish, 0));
        questionList.add(new ImageOptionsQuestion("¿Quién sale en Resident Evil 2?", R.drawable.image_op_question_jill, R.drawable.image_op_question_adawong, R.drawable.image_op_question_mia, R.drawable.image_op_question_sheva,  1));
        questionList.add(new ImageOptionsQuestion("¿Quién es Apollo Justice de la saga Ace Attorney?", R.drawable.image_op_question_godot, R.drawable.image_op_question_edgeworth, R.drawable.image_op_question_apollo, R.drawable.image_op_question_phoenix,  2));
        questionList.add(new ImageOptionsQuestion("¿Quién de estos personajes de Nier Automata es A2?", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3));

        questionList.add(new NumberQuestion("¿Cuántos personajes hay en el Smash Bros Ultimate incluyendo los DLCs?", 82));
        questionList.add(new NumberQuestion("Siguiendo la numeración de la saga principal de Metroid. ¿Qué número es el Metroid Dread?", 5));
        questionList.add(new NumberQuestion("¿Cuántas entregas de Gears of War hay? Sin contar spin-offs", 6));
        questionList.add(new NumberQuestion("¿Cuántos campeones de Demacia hay en el LoL?", 16));

        questionList.add(new ImageQuestion("¿Quién es este personaje del Hollow Knight?", "Zote", "Tiso", "Cornifer", "Quirrel", 2, R.drawable.image_question_cornifer));
        questionList.add(new ImageQuestion("¿Cuál es el color característico de este personaje de Sonic?", "Rosa", "Naranja", "Morado", "Amarillo", 0, R.drawable.image_question_amy_bnw));
        questionList.add(new ImageQuestion("¿Cómo se llama este jefe del Dark Souls III?", "Campeón Gundyr", "Caballero esclavo Gael", "Alma de Cenizas", "Los vigilantes del Abismo", 3, R.drawable.image_question_vigilantes));
        questionList.add(new ImageQuestion("¿Quién es este personaje del Animal Crossing?", "Calabazo", "Soponcio", "Zapirón", "Rufino", 1, R.drawable.image_question_soponcio));
    }
}
