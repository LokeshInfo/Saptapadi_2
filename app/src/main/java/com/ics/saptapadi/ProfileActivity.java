package com.ics.saptapadi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView back;
    ImageView edit1, edit2, edit3, edit4, edit5, edit6;
    ImageView save1, save2, save3, save4, save5, save6;
    EditText edname, edpass, edmobile, edmail, edaddr;
    CircleImageView img_profile;
    ImageView icgallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = (ImageView) findViewById(R.id.imgBack);

        edit1 = (ImageView) findViewById(R.id.editProfile1);
        edit2 = (ImageView) findViewById(R.id.editProfile2);
        edit3 = (ImageView) findViewById(R.id.editProfile3);
        edit4 = (ImageView) findViewById(R.id.editProfile4);
        edit5 = (ImageView) findViewById(R.id.editProfile5);
//        edit6 = (ImageView) findViewById(R.id.editProfil);

        save1 = (ImageView) findViewById(R.id.save1);
       save2 = (ImageView) findViewById(R.id.save2);
        save3 = (ImageView) findViewById(R.id.save3);
        save4 = (ImageView) findViewById(R.id.save4);
        save5 = (ImageView) findViewById(R.id.save5);
//        save6 = (ImageView) findViewById(R.id.sav);

        edname = (EditText) findViewById(R.id.ed_name);
//        edprofile = (EditText) findViewById(R.id.ed_up);
        edpass = (EditText) findViewById(R.id.ed_pass);
        edmobile = (EditText) findViewById(R.id.ed_mobile);
        edmail = (EditText) findViewById(R.id.ed_mail);
        edaddr = (EditText) findViewById(R.id.ed_addr);

        img_profile = findViewById(R.id.img_profil);
        icgallery = findViewById(R.id.ic_gallery);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edname.setEnabled(false);
        //edprofile.setEnabled(false);
        edmobile.setEnabled(false);
        edpass.setEnabled(false);
        edmail.setEnabled(false);
        edaddr.setEnabled(false);

        Click_Listeners();

    }

    private void Click_Listeners() {
        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save1.setVisibility(View.VISIBLE);
                edit1.setVisibility(View.GONE);
                edname.setEnabled(true);
            }
        });

        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save1.setVisibility(View.GONE);
                edit1.setVisibility(View.VISIBLE);
                edname.setEnabled(false);
            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save2.setVisibility(View.VISIBLE);
                edit2.setVisibility(View.GONE);
               //edprofile.setEnabled(true);
            }
        });

        save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save2.setVisibility(View.GONE);
                edit2.setVisibility(View.VISIBLE);
               // edprofile.setEnabled(false);
            }
        });

        edit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save3.setVisibility(View.VISIBLE);
                edit3.setVisibility(View.GONE);
                edpass.setEnabled(true);
            }
        });

        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save3.setVisibility(View.GONE);
                edit3.setVisibility(View.VISIBLE);
                edpass.setEnabled(false);
            }
        });

        edit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save4.setVisibility(View.VISIBLE);
                edit4.setVisibility(View.GONE);
                edmobile.setEnabled(true);
            }
        });

        save4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save4.setVisibility(View.GONE);
                edit4.setVisibility(View.VISIBLE);
                edmobile.setEnabled(false);
            }
        });

        edit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save5.setVisibility(View.VISIBLE);
                edit5.setVisibility(View.GONE);
                edmail.setEnabled(true);
            }
        });

        save5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save5.setVisibility(View.GONE);
                edit5.setVisibility(View.VISIBLE);
                edmail.setEnabled(false);
            }
        });

//        edit6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                save6.setVisibility(View.VISIBLE);
//                edit6.setVisibility(View.GONE);
//                edaddr.setEnabled(true);
//            }
//        });
//
//        save6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                save6.setVisibility(View.GONE);
//                edit6.setVisibility(View.VISIBLE);
//                edaddr.setEnabled(false);
//            }
//        });
//
        icgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfAlreadyhavePermission()){
                selectImage(ProfileActivity.this);}
                else {
                    check_permission();
                }            }
        });


    }

    private void selectImage(Activity context) {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                        img_profile.setImageBitmap(selectedImage);
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();

                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                img_profile.setImageBitmap(BitmapFactory.decodeFile(picturePath));

                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                BitmapFactory.decodeFile(picturePath).compress(Bitmap.CompressFormat.JPEG, 100, baos);
                                byte[] b = baos.toByteArray();
                                cursor.close();
                            }
                        }
                        break;
                    }
            }
        }
    }


    ////// Permissions

    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            check_permission();
            return false;
        }
    }

   void check_permission()
   {
       ActivityCompat.requestPermissions(ProfileActivity.this,
               new String[]{Manifest.permission.READ_EXTERNAL_STORAGE , Manifest.permission.CAMERA},
               1);
   }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(ProfileActivity.this, "Permission granted...", Toast.LENGTH_SHORT).show();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(ProfileActivity.this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }

    }
}