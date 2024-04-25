package com.example.rental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Westlands extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    ArrayList<ModelClass> arrayList= new ArrayList<>();
    ArrayList<ModelClass> searchList;
    String[] apartmentList= new String[]{"Westlands Avenue\t Serenity Apartment","Parklands Road \tPineview Apartment","Mtiti Road \t Sunset palms Apartment",
            "Sport Road \t Lakeview Apartment","Crossway \t Willow Springs Apartment",
            "Ring Road \t Golden Gate Apartment","Lower Kabete Road \t Azure Sky Apartment",
            "Karuna Road \t Tranquil Waters Apartment","Westlands Roundabout \t Avalon Apartment"
            ,"Westlands Expressway Entry \t Highlands Apartment"};

    String[] apartmentNum= new String[]{"2-Bedroom\n Price $200 per month","4-Bedroom\n Price $500 per month",
            "Single Room \n $100 per month","3-Bedroom\n $350 per month","Single Room \n $150 Per Month",
            "2-Bedroom \n $200 Per Month","4-Bedroom \n $450 Per Month","Single Room \n $170 Per Month",
            "3-Bedroom \n $300 Per Month","4-Bedroom \n $650 per Month"};
    int[] imgList= new int[]{R.drawable.rental_2,R.drawable.room2,R.drawable.room4,
            R.drawable.room5,R.drawable.room7,R.drawable.room6,
            R.drawable.r11,R.drawable.r12,R.drawable.r7,R.drawable.r15};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_westlands);

        searchView= findViewById(R.id.searchview);
        recyclerView= findViewById(R.id.recyclerview);

        for (int i=0; i<apartmentList.length;i++){
            ModelClass modelClass= new ModelClass();
            modelClass.setApartmentName(apartmentList[i]);
            modelClass.setApartmentNum(apartmentNum[i]);
            modelClass.setImg(imgList[i]);
            arrayList.add(modelClass);
        }

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(Westlands.this);
        recyclerView.setLayoutManager(layoutManager);

        WestlandsAdapter westlandsAdapter= new WestlandsAdapter(Westlands.this,arrayList);
        recyclerView.setAdapter(westlandsAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchList= new ArrayList<>();

                if (query.length()>0){
                    for (int i=0; i<arrayList.size();i++){
                        if (arrayList.get(i).getApartmentName().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getApartmentNum().toUpperCase().contains(query.toUpperCase())){
                            ModelClass modelClass= new ModelClass();
                            modelClass.setApartmentName(arrayList.get(i).getApartmentName());
                            modelClass.setApartmentNum(arrayList.get(i).getApartmentNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(Westlands.this);
                    recyclerView.setLayoutManager(layoutManager);

                    WestlandsAdapter westlandsAdapter= new WestlandsAdapter(Westlands.this,searchList);
                    recyclerView.setAdapter(westlandsAdapter);
                }else {

                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(Westlands.this);
                    recyclerView.setLayoutManager(layoutManager);

                    WestlandsAdapter serviceAdapter= new WestlandsAdapter(Westlands.this,arrayList);
                    recyclerView.setAdapter(westlandsAdapter);

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList= new ArrayList<>();

                if (newText.length()>0){
                    for (int i=0; i<arrayList.size();i++){
                        if (arrayList.get(i).getApartmentName().toUpperCase().contains(newText.toUpperCase()) || arrayList.get(i).getApartmentNum().toUpperCase().contains(newText.toUpperCase())){
                            ModelClass modelClass= new ModelClass();
                            modelClass.setApartmentName(arrayList.get(i).getApartmentName());
                            modelClass.setApartmentNum(arrayList.get(i).getApartmentNum());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchList.add(modelClass);
                        }
                    }

                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(Westlands.this);
                    recyclerView.setLayoutManager(layoutManager);

                    WestlandsAdapter westlandsAdapter= new WestlandsAdapter(Westlands.this,searchList);
                    recyclerView.setAdapter(westlandsAdapter);
                }else {

                    RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(Westlands.this);
                    recyclerView.setLayoutManager(layoutManager);

                    WestlandsAdapter westlandsAdapter= new WestlandsAdapter(Westlands.this,arrayList);
                    recyclerView.setAdapter(westlandsAdapter);

                }
                return false;
            }
        });
    }
}
