package com.gzeinnumer.batch3day3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;

public class LoginActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoading();
                    }
                }, 4000);
            }
        });
    }

    private LoadingDialog loadingDialog;

    private void showLoading() {
        //type 1
        progressBar.setVisibility(View.VISIBLE);

        //type 2
        loadingDialog = new LoadingDialog(getSupportFragmentManager())
                .setContent("Tunggu 4 Detik");
        loadingDialog.show();
    }

    private void hideLoading() {
        //type 1
        progressBar.setVisibility(View.GONE);
        //type 2
        loadingDialog.dismis();
    }
}