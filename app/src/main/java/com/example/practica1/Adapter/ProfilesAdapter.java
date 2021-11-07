package com.example.practica1.Adapter;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica1.Data.AccountProfile;
import com.example.practica1.Data.Profile;
import com.example.practica1.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.ViewHolder_Profile>{
    List<AccountProfile> profiles;
    List<ViewHolder_Profile> profile_holders = new ArrayList<>();
    public int selected_profile = -1;
    public ProfilesAdapter(List<AccountProfile> profiles){
        this.profiles=profiles;
    }

    public ViewHolder_Profile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_cardview_layout, parent, false);
        return new ViewHolder_Profile(v);
    }

    public void onBindViewHolder(@NonNull ViewHolder_Profile holder, int position) {
        profile_holders.add(holder);
        AccountProfile profile = profiles.get(position);
        holder.name.setText(profile.getName());
        holder.score.setText(profile.getMaxScore() + "");
        holder.picture.setImageURI(Uri.parse(profile.getPicture_URI()));
        holder.last_game_date.setText(profile.getDateAsString());
        holder.boton_seleccionar_perfil.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Communicator.setAccountProfile(profile);
                Toast.makeText(view.getContext(), "Perfil seleccionado : " + profile.getName() + ".", Toast.LENGTH_SHORT).show();
                Selectprofile(position);
                Profile p=new Profile(null,0,null);
                p.setName(profile.getName());
                Communicator.setNewProfile(p);
            }
        });
    }

    private void Selectprofile(int id){
        for (int i = 0; i < profile_holders.size(); i++){
            if(i != id)
                profile_holders.get(i).boton_seleccionar_perfil.setText("SELECIONAR");
            else{
                profile_holders.get(i).boton_seleccionar_perfil.setText("SELECCIONADO");

            }
        }
        selected_profile = id;
    }

    public int getItemCount() {
        //devuelve el tamaño de la fuente de los datos, en este caso el tammaño del arraylist
        return profiles.size();
    }

    class ViewHolder_Profile extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView picture;
        public TextView score;
        public TextView last_game_date;
        public Button boton_seleccionar_perfil;

        public ViewHolder_Profile(View v) {
            super(v);
            name=v.findViewById(R.id.tv_nombre);
            picture=v.findViewById(R.id.iv_profilePic);
            score=v.findViewById(R.id.tv_score);
            last_game_date=v.findViewById(R.id.tv_date);
            boton_seleccionar_perfil=v.findViewById(R.id.btn_seleccionar_perfil);
        }
    }
}
