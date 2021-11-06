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

import com.example.practica1.Adapter.ProfilesAdapter;
import com.example.practica1.Data.AccountProfile;
import com.example.practica1.R;

import java.util.List;

public class ProfilesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProfilesAdapter adapter;
    private List<AccountProfile> profileList;



    public ProfilesFragment(List<AccountProfile> list){
        System.out.println("PROFILESFRAGMENT: Creando lista con " + list.size() + " perfiles.");
        this.profileList=list;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        System.out.println("PROFILESFRAGMENT: Inflando vista con " + profileList.size() + " perfiles.");
        View v = inflater.inflate(R.layout.fragment_profiles, container, false);
        recyclerView=v.findViewById(R.id.ranking_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new ProfilesAdapter(profileList);
        recyclerView.setAdapter(adapter);
        return  v;
    }
}