package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private EditText loguser, logpass;
    private String sloguser, slogpass;
    private TextView btnlogin, lupapass, blmpunya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loguser = findViewById(R.id.loguser);
        logpass = findViewById(R.id.logpass);
        lupapass = findViewById(R.id.lupapass);
        btnlogin = findViewById(R.id.btnlogin);
        blmpunya = findViewById(R.id.blmpunya);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sloguser = loguser.getText().toString();
                slogpass = logpass.getText().toString();


                if (slogpass.isEmpty()){
                    Toast.makeText(LoginActivity.this,
                            "Password harus diisi",
                            Toast.LENGTH_SHORT).show();

                    return;
                }
                Intent login = new Intent(LoginActivity.this, ProfilePicActivity.class);
                startActivity(login);
            }
        });

        lupapass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lupa = new Intent(LoginActivity.this, LupaPass.class);
                startActivity(lupa);
            }
        });

        blmpunya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gapunya = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(gapunya);
            }
        });
    }
}