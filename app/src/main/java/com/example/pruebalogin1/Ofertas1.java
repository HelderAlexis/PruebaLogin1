package com.example.pruebalogin1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Ofertas1 extends RecyclerView.Adapter<Ofertas1.ViewHolder> {
    ArrayList<Ofertas> items;
    DecimalFormat formatter;
    Context context;

    public Ofertas1(ArrayList<Ofertas> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,##");
    }

    @NonNull
    @Override
    public Ofertas1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_course,parent,false );
        context= parent.getContext();

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Ofertas1.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.ownerTxt.setText(items.get(position).getOwner());
        holder.precioTxt.setText("$"+formatter.format(items.get(position).getPrecio()));

        int drawableResourceId= holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(),
                "drawable",holder.itemView.getContext().getPackageName());
            Glide.with(holder.itemView.getContext())
                    .load(drawableResourceId)
                    .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, ownerTxt, precioTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt= itemView.findViewById(R.id.titleTxt);
            ownerTxt=itemView.findViewById(R.id.ownerTxt);
            precioTxt=itemView.findViewById(R.id.precioTxt);
            pic= itemView.findViewById(R.id.pic);

        }
    }
}
