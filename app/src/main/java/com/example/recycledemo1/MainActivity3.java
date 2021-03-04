package com.example.recycledemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView txtname,txtemail,txtwebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtname = findViewById(R.id.TxtName);
        txtemail = findViewById(R.id.TxtEmail);
        txtwebsite = findViewById(R.id.TxtWebsite);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String email = intent.getStringExtra("Email");
        String website = intent.getStringExtra("Website");

        txtname.setText(name);
        txtemail.setText(email);
        txtwebsite.setText(website);

        txtemail.setOnClickListener(new TxtEmail());
        txtwebsite.setOnClickListener(new TxtWeb());
    }

    class TxtEmail implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intente = new Intent(Intent.ACTION_SEND, Uri.parse(""+txtemail.getText().toString().trim()));
            intente.putExtra(Intent.EXTRA_SUBJECT,"MESSAGE");
            intente.putExtra(Intent.EXTRA_TEXT,"Hellooooooo");

            intente.setType("message/rfc822");
            startActivity(Intent.createChooser(intente,"Choose Valid Email Id"));

        }
    }

    class TxtWeb implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intentw = new Intent(Intent.ACTION_VIEW);
            intentw.setData(Uri.parse("https://"+txtwebsite.getText().toString().trim()));
            startActivity(intentw);

        }
    }
}