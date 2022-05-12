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
        Person p1 = new Person("john", "Rambo", "Bus");
        Person p2 = new Person("Mike", "lowery", "Plane");
        Person p3= new Person("john", "Cena", "Bus");
        Person p4 = new Person("Dwayne", "johnson", "plane");
        Person p5= new Person("Hritvik", "Gupta", "Plane");

        Person [] people = {p1, p2, p3,p4,p5};

        /*
        Here IF we are passing the data as array list of people then it is shutting the
        application on start, but if we simple passed data like this then it is working fine

        PersonAdapterNew is a Java class created Using code with Harry video, Therefore only for
        testing purpose
         */
        //PersonAdapterNew myAdapter = new PersonAdapterNew(people);
        PersonAdapter myAdapter = new PersonAdapter(this, people);
        // Here we set the recycler view that we have created as the myadpater that we have created
        recyclerView.setAdapter(myAdapter);



    }
}