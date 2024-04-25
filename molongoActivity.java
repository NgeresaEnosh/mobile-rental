package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class MlolongoActivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClassMlolongo> arrayList = new ArrayList<>();
    ArrayList<ModelClassMlolongo> searchList;
    String[] apartmentList = new String[]{"Westlands Avenue\t Serenity Apartment", "Parklands Road \tPineview Apartment", "Mtiti Road \t Sunset palms Apartment",
            "Sport Road \t Lakeview Apartment", "Crossway \t Willow Springs Apartment",
            "Ring Road \t Golden Gate Apartment", "Lower Kabete Road \t Azure Sky Apartment",
            "Karuna Road \t Tranquil Waters Apartment", "Westlands Roundabout \t Avalon Apartment"
            , "Westlands Expressway Entry \t Highlands Apartment"};

    String[] apartmentNum = new String[]{"2-Bedroom\n Price $200 per month", "4-Bedroom\n Price $500 per month",
            "Single Room \n $100 per month", "3-Bedroom\n $350 per month", "Single Room \n $150 Per Month",
            "2-Bedroom \n $200 Per Month", "4-Bedroom \n $450 Per Month", "Single Room \n $170 Per Month",
            "3-Bedroom \n $300 Per Month", "4-Bedroom \n $650 per Month"};
    int[] imgList = new int[]{R.drawable.mlolongo1, R.drawable.mlolongo2, R.drawable.mlolongo3,
            R.drawable.mlolongo4, R.drawable.mlolongo5, R.drawable.mlolongo6,
            R.drawable.r11, R.drawable.r12, R.drawable.r7, R.drawable.r15};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mlolongo);

        searchView = findViewById(R.id.searchview);
        recyclerView = findViewById(R.id.recyclerview);

        for (int i = 0; i < Math.min(apartmentList.length, Math.min(apartmentNum.length, imgList.length)); i++) {
            ModelClassMlolongo modelClassMlolongo = new ModelClassMlolongo();
            modelClassMlolongo.setApartmentName(apartmentList[i]);
            modelClassMlolongo.setApartmentNum(apartmentNum[i]);
            modelClassMlolongo.setImg(imgList[i]);
            arrayList.add(modelClassMlolongo);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MlolongoActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        final MlolongoAdapter mlolongoAdapter = new MlolongoAdapter(MlolongoActivity.this, arrayList);
        recyclerView.setAdapter(mlolongoAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mlolongoAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mlolongoAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
