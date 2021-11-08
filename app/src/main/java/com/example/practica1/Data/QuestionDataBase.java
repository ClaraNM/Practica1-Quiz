package com.example.practica1.Data;

import static java.util.Collections.shuffle;

import android.content.Context;

import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionDataBase {

    private static List<Question> questionListAux;
    private static List<Question> questionList;
    public static List<Question> getQuestionPool(int size, int d, boolean c1,boolean c2,boolean c3,Context context) throws Exception {

        questionList=new ArrayList<Question>();
        questionListAux=new ArrayList<Question>();
        DbQuerys dbQuerys = new DbQuerys(context);

        List<Question> questionListAux2 = dbQuerys.getQuestionsWithDifficulty(d);
        for(int i = 0; i < questionListAux2.size(); i++){
            Question question = questionListAux2.get(i);
            if(c1 && questionListAux2.get(i).getTheme() == 0)
                questionListAux.add(question);
            else if(c2 && questionListAux2.get(i).getTheme() == 1)
                questionListAux.add(question);
            else if(c3 && questionListAux2.get(i).getTheme() == 2)
                questionListAux.add(question);
        }

        questionListAux = SuffleList(questionListAux);

        for (int i = 0; i < Math.min(size, questionListAux.size()); i++){
            questionList.add(questionListAux.get(i));
        }
        return questionList;
        /*
        questionList=new ArrayList<Question>();
        questionListAux=new ArrayList<Question>();
        DbQuerys dbQuerys = new DbQuerys(context);
        Random r=new Random();
        int randomQ;
        if ( c1==true &&  c2==true &&  c3==false){
            questionListAux=dbQuerys.getAAA_Indie();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                    //randomQ=r.nextInt((dbQuerys.getMaxAAA_IndieTextQuestion()+dbQuerys.getMaxAAA_IndieNumberQuestion()+dbQuerys.getMaxAAA_IndieImgQuestion()+dbQuerys.getMaxAAA_IndieImgOpQuestion()+dbQuerys.getMaxAAA_IndieSoundQuestion()+dbQuerys.getMaxAAA_IndieVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else{
                for (int i = 0; i < size; i++) {
                //randomQ=r.nextInt((dbQuerys.getMaxAAA_IndieTextQuestion()+dbQuerys.getMaxAAA_IndieNumberQuestion()+dbQuerys.getMaxAAA_IndieImgQuestion()+dbQuerys.getMaxAAA_IndieImgOpQuestion()+dbQuerys.getMaxAAA_IndieSoundQuestion()+dbQuerys.getMaxAAA_IndieVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==0){
                    questionList.add(questionListAux.get(randomQ));
                    questionListAux.remove(randomQ);
                } else{ i--;questionListAux.remove(randomQ);}
            }
            }
        }else if ( c1==true &&  c2==false &&  c3==true){
            questionListAux=dbQuerys.getAAA_Industry();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                    //randomQ=r.nextInt((dbQuerys.getMaxAAA_IndustryTextQuestion()+dbQuerys.getMaxAAA_IndustryNumberQuestion()+dbQuerys.getMaxAAA_IndustryImgQuestion()+dbQuerys.getMaxAAA_IndustryImgOpQuestion()+dbQuerys.getMaxAAA_IndustrySoundQuestion()+dbQuerys.getMaxAAA_IndustryVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else {
                for (int i = 0; i < size; i++) {
                 //   randomQ = r.nextInt((dbQuerys.getMaxAAA_IndustryTextQuestion() + dbQuerys.getMaxAAA_IndustryNumberQuestion() + dbQuerys.getMaxAAA_IndustryImgQuestion() + dbQuerys.getMaxAAA_IndustryImgOpQuestion() + dbQuerys.getMaxAAA_IndustrySoundQuestion() + dbQuerys.getMaxAAA_IndustryVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }else if ( c1==false &&  c2==true &&  c3==true){
            questionListAux=dbQuerys.getIndie_Industry();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                  //  randomQ = r.nextInt((dbQuerys.getMaxIndie_IndustryTextQuestion() + dbQuerys.getMaxIndie_IndustryNumberQuestion() + dbQuerys.getMaxIndie_IndustryImgQuestion() + dbQuerys.getMaxIndie_IndustryImgOpQuestion() + dbQuerys.getMaxIndie_IndustrySoundQuestion() + dbQuerys.getMaxIndie_IndustryVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else{
                for (int i = 0; i < size; i++) {
                    //randomQ = r.nextInt((dbQuerys.getMaxIndie_IndustryTextQuestion() + dbQuerys.getMaxIndie_IndustryNumberQuestion() + dbQuerys.getMaxIndie_IndustryImgQuestion() + dbQuerys.getMaxIndie_IndustryImgOpQuestion() + dbQuerys.getMaxIndie_IndustrySoundQuestion() + dbQuerys.getMaxIndie_IndustryVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }else if ( c1==true &&  c2==false &&  c3==false){
            questionListAux=dbQuerys.getOnlyAAA();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                   // randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(0)+dbQuerys.getMaxOnlyThemeNumberQuestion(0)+dbQuerys.getMaxOnlyThemeImgQuestion(0)+dbQuerys.getMaxOnlyThemeImgOpQuestion(0)+dbQuerys.getMaxOnlyThemeSoundQuestion(0)+dbQuerys.getMaxOnlyThemeVideoQuestion(0)));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else{
                for (int i = 0; i < size; i++) {
//                    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(0)+dbQuerys.getMaxOnlyThemeNumberQuestion(0)+dbQuerys.getMaxOnlyThemeImgQuestion(0)+dbQuerys.getMaxOnlyThemeImgOpQuestion(0)+dbQuerys.getMaxOnlyThemeSoundQuestion(0)+dbQuerys.getMaxOnlyThemeVideoQuestion(0)));
                    randomQ=r.nextInt(questionListAux.size());

                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }else if ( c1==false &&  c2==true &&  c3==false){
            questionListAux=dbQuerys.getOnlyIndie();

            if ( d==1){
                for (int i = 0; i < size; i++) {
  //                  randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(1)+dbQuerys.getMaxOnlyThemeNumberQuestion(1)+dbQuerys.getMaxOnlyThemeImgQuestion(1)+dbQuerys.getMaxOnlyThemeImgOpQuestion(1)+dbQuerys.getMaxOnlyThemeSoundQuestion(1)+dbQuerys.getMaxOnlyThemeVideoQuestion(1)));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                    }
                }else{
                       for (int i = 0; i < size; i++) {
                    //randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(1)+dbQuerys.getMaxOnlyThemeNumberQuestion(1)+dbQuerys.getMaxOnlyThemeImgQuestion(1)+dbQuerys.getMaxOnlyThemeImgOpQuestion(1)+dbQuerys.getMaxOnlyThemeSoundQuestion(1)+dbQuerys.getMaxOnlyThemeVideoQuestion(1)));
                           randomQ=r.nextInt(questionListAux.size());
                           if (questionListAux.get(randomQ).getDificulty() == 0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }else if ( c1==false &&  c2==false &&  c3==true){
            questionListAux=dbQuerys.getOnlyIndustry();

            if ( d==1){
                for (int i = 0; i < size; i++) {
                    //randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(2)+dbQuerys.getMaxOnlyThemeNumberQuestion(2)+dbQuerys.getMaxOnlyThemeImgQuestion(2)+dbQuerys.getMaxOnlyThemeImgOpQuestion(2)+dbQuerys.getMaxOnlyThemeSoundQuestion(2)+dbQuerys.getMaxOnlyThemeVideoQuestion(2)));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else{
                for (int i = 0; i < size; i++) {
                //    randomQ=r.nextInt((dbQuerys.getMaxOnlyThemeTextQuestion(2)+dbQuerys.getMaxOnlyThemeNumberQuestion(2)+dbQuerys.getMaxOnlyThemeImgQuestion(2)+dbQuerys.getMaxOnlyThemeImgOpQuestion(2)+dbQuerys.getMaxOnlyThemeSoundQuestion(2)+dbQuerys.getMaxOnlyThemeVideoQuestion(2)));
                    randomQ=r.nextInt(questionListAux.size());

                    if (questionListAux.get(randomQ).getDificulty() == 0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }else{
            questionListAux=dbQuerys.getAll();
            if ( d==1){
                for (int i = 0; i < size; i++) {
                  //  randomQ=r.nextInt((dbQuerys.getMaxTextQuestion()+dbQuerys.getMaxNumberQuestion()+dbQuerys.getMaxImageQuestion()+dbQuerys.getMaxImageOpQuestion()+dbQuerys.getMaxSoundQuestion()+dbQuerys.getMaxVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());

                    if (questionListAux.get(randomQ).getDificulty()==1){
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }else{
                for (int i = 0; i < size; i++) {
                   // randomQ=r.nextInt((dbQuerys.getMaxTextQuestion()+dbQuerys.getMaxNumberQuestion()+dbQuerys.getMaxImageQuestion()+dbQuerys.getMaxImageOpQuestion()+dbQuerys.getMaxSoundQuestion()+dbQuerys.getMaxVideoQuestion()));
                    randomQ=r.nextInt(questionListAux.size());
                    if (questionListAux.get(randomQ).getDificulty()==0) {
                        questionList.add(questionListAux.get(randomQ));
                        questionListAux.remove(randomQ);
                    } else{ i--;questionListAux.remove(randomQ);}
                }
            }
        }
        return questionList;
        */
    }

    private static List<Question> SuffleList(List<Question> questions){
        shuffle(questions);
        return questions;
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
        dbQuerys.insertImageQuestion(new ImageQuestion(4,"¿Qué cargo tiene la persona del foto?", R.drawable.image_question_valeria_castro, "CEO de The Game Kitchen", "CEO de Mercury Steam", "Presidenta de DEV", "Presidenta de AEVI", 2,1,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(5,"¿En cuál de los siguientes juegos NO ha participado esta persona?", R.drawable.image_question_hidetaka_miyazaki, "Kindred Spirits", "Dark Souls", "Deraciné", "Armored Core 4", 0,0,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(6,"¿Para qué empresa NO trabajó esta persona?", R.drawable.image_question_ikumi_nakamura, "Capcom", "Tango Gameworks", "Platinum Games", "Crystal Dynamics", 3,1,2));
        dbQuerys.insertImageQuestion(new ImageQuestion(7,"¿Cómo se llama este personaje de Hades?", R.drawable.image_question_zagreus, "Zagreus", "Perseo", "Hades", "Patroclo", 0,0,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(8,"¿Cuál es la bebida favorita de este personaje ed VA-11 Hall-A?", R.drawable.image_question_alma_armitage, "Cobalt Velvet", "Brandtini", "Piano Woman", "Moonblast", 1,1,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(9,"¿Quién es este personaje de Undertale?", R.drawable.image_question_toriel, "Camilla", "Susie", "Alphys", "Toriel", 3,0,1));
        dbQuerys.insertImageQuestion(new ImageQuestion(10,"¿Cómo se llama este enemigo de la saga The Legend of Zelda?", R.drawable.image_question_gibdo, "Mummian", "Keese", "Gibdo", "ReDead", 2,1,0));

        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(0,"¿Cuál de estos pokemon tiene más defensa?", R.drawable.image_op_question_shuckle, R.drawable.image_op_question_celesteela, R.drawable.image_op_question_bastiodon, R.drawable.image_op_question_galarianstunkfish, 0,1,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(1,"¿Quién sale en Resident Evil 2?", R.drawable.image_op_question_jill, R.drawable.image_op_question_adawong, R.drawable.image_op_question_mia, R.drawable.image_op_question_sheva,  1,0,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(2,"¿Quién es Apollo Justice de la saga Ace Attorney?", R.drawable.image_op_question_godot, R.drawable.image_op_question_edgeworth, R.drawable.image_op_question_apollo, R.drawable.image_op_question_phoenix,  2,1,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(3,"¿Quién de estos personajes de Nier Automata es A2?", R.drawable.image_op_question_eve, R.drawable.image_op_question_nines, R.drawable.image_op_question_commander, R.drawable.image_op_question_a2,  3,0,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(4,"¿Quién de estos personajes es Kim Kitsuragi?", R.drawable.image_option_question_portrait_roy, R.drawable.image_option_question_portrait_gaston, R.drawable.image_option_question_portrait_paledriver, R.drawable.image_option_question_portrait_kitsuragi,  3,1,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(5,"¿Quién es Azazel (Binding of Isaac)?", R.drawable.image_option_question_azazel, R.drawable.image_option_question_unkown, R.drawable.image_option_question_lost, R.drawable.image_option_question_apollyon,  0,0,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(6,"¿Quién es Altasgracias (Blasphemous)?", R.drawable.image_option_question_deogracias, R.drawable.image_option_question_altasgracias, R.drawable.image_option_question_santo_de_las_orillas_saladas, R.drawable.image_option_question_viridiana,  1,1,1));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(7,"¿Quién es Beidou?", R.drawable.image_option_question_ningguang, R.drawable.image_option_question_rosaria, R.drawable.image_option_question_beidou, R.drawable.image_option_question_barbara,  2,0,0));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(8,"¿Quién trabaja en Deconstructeam?", R.drawable.image_option_question_rihanna_pratchett, R.drawable.image_option_question_enrique_colinet, R.drawable.image_option_question_eric_barone, R.drawable.image_option_question_marina,  3,1,2));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(9,"¿Quién es el jefe de la marca Xbox?", R.drawable.image_option_question_timsweeney, R.drawable.image_option_question_phil_spencer, R.drawable.image_option_question_jim_ryan, R.drawable.image_option_question_doug_bowser,  1,0,2));
        dbQuerys.insertImageOptionsQuestion(new ImageOptionsQuestion(10,"¿Quién es el creador de Bayonetta?", R.drawable.image_option_question_shinji_mikami, R.drawable.image_option_question_swery, R.drawable.image_option_question_hideki_kamiya, R.drawable.image_option_question_aonuma,  2,0,2));

        dbQuerys.insertSoundQuestion(new SoundQuestion(0,"¿A qué videojuego pertenece esta canción?", "Hollow Knight", "Dark Souls", "Bloodstain", "Deaths Door", 0, R.raw.sound_question_hollowknight,0,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(1,"¿A qué videojuego pertenece esta canción?", "Nioh", "Bloodborne", "Diablo 3", "Below", 1, R.raw.sound_question_bloodborne_ost,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(2,"¿Quién está hablando?", "Aonuma", "Miyamoto", "Miyazaki", "Kamiya", 0, R.raw.sound_question_aonuma_botw2,0,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(3,"¿Qué personaje del LoL es el que está hablando?", "Diana", "Jynx", "Irelia", "Fiora", 3, R.raw.sound_question_fiora,1,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(4,"¿Cuál es esta canción del Sayonara Wild Hearts?", "Mine", "Begin Again", "Inside", "Doki Doki Rush", 0, R.raw.sound_question_mine,1,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(5,"¿A qué empresa pertenece esta canción?", "Chibig Studio", "Brainwash Gang", "Platonic Games", "Team 7", 1, R.raw.sound_question_brainwashgang,1,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(6,"¿A qué videojuego pertenece esta canción?", "Shin Megami Tensei V", "Final Fantasy XV", "Persona 5", "Yakuza Like a Dragon", 2, R.raw.sound_question_persona5,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(7,"¿A qué videojuego pertenece la siguiente canción?", "Pyre", "Transistor", "Bastion", "Hades", 3, R.raw.sound_question_hades,0,1));
        dbQuerys.insertSoundQuestion(new SoundQuestion(8,"¿Quién está hablando?", "Josef Fares", "Jonathan Blow", "Dan Mullins", "Randy Pitchford", 0, R.raw.sound_question_josef_fares,1,2));
        dbQuerys.insertSoundQuestion(new SoundQuestion(9,"¿En qué videojuego se escucha esta canción?", "We happy few", "Fallout 3", "Rage 2", "Bioshock Infinite", 1, R.raw.sound_question_fallout3,0,0));
        dbQuerys.insertSoundQuestion(new SoundQuestion(10,"¿Quién dice esta frase?", "Swery", "Shinji Mikami", "Kojima", "Suda51", 2, R.raw.sound_question_kojima,0,2));

        dbQuerys.insertVideoQuestion(new VideoQuestion(0,"¿Este trailer a que juego pertenece?", "Elden Ring", "Dark Souls 3", "New World", "Drakengard", 0, R.raw.video_question_elden_ring,0,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(1,"¿Cuál es este videojuego?", "Super Meatboy", "The End is Nigh", "Jump King", "Bloody Scope", 0, R.raw.video_question_super_meat_boy,0,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(2,"¿Qué feria de videojuegos es la del video?", "Fun&Serious", "Tokyo Game Show", "Gamescom", "E3", 3, R.raw.video_question_e3,0,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(3,"¿En qué videojuego aparece esta pelea?", "Pillars of Eternity", "Nier Replicant", "Drakengard 3", "Final Fantasy XV", 1, R.raw.video_question_nier_replicant,1,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(4,"¿Cuál es este videojuego?", "The Hex", "Hearstone", "Inscryption", "Voice of Cards", 2, R.raw.video_question_inscryption,1,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(5,"¿Quién es la persona entrevistada?", "Naoki Yoshida", "Swery", "Takenobu Mitsuyoshi", "Toshihiro Nagoshi", 3, R.raw.video_question_toshihiro,1,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(6,"¿Cuál es este videojuego?", "Nightcity", "Cloudpunk", "Cyberpunk 2033", "Taxi Night", 1, R.raw.video_question_cloudpunk,1,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(7,"¿Este gameplay a que juego pertenece?", "Uncharted", "Mirrors Edge Catalyst", "Horizon Zero Down", "Rise of the Tomb Raider", 2, R.raw.video_question_horizon_zero_down,0,0));
        dbQuerys.insertVideoQuestion(new VideoQuestion(8,"¿De qué videojuego es este gameplay?", "Jump Queen", "Moonwalk", "Canavalt", "Celeste", 3, R.raw.video_question_celeste,0,1));
        dbQuerys.insertVideoQuestion(new VideoQuestion(9,"¿Quién es la persona del video?", "Yoko Taro", "Tetsuya Nomura", "Eiji Aonuma", "Yuji Naka", 0, R.raw.video_question_yoko_taro,0,2));
        dbQuerys.insertVideoQuestion(new VideoQuestion(10,"¿Esta CGI a que juego pertenece?", "Xbox All Stars", "Mass Efect 4", "Halo Infinite", "Jedi Fallen Order", 2, R.raw.video_question_halo_infinite,0,0));

    }

}
