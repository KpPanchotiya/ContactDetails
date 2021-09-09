package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ContactMoreDetails extends AppCompatActivity {
    ImageButton c_image_btn;
    TextView tv_name,tv_email,tv_number,tv_address;
    RadioButton r_female,r_male;
    String s1[],s2[],s3[],data;
    String data1,data2,data3;
    int contact_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_more_details);
        c_image_btn = findViewById(R.id.c_d_img_btn);
        tv_name = findViewById(R.id.c_d_name);
        tv_email = findViewById(R.id.c_d_email);
        tv_number = findViewById(R.id.c_d_number);
        tv_address = findViewById(R.id.c_d_address);
        r_female = findViewById(R.id.r_btn_female);
        r_male = findViewById(R.id.r_btn_male);

        r_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadiobuttonClicked(r_female);
            }
        });
        r_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadiobuttonClicked(r_male);
            }
        });
        getData();
        setData();
    }

    public void onRadiobuttonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.r_btn_female:
                if (checked)
                    break;
            case R.id.r_btn_male:
                if (checked)
                    break;
        }
    }

    private void getData() {
        if (getIntent().hasExtra("image") && getIntent().hasExtra("data")){
            data =getIntent().getStringExtra("data");
            contact_image =getIntent().getIntExtra("image",1);
            s3 = getResources().getStringArray(R.array.person_email);
            s2 = getResources().getStringArray(R.array.person_contact);
            s1= getResources().getStringArray(R.array.person_address);
        }
        else {
            Toast.makeText(this,"no data",Toast.LENGTH_SHORT).show();
        }
    }


    private void setData() {
        tv_name.setText(data);
        c_image_btn.setImageResource(contact_image);
        //for address
        for (int i=0;i<s1.length;i++){
            data1 = s1[i];
        }
        tv_address.setText(data1);
        //for contact
        for (int i=0;i<s2.length;i++){
            data2 = s2[i];
        }
        tv_number.setText(data2);
        //for email
        for (int i=0;i<s3.length;i++){
            data3 = s3[i];
        }
        tv_email.setText(data3);
    }

}