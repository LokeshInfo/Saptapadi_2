package com.ics.saptapadi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ProfileCameraActivity extends AppCompatActivity {
    ImageView iv;
    Button btnGallery,btnCamera,btnNewApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_camera);

        iv=(ImageView)findViewById(R.id.imageView);
        btnCamera=(Button)findViewById(R.id.btnCamera);
        btnGallery=(Button)findViewById(R.id.btnGal);
        btnNewApp=(Button)findViewById(R.id.btnNewApp);

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(ProfileCameraActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) !=
                        PermissionChecker.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ProfileCameraActivity.this, new
                            String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 112);
                }
                else
                {
                    Intent in=new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(in,112);
                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(ProfileCameraActivity.this,
                        Manifest.permission.CAMERA) !=
                        PermissionChecker.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ProfileCameraActivity.this, new
                            String[]{Manifest.permission.CAMERA}, 11);
                }
                else {
                    Intent in =
                            new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(in, 113);
                }
            }
        });
        btnNewApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= getPackageManager().
                        getLaunchIntentForPackage(
                                "com.example.root.alarmservicedemoapp");
                in.putExtra("start",20);

                if(in!=null)
                {
                    in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(in);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==112 && data!=null)
        {
            Uri uri= data.getData();
            iv.setImageURI(uri);
        }
        if(requestCode==113 && data !=null)
        {
            Bitmap bmp=(Bitmap)data.getExtras().get("data");
            iv.setImageBitmap(bmp);

        }
}
}
