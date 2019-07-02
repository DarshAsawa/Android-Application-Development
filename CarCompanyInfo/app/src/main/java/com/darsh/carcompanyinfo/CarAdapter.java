package com.darsh.carcompanyinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    ArrayList<Car> cars;
    ItemClicked activity;

    public interface ItemClicked
    {
        public void onItemClicked(int index);

    }

    public CarAdapter(Context context,ArrayList<Car> list){
        cars = list;
        activity=(ItemClicked)context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivMake;
        TextView tvModel,tvOwner;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivMake=itemView.findViewById(R.id.ivMake);
            tvModel=itemView.findViewById(R.id.tvModel);
            tvOwner=itemView.findViewById(R.id.tvOwner);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(cars.indexOf((Car) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(cars.get(i));
        viewHolder.tvOwner.setText(cars.get(i).getOwner());
        viewHolder.tvModel.setText(cars.get(i).getModel());

        if (cars.get(i).getMake().equals("BMW"))
        {
            viewHolder.ivMake.setImageResource(R.drawable.bmw);
        }
        else if (cars.get(i).getMake().equals("volkswagen"))
        {
            viewHolder.ivMake.setImageResource(R.drawable.volkswagen);

        }
        else if (cars.get(i).getMake().equals("toyato"))
        {
            viewHolder.ivMake.setImageResource(R.drawable.toyato);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
