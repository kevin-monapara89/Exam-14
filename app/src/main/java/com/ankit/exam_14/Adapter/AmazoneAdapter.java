package com.ankit.exam_14.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankit.exam_14.R;
import com.bumptech.glide.Glide;

public class AmazoneAdapter extends RecyclerView.Adapter<AmazoneAdapter.AmazonHolder> {


    public String name, price, delivery, discount;
    public int product;

    public AmazoneAdapter(String name, String price, String delivery, String discount, int product) {
        this.name = name;
        this.price = price;
        this.delivery = delivery;
        this.discount = discount;
        this.product = product;
    }
    Context context;

    @NonNull
    @Override
    public AmazoneAdapter.AmazonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amazonlist,parent,false);
        return new AmazonHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmazoneAdapter.AmazonHolder holder, int position) {
        Glide.with(context).load(product).into(holder.product);
        holder.name.setText(name);
        holder.price.setText(price);
        holder.discount.setText(discount);
        holder.delivery.setText(delivery);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return name.length();
    }

    public class AmazonHolder extends RecyclerView.ViewHolder {
        ImageView product;
        TextView name, price, delivery, discount;
        public AmazonHolder(@NonNull View itemView) {
            super(itemView);

            product = itemView.findViewById(R.id.product);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            delivery = itemView.findViewById(R.id.delivery);
            discount = itemView.findViewById(R.id.discount);
        }
    }
}
