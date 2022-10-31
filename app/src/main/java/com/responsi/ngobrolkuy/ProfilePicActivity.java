package com.responsi.ngobrolkuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Objects;

public class ProfilePicActivity extends AppCompatActivity {
    private ImageView editgambar, tampilgambar;
    private Uri avatarUri;
    private TextView lewat;

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);

        editgambar = findViewById(R.id.editgambar);
        tampilgambar = findViewById(R.id.profilePic);
        lewat = findViewById(R.id.lewat);

        lewat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skip = new Intent(ProfilePicActivity.this, Chat.class);
                startActivity(skip);
            }
        });

        editgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), GALLERY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(ProfilePicActivity.this,
                    "Batal menambahkan gambar",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if (requestCode == GALLERY_REQUEST_CODE) {
            if (!Objects.equals(data, null)) {
                try {
                    avatarUri = data.getData();
                    Bitmap avatarBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), avatarUri);
                    tampilgambar.setImageBitmap(avatarBitmap);
                } catch (IOException e) {
                    Toast.makeText(ProfilePicActivity.this,
                            "Tidak bisa memuat gambar",
                            Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
}