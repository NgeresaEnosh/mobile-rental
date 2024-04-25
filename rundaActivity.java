package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RundaActivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClassRunda> arrayList = new ArrayList<>();
    ArrayList<ModelClassRunda> searchList;
    String[] apartmentList = new String[]{"Westlands Avenue\t Serenity Apartment", "Parklands Road \tPineview Apartment", "Mtiti Road \t Sunset palms Apartment",
            "Sport Road \t Lakeview Apartment", "Crossway \t Willow Springs Apartment",
            "Ring Road \t Golden Gate Apartment", "Lower Kabete Road \t Azure Sky Apartment",
            "Karuna Road \t Tranquil Waters Apartment", "Westlands Roundabout \t Avalon Apartment"
            , "Westlands Expressway Entry \t Highlands Apartment"};

    String[] apartmentNum = new String[]{"2-Bedroom\n Price $200 per month", "4-Bedroom\n Price $500 per month",
            "Single Room \n $100 per month", "3-Bedroom\n $350 per month", "Single Room \n $150 Per Month",
            "2-Bedroom \n $200 Per Month", "4-Bedroom \n $450 Per Month", "Single Room \n $170 Per Month",
            "3-Bedroom \n $300 Per Month", "4-Bedroom \n $650 per Month"};
    int[] imgList = new int[]{R.drawable.runda1, R.drawable.runda2, R.drawable.runda3,
            R.drawable.runda4, R.drawable.runda5, R.drawable.runda6,R.drawable.runda6,R.drawable.runda6
              ,R.drawable.runda6,R.drawable.runda6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runda);

        searchView = findViewById(R.id.searchview);
        recyclerView = findViewById(R.id.recyclerview);

        int min = Math.min(apartmentList.length, Math.min(apartmentNum.length, imgList.length));
        for (int i = 0; i < min; i++) {
            ModelClassRunda modelClassRunda = new ModelClassRunda();
            modelClassRunda.setApartmentName(apartmentList[i]);
            modelClassRunda.setApartmentNum(apartmentNum[i]);
            modelClassRunda.setImg(imgList[i]);
            arrayList.add(modelClassRunda);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RundaActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        final RundaAdapter rundaAdapter = new RundaAdapter(RundaActivity.this, arrayList);
        recyclerView.setAdapter(rundaAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                rundaAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rundaAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
