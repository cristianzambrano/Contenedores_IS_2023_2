package com.example.contenedores_is_2023_2.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.contenedores_is_2023_2.Modelos.Noticias;
import com.example.contenedores_is_2023_2.Modelos.Usuario;
import com.example.contenedores_is_2023_2.R;

import java.util.ArrayList;

public class AdaptadorUsuarios extends ArrayAdapter<Usuario> {
    public AdaptadorUsuarios(Context context, ArrayList<Usuario> datos) {
        super(context, R.layout.ly_itemusuario, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_itemusuario, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombres());
        TextView lblemail = (TextView)item.findViewById(R.id.lblEmail);
        lblemail.setText(getItem(position).getEmail());
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);
        lblweb.setText(getItem(position).getWebsite());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar())
                .into(imageView);

        return(item);
    }
}
