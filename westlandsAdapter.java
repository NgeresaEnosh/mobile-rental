package com.example.rental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WestlandsAdapter extends RecyclerView.Adapter<WestlandsAdapter.MyHolder> {

    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater layoutInflater;

    public WestlandsAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.apartmentName.setText(arrayList.get(position).getApartmentName());
        holder.apartmentNum.setText(arrayList.get(position).getApartmentNum());
        holder.img.setImageResource(arrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView apartmentName, apartmentNum;
        ImageView img;
        Button bookButton; // Add reference to the button

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            apartmentName = itemView.findViewById(R.id.txt);
            apartmentNum = itemView.findViewById(R.id.txt2);
            img = itemView.findViewById(R.id.img);
            bookButton = itemView.findViewById(R.id.bookbutton); // Initialize the button reference

            // Set OnClickListener for the button
            bookButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Example: Start BookRental activity
                    Intent intent = new Intent(context, BookRentalActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
