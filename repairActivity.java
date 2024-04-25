package com.example.rental;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RepairActivity extends AppCompatActivity {

    private Button btnElectricity;
    private Button btnWater;
    private Button btnHouseRenovation;
    private CardView descriptionCardView;
    private Button btnSave;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        initializeViews();
        setButtonListeners();
        setBottomNavigation();
    }

    private void initializeViews() {
        btnElectricity = findViewById(R.id.btnElectricity);
        btnWater = findViewById(R.id.btnWater);
        btnHouseRenovation = findViewById(R.id.btnHouseRenovation);
        descriptionCardView = findViewById(R.id.descriptionCardView);
        btnSave = findViewById(R.id.btnSave);
        bottomNavigationView = findViewById(R.id.bottomnavigator);
    }

    private void setButtonListeners() {
        btnElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColor(btnElectricity);
            }
        });

        btnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColor(btnWater);
            }
        });

        btnHouseRenovation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeButtonColor(btnHouseRenovation);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform save operation here
                // Once saved, reset button colors
                resetButtonColors();

                // Show a toast message indicating successful save
                showToast("Saved successfully");
            }
        });
    }

    private void changeButtonColor(Button button) {
        // Change the background color of the clicked button to red
        button.setBackgroundColor(Color.RED);
    }

    private void resetButtonColors() {
        // Reset the background color of all buttons to default
        btnElectricity.setBackgroundColor(Color.TRANSPARENT);
        btnWater.setBackgroundColor(Color.TRANSPARENT);
        btnHouseRenovation.setBackgroundColor(Color.TRANSPARENT);
    }

    // Method to show a toast message
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void setBottomNavigation() {
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
                    // No need to start RepairActivity again, already in RepairActivity
                    return true;
                } else if (itemId == R.id.repair) {
                    // Already in RepairActivity, no need to do anything
                    return true;
                } else {
                    Toast.makeText(RepairActivity.this, "Invalid navigation item selected!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
