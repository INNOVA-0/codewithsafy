package com.example.codewithsafy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EquipmentDetails extends AppCompatActivity {

    String label;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_details);

        description = findViewById(R.id.equipmentDescription);

        label = ei.classification;
        ei.fromGallery = false;

        if (label != null)   // just  display the name of detected weed
        {
            TextView equipmentName = findViewById(R.id.equipmentName);
            equipmentName.setText(label);
            displayDetails(label); // and set the details for the weed
        }
    }

    public void displayDetails(String name)
    {
        String descriptionTxt; // will countain the description text

        if (name.equals("aerobic_steppers"))
        {
            description.setText(" The Model has detected aerobic_steppers.");
        }
        else if (name.equals("bench_press"))
        {
            description.setText("The Model has detected bench_press.");
        }
        else if (name.equals("dumb_bell"))
        {
            description.setText("The Model has detected dumb_bell");

        }
        else if (name.equals("elliptical"))
        {
            description.setText("The Model has detected  elliptical");

        }
        else if (name.equals("multi_machine"))
        {
            description.setText("The Model has detected multi_machine");

        }
        else if (name.equals("rowing_machine"))
        {
            description.setText("The Model has detected rowing_machine");

        }else if (name.equals("treadmill")) {
            description.setText("The Model has detected treadmill");

        }

    }

}