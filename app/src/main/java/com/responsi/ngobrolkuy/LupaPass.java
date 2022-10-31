package com.responsi.ngobrolkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LupaPass extends AppCompatActivity {

    private EditText lupaemail;
    private String slupaemail;
    private TextView submitemail;
    private ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_pass);

        lupaemail = findViewById(R.id.lupaemail);
        submitemail = findViewById(R.id.submitemail);
        arrow = findViewById(R.id.arrow);

        submitemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slupaemail = lupaemail.getText().toString();



                if (slupaemail.isEmpty()){
                    Toast.makeText(LupaPass.this,
                            "Email harus diisi",
                            Toast.LENGTH_SHORT).show();

                    return;
                }
                Intent cekemail = new Intent(LupaPass.this, CekEmail.class);
                startActivity(cekemail);
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(LupaPass.this, LoginActivity.class);
                startActivity(back);
            }
        });
    }
}