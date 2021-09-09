package com.example.mycontact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactAdapterHolder> {
    String data[];
    int images[];
    Context context;
    public ContactAdapter(Context c,String s1[],int img[]){
        context = c;
        data = s1;
        images = img;
    }
    @NonNull
    @Override
    public ContactAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.activity_contact_items,parent,false);
        return new ContactAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapterHolder holder, int position) {
        holder.rcv_img.setImageResource(images[holder.getAdapterPosition()]);
        holder.rcv_text.setText(data[holder.getAdapterPosition()]);
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ContactMoreDetails.class);
                intent.putExtra("data",data[holder.getAdapterPosition()]);
                intent.putExtra("image",images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ContactAdapterHolder extends RecyclerView.ViewHolder {
        ImageView rcv_img;
        TextView rcv_text;
        ConstraintLayout constraintLayout;
        public ContactAdapterHolder(@NonNull View itemView) {
            super(itemView);
            rcv_img = itemView.findViewById(R.id.rcv_contact_image);
            rcv_text = itemView.findViewById(R.id.rcv_contact_tv);
            constraintLayout = itemView.findViewById(R.id.rcv_layout);
        }
    }
}
