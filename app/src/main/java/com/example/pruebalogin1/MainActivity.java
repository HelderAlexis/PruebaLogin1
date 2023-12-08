package com.example.pruebalogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAccesorios;
    private RecyclerView.Adapter adapterCourses;
    public RecyclerView recyclerViewCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAccesorios=(Button)findViewById(R.id.btnAccesorios);


        initRecyclerView();

        btnAccesorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, Catproducto.class);
                startActivity(i);
            }
        });
    }


    private void initRecyclerView() {
        ArrayList<Ofertas> ItemsArraylist= new ArrayList<>();

        ItemsArraylist.add(new Ofertas("ATREVIA XR LARGE X 1 TAB","ATREVIA XR",12260,4.6,"img_oferta1"));
        ItemsArraylist.add(new Ofertas("NEX GARD 68 MG DE 10-25 KG","NEX GARD",16450,4.7,"img_oferta2"));
        ItemsArraylist.add(new Ofertas("BRAVECTO 2 - 4.5 KG","BRAVECTO",10990,5.0,"img_oferta3"));
        ItemsArraylist.add(new Ofertas("SIMPARICA 10 MG X 3 TAB (2.5 - 5KG)","SIMPARICA",13420,4.3,"img_oferta4"));

        recyclerViewCourses= findViewById(R.id.view);
        recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterCourses= new Ofertas1(ItemsArraylist);
        recyclerViewCourses.setAdapter(adapterCourses);

    }
}