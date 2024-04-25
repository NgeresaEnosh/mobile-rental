package com.example.rental;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText date;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView imgWestlands = findViewById(R.id.imgwestlands);
        TextView tvWestlands = findViewById(R.id.tvwestlands);
        date= findViewById(R.id.dateedittext);


        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + (month + 1 + "/" + year));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Set click listener for ImageView
        if (imgWestlands != null) {
            imgWestlands.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to WestlandsActivity when ImageView is clicked
                    navigateToWestlandsActivity();
                }
            });
        }

        // Set click listener for TextView
        if (tvWestlands != null) {
            tvWestlands.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to WestlandsActivity when TextView is clicked
                    navigateToWestlandsActivity();
                }
            });
        }

        // Initialize and set click listeners for Runda views
        ImageView imgRunda = findViewById(R.id.image6);
        TextView tvRunda = findViewById(R.id.textviewRunda);

        if (imgRunda != null) {
            imgRunda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToRundaActivity();
                }
            });
        }

        if (tvRunda != null) {
            tvRunda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToRundaActivity();
                }
            });
        }

        // Initialize and set click listeners for Kasarani views
        ImageView imgKasarani = findViewById(R.id.imagekasarani);
        TextView tvKasarani = findViewById(R.id.textviewkasarani);

        if (imgKasarani != null) {
            imgKasarani.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToKasaraniActivity();
                }
            });
        }

        if (tvKasarani != null) {
            tvKasarani.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToKasaraniActivity();
                }
            });
        }

        // Initialize and set click listeners for Mlolongo views
        ImageView imgMlolongo = findViewById(R.id.imagemlolongo);
        TextView tvMlolongo = findViewById(R.id.textviewmlolongo);

        if (imgMlolongo != null) {
            imgMlolongo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToMlolongoActivity();
                }
            });
        }

        if (tvMlolongo != null) {
            tvMlolongo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToMlolongoActivity();
                }
            });
        }

        bottomNavigationView = findViewById(R.id.bottomnavigator);
        bottomNavigationView.setSelectedItemId(R.id.search);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.profile) {
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.search) {
                    return true;
                } else if (itemId == R.id.repair) {
                    startActivity(new Intent(getApplicationContext(), RepairActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else {
                    Toast.makeText(HomeActivity.this, "Invalid navigation item selected!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    // Method to navigate to WestlandsActivity
    private void navigateToWestlandsActivity() {
        Intent intent = new Intent(HomeActivity.this, Westlands.class);
        startActivity(intent);
    }

    // Method to navigate to RundaActivity
    private void navigateToRundaActivity() {
        Intent intent = new Intent(HomeActivity.this, RundaActivity.class);
        startActivity(intent);
    }
    // Method to navigate to KasaraniActivity
    private void navigateToKasaraniActivity() {
        Intent intent = new Intent(HomeActivity.this, KasaraniActivity.class);
        startActivity(intent);
    }

    // Method to navigate to MlolongoActivity
    private void navigateToMlolongoActivity() {
        Intent intent = new Intent(HomeActivity.this, MlolongoActivity.class);
        startActivity(intent);
    }
}
