package com.example.practica1.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica1.Data.Profile;
import com.example.practica1.R;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder_Rank>{
    List<Profile> rankingofProfiles;
    public RankingAdapter( List<Profile> listProfiles){
        this.rankingofProfiles=listProfiles;
    }

    public ViewHolder_Rank onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_view_profile, parent, false);
        return new ViewHolder_Rank(v);
    }

    public void onBindViewHolder(@NonNull ViewHolder_Rank holder, int position) {
        holder.name.setText(Integer.toString(position+1)+".- "+rankingofProfiles.get(position).getName());
        holder.score.setText(Integer.toString(rankingofProfiles.get(position).getScore()) );
        holder.time.setText(rankingofProfiles.get(position).getTime());
    }

    public int getItemCount() {
        //devuelve el tamaño de la fuente de los datos, en este caso el tammaño del arraylist
        return rankingofProfiles.size();
    }

    class ViewHolder_Rank extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView score;
        public TextView time;
        public ViewHolder_Rank(View v) {
            super(v);
            name=v.findViewById(R.id.profile_name);
            score=v.findViewById(R.id.profile_score);
time=v.findViewById(R.id.profile_time);

        }
    }
    }
