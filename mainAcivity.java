package com.example.rental;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btncontinue;
    CheckBox box1, box2, box3;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure correct layout file is inflated
        // Initialize CheckBoxes
        box1 = findViewById(R.id.terms_checkbox);
        box2 = findViewById(R.id.term2_checkbox);
        box3 = findViewById(R.id.term3_checkbox);
        btncontinue = findViewById(R.id.continue_button);

        // Set OnCheckedChangeListener for each CheckBox
        box1.setOnCheckedChangeListener((buttonView, isChecked) -> updateContinueButtonVisibility());
        box2.setOnCheckedChangeListener((buttonView, isChecked) -> updateContinueButtonVisibility());
        box3.setOnCheckedChangeListener((buttonView, isChecked) -> updateContinueButtonVisibility());

        // Additional code for handling window insets (optional)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets.consumeSystemWindowInsets();
        });
    }

    // Method to update visibility of Continue button based on checkbox states
    private void updateContinueButtonVisibility() {
        if (box1.isChecked() && box2.isChecked() && box3.isChecked()) {
            btncontinue.setEnabled(true);
            btncontinue.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class );
                startActivity(intent);
                finish();
            });
        } else {
            btncontinue.setEnabled(false);
        }
    }

}
