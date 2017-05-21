package com.example.fikid.itschilliv3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.fikid.itschilliv3.AsyncTask.AppController;
import com.example.fikid.itschilliv3.AsyncTask.Helper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends Helper {
    private EditText userdaftar, emaildaftar, pwdaftar1, pwdaftar2, telpdaftar;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userdaftar = (EditText) findViewById(R.id.userdaftar);
        emaildaftar = (EditText) findViewById(R.id.emaildaftar);
        pwdaftar1 = (EditText) findViewById(R.id.pwdaftar1);
        pwdaftar2 = (EditText) findViewById(R.id.pwdaftar2);
        telpdaftar = (EditText) findViewById(R.id.telpdaftar);

        pd = new ProgressDialog(this);

        Button btnDaftar = (Button) findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String struser = userdaftar.getText().toString().trim();
                String stremail = emaildaftar.getText().toString().trim();
                String strpas1 = pwdaftar1.getText().toString().trim();
                String strpas2 = pwdaftar2.getText().toString().trim();
                String strtelp = telpdaftar.getText().toString().trim();

                if (!struser.isEmpty() && !stremail.isEmpty() && !strtelp.isEmpty() && !strpas1.isEmpty() && !strpas2.isEmpty()) {
                    simpanData(struser, stremail, strtelp, strpas1);
                } else if (struser.isEmpty()) {
                    userdaftar.setError("Nama Lengkap tidak boleh kosong");
                    userdaftar.requestFocus();
                } else if (stremail.isEmpty()) {
                    emaildaftar.setError("Email tidak boleh kosong");
                    emaildaftar.requestFocus();
                } else if (strpas1.isEmpty()) {
                    pwdaftar1.setError("Password tidak boleh kosong");
                    pwdaftar1.requestFocus();
                } else if (strpas2.isEmpty()) {
                    pwdaftar2.setError("Konfirmasi Password tidak boleh kosong");
                    pwdaftar2.requestFocus();
                }else if (strtelp.isEmpty()) {
                    telpdaftar.setError("Telp tidak boleh kosong");
                    telpdaftar.requestFocus();
                }
            }
        });
    }

    private void simpanData(final String user, final String email, final String telp, final String pas) {
        String url_daftar = Helper.BASE_URL + "loginregister.php";

        String tag_json = "tag_json";

        pd.setCancelable(false);
        pd.setMessage("Menyimpan...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url_daftar, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response", response.toString());
                hideDialog();

                try {
                    JSONObject jObject = new JSONObject(response);
                    String pesan = jObject.getString("message");
                    String error = jObject.getString("error");
                    if (error.equalsIgnoreCase("false")) {
                        Helper.pesan(context, pesan);
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    } else {
                        Helper.pesan(context, pesan);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Helper.pesan(context, e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR", error.getMessage());
                pesan(context, error.getMessage());
                hideDialog();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                param.put("nama", user);
                param.put("email", email);
                param.put("pass", pas);
                param.put("no_telp", telp);
                param.put("daftar", "true");
                return param;
            }
        };

        AppController.getAppController().addToRequestQueue(stringRequest, tag_json);
    }

    private void showDialog() {
        if (!pd.isShowing())
            pd.show();
    }

    private void hideDialog() {
        if (pd.isShowing())
            pd.dismiss();
    }

}