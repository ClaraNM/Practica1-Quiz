package com.example.practica1.Adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica1.Data.AccountProfile;
import com.example.practica1.Data.Profile;
import com.example.practica1.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder_Profile>{
    List<AccountProfile> profiles;
    List<ViewHolder_Profile> profile_holders = new ArrayList<>();
    public ProfilesAdapter(List<AccountProfile> profiles){
        this.profiles=profiles;
    }

    public ViewHolder_Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_cardview_layout, parent, false);
        return new ViewHolder_Profile(v);
    }

    @SuppressLint("ResourceAsColor")
    public void onBindViewHolder(@NonNull ViewHolder_Profile holder, @SuppressLint("RecyclerView") int position) {
        profile_holders.add(holder);
        AccountProfile profile = profiles.get(position);
        holder.name.setText(profile.getName());
        holder.score.setText(profile.getMaxScore() + "");
        holder.games.setText(profile.getTotal_games() + "");
        if(profile.getPicture_URI() != null && !profile.getPicture_URI().isEmpty()) {
            holder.picture.setImageURI(Uri.parse(profile.getPicture_URI()));
        }
        else{
            holder.picture.setImageResource(R.drawable.ic_baseline_camera_24);
        }

        holder.last_game_date.setText(profile.getDateAsString());

        if(Communicator.selectedProfileId == position){
            holder.boton_seleccionar_perfil.setText("SELECIONADO");
            holder.cardView.setCardBackgroundColor(R.color.teal_700);
        }
        holder.boton_seleccionar_perfil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Communicator.setAccountProfile(profile);
                Communicator.selectedProfileId = position;
                Toast.makeText(view.getContext(), "Perfil seleccionado : " + profile.getName() + ".", Toast.LENGTH_SHORT).show();
                Selectprofile(position);
                Profile p=new Profile(null,0,null);
                p.setName(profile.getName());
                Communicator.setNewProfile(p);
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void Selectprofile(int id){
        for (int i = 0; i < profile_holders.size(); i++){
            if(i != id){
                profile_holders.get(i).boton_seleccionar_perfil.setText("SELECCIONAR");
            }
            else{
                profile_holders.get(i).boton_seleccionar_perfil.setText("SELECCIONADO");

            }
        }
    }

    public int getItemCount() {
        //devuelve el tamaño de la fuente de los datos, en este caso el tammaño del arraylist
        return profiles.size();
    }

    class ViewHolder_Profile extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView picture;
        public TextView score;
        public TextView games;
        public TextView last_game_date;
        public Button boton_seleccionar_perfil;
        public CardView cardView;

        public ViewHolder_Profile(View v) {
            super(v);
            name=v.findViewById(R.id.tv_nombre);
            picture=v.findViewById(R.id.iv_profilePic);
            games=v.findViewById(R.id.tv_games);
            score=v.findViewById(R.id.tv_score);
            last_game_date=v.findViewById(R.id.tv_date);
            boton_seleccionar_perfil=v.findViewById(R.id.btn_seleccionar_perfil);
            cardView = v.findViewById(R.id.cardView);
        }
    }
}
