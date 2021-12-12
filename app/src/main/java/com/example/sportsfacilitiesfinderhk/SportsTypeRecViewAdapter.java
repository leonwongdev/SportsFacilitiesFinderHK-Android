package com.example.sportsfacilitiesfinderhk;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SportsTypeRecViewAdapter extends RecyclerView.Adapter<SportsTypeRecViewAdapter.ViewHolder> {
    Context context;
    ArrayList<String> sports;

    public SportsTypeRecViewAdapter(Context context, ArrayList<String> sports) {
        this.context = context;
        this.sports = sports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sports_type_button, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: start activity
            }
        });
        holder.titleTextView.setText(sports.get(position));
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout parentLayout;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.sports_type_button_layout);
            titleTextView = itemView.findViewById(R.id.sport_title_tv);
        }
    }
}
