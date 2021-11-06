package com.example.practica1.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica1.Data.AccountProfile;
import com.example.practica1.R;

import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder_Profile>{
    List<AccountProfile> profiles;
    public ProfilesAdapter(List<AccountProfile> profiles){
        this.profiles=profiles;
    }

    public ViewHolder_Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_cardview_layout, parent, false);
        return new ViewHolder_Profile(v);
    }

    public void onBindViewHolder(@NonNull ViewHolder_Profile holder, int position) {
        holder.name.setText(profiles.get(position).getName());
    }

    public int getItemCount() {
        //devuelve el tamaño de la fuente de los datos, en este caso el tammaño del arraylist
        return profiles.size();
    }

    class ViewHolder_Profile extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder_Profile(View v) {
            super(v);
            name=v.findViewById(R.id.tv_nombre);
        }
    }
}
