package com.example.collegeinfo2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myviewholder> implements Filterable {

ArrayList<Model> data;
ArrayList<Model> backup;
Context context;
    public myadapter(ArrayList<Model> data, Context context) {

        this.data = data;
        this.context=context;
        backup=new ArrayList<>(data);

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.college_model,parent,false);


        return  new myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final  Model temp=data.get(position);
holder.txtname1.setText(data.get(position).getName());
holder.img.setImageResource(data.get(position).getImage());
holder.des.setText(data.get(position).getDescription());
holder.web.loadUrl(data.get(position).getUrl());




holder.main_card.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context, CollegeDetails.class);
        intent.putExtra("image",temp.getImage());
        intent.putExtra("Title",temp.getName());
        intent.putExtra("desc",temp.getDescription());
        intent.putExtra("website",temp.getUrl());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
});



    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter=new Filter() {
        @Override //background thread
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Model> filteredata=new ArrayList<>();
            if (keyword.toString().isEmpty())
                filteredata.addAll(backup);
            else
                for (Model obj:backup)
                {
                    if(obj.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                        filteredata.add(obj);
                }
                FilterResults results=new FilterResults();
                results.values=filteredata;
                return results;
        }

        @Override //UI thread
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();
        }
    };
}
