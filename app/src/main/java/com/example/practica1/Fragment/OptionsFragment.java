package com.example.practica1.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.R;

public class OptionsFragment extends Fragment {

    private boolean isDarkTheme;
    private static final String ARG_THEME = "theme";
    public OptionsFragment() {

    }

    public static OptionsFragment newInstance(Boolean b) {
        OptionsFragment fragment = new OptionsFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARG_THEME, b);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            isDarkTheme = getArguments().getBoolean(ARG_THEME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_options, container, false);
        MainActivity activity = ((MainActivity)getActivity());

        Button button_back = root.findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.loadMainMenuFragment();
            }
        });

        Switch theme_switch = root.findViewById(R.id.switch1);

        if(isDarkTheme)
            theme_switch.setChecked(true);

        theme_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               activity.ChangeTheme(b);
            }
        });

        return root;


    }
}