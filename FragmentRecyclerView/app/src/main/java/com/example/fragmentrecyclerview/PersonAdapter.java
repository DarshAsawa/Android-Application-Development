package com.example.fragmentrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    private ArrayList<Person> people;
    ItemClicked Activity;
    public interface ItemClicked{
        void OnItemClicked(int index);
    }

    public PersonAdapter(Context context,ArrayList<Person> list){
        people=list;
        Activity=(ItemClicked) context;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;


        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity.OnItemClicked(people.indexOf((Person) v.getTag()));

                }
            });
        }
    }



    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //LINK TO EXTERNAL LAYOUT CALLED ROW LAYOUT...
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(people.get(i));
        viewHolder.tvName.setText(people.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
