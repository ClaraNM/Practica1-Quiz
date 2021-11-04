package com.example.practica1.Activities;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.Fragment.MainMenuFragment;
import com.example.practica1.Fragment.OptionsFragment;
import com.example.practica1.R;

public class MainActivity extends AppCompatActivity {

    private  boolean dbCreate=false;
    public static String PACKAGE_NAME;
    //Buttons:
    private Button play_button;
    private Switch modeSw;
    private  ImageView img_title ;
    public boolean theme=false; //false->Light true-> Dark


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        PACKAGE_NAME = getPackageName();
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Practica1_Dark);
            theme=true;
        }else{
            setTheme(R.style.Theme_Practica1_Light);
            theme=false;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadMainMenuFragment();

        //img_title=findViewById(R.id.main_title_img);
        /*
        if(theme ==true){
            img_title.setImageResource(R.drawable.main_title_img_dark);
        }else{
            img_title.setImageResource(R.drawable.main_title_img_light);
        }
        */
        // Cambio de modo dark/light
        //modeSw=findViewById(R.id.theme_mode);
        /*
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            modeSw.setChecked(true);
        }
        modeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
         */
         if (dbCreate==false){
             QuestionDataBase.InitializeDataBase(MainActivity.this);
             dbCreate=true;
         }
    }

    public void loadGameActivity(){
        finish();
        startActivity(new Intent(MainActivity.this, QuizActivity.class));
    }

    public void loadMainMenuFragment(){
            MainMenuFragment fragment = MainMenuFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragmentContainerView, fragment);
            ft.commit();
    }

    public void loadOptionsFragment(){
        boolean b = AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES;
        OptionsFragment fragment = OptionsFragment.newInstance(b);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

    private void loadProfilesFragment(){
        // TO DO
    }

    private void loadRankingFragment(){
        // TO DO
    }

    public void ChangeTheme(boolean b){
        if (b){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }


}