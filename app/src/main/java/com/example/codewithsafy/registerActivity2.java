package com.example.codewithsafy;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class registerActivity2 extends AppCompatActivity {
            EditText username1 , pasword, confirmpassword, name,age ;
      RadioGroup gender1;
            Button register;
            Button login;
    SharedPreferences sharedPreferences;
String name1;

    DB db;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_register2);
                sharedPreferences = getSharedPreferences("SHARED PREFRENCES", MODE_PRIVATE);
                name=findViewById(R.id.username);
                username1 = findViewById(R.id.email1);
                login=findViewById(R.id.login);
                pasword = findViewById(R.id.pass);
                confirmpassword = findViewById(R.id.repass);
                age = findViewById(R.id.a);
                gender1=findViewById(R.id.gen);
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openactivity();
    }
});
                register = (Button) findViewById(R.id.reg);
                db = new DB(this);
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name1 = name.getText().toString();
                        String age1 = age.getText().toString();
                        String user = username1.getText().toString();
                        String pass = pasword.getText().toString();
                        RadioButton check=findViewById(gender1.getCheckedRadioButtonId());
                        String gg= check.getText().toString();

                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("name1",name1);
                        editor.apply();

                        String repassword = confirmpassword.getText().toString();
                        if (name1.equals("")|| age1.equals("")||user.equals("") || pass.equals("") || repassword.equals("") || name1.equals("")) {
                            Toast.makeText(registerActivity2.this, "please fill every fields", Toast.LENGTH_LONG).show();
                        }
                        else if(db.checkuser(user) == true){
                            Toast.makeText(registerActivity2.this, "user Already exist", Toast.LENGTH_LONG).show();
                        }
                        else if( ! Patterns.EMAIL_ADDRESS.matcher(user).matches())
                        {
                            username1.setError("please enter a valid email address/phone no");
                        }
                        else {
                            if (pass.equals(repassword)) {

                                    if (name1.length() > 3) {
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("Name", name1);
                                        contentValues.put("age", age1);
                                        contentValues.put("email", user);
                                        contentValues.put("password", pass);
                                        contentValues.put("gender", gg);
                                        db.insertuser(contentValues);
                                        Toast.makeText(registerActivity2.this, "User Registred", Toast.LENGTH_SHORT).show();
                                        openactivity();
                                    } else {
                                        Toast.makeText(registerActivity2.this, "enter Valid name", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            else{
                                    Toast.makeText(registerActivity2.this, "password donot match", Toast.LENGTH_SHORT).show();
                                }







                        }
                    }


                });

            }
    private void openactivity() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}


