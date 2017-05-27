package com.example.fikid.itschilliv3;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.fikid.itschilliv3.AsyncTask.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class BeritaDet extends Helper {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_det);
        webview = (WebView) findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        Bundle bundle = getIntent().getExtras();
        webview.getSettings().getJavaScriptEnabled();
        webview.loadUrl(bundle.getString("Link"));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            //end the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
/*
public class BeritaDet extends Helper {

    private ImageView imgbrt;
    private TextView txtjudul, txttgl, txtisi;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_det);

        String url=Helper.BASE_URL+ "berita.php";

        setupView();
        requestQueue = Volley.newRequestQueue(BeritaDet.this);

        list_data =  new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("judulBerita", json.getString("judulBerita"));
                        map.put("deskBerita", json.getString("deskBerita"));
                        map.put("date", json.getString("date"));
                        map.put("image", json.getString("image"));
                        list_data.add(map);
                    }
                    Glide.with(getApplicationContext())
                            .load(list_data.get(0).get("image"))
                            .crossFade()
                            .placeholder(R.mipmap.ic_launcher)
                            .into(imgbrt);
                    txtjudul.setText(list_data.get(0).get("judulBerita"));
                    txttgl.setText(list_data.get(0).get("date"));
                    txtisi.setText(list_data.get(0).get("deskBerita"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Helper.pesan(context, error.getMessage());
            }
        });

        requestQueue.add(stringRequest);
    }

    private void setupView() {
        imgbrt = (ImageView) findViewById(R.id.imgbrt);
        txtjudul = (TextView) findViewById(R.id.txtjudul);
        txttgl = (TextView) findViewById(R.id.txttgl);
        txtisi = (TextView) findViewById(R.id.txtisi);
    }

}*/
