package com.example.pruebalogin1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ViewHolder> {

    Context context;
    List<ModelCart> modelCarts;

    public AdapterCart(Context context, List<ModelCart> modelCarts) {
        this.context = context;
        this.modelCarts = modelCarts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cartcontainer,parent,false);
        return new AdapterCart.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String image=modelCarts.get(position).getImage();
        String name=modelCarts.get(position).getName();
        String price=modelCarts.get(position).getPrice();

        holder.cartprice.setText(price);
        holder.cartname.setText(name);

        try {
            Picasso.get().load(image).into(holder.cartimage);
        }
        catch (Exception e){

        }

    }

    @Override
    public int getItemCount() {
        return modelCarts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cartimage;
        TextView cartname,cartprice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartimage= itemView.findViewById(R.id.cartimage);
            cartname= itemView.findViewById(R.id.cartproductname);
            cartprice= itemView.findViewById(R.id.cartproductprice);

        }
    }
}
