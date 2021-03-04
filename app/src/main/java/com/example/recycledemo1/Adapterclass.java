package com.example.recycledemo1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.ViewHolder> {

    Context ncontext;
    List<Modelclass> nmodelclass;

    public Adapterclass(Context ncontext, List<Modelclass> nmodelclass) {
        this.ncontext = ncontext;
        this.nmodelclass = nmodelclass;
    }

    @NonNull
    @Override
    public Adapterclass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlist,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterclass.ViewHolder holder, int position) {

        Modelclass modelclass = nmodelclass.get(position);
        holder.Name.setText(modelclass.getName());
        holder.Email.setText(modelclass.getEmail());
        holder.Website.setText(modelclass.getWebsite());

    }

    @Override
    public int getItemCount() {
        return nmodelclass.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Name,Email,Website;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            Name = itemView.findViewById(R.id.customname);
            Email = itemView.findViewById(R.id.customemail);
            Website = itemView.findViewById(R.id.customwebsite);

            Name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   Intent intent = new Intent(ncontext,MainActivity3.class);
                   intent.putExtra("Name",Name.getText().toString().trim());
                   intent.putExtra("Email",Email.getText().toString().trim());
                   intent.putExtra("Website",Website.getText().toString().trim());
                   ncontext.startActivity(intent);

                }
            });

        }
    }
}
