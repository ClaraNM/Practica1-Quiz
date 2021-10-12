package com.example.practica1.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.TextQuestion;
import com.example.practica1.Fragment.ImageOptionsQuestionFragment;
import com.example.practica1.Fragment.ImageQuestionFragment;
import com.example.practica1.Fragment.NumberQuestionFragment;
import com.example.practica1.Fragment.QuestionFragment;
import com.example.practica1.Fragment.TextQuestionFragment;
import com.example.practica1.R;

import java.util.List;


public class ReviewAdapter extends RecyclerView.Adapter {

    List<Question> questions;
    List<QuestionFragment> questionAnswers;

    public ReviewAdapter(List<Question>questions, List<QuestionFragment>questionAnswers){

        this.questions=questions;
        this.questionAnswers=questionAnswers;
    }

    @Override
    public int getItemViewType(int position) {
        if (questions.get(position) instanceof TextQuestion){
            return 1;
        }else if (questions.get(position) instanceof NumberQuestion){
            return 2;}
        else if (questions.get(position) instanceof ImageQuestion){
            return 3;}

        return 0;
    }

    @NonNull
    @Override
    //0->Pregunta de respuestas imagenes
    //1->Preguntas de texto
    //2->Preguntas de número
    //3->Preguntas de enunciado con imagen
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view;
        if(viewType==1){
            view=layoutInflater.inflate(R.layout.result_view_text_question,parent,false);
            return new ViewHolder_TxtQ(view);
        }else if (viewType==2) {
            view = layoutInflater.inflate(R.layout.result_view_number_question, parent, false);
            return new ViewHolder_NmbQ(view);
        }else   if (viewType==3){
            view = layoutInflater.inflate(R.layout.result_view_image_question,parent,false);
            return  new ViewHolder_ImgQ(view);
        }
        view=layoutInflater.inflate(R.layout.result_view_image_options_question,parent,false);
        return new ViewHolder_ImgOQ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Question question = questions.get(position);
        QuestionFragment questionAnswer=questionAnswers.get(position);
        if (question instanceof TextQuestion && questionAnswer instanceof TextQuestionFragment){
            ViewHolder_TxtQ ViewHolder_TxtQ =(ViewHolder_TxtQ) holder;
            ViewHolder_TxtQ.textView.setText(question.getQuestion());
            ViewHolder_TxtQ.answer1.setText(((TextQuestion) question).getOp1());
            ViewHolder_TxtQ.answer2.setText(((TextQuestion) question).getOp2());
            ViewHolder_TxtQ.answer3.setText(((TextQuestion) question).getOp3());
            ViewHolder_TxtQ.answer4.setText(((TextQuestion) question).getOp4());
            switch (question.getCorrectAnswer()){
                case 0:
                    ViewHolder_TxtQ.answer1.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 1:
                    ViewHolder_TxtQ.answer2.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 2:
                    ViewHolder_TxtQ.answer3.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 3:
                    ViewHolder_TxtQ.answer4.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
            }

            if (questionAnswer.getAnswer()!=question.getCorrectAnswer()){
                switch (questionAnswer.getAnswer()){
                    case 0:
                        ViewHolder_TxtQ.answer1.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 1:
                        ViewHolder_TxtQ.answer2.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 2:
                        ViewHolder_TxtQ.answer3.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 3:
                        ViewHolder_TxtQ.answer4.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                }
            }

        }else if (question instanceof NumberQuestion && questionAnswer instanceof NumberQuestionFragment){
            ViewHolder_NmbQ ViewHolder_NmbQ = (ViewHolder_NmbQ) holder;
            ViewHolder_NmbQ.textView.setText(question.getQuestion());
            ViewHolder_NmbQ.answer1.setText(String.valueOf(question.getCorrectAnswer()));
            ViewHolder_NmbQ.answer2.setText(String.valueOf(questionAnswer.getAnswer()));
            if (questionAnswer.getAnswer()==question.getCorrectAnswer()){
                ViewHolder_NmbQ.card_answer.setCardBackgroundColor(Color.parseColor("#ABFAA7"));
            }else{
                ViewHolder_NmbQ.card_answer.setCardBackgroundColor(Color.parseColor("#F58C8A"));
            }
        }else if (question instanceof ImageOptionsQuestion && questionAnswer instanceof ImageOptionsQuestionFragment){
            ViewHolder_ImgOQ ViewHolder_ImgOQ=(ViewHolder_ImgOQ) holder;
            ViewHolder_ImgOQ.textView.setText(question.getQuestion());
            ViewHolder_ImgOQ.imgV1.setImageResource(((ImageOptionsQuestion)question).getImageId1());
            ViewHolder_ImgOQ.imgV2.setImageResource(((ImageOptionsQuestion)question).getImageId2());
            ViewHolder_ImgOQ.imgV3.setImageResource(((ImageOptionsQuestion)question).getImageId3());
            ViewHolder_ImgOQ.imgV4.setImageResource(((ImageOptionsQuestion)question).getImageId4());
            switch (question.getCorrectAnswer()){
                case 0:
                    ViewHolder_ImgOQ.card1.setCardBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 1:
                    ViewHolder_ImgOQ.card2.setCardBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 2:
                    ViewHolder_ImgOQ.card3.setCardBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 3:
                    ViewHolder_ImgOQ.card4.setCardBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
            }
            if (questionAnswer.getAnswer()!=question.getCorrectAnswer()){
                switch (questionAnswer.getAnswer()){
                    case 0:
                        ViewHolder_ImgOQ.card1.setCardBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 1:
                        ViewHolder_ImgOQ.card2.setCardBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 2:
                        ViewHolder_ImgOQ.card3.setCardBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 3:
                        ViewHolder_ImgOQ.card4.setCardBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                }
            }

        } else if (question instanceof ImageQuestion && questionAnswer instanceof ImageQuestionFragment){
            ViewHolder_ImgQ ViewHolder_ImgQ =(ViewHolder_ImgQ) holder;
            ViewHolder_ImgQ.textView.setText(question.getQuestion());
            ViewHolder_ImgQ.image.setImageResource(((ImageQuestion)question).getImageQuestionId());
            ViewHolder_ImgQ.answer1.setText(((ImageQuestion) question).getOp1());
            ViewHolder_ImgQ.answer2.setText(((ImageQuestion) question).getOp2());
            ViewHolder_ImgQ.answer3.setText(((ImageQuestion) question).getOp3());
            ViewHolder_ImgQ.answer4.setText(((ImageQuestion) question).getOp4());
            switch (question.getCorrectAnswer()){
                case 0:
                    ViewHolder_ImgQ.answer1.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 1:
                    ViewHolder_ImgQ.answer2.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 2:
                    ViewHolder_ImgQ.answer3.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
                case 3:
                    ViewHolder_ImgQ.answer4.setBackgroundColor(Color.parseColor("#ABFAA7"));
                    break;
            }

            if (questionAnswer.getAnswer()!=question.getCorrectAnswer()){
                switch (questionAnswer.getAnswer()){
                    case 0:
                        ViewHolder_ImgQ.answer1.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 1:
                        ViewHolder_ImgQ.answer2.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 2:
                        ViewHolder_ImgQ.answer3.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                    case 3:
                        ViewHolder_ImgQ.answer4.setBackgroundColor(Color.parseColor("#F58C8A"));
                        break;
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    class ViewHolder_ImgOQ extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imgV1, imgV2, imgV3, imgV4;
        CardView card1, card2,card3,card4;
        public ViewHolder_ImgOQ(@NonNull View v) {
            super(v);
            textView=v.findViewById(R.id.imageOQ_statement);
            imgV1=v.findViewById(R.id.imageOQ_answer_1);
            imgV2=v.findViewById(R.id.imageOQ_answer_2);
            imgV3=v.findViewById(R.id.imageOQ_answer_3);
            imgV4=v.findViewById(R.id.imageOQ_answer_4);
            card1=v.findViewById(R.id.imageOQ_card_1);
            card2=v.findViewById(R.id.imageOQ_card_2);
            card3=v.findViewById(R.id.imageOQ_card_3);
            card4=v.findViewById(R.id.imageOQ_card_4);
        }
    }

    class ViewHolder_TxtQ extends RecyclerView.ViewHolder{
        TextView textView,answer1,answer2,answer3,answer4;
        public ViewHolder_TxtQ(@NonNull View v) {
            super(v);
            textView=v.findViewById(R.id.textQ_statement);
            answer1=v.findViewById(R.id.textQ_answer_1);
            answer2=v.findViewById(R.id.textQ_answer_2);
            answer3=v.findViewById(R.id.textQ_answer_3);
            answer4=v.findViewById(R.id.textQ_answer_4);
        }
    }
    class ViewHolder_NmbQ extends RecyclerView.ViewHolder{
        TextView textView,answer1,answer2;
        CardView card_answer;
        public ViewHolder_NmbQ(@NonNull View v) {
            super(v);
            textView=v.findViewById(R.id.numberQ_statement);
            answer1=v.findViewById(R.id.numberQ_answer_1);
            answer2=v.findViewById(R.id.numberQ_answer_2);
            card_answer=v.findViewById(R.id.numberQ_card_2);

        }
    }
    class ViewHolder_ImgQ extends RecyclerView.ViewHolder{
        TextView textView,answer1,answer2,answer3,answer4;
        ImageView image;
        public ViewHolder_ImgQ(@NonNull View v) {
            super(v);
            textView=v.findViewById(R.id.imgQ_statement);
            image=v.findViewById(R.id.imgQ_image);
            answer1=v.findViewById(R.id.imgQ_answer_1);
            answer2=v.findViewById(R.id.imgQ_answer_2);
            answer3=v.findViewById(R.id.imgQ_answer_3);
            answer4=v.findViewById(R.id.imgQ_answer_4);
        }
    }
}

