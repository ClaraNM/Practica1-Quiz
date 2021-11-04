package com.example.practica1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.Data.Profile;
import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.R;

import java.util.List;

public class MainMenuFragment extends Fragment {

    Button play_button;
    Button option_button;
    Button profiles_button;
    Button ranking_button;

    public MainMenuFragment() {

    }

    public static MainMenuFragment newInstance() {
        MainMenuFragment fragment = new MainMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main_menu, container, false);

        // Cambiar imagen de inicio según el tema:
        ImageView img_title= root.findViewById(R.id.main_title_img);
        MainActivity activity = ((MainActivity)getActivity());
        if(activity.theme == true){
            img_title.setImageResource(R.drawable.main_title_img_dark);
        }else{
            img_title.setImageResource(R.drawable.main_title_img_light);
        }

        // Establecer los eventos de los botones:
        play_button = root.findViewById(R.id.button_startQuiz);
        option_button = root.findViewById(R.id.button_opciones);
        profiles_button = root.findViewById(R.id.button_perfiles);
        ranking_button = root.findViewById(R.id.button_clasificacion);

        play_button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {activity.loadGameActivity(); }
        });
        option_button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {activity.loadOptionsFragment(); }
        });
        profiles_button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {activity.loadGameActivity(); }
        });
        DbQuerys dbQuerys = new DbQuerys(this.getActivity());
        ranking_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Profile> listaRanking= dbQuerys.getRanking();

                RankingFragment rankingFragment=new RankingFragment(listaRanking);
                rankingFragment.show(getParentFragmentManager(),"ranking_fragment");
            }

            // @Override public void onClick(View view) {activity.loadGameActivity();


        });
        return root;
    }

}