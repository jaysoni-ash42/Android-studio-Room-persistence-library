package com.example.sql.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sql.R;
import com.example.sql.adapter.DataAdapter;
import com.example.sql.sql.Dao;
import com.example.sql.sql.Repository;
import com.example.sql.sql.Usersdatabase;
import com.example.sql.sql.Usersschema;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
private Repository repository;
    TextInputEditText fullname,Email,address;
    Button display,submit;
    RecyclerView recyclerView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository=new Repository(this);
        display=findViewById(R.id.display);
        display.setClickable(false);
        submit=findViewById(R.id.submit);
        fullname=findViewById(R.id.username);
        textView=findViewById(R.id.textview2);
        Email=findViewById(R.id.Email);
        address=findViewById(R.id.address);
        recyclerView=findViewById(R.id.recyclerview);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function();
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(new DataAdapter(repository.getall()));
            }
        });



    }
    private void function() {
        if (TextUtils.isEmpty(fullname.getText().toString())) {
            fullname.setError("Invalid name");

        } else if (TextUtils.isEmpty(Email.getText().toString())) {
            Email.setError("Invalid Email");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(Email.getText().toString()).matches())
        {
            Email.setError("Invalid Email");
        }
        else if (TextUtils.isEmpty(address.getText().toString())) {
            address.setError("Invalid Department");
        }
        else {
            repository.insertdata(new Usersschema(fullname.getText().toString(),Email.getText().toString(),address.getText().toString()));
            Toast.makeText(MainActivity.this,"Submitted",Toast.LENGTH_SHORT).show();
            display.setVisibility(View.VISIBLE);
            display.setClickable(true);
            recyclerView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);

        }
    }

}