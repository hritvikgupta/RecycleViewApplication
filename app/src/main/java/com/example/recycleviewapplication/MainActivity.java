package com.example.recycleviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Person> people;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The list is the id that we have named in the main activity layout for the recycler view
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);


        // Here we need to manage the recycle view ans that will be done using the layout manager of this mainactivity
        //class as we created a recycle view layout in the main activity layout
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Now to pass the data in the layout we need to add some of the data first
        // Therefore here we create called the person class that we have created and pass some of the data
        //Here people is the list of Person class items or list of person class that we pass tp the PersonAdapter forDisplay
        people.add(new Person("john", "Rambo", "Bus"));
        people.add(new Person("Mike", "lowery", "Plane"));
        people.add(new Person("john", "Cena", "Bus"));
        people.add(new Person("Dwayne", "johnson", "plane"));
        people.add(new Person("Hritvik", "Gupta", "Plane"));

        PersonAdapterNew myAdapter = new PersonAdapterNew(people);
        // Here we set the recycler view that we have created as the myadpater that we have created
        recyclerView.setAdapter(myAdapter);
    }
}