package com.example.recycledemo1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    EditText edtname,edtemail,edtwebsite;
    Button AddBtn,ImageGallerybtn;
    ImageView Image;

    static final int REQ_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtname = findViewById(R.id.EdtName);
        edtwebsite = findViewById(R.id.EdtWebsite);
        edtemail = findViewById(R.id.EdtEmail);

        AddBtn = findViewById(R.id.AddBtn);
        ImageGallerybtn = findViewById(R.id.ImageGallerybtn);

        Image = findViewById(R.id.ImageView);

        AddBtn.setOnClickListener(new BtnAdd());
        ImageGallerybtn.setOnClickListener(new GalleryBtn());
    }

    class BtnAdd implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity2.this,MainActivity.class);

            String name = edtname.getText().toString().trim();
            String email = edtemail.getText().toString().trim();
            String website = edtwebsite.getText().toString().trim();

            intent.putExtra("Name",name);
            intent.putExtra("Email",email);
            intent.putExtra("Web",website);

            setResult(Activity.RESULT_OK,intent);
            finish();

        }
    }

    class GalleryBtn implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent,REQ_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(REQ_CODE == requestCode && Activity.RESULT_OK == resultCode){

            Uri imagedata = data.getData();
            Image.setImageURI(imagedata);
        }
    }
}