package com.example.practica1.Data;

import android.content.Context;

import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionDataBase {

    private static List<Question> questionListAux;
    private static List<Question> questionList=new ArrayList<Question>();
    public static List<Question> getQuestionPool(int size, int d,boolean c1,boolean c2,boolean c3,Context context) throws Exception {
        questionListAux=new ArrayList<Question>();
        DbQuerys dbQuerys = new DbQuerys(context);
        Random r=new Random();
        int randomQ;
        if ( c1==true &&  c2==true &&  c3==false){
            questionListAux=dbQuerys.getAAA_Indie();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxAAA_IndieTextQuestion()+dbQuerys.getMaxAAA_IndieNumberQuestion()+dbQuerys.getMaxAAA_IndieImgQuestion()+dbQuerys.getMaxAAA_IndieImgOpQuestion()+dbQuerys.getMaxAAA_IndieSoundQuestion()+dbQuerys.getMaxAAA_IndieVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else{
                for (int i = 0; i < size; i++) {
                randomQ=r.nextInt((dbQuerys.getMaxAAA_IndieTextQuestion()+dbQuerys.getMaxAAA_IndieNumberQuestion()+dbQuerys.getMaxAAA_IndieImgQuestion()+dbQuerys.getMaxAAA_IndieImgOpQuestion()+dbQuerys.getMaxAAA_IndieSoundQuestion()+dbQuerys.getMaxAAA_IndieVideoQuestion()));
                if (questionListAux.get(randomQ).getDificulty()==0){
                    if (questionList.size()>0) {
                        if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                    }else{ questionList.add(questionListAux.get(randomQ)); }
                } else{ i--;}
            }
            }
        }else if ( c1==true &&  c2==false &&  c3==true){
            questionListAux=dbQuerys.getAAA_Industry();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxAAA_IndustryTextQuestion()+dbQuerys.getMaxAAA_IndustryNumberQuestion()+dbQuerys.getMaxAAA_IndustryImgQuestion()+dbQuerys.getMaxAAA_IndustryImgOpQuestion()+dbQuerys.getMaxAAA_IndustrySoundQuestion()+dbQuerys.getMaxAAA_IndustryVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else {
                for (int i = 0; i < size; i++) {
                    randomQ = r.nextInt((dbQuerys.getMaxAAA_IndustryTextQuestion() + dbQuerys.getMaxAAA_IndustryNumberQuestion() + dbQuerys.getMaxAAA_IndustryImgQuestion() + dbQuerys.getMaxAAA_IndustryImgOpQuestion() + dbQuerys.getMaxAAA_IndustrySoundQuestion() + dbQuerys.getMaxAAA_IndustryVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }else if ( c1==false &&  c2==true &&  c3==true){
            questionListAux=dbQuerys.getIndie_Industry();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ = r.nextInt((dbQuerys.getMaxIndie_IndustryTextQuestion() + dbQuerys.getMaxIndie_IndustryNumberQuestion() + dbQuerys.getMaxIndie_IndustryImgQuestion() + dbQuerys.getMaxIndie_IndustryImgOpQuestion() + dbQuerys.getMaxIndie_IndustrySoundQuestion() + dbQuerys.getMaxIndie_IndustryVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else{
                for (int i = 0; i < size; i++) {
                    randomQ = r.nextInt((dbQuerys.getMaxIndie_IndustryTextQuestion() + dbQuerys.getMaxIndie_IndustryNumberQuestion() + dbQuerys.getMaxIndie_IndustryImgQuestion() + dbQuerys.getMaxIndie_IndustryImgOpQuestion() + dbQuerys.getMaxIndie_IndustrySoundQuestion() + dbQuerys.getMaxIndie_IndustryVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }else if ( c1==true &&  c2==false &&  c3==false){
            questionListAux=dbQuerys.getOnlyAAA();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(0)+dbQuerys.getMaxOnlyThemeNumberQuestion(0)+dbQuerys.getMaxOnlyThemeImgQuestion(0)+dbQuerys.getMaxOnlyThemeImgOpQuestion(0)+dbQuerys.getMaxOnlyThemeSoundQuestion(0)+dbQuerys.getMaxOnlyThemeVideoQuestion(0)));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else{
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(0)+dbQuerys.getMaxOnlyThemeNumberQuestion(0)+dbQuerys.getMaxOnlyThemeImgQuestion(0)+dbQuerys.getMaxOnlyThemeImgOpQuestion(0)+dbQuerys.getMaxOnlyThemeSoundQuestion(0)+dbQuerys.getMaxOnlyThemeVideoQuestion(0)));
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }else if ( c1==false &&  c2==true &&  c3==false){
            questionListAux=dbQuerys.getOnlyIndie();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(1)+dbQuerys.getMaxOnlyThemeNumberQuestion(1)+dbQuerys.getMaxOnlyThemeImgQuestion(1)+dbQuerys.getMaxOnlyThemeImgOpQuestion(1)+dbQuerys.getMaxOnlyThemeSoundQuestion(1)+dbQuerys.getMaxOnlyThemeVideoQuestion(1)));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                    }
                }else{
                       for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(1)+dbQuerys.getMaxOnlyThemeNumberQuestion(1)+dbQuerys.getMaxOnlyThemeImgQuestion(1)+dbQuerys.getMaxOnlyThemeImgOpQuestion(1)+dbQuerys.getMaxOnlyThemeSoundQuestion(1)+dbQuerys.getMaxOnlyThemeVideoQuestion(1)));
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }else if ( c1==false &&  c2==false &&  c3==true){
            questionListAux=dbQuerys.getOnlyIndustry();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(2)+dbQuerys.getMaxOnlyThemeNumberQuestion(2)+dbQuerys.getMaxOnlyThemeImgQuestion(2)+dbQuerys.getMaxOnlyThemeImgOpQuestion(2)+dbQuerys.getMaxOnlyThemeSoundQuestion(2)+dbQuerys.getMaxOnlyThemeVideoQuestion(2)));
                    if (questionListAux.get(randomQ).getDificulty()==1){if (questionList.size()>0) {
                        if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                    }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else{
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(2)+dbQuerys.getMaxOnlyThemeNumberQuestion(2)+dbQuerys.getMaxOnlyThemeImgQuestion(2)+dbQuerys.getMaxOnlyThemeImgOpQuestion(2)+dbQuerys.getMaxOnlyThemeSoundQuestion(2)+dbQuerys.getMaxOnlyThemeVideoQuestion(2)));
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }else{
            questionListAux=dbQuerys.getAll();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxTextQuestion()+dbQuerys.getMaxNumberQuestion()+dbQuerys.getMaxImageQuestion()+dbQuerys.getMaxImageOpQuestion()+dbQuerys.getMaxSoundQuestion()+dbQuerys.getMaxVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }else{
                for (int i = 0; i < size; i++) {
                    randomQ=r.nextInt((dbQuerys.getMaxTextQuestion()+dbQuerys.getMaxNumberQuestion()+dbQuerys.getMaxImageQuestion()+dbQuerys.getMaxImageOpQuestion()+dbQuerys.getMaxSoundQuestion()+dbQuerys.getMaxVideoQuestion()));
                    if (questionListAux.get(randomQ).getDificulty()==0) {
                        if (questionList.size()>0) {
                            if (questionList.contains(questionListAux.get(randomQ))) { i--; } else {questionList.add(questionListAux.get(randomQ)); }
                        }else{ questionList.add(questionListAux.get(randomQ)); }
                    } else{ i--;}
                }
            }
        }
        return questionList;

    }

    public static void InitializeDataBase(Context context){
        DbQuerys dbQuerys = new DbQuerys(context);
        dbQuerys.insertTextQuestion(new TextQuestion(0,"¿Qué juego ganó el GOTY en 2020?", "Death Stranding", "Sekiro: Shadows Die Twice", "Hollow Knight", "Smash Bros Ultimate", 0,0,0));
        dbQuerys.insertTextQuestion(new TextQuestion(1,"¿En qué generación de Pokémon se introdujo la distinción entre movimientos físicos y especiales?", "Tercera generación", "Cuarta generación", "Segunda generación", "Quinta generación", 1,1,0));
        dbQuerys.insertTextQuestion(new TextQuestion(2,"¿Cuál es el nombre del hijo de Kratos?", "Alexios", "Einar", "Atreus", "Sigurd", 2,0,0));
        dbQuerys.insertTextQuestion(new TextQuestion(3,"¿En qué videojuego spin-off de Mario apareció por primera vez Mario bebé", "Mario Kart", "Mario & Luigi: Compañeros en el Tiempo", "Mario Golf", "Yoshi Island", 3,0,0));
        dbQuerys.insertTextQuestion(new TextQuestion(4,"¿Qué juego ganó el premio a mejor juego independiente en 2019?", "Disco Elyseum", "Untitled Goose Game", "Hades", "Celeste", 0,1,1));
        dbQuerys.insertTextQuestion(new TextQuestion(5,"¿Con qué clase empieza tu personaje desnudo en Dark Souls 1?", "Desamparado", "Marginado", "Vagabundo", "Ermitaño", 1,1,0));
        dbQuerys.insertTextQuestion(new TextQuestion(6,"¿Qué personaje del LoL salió antes?", "Nasus", "Nidalee", "Morgana", "Hermendiger", 2,1,0));
        dbQuerys.insertTextQuestion(new TextQuestion(7,"¿Cuál de los siguientes minijuegos no es una final de Fall Guys?", "Club de salto", "Sopa de tropezones", "Hielo fino", "Telesilla", 3,1,0));
        dbQuerys.insertTextQuestion(new TextQuestion(8,"¿Quién es creador de la saga Smash Bros ?", "Miyamoto", "Sakurai", "Kojima", "Yoko Taro", 1,0,2));
        dbQuerys.insertTextQuestion(new TextQuestion(9,"¿Cuál de los siguientes estudios ha sido adquirido por Devolver Digital?", "Super Giants", "Red Candle", "Team 7", "Croteam", 3,1,2));
        dbQuerys.insertTextQuestion(new TextQuestion(10,"¿Cómo se llama el país donde trabajamos en Papers Please?", "Novosibirsk", "Arstotzka", "Salejard", "Kazán", 1,1,1));

        dbQuerys.insertNumberQuestion(new NumberQuestion(0,"¿Cuántos personajes hay en el Smash Bros Ultimate incluyendo los DLCs?", 82,1,0));
        dbQuerys.insertNumberQuestion(new NumberQuestion(1,"Siguiendo la numeración de la saga principal de Metroid. ¿Qué número es el Metroid Dread?", 5,0,0));
        dbQuerys.insertNumberQuestion(new NumberQuestion(2,"¿Cuántas entregas de Gears of War hay? Sin contar spin-offs", 6,0,0));
        dbQuerys.insertNumberQuestion(new NumberQuestion(3,"¿Cuántos campeones de Demacia hay en el LoL?", 16,1,0));
        dbQuerys.insertNumberQuestion(new NumberQuestion(4,"¿Cuántos regalos a una persona puedes hacer a la semana en Stardew Valley?", 2,0,1));
        dbQuerys.insertNumberQuestion(new NumberQuestion(5,"¿Cuántos jefes hay en Hyper Light Drifter?", 8,1,1));
        dbQuerys.insertNumberQuestion(new NumberQuestion(6,"¿Cuántos videojuegos ha desarrollado Jonathan Blow?", 2,1,2));
        dbQuerys.insertNumberQuestion(new NumberQuestion(7,"¿Cuántas personas desarrollaron Stardew Valley?", 1,0,2));
        dbQuerys.insertNumberQuestion(new NumberQuestion(8,"¿Cuántas entregas hay de la saga Little Nightmares?", 2,0,1));
        dbQuerys.insertNumberQuestion(new NumberQuestion(9,"¿Cuánto porcentaje de acciones de Devolver Digital ha comprado Sony recientemente?", 5,1,2));
        dbQuerys.insertNumberQuestion(new NumberQuestion(10,"¿Cuántos tipos hay en TemTem?", 12,1,1));

        dbQuerys.insertImageQuestion(new ImageQuestion(0,"¿Quién es este personaje del Hollow Knight?", R.drawable.image_question_cornifer ,"Zote", "Tiso", "Cornifer", "Quirrel", 2,0,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(1,"¿Cuál es el color característico de este personaje de Sonic?", R.drawable.image_question_amy_bnw, "Rosa", "Naranja", "Morado", "Amarillo", 0,0,0));
        dbQuerys.insertImageQuestion(new ImageQuestion(2,"¿Cómo se llama este jefe del Dark Souls III?", R.drawable.image_question_vigilantes, "Campeón Gundyr", "Caballero esclavo Gael", "Alma de Cenizas", "Los vigilantes del Abismo", 3,0,0));
        dbQuerys.insertImageQuestion(new ImageQuestion(3,"¿Quién es este personaje del Animal Crossing?", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,0,0));
        dbQuerys.insertImageQuestion(new ImageQuestion(4,"Pregunta5", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,0,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(5,"Pregunta6", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,1,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(6,"Pregunta7", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,1,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(7,"Pregunta8", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,0,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(8,"Pregunta9", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,1,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(9,"Pregunta10", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,0,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(10,"Pregunta11", R.drawable.image_question_soponcio, "Calabazo", "Soponcio", "Zapirón", "Rufino", 1,1,0));

        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(0,"¿Cuál de estos pokemon tiene más defensa?", R.drawable.image_op_question_shuckle, R.drawable.image_op_question_celesteela, R.drawable.image_op_question_bastiodon, R.drawable.image_op_question_galarianstunkfish, 0,1,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(1,"¿Quién sale en Resident Evil 2?", R.drawable.image_op_question_jill, R.drawable.image_op_question_adawong, R.drawable.image_op_question_mia, R.drawable.image_op_question_sheva,  1,0,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(2,"¿Quién es Apollo Justice de la saga Ace Attorney?", R.drawable.image_op_question_godot, R.drawable.image_op_question_edgeworth, R.drawable.image_op_question_apollo, R.drawable.image_op_question_phoenix,  2,1,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(3,"¿Quién de estos personajes de Nier Automata es A2?", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3,0,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(4,"Pregunta4", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3,1,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(5,"Pregunta5", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  0,0,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(6,"Pregunta7", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  1,1,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(7,"Pregunta8", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  2,0,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(8,"Pregunta9", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3,1,2));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(9,"Pregunta10", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  1,0,2));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(10,"Pregunta11", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  2,0,2));

        dbQuerys.insertSoundQuestion(new SoundQuestion(0,"¿A qué videojuego pertenece esta canción?", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(1,"Pregunta2", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(2,"Pregunta3", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(3,"Pregunta4", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,1,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(4,"Pregunta5", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,1,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(5,"Pregunta6", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,1,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(6,"Pregunta7", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(7,"Pregunta8", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(8,"Pregunta9", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,1,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(9,"Pregunta10", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(10,"Pregunta11", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.song,0,2));

        dbQuerys.insertVideoQuestion(new VideoQuestion(0,"¿Este trailer a que juego pertenece?", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(1,"Pregunta2", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(2,"Pregunta3", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(3,"Pregunta4", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,1,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(4,"Pregunta5", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,1,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(5,"Pregunta6", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,1,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(6,"Pregunta7", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,1,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(7,"Pregunta8", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(8,"Pregunta9", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(9,"Pregunta10", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,1,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(10,"Pregunta11", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video,0,0));

    }

}
