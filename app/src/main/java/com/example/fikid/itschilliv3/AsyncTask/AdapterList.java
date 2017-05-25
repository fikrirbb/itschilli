package com.example.fikid.itschilliv3.AsyncTask;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fikid.itschilliv3.BeritaDet;
import com.example.fikid.itschilliv3.ListBerita;
import com.example.fikid.itschilliv3.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by FIKID on 5/20/2017.
 */

public class AdapterList extends RecyclerView.Adapter<BeritaHolder>  {

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(ListBerita listBerita, ArrayList<HashMap<String, String>> list_data) {
        this.context = listBerita;
        this.list_data = list_data;
    }

    @Override
    public BeritaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new BeritaHolder(view);

    }

    @Override
    public void onBindViewHolder(BeritaHolder holder, final int position) {
        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BeritaDet.class);
                intent.putExtra("Link", list_data.get(position).get("link"));
            }
        });*/
        Glide.with(context)
                .load(list_data.get(position).get("image"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.leftIconn);
        holder.txtheading.setText(list_data.get(position).get("judulBerita"));
        holder.txtdesc.setText(list_data.get(position).get("deskBerita"));
        holder.txttime.setText(list_data.get(position).get("date"));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), BeritaDet.class);
                intent.putExtra("Link", list_data.get(position).get("link"));
                v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(), "linknya: " + list_data.get(position).get("link"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
}