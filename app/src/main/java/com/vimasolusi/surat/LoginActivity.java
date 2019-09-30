package com.vimasolusi.surat;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ApiHelper.BaseApiService;
import ApiHelper.UtilsApi;
import Utils.SharedPrefManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog loading;
    @BindView(R.id.et_Nik)
    EditText etUsername;
    @BindView(R.id.et_password) EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);
        //initComponents();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext, null,"Harap Tunggu .... ", true,false);
                requestLogin();
            }
        });

        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
    }

    private void requestLogin() {
        mApiService.loginRequest(etUsername.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                 String user_id = jsonRESULTS.getJSONObject("users").getString("uid");
                                    String nama = jsonRESULTS.getJSONObject("users").getString("nama");
                                    String pangkat = jsonRESULTS.getJSONObject("users").getString("pangkat");
                                    String nik = jsonRESULTS.getJSONObject("users").getString("nrp");

                                    Toast.makeText(mContext, "Selamat Datang " + nama, Toast.LENGTH_SHORT).show();

                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERID, user_id);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_PANGKAT, pangkat);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NIK, nik);
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_NAMA, nama);

                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERID, user_id);

                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                                    //userList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    //startActivity(userList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    //finish();


                                    // Shared Pref ini berfungsi untuk menjadi trigger session login

                                    startActivity(new Intent(mContext, MainActivity.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                } else {
                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }
}
