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
import com.example.fikid.itschilliv3.AsyncTask.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Helper {
    private EditText emaillogin, pwlogin;
    ProgressDialog pd;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        sessionManager = new SessionManager(getApplicationContext());

        Button btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, RegisterActivity.class));
            }
        });

        emaillogin = (EditText) findViewById(R.id.email);
        pwlogin = (EditText) findViewById(R.id.password);

        pd = new ProgressDialog(this);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stremail = emaillogin.getText().toString().trim();
                String strpas = pwlogin.getText().toString().trim();

                if (!stremail.isEmpty() && !strpas.isEmpty()) {
                    loginAksi(stremail, strpas);
                } else if (stremail.isEmpty()) {
                    emaillogin.setError("Email tidak boleh kosong");
                    emaillogin.requestFocus();
                } else if (strpas.isEmpty()) {
                    pwlogin.setError("Password tidak boleh kosong");
                    pwlogin.requestFocus();
                }
            }
        });
    }

    private void loginAksi(final String email, final String pass) {
        String url_daftar = Helper.BASE_URL + "loginregister.php";

        String tag_json = "tag_json";

        pd.setCancelable(false);
        pd.setMessage("Login..");
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
                        sessionManager.createSession(jObject.getString("email"));
                        startActivity(new Intent(getApplicationContext(), ActivityMain.class));
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
                param.put("email", email);
                param.put("pass", pass);
                param.put("login", "true");
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
