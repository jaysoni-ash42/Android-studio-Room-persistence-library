package com.example.sql.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sql.R;

import com.example.sql.sql.Usersschema;

import java.util.List;
import java.util.zip.Inflater;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterholder> {
    List<Usersschema> users;
    public DataAdapter(List<Usersschema> users)
    {
        this.users=users;
    }
    @NonNull
    @Override
    public DataAdapterholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter,parent,false);
      return new DataAdapterholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapterholder holder, int position) {
        holder.username.setText(users.get(position).getUsername());
        holder.email.setText(users.get(position).getEmail());
        holder.address.setText(users.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
       if(users.size() == 0)
       {
           return 0;
       }
       else return users.size();
    }

    public class DataAdapterholder extends RecyclerView.ViewHolder
    {
        TextView username,email,address;

        public DataAdapterholder(@NonNull View itemView) {
            super(itemView);
            username=itemView.findViewById(R.id.username);
            email=itemView.findViewById(R.id.email);
           address=itemView.findViewById(R.id.address);
        }
    }
}
