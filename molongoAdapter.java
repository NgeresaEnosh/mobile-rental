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

public class MlolongoAdapter extends RecyclerView.Adapter<MlolongoAdapter.MyHolder> implements Filterable {

    private Context context;
    private List<ModelClassMlolongo> arrayList;
    private List<ModelClassMlolongo> filteredList;
    private LayoutInflater layoutInflater;

    public MlolongoAdapter(Context context, List<ModelClassMlolongo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.filteredList = new ArrayList<>(arrayList);
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file_mlolongo, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.apartmentName.setText(filteredList.get(position).getApartmentName());
        holder.apartmentNum.setText(filteredList.get(position).getApartmentNum());
        holder.img.setImageResource(filteredList.get(position).getImg());

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
        return filteredList.size();
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
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString().toLowerCase().trim();
                if (charString.isEmpty()) {
                    filteredList = arrayList;
                } else {
                    List<ModelClassMlolongo> filtered = new ArrayList<>();
                    for (ModelClassMlolongo model : arrayList) {
                        if (model.getApartmentName().toLowerCase().contains(charString) || model.getApartmentNum().toLowerCase().contains(charString)) {
                            filtered.add(model);
                        }
                    }
                    filteredList = filtered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (ArrayList<ModelClassMlolongo>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
