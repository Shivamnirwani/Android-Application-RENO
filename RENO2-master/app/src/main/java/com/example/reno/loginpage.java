package com.example.reno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        final Spinner spinner=(Spinner)findViewById(R.id.spinner_id);
        Button button=(Button)findViewById(R.id.button_id);
        List<String> categories;
        categories = new ArrayList<String>();
        categories.add("Admin");
        categories.add("Student");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = spinner.getSelectedItem().toString();
                if (item.equals("Student")){
                    Intent in=new Intent(loginpage.this,h.class);
                    startActivity(in);
                }
                else if (item.equals("Admin")){
                    Intent in=new Intent(loginpage.this,admin.class);
                    startActivity(in);
                }
            }
        });



    }
    public void registerit(View view)
    {
        Intent in=new Intent(this,register.class);
        startActivity(in);
    }






}


