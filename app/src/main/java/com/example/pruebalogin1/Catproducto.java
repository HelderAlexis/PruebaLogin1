package com.example.pruebalogin1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Catproducto extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    List<ModelProduct> modelProducts;
    AdapterProduct adapterProduct;

    TextView cartcounter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catproducto);
        recyclerView=findViewById(R.id.productrecyclerview);
        floatingActionButton=findViewById(R.id.floatingcart);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Catproducto.this, Cart.class));
            }
        });
        modelProducts= new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager= new GridLayoutManager(Catproducto.this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        cartcounter=findViewById(R.id.cartcounter);
        getCardCount();
        
        
        getProducts();
        


    }

    public void getCardCount() {
        CartCounter cartCounter=new CartCounter(Catproducto.this);
        int count=cartCounter.cartCount();
        cartcounter.setText(""+count);
    }

    private void getProducts() {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("products");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    modelProducts.clear();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    ModelProduct modelProduct= snapshot.getValue(ModelProduct.class);
                    modelProducts.add(modelProduct);
                    adapterProduct= new AdapterProduct(Catproducto.this,modelProducts,floatingActionButton);
                    recyclerView.setAdapter(adapterProduct);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}