package com.example.practica1.Activities;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceManager;

import android.accounts.Account;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.practica1.Adapter.Communicator;
import com.example.practica1.Data.AccountProfile;
import com.example.practica1.Data.Profile;
import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.Fragment.MainMenuFragment;
import com.example.practica1.Fragment.OptionsFragment;
import com.example.practica1.Fragment.ProfilesFragment;
import com.example.practica1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private  boolean dbCreate=false;
    public static String PACKAGE_NAME;
    public static final int REQUEST_CAM = 1;
    //Buttons:
    private Button play_button;
    private Switch modeSw;
    private  ImageView img_title ;
    public boolean theme=false; //false->Light true-> Dark


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(this);
        ChangeTheme(sp.getBoolean("pref_change_theme",false));

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
        loadOptionsNav();
       // loadMainMenuFragment();

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
        if(Communicator.getAccountProfile() == null || Communicator.getAccountProfile().getName() == ""){
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Partida sin perfil")
                    .setMessage("¿Quieres jugar sin seleccionar un perfil?\n La puntuación final no se guardará.")
                    .setPositiveButton("Adelante", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                            startActivity(new Intent(MainActivity.this, QuizActivity.class));
                        }
                    })
                    .setNegativeButton("No!", null)
                    .show();
        }
        else{
            finish();
            startActivity(new Intent(MainActivity.this, QuizActivity.class));
        }
    }

    public void loadMainMenuFragment(){
            MainMenuFragment fragment = MainMenuFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragmentContainerView, fragment);
            ft.commit();
    }

    public void loadOptionsNav(){
        //NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        FragmentManager manager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        NavHostFragment navHostFragment = (NavHostFragment) manager.findFragmentById(R.id.fragmentContainerView);
         NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);

        boolean b = AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES;
       /* OptionsFragment fragment = OptionsFragment.newInstance(b);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();*/
    }

    public void loadProfilesFragment(){
        DbQuerys dbQuerys = new DbQuerys(this);
        List<AccountProfile> listaRanking= dbQuerys.getAccountList();
        ProfilesFragment fragment = new ProfilesFragment(listaRanking);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

    public void ChangeTheme(boolean b){
        if (b){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

}