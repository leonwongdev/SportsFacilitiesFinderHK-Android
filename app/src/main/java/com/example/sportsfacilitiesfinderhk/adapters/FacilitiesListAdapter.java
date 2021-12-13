package com.example.sportsfacilitiesfinderhk.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails.FacilitiesDetailsActivity;

import java.util.List;

public class FacilitiesListAdapter extends RecyclerView.Adapter<FacilitiesListAdapter.ViewHolder> {
    Context context;
    List<SportFacility> sportFacilities;

    public FacilitiesListAdapter(Context context, List<SportFacility> sportFacilities) {
        this.context = context;
        this.sportFacilities = sportFacilities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.facilities_list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FacilitiesDetailsActivity.class);
                intent.putExtra("index", position);
                context.startActivity(intent);
            }
        });
        holder.titleTextView.setText(sportFacilities.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return sportFacilities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout parentLayout;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.facilities_list_item_layout);
            titleTextView = itemView.findViewById(R.id.facilities_list_item_name);
        }
    }
}
