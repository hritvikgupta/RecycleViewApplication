package com.example.recycleviewapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnClickItem {

    RecyclerView recyclerView;
    //RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;
    EditText insertText;
    String newName;


    ArrayList<Person> p = new ArrayList<Person>();

    //Now to pass the data in the layout we need to add some of the data first
    // Therefore here we create called the person class that we have created and pass some of the data
    //Here people is the list of Person class items or list of person class that we pass tp the PersonAdapter forDisplay
    Person p1 = new Person("john", "Rambo", "Bus");
    Person p2 = new Person("Mike", "lowery", "Plane");
    Person p3= new Person("john", "Cena", "Bus");
    Person p4 = new Person("Dwayne", "johnson", "plane");
    Person p5= new Person("Hritvik", "Gupta", "Plane");

    Person [] people = {p1, p2, p3,p4,p5};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        insertText = findViewById(R.id.insertText);

        //The list is the id that we have named in the main activity layout for the recycler view
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        // Here we need to manage the recycle view ans that will be done using the layout manager of this mainactivity
        //class as we created a recycle view layout in the main activity layout
        /*
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

         */
        //Here in this Layout Manger if we want to set our RecyclerView list from
        //Vertical to the horizontal, then we do this
        //Here we have passed the false to the last argument we don't this list to reverse and start from last value
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        //Now to pass the data in the layout we need to add some of the data first
        // Therefore here we create called the person class that we have created and pass some of the data
        //Here people is the list of Person class items or list of person class that we pass tp the PersonAdapter forDisplay
        Person p1 = new Person("john", "Rambo", "Bus");
        Person p2 = new Person("Mike", "lowery", "Plane");
        Person p3= new Person("john", "Cena", "Bus");
        Person p4 = new Person("Dwayne", "johnson", "plane");
        Person p5= new Person("Hritvik", "Gupta", "Plane");

        //Two ways of doing it either by static array or by Array list
        //This is method 1
        Person [] people = {p1, p2, p3,p4,p5};
        //this is method 2
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);

        //if using the static array list then convert the ArryayList to Person [] localdataset
        //in Adapter either PersonAdapterNew or PersonAdapter


        /*
        Here IF we are passing the data as array list of people then it is shutting the
        application on start, but if we simple passed data like this then it is working fine

        PersonAdapterNew is a Java class created Using code with Harry video, Therefore only for
        testing purpose
         */
        //PersonAdapterNew myAdapter = new PersonAdapterNew(p);
        PersonAdapter myAdapter = new PersonAdapter(this, p);
        // Here we set the recycler view that we have created as the myadpater that we have created
        recyclerView.setAdapter(myAdapter);

        //This is to add the data Dynamically.
        //For this we have created a Button and a EditText View
        //After which we have passed the name in the EditText
        //Here we created instance of person Class and passed the entered Name
        //Then we have notify the Adapter that changes are made and to update the p with
        //new p that we have created

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newName = insertText.getText().toString().trim();
                Person n = new Person(newName, "Gupta", "Bus");
                p.add(n);
                myAdapter.notifyDataSetChanged();

            }
        });



    }

    @Override
    public void onclicking(int index) {

        Toast.makeText(this, "Surname" + " " +  people[index].getSurname(), Toast.LENGTH_SHORT).show();

    }
}