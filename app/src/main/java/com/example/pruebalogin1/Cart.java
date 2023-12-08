package com.example.pruebalogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import p32929.androideasysql_library.Column;
import p32929.androideasysql_library.EasyDB;

public class Cart extends AppCompatActivity {

    List<ModelCart> modelCarts;
    AdapterCart adapterCart;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.cartrecycler);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Cart.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        modelCarts= new ArrayList<>();
        
        getcartitemns();
    }

    private void getcartitemns() {

        EasyDB easyDB= EasyDB.init(Cart.this,"ITEM_DB")
                .setTableName("ITEM_TABLE")
                .addColumn(new Column("item_id",new String[]{"text","unique"}))
                .addColumn(new Column("item_name",new String[]{"text","not null"}))
                .addColumn(new Column("item_price",new String[]{"text","not null"}))
                .addColumn(new Column("item_image",new String[]{"text","not null"}))
                .doneTableColumn();

        Cursor res= easyDB.getAllData();
        while (res.moveToNext()){
            String id=res.getString(0);
            String name=res.getString(1);
            String price=res.getString(2);
            String image=res.getString(3);

            ModelCart modelCart=new ModelCart(id,name,price,image);
            modelCarts.add(modelCart);
            adapterCart= new AdapterCart(Cart.this,modelCarts);
            recyclerView.setAdapter(adapterCart);


        }
    }
}