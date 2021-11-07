package com.example.practica1.Fragment;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.Adapter.Communicator;
import com.example.practica1.Adapter.ProfilesAdapter;
import com.example.practica1.Data.AccountProfile;
import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.Data.db.DbTables;
import com.example.practica1.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProfilesFragment extends Fragment {

    private RecyclerView recyclerView;
    private View root;
    private ImageView iv_profile;

    private ProfilesAdapter adapter;
    private List<AccountProfile> profileList;
    private static int REQUEST_RESULT = 1234;

    String currentPicturePath;

    public ProfilesFragment(List<AccountProfile> list){
        this.profileList=list;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        MainActivity activity = ((MainActivity)getActivity());

        View v = inflater.inflate(R.layout.fragment_profiles, container, false);

        iv_profile = v.findViewById(R.id.iv_profile);

        //  BOTÓN DE ACTIVAR LA CAMARA
        Button btn_camera = v.findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        openCamera();
                    }
                    else{
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQUEST_RESULT);
                    }
                }
                else{
                    openCamera();
                }
            }
        });

        EditText name_profile_edit_text = v.findViewById(R.id.edit_text_profile_name);

        //  BOTÓN DE VOLVER AL MENÚ PRINCIPAL
        Button btn_atras = v.findViewById(R.id.btn_atras);
        btn_atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                activity.loadMainMenuFragment();
            }
        });

        //  BOTÓN DE ELIMINAR EL PERFIL SELECCIONADO
        Button btn_borrar_perfil = v.findViewById(R.id.btn_borrar_perfil);
        btn_borrar_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Communicator.getSelectedProfileId() != -1){
                    AlertDialog dialog = new AlertDialog.Builder(getContext())
                            .setTitle("Borrar perfil")
                            .setMessage("¿Seguro que quieres borrar el perfil?")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    DeleteProfile();
                                    Communicator.selectedProfileId = -1;
                                    Communicator.setAccountProfile(null);
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
                }
            }
        });

        //  BOTÓN DE CREAR UN NUEVO PERFIL
        Button btn_nuevo_perfil = v.findViewById(R.id.btn_nuevo_perfil);
        btn_nuevo_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = name_profile_edit_text.getText().toString();
                System.out.println("AAAAA: " + text);
                if(!text.isEmpty() && text != null){
                    AccountProfile ap = new AccountProfile(text, currentPicturePath);
                    profileList.add(ap);
                    DbQuerys dbQuerys = new DbQuerys(getContext());
                    dbQuerys.insertAccountProfile(ap);
                    SetRecycleView(root);
                }
                else{
                    Toast.makeText(getContext(), "Introduce un nombre para crear el perfil", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //  BOTÓN DE CAMBIAR LA FOTO DEL PERFIL SELECCIONADO
        Button btn_editar_perfil = v.findViewById(R.id.btn_cambir_foto);
        btn_editar_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Communicator.getSelectedProfileId() != -1){
                    profileList.get(Communicator.getSelectedProfileId()).setPicture_URI(currentPicturePath);
                    if(currentPicturePath != null && !currentPicturePath.isEmpty()){
                        Uri uri = Uri.parse(currentPicturePath);
                        iv_profile.setImageURI(uri);
                    }
                    SetRecycleView(root);
                }
                else{
                    Toast.makeText(getContext(), "Selecciona un perfil para editarlo", Toast.LENGTH_SHORT).show();
                }
            }
        });
        root = v;
        SetRecycleView(v);
        return  v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_RESULT){
            if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            }
            else{
                Toast.makeText(getContext(), "Necesitas dar permisos a la aplicación", Toast.LENGTH_SHORT);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_RESULT && resultCode == Activity.RESULT_OK){
            //Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            //Log.i("TAG", "Result => " + bitmap);
            Uri uri = Uri.parse(currentPicturePath);
            iv_profile.setImageURI(uri);
            System.out.println("Imagen guardada en" + uri.toString());
        }
    }

    private void openCamera(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getActivity().getPackageManager())!= null){
            File pic_file = null;
            try {
                pic_file = createPictureFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(pic_file != null){
                Uri picUri = FileProvider.getUriForFile(getContext(), "com.example.practica1", pic_file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, picUri);
                startActivityForResult(intent, REQUEST_RESULT);
            }

        }
    }

    private void DeleteProfile(){
        String name = Communicator.getAccountProfile().getName();
        DbTables dbhelper = new DbTables(this.getActivity());
        dbhelper.DeleteAccountProfileData(name);
        profileList.remove(Communicator.getSelectedProfileId());

        SetRecycleView(root);
        Toast.makeText(getContext(), "Perfil borrado", Toast.LENGTH_SHORT);
    }

    private void SetRecycleView(View v){
        recyclerView=v.findViewById(R.id.ranking_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        adapter=new ProfilesAdapter(profileList);
        recyclerView.setAdapter(adapter);
    }

    private File createPictureFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH-mm-ss").format(new Date());
        String filename = "IMG_PROFILE_" + timeStamp;
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File img = File.createTempFile(filename, ".jpg", storageDir);
        currentPicturePath = img.getAbsolutePath();
        return img;
    }
}