package com.example.rental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RundaAdapter extends RecyclerView.Adapter<RundaAdapter.MyHolder> implements Filterable {

    private Context context;
    private ArrayList<ModelClassRunda> arrayList;
    private ArrayList<ModelClassRunda> arrayListFull;

    public RundaAdapter(Context context, ArrayList<ModelClassRunda> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayListFull = new ArrayList<>(arrayList);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_runda, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.apartmentName.setText(arrayList.get(position).getApartmentName());
        holder.apartmentNum.setText(arrayList.get(position).getApartmentNum());
        holder.img.setImageResource(arrayList.get(position).getImg());

        // Set OnClickListener for the button
        holder.bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example: Start BookRental activity
                Intent intent = new Intent(context, BookRentalActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public Filter getFilter() {
        return apartmentFilter;
    }

    private Filter apartmentFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ModelClassRunda> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(arrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelClassRunda item : arrayListFull) {
                    if (item.getApartmentName().toLowerCase().contains(filterPattern) || item.getApartmentNum().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList.clear();
            arrayList.addAll((List<ModelClassRunda>) results.values);
            notifyDataSetChanged();
        }
    };

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
        }
    }
}
