package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class KasaraniActivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClassKasarani> arrayList = new ArrayList<>();
    ArrayList<ModelClassKasarani> searchList;
    String[] apartmentList = new String[]{"Westlands Avenue\t Serenity Apartment", "Parklands Road \tPineview Apartment", "Mtiti Road \t Sunset palms Apartment",
            "Sport Road \t Lakeview Apartment", "Crossway \t Willow Springs Apartment",
            "Ring Road \t Golden Gate Apartment", "Lower Kabete Road \t Azure Sky Apartment",
            "Karuna Road \t Tranquil Waters Apartment", "Westlands Roundabout \t Avalon Apartment"
            , "Westlands Expressway Entry \t Highlands Apartment"};

    String[] apartmentNum = new String[]{"2-Bedroom\n Price $200 per month", "4-Bedroom\n Price $500 per month",
            "Single Room \n $100 per month", "3-Bedroom\n $350 per month", "Single Room \n $150 Per Month",
            "2-Bedroom \n $200 Per Month", "4-Bedroom \n $450 Per Month", "Single Room \n $170 Per Month",
            "3-Bedroom \n $300 Per Month", "4-Bedroom \n $650 per Month"};
    int[] imgList = new int[]{R.drawable.kasarani1, R.drawable.kasarani2, R.drawable.kasarani3,
            R.drawable.kasarani4, R.drawable.room7, R.drawable.room6,
            R.drawable.r11, R.drawable.r12, R.drawable.r7, R.drawable.r15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasarani);

        searchView = findViewById(R.id.searchview);
        recyclerView = findViewById(R.id.recyclerview);

        for (int i = 0; i < Math.min(apartmentList.length, Math.min(apartmentNum.length, imgList.length)); i++) {
            ModelClassKasarani modelClassKasarani = new ModelClassKasarani();
            modelClassKasarani.setApartmentName(apartmentList[i]);
            modelClassKasarani.setApartmentNum(apartmentNum[i]);
            modelClassKasarani.setImg(imgList[i]);
            arrayList.add(modelClassKasarani);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KasaraniActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        final KasaraniAdapter kasaraniAdapter = new KasaraniAdapter(KasaraniActivity.this, arrayList);
        recyclerView.setAdapter(kasaraniAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                kasaraniAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                kasaraniAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
