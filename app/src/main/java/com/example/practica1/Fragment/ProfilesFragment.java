package com.example.practica1.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.Adapter.ProfilesAdapter;
import com.example.practica1.Data.AccountProfile;
import com.example.practica1.R;

import java.util.List;

public class ProfilesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProfilesAdapter adapter;
    private List<AccountProfile> profileList;



    public ProfilesFragment(List<AccountProfile> list){
        this.profileList=list;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        MainActivity activity = ((MainActivity)getActivity());
        View v = inflater.inflate(R.layout.fragment_profiles, container, false);
        Button btn_atras = v.findViewById(R.id.btn_atras);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.loadMainMenuFragment();
            }
        });

        recyclerView=v.findViewById(R.id.ranking_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new ProfilesAdapter(profileList);
        recyclerView.setAdapter(adapter);
        return  v;
    }
}