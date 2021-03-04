package com.example.recycledemo1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button AddUserBtn;
    RecyclerView recyclerView;

    List<Modelclass> modelList;
    Modelclass modelclass;
    Adapterclass adapterclass;

    static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddUserBtn = findViewById(R.id.AddUserbtn);
        recyclerView = findViewById(R.id.RecycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        modelList = new ArrayList<>();

        adapterclass = new Adapterclass(this,modelList);
        recyclerView.setAdapter(adapterclass);

        AddUserBtn.setOnClickListener(new Btnadduser());

    }

    class Btnadduser implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivityForResult(intent,REQ_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQ_CODE == requestCode){

            if (Activity.RESULT_OK == resultCode){

                String Name = data.getStringExtra("Name");
                String Email = data.getStringExtra("Email");
                String Website = data.getStringExtra("Web");

                modelclass = new Modelclass();
                modelclass.setName(Name);
                modelclass.setEmail(Email);
                modelclass.setWebsite(Website);

                modelList.add(modelclass);
                adapterclass.notifyDataSetChanged();
            }
        }




    }
}