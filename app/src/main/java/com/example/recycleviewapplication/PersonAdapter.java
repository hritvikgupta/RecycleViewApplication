package com.example.recycleviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// We have initially written RecyclerView.Adapter after that we have first created
//Our own ViewHolder  Then created <PersonAdapter.ViewHolder>
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{

    private ArrayList<Person> people;

    public PersonAdapter(Context context,ArrayList<Person> list)
    {
        people = list;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvSurname;
        ImageView ivPref;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Define click listener for the ViewHolder's View

            //Here Item view represents the list_item.xml view.
            // Our custoused ViewHolder class holds the view for the layout that we have created
            //Therefore we use find view by id here

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname =itemView.findViewById(R.id.tvSurname);

            ivPref = itemView.findViewById(R.id.ivPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });


        }
    }


    //After creating Our Own View Holder we are getting error on RecyclerView.ViewHolder So we have written
    //PersonAdapter.ViewHolder inplace of RecyclerView.ViewHolder in next 3 functions
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Now as we have created our own list_items layout file or the Custom Recycler View layout file
        // so what we do is inflate that custom layout in here using context parent that is passed as a ViewGroup

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent, false);
        //Here v Is the ItemView that we have created in the ViewHolder
        //Now we call that ViewHolder that we have created up with v As a Item View
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        //Now after Creating ViewHolder and calling the ViewHolder from OnCreateView.
        //in this step this method runs for every items in the list that we have created
        // which is it bind the view for every items in the list of person adapter that we have created


        //The next step is to know which item is clicked so as to pass it to the itemView.OncLicklistener
        // for that we set the tag to each itemView
        //Therefore calling the itemView from view holder holder
        //And Thereby setting the tag as the item we are currently at
        holder.itemView.setTag(people.get(position));
        //Below we are setting the text of the name py getting the person class which it was clicked on
        // And Then afterwords we call the getName() that we have created in the person.Java class
        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurname());

        if(people.get(position).getPreference().equals("bus"))
        {
            holder.ivPref.setImageResource(R.drawable.bus);
        }
        else
        {
            holder.ivPref.setImageResource(R.drawable.plane);
        }

    }

    @Override
    public int getItemCount() {
        //Here we written the size of the list that we have created so as to let the onBindViewHolder how many
        //times it has to run
        return people.size();
    }
}
