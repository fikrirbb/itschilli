package com.example.fikid.itschilliv3.AsyncTask;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fikid.itschilliv3.R;

/**
 * Created by FIKID on 5/20/2017.
 */

public class BeritaHolder extends RecyclerView.ViewHolder {
    public TextView txtheading, txtdesc, txttime;
    public ImageView leftIconn;


    public BeritaHolder(View itemView) {
        super(itemView);

        /*mangenalkan objek*/
        txtheading = (TextView) itemView.findViewById(R.id.heading);
        txtdesc = (TextView) itemView.findViewById(R.id.desc);
        txttime = (TextView) itemView.findViewById(R.id.time);
        leftIconn = (ImageView) itemView.findViewById(R.id.leftIco);
    }
}