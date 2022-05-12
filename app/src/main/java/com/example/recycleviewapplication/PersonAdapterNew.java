package com.example.recycleviewapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonAdapterNew extends RecyclerView.Adapter<PersonAdapterNew.ViewHolder> {

    //private Person [] localdataset ;
    TextView tvName, tvSurname;
    ImageView ivPref;

    private ArrayList<Person> localdataset;


    public PersonAdapterNew(ArrayList<Person> dataSet) {
        localdataset = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.tvSurname);
        }

        public TextView getTextView() {
            return textView;
        }
    }


    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_items, viewGroup, false);

        tvName = view.findViewById(R.id.tvName);
        tvSurname =view.findViewById(R.id.tvSurname);

        ivPref = view.findViewById(R.id.ivPref);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        tvName.setText(localdataset.get(position).getName());
        tvSurname.setText(localdataset.get(position).getSurname());

        if(localdataset.get(position).getPreference().equals("bus"))
        {
            ivPref.setImageResource(R.drawable.bus);
        }
        else
        {
            ivPref.setImageResource(R.drawable.plane);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localdataset.size();
    }
}

