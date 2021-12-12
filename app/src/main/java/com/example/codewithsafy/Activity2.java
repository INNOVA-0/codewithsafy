package com.example.codewithsafy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Activity2 extends AppCompatActivity  {

ImageView ubm;
ImageView backbutton;
ImageView Workoutplan;
ImageView dailychallenge;
ImageView steptracking;
ImageView equipmentidentification;
NavigationView nav;
DrawerLayout drawerLayout;
ActionBarDrawerToggle toggle;
Toolbar toolbar;
int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
toolbar=findViewById(R.id.tooolbar);

setSupportActionBar(toolbar);
equipmentidentification=findViewById(R.id.EI);

        ubm= findViewById(R.id.ubm);
        Workoutplan=findViewById(R.id.WK);
        dailychallenge=findViewById(R.id.DC);
        steptracking=findViewById(R.id.ST);
        equipmentidentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openei();
            }
        });
        steptracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensteptracking();
            }
        });
        dailychallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
dailychallenge();
            }
        });
        backbutton=findViewById(R.id.backbutton);


        nav=(NavigationView)findViewById(R.id.navmenu);
        nav.bringToFront();
        drawerLayout =(DrawerLayout)findViewById(R.id.drawer);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
                switch (menuitem.getItemId())
                {
                    case R.id.menu_Logout :

                    {

                        AlertDialog.Builder builder= new AlertDialog.Builder(Activity2.this);
                        builder.setTitle("Logout");

                        builder.setMessage("Are you sure you want to logout?");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
openMainActivity();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                          dialog.dismiss();
                            }
                        });


                        AlertDialog alert= builder.create();
                        alert.show();



                    }
                        drawerLayout.closeDrawer(GravityCompat.START);
break;
                    case R.id.menu_home :
                        drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                    case R.id.menu_aboutua:
                        openaboutus();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_profile:
                        openprofile();
                        drawerLayout.closeDrawer(GravityCompat.START);
                }



                return true;
            }
        });



ubm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openBMI();
    }
});
Workoutplan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openWorkoutplan();
    }
});
backbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder= new AlertDialog.Builder(Activity2.this);
        builder.setTitle("Confirm Exit..!!");

        builder.setMessage("Are you sure you want to Exit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openMainActivity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        AlertDialog alert= builder.create();
        alert.show();


    }
});


    }




    private void openMainActivity() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);
    }
    private void openBMI() {
        Intent intent= new Intent(this, BMI.class);
        startActivity(intent);
    }
    public void onBackPressed(){
counter++;

        if(counter ==2){
            super.onBackPressed();


        }
        else{
            Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT).show();
        }


    }
private void openWorkoutplan(){
    Intent intent= new Intent(this, workoutplan.class);
    startActivity(intent);

}
    private void dailychallenge(){
        Intent intent= new Intent(this, dailychallenge.class);
        startActivity(intent);

    }
    private void opensteptracking(){
        Intent intent= new Intent(this, com.example.codewithsafy.ui.steptracking.class);
        startActivity(intent);

    }
    private void openaboutus(){
        Intent intent= new Intent(this, aboutus.class);
        startActivity(intent);

    }
    private void openprofile(){
        Intent intent= new Intent(this, profile.class);
        startActivity(intent);

    }
    private void openei(){
        Intent intent= new Intent(this, ei.class);
        startActivity(intent);

    }
}