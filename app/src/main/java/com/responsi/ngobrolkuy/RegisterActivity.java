package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private EditText etuser, etemail, etpass, etconfpass;
    private String suser, semail, spass, sconfpass;
    private TextView btnregister, punyaakun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etuser = findViewById(R.id.etuser);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        etconfpass = findViewById(R.id.etconfpass);
        btnregister = findViewById(R.id.btnregister);
        punyaakun = findViewById(R.id.punyaakun);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suser = etuser.getText().toString();
                semail = etemail.getText().toString();
                spass = etpass.getText().toString();
                sconfpass = etconfpass.getText().toString();

                if (!Objects.equals(spass, sconfpass)) {
                    Toast.makeText(RegisterActivity.this,
                            "Konfirmasi password tidak cocok",
                            Toast.LENGTH_SHORT).show();

                    return;
                }if (spass.isEmpty()){
                    Toast.makeText(RegisterActivity.this,
                            "Password harus diisi",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                Intent register = new Intent(RegisterActivity.this, LoginActivity.class);

                register.putExtra("username", suser);
                register.putExtra("email", semail);
                register.putExtra("password", spass);
                register.putExtra("confpass", sconfpass);

                startActivity(register);

            }
        });

        punyaakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }
}