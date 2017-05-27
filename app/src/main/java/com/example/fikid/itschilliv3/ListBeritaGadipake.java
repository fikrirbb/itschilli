package com.example.fikid.itschilliv3;

/**
 * Created by FIKID on 5/25/2017.
 */

public class ListBeritaGadipake {
}

/*
package com.example.fikid.itschilliv3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.fikid.itschilliv3.AsyncTask.AdapterList;
import com.example.fikid.itschilliv3.AsyncTask.AppController;
import com.example.fikid.itschilliv3.AsyncTask.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListBerita extends Helper {
    private RecyclerView lvberita;

    private ArrayList<HashMap<String, String>> list_data;
    private String tag_json = "tag_json";

    private String url = Helper.BASE_URL + "berita.php";

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_berita);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pd = new ProgressDialog(this);

        lvberita = (RecyclerView) findViewById(R.id.lvberita);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lvberita.setLayoutManager(linearLayoutManager);

        list_data = new ArrayList<HashMap<String, String>>();

        lvberita.addOnItemTouchListener(new RecyclerTouchListener(this,
                lvberita, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                /*Toast.makeText(ListBerita.this, "Single Click on position :"+position,
                        Toast.LENGTH_SHORT).show();
                ImageView picture=(ImageView)view.findViewById(R.id.leftIco);
                picture.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ListBerita.this, "Single Click on Image :"+position,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(ListBerita.this, "Long press on position :"+position,
                        Toast.LENGTH_LONG).show();
            }
                    }));

                    showData();
                    }

private void showData() {

        pd.setMessage("Loading...");
        pd.setCancelable(false);
        showDialog();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
@Override
public void onResponse(JSONObject response) {
        Log.d("RESPONSE ", response.toString());
        hideDialog();
        try {
        JSONArray jray = response.getJSONArray("data");
        for (int a = 0; a < jray.length(); a++) {
        JSONObject json = jray.getJSONObject(a);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", json.getString("idberita"));
        map.put("judulBerita", json.getString("judulBerita"));
        map.put("deskBerita", json.getString("deskBerita"));
        map.put("date", json.getString("date"));
        map.put("link", json.getString("link"));
        map.put("image", json.getString("image"));
        list_data.add(map);
        AdapterList adapter = new AdapterList(ListBerita.this, list_data);
        lvberita.setAdapter(adapter);
        }
        } catch (JSONException e) {
        e.printStackTrace();
        }
        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        VolleyLog.d("ERROR", error.getMessage());
        hideDialog();
        }
        });

        AppController.getAppController().addToRequestQueue(jsonRequest, tag_json);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
        //end the activity
        this.finish();
        }
        return super.onOptionsItemSelected(item);
        }

private void showDialog() {
        if (!pd.isShowing())
        pd.show();
        }

private void hideDialog() {
        if (pd.isShowing())
        pd.dismiss();
        }

public static interface ClickListener{
    public void onClick(View view, int position);
        public void onLongClick(View view,int position);
}

class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

    private ClickListener clicklistener;
    private GestureDetector gestureDetector;

    public RecyclerTouchListener(Context context, final RecyclerView recycleView, final ClickListener clicklistener){

        this.clicklistener=clicklistener;
        gestureDetector=new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child=recycleView.findChildViewUnder(e.getX(),e.getY());
                    if(child!=null && clicklistener!=null){
                        clicklistener.onLongClick(child,recycleView.getChildAdapterPosition(child));
                    }
                }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child=rv.findChildViewUnder(e.getX(),e.getY());
        if(child!=null && clicklistener!=null && gestureDetector.onTouchEvent(e)){
            clicklistener.onClick(child,rv.getChildAdapterPosition(child));
            clicklistener.onClick(child, list_data.get(position).get("link"));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
}
 */