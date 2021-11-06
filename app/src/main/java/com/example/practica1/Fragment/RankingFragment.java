package com.example.practica1.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica1.Adapter.RankingAdapter;
import com.example.practica1.Data.Profile;
import com.example.practica1.R;

import java.util.List;

public class RankingFragment extends DialogFragment {
    @Nullable
    private RecyclerView recyclerView;
    private RankingAdapter adapter;
    private List<Profile> rankingList;

    //private RecyclerView.Adapter adapter;

    public RankingFragment(List<Profile> list){
    this.rankingList=list;
}
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_ranking, container, false);

        recyclerView=v.findViewById(R.id.ranking_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new RankingAdapter(rankingList);
        recyclerView.setAdapter(adapter);


        return  v;

    }




}
