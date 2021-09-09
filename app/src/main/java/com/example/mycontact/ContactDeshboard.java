package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDeshboard extends AppCompatActivity {
    ImageView c_image;
    TextView c_text;
    RecyclerView rcv_contact_list;
    ContactAdapter contactAdapter;
    String s[];
    int image[] = {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__deshboard);
        c_image = findViewById(R.id.c_list_img);
        c_text = findViewById(R.id.contact_list_tv);
        rcv_contact_list = findViewById(R.id.rcv_contact_list);
        s =getResources().getStringArray(R.array.contact_name);
        contactAdapter = new ContactAdapter(this,s,image);
        rcv_contact_list.setAdapter(contactAdapter);
        rcv_contact_list.setLayoutManager(new LinearLayoutManager(this));
    }
}