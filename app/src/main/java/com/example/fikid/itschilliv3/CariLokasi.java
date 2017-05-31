package com.example.fikid.itschilliv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fikid.itschilliv3.AsyncTask.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CariLokasi extends AppCompatActivity implements Spinner.OnItemSelectedListener{

    private Spinner spinner;
    private TextView tglini;
    private ArrayList<String> lokasi;

    private JSONArray result;

    private TextView tvMK, tvRH, tvRLH, tvRLP, tvRS, tvRHL, tvMB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_lokasi);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        // textView is the TextView view that should display it

        tglini = (TextView) findViewById(R.id.tglini);
        tglini.setText(currentDateTimeString);

        lokasi = new ArrayList<String>();

        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(this);

        tvMK = (TextView) findViewById(R.id.mk);
        tvRH = (TextView) findViewById(R.id.rh);
        tvRLH = (TextView) findViewById(R.id.rlh);
        tvRLP = (TextView) findViewById(R.id.rlp);
        tvRS = (TextView) findViewById(R.id.rs);
        tvRHL = (TextView) findViewById(R.id.rhl);
        tvMB = (TextView) findViewById(R.id.mb);

        getdata();

    }

    private void getdata(){
        StringRequest stringRequest = new StringRequest(Helper.BASE_URL + "hargahariini.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray("result");

                            //Calling method getStudents to get the students from the JSON Array
                            getStudents(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }

    private void getStudents(JSONArray j){
        //Traversing through all the items in the json array
        for(int i=0;i<j.length();i++){
            try {
                //Getting json object
                JSONObject json = j.getJSONObject(i);

                //Adding the name of the student to array list
                lokasi.add(json.getString("lokasi"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //Setting adapter to show the items in the spinner
        spinner.setAdapter(new ArrayAdapter<String>(CariLokasi.this, android.R.layout.simple_spinner_dropdown_item, lokasi));
    }

        //Method to get student name of a particular position
        private String getMK(int position){
            String name="";
            try {
                //Getting object of given index
                JSONObject json = result.getJSONObject(position);

                //Fetching name from that object
                name = json.getString("MK");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Returning the name
            return name;
        }

    private String getRH(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("RH");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private String getRLH(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("RLH");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private String getRLP(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("RLP");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private String getRS(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("RS");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private String getMB(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("MB");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    private String getRHL(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString("RHL");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Setting the values to textviews for a selected item
        //textViewCabecabean.setText(getName(position))
        tvMB.setText(getMB(position));
        tvMK.setText(getMK(position));
        tvRH.setText(getRH(position));
        tvRLH.setText(getMB(position));
        tvRLP.setText(getRLP(position));
        tvRS.setText(getRS(position));
        tvRHL.setText(getRHL(position));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //textViewCabecabean.setText("");
        tvMB.setText("");
        tvMK.setText("");
        tvRH.setText("");
        tvRLH.setText("");
        tvRLP.setText("");
        tvRS.setText("");
        tvRHL.setText("");
    }
}
