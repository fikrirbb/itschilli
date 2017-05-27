package com.example.fikid.itschilliv3.AsyncTask;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fikid.itschilliv3.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by FIKID on 5/20/2017.
 */

public class BeritaHolder extends RecyclerView.ViewHolder{
    public TextView txtheading, txtdesc, txttime;
    public ImageView leftIconn;
    public CardView cardView;

    ArrayList<HashMap<String, String>> list_data;



    public BeritaHolder(final View itemView) {
        super(itemView);
        //itemView.setOnClickListener(this);

        /*mangenalkan objek*/
        txtheading = (TextView) itemView.findViewById(R.id.heading);
        txtdesc = (TextView) itemView.findViewById(R.id.desc);
        txttime = (TextView) itemView.findViewById(R.id.time);
        leftIconn = (ImageView) itemView.findViewById(R.id.leftIco);
        cardView = (CardView) itemView.findViewById(R.id.cardView);

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(v.getContext(), SecondPage.class);
                //v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(), "os version is: " + list_data.get(this).get("link"), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}