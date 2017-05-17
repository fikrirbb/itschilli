package com.example.fikid.itschilliv3;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class DetailBerita extends Helper {

    private List<berita> newsFeed = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newsFeed.clear();
        tampilberita();
        buatListView();
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

    @Override
    protected void onStart()
    {
        //TODO Auto-generated method stub
        super.onStart();

    }


    @Override
    protected void onResume()
    {
        //TODO Auto-generated method stub
        super.onResume();
        /*newsFeed.clear();
        tampilberita();
        buatListView();*/
    }

    private void tampilberita(){
        String URL = Helper.BASE_URL + "berita.php";
        Map<String, String> param = new HashMap<>();

        /*param.put("email", logtxtEmail.getText().toString());
        param.put("password", logtxtPassword.getText().toString());*/

            /*menampilkan progressbar saat mengirim data*/
        ProgressDialog pd = new ProgressDialog(context);
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.setInverseBackgroundForced(false);
        pd.setCanceledOnTouchOutside(false);
        pd.setTitle("Info");
        pd.setMessage("Sedang Mengambil Data");
        pd.show();

        try {
                /*format ambil data*/
            aQuery.progress(pd).ajax(URL, param, String.class, new AjaxCallback<String>() {
                @Override
                public void callback(String url, String Obj, AjaxStatus status) {
                        /*jika objek tidak kosong*/
                    if (Obj != null) {
                        try {
                            JSONObject jsonObj = new JSONObject(Obj);

                            // Getting JSON Array node
                            JSONArray data = jsonObj.getJSONArray("data");
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject c = data.getJSONObject(i);

                                String judulBerita = c.getString("judulBerita");
                                String deskBerita = c.getString("deskBerita");
                                String date = c.getString("date");
                                String link = c.getString("link");
                                String image = c.getString("image");

                                newsFeed.add(new berita(judulBerita, deskBerita, date, link, image));
                            }

                        } catch (JSONException e) {
                            Helper.pesan(context, "Error convert data json");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Helper.pesan(context, "Gagal mengambil data");
        }

    }

    private void buatListView(){
        ArrayAdapter<berita> adapter = new customAdapter();

        ListView berita = (ListView) (findViewById(R.id.berita));
        berita.setAdapter(adapter);

        berita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Helper.pesan(context, "My List View Item");
            }
        });
    }

    private class customAdapter extends ArrayAdapter<berita>{
        public customAdapter(){
            super(DetailBerita.this, R.layout.item, newsFeed);
        }

        @Override
        public View getView (int position, View convertView, ViewGroup parent){

            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item, parent, false);
            }

            berita myCurrentBerita = newsFeed.get(position);

            ImageView myImg = (ImageView) convertView.findViewById(R.id.leftIco);
            TextView myHead = (TextView) convertView.findViewById(R.id.heading);
            TextView myDesc = (TextView) convertView.findViewById(R.id.desc);

            myHead.setText(myCurrentBerita.getJudulBerita());
            myDesc.setText(myCurrentBerita.getDeskBerita());
            myImg.setImageResource(R.mipmap.ic_launcher);

            return convertView;
        }
    }
}
