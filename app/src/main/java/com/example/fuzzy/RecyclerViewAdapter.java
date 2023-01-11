package com.example.fuzzy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<UniModel> uniModels;
    public RecyclerViewAdapter(Context context, ArrayList<UniModel> uniModels,
                               RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.uniModels = uniModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    public void FilteredList(ArrayList<UniModel> fl){
        this.uniModels = fl;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // increase the layout and give the appearance of lines
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MViewHolder holder, int position) {
        // assigning string values as they appear on the screen
        holder.name.setText(uniModels.get(position).getName());
        holder.pr.setText(uniModels.get(position).getPr());
        holder.imageView.setImageResource(uniModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // a number of values (to know how much data to update)
        return uniModels.size();
    }


    public static class MViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, pr;
        public MViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView2);
            pr = itemView.findViewById(R.id.textView3);
            name.setSelected(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }}

                }
            });
        }
    }
    }

