package com.example.collegeinfo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;
    myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv=(RecyclerView) findViewById(R.id.recyclerview);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter=new myadapter(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapter);







    }



    public  static ArrayList<Model> dataqueue() {

        ArrayList<Model> holder=new ArrayList<>();
       Model ob1=new Model();
       ob1.setImage(R.drawable.img_2);
       ob1.setName("New Horizon Institute of Technology and Management");
      ob1.setUrl("https://nhitm.ac.in/");
      ob1.setDescription("Foundation:2014\n" +
              "Course: ComputerScience and Design:60 seats\n"+
              "COMPUTER ENGINEERING:120 seats\n"+
      "Artifical Intelligence and Data Science:60\n"+
              "Civil Engineering:60\n"+
              "Mechanical Engineering :30\n"+
              "Mechantroics:30\n"+
              "Location: New Horizon Education Society's Complex, Off Ghodbunder Road, Anand Nagar, Kavesar, Thane West, Thane, Maharashtra 400615");
       holder.add(ob1);




        Model ob2=new Model();
        ob2.setImage(R.drawable.img_3);
        ob2.setName("A.P.Shah Institute of Technology");
        ob2.setUrl("https://www.apsit.edu.in/");
        ob2.setDescription("Foundation:1993\n"+
                "Course:Aritifical Intelligence and Machine Learning:120 seats\n"+
                        "Computer Engineering:180 seats\n"+
                "Information Technology:180 seats\n"+
                "Civil Engineering:60 seats\n"+
                "Mechanical Engineering:60 seats\n"+
                "Location:Survey No, 12, Ghodbunder Rd, opp. Hypercity Mall, Bhawani Nagar, Kasarvadavali, Thane West, Thane, Maharashtra 400615");
        holder.add(ob2);

        Model ob3=new Model();
        ob3.setImage(R.drawable.img);
        ob3.setName("K.C. College of Engineering");
        ob3.setUrl("https://kccemsr.edu.in/");
        ob3.setDescription("Foundation:1978\n" +
                "Course:Computer Engineering:90 seats\n" +
                "Electronics and Telecommunication:60 seats\n" +
                "Information Technology:90 seats\n "+
                "Location : Mithbunder Rd, near Sadguru Gardens, Kopri, Thane East, Thane, Maharashtra 400603");
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setImage(R.drawable.img_1);
        ob4.setName("L.R.Tiwari College of Engineering ");
        ob4.setUrl("https://slrtce.in/");
        ob4.setDescription("Foundation:2010" +
                "Courses:Electronics and Telecommunication Ennigeering:60 seats \n" +
                "Computer Engineering:90 seats\n" +
                "Information Technology:180 seats seats\n" +
                "Mechanical Engineering:30 seats\n" +
                " Electronics and Computer Science Engineering:60 seats\n" +
                "Civil Engineering:60 seats\n" +
                "Location:Kanakia Rd, Kanakia Park, Mira Road East, Mira Bhayandar, Maharashtra 401107");
        holder.add(ob4);



        Model ob6=new Model();
        ob6.setImage(R.drawable.img_5);
        ob6.setName("B.R.Harne College of Engineering");
        ob6.setUrl("https://brharnetc.edu.in/br/");
        ob6.setDescription("Foundation:2011\n" +
                "Computer Engineering:60 seats \n" +
                "Electrical Engineering:60 seats \n" +
                "Electronics & Telecommunication Engineering:120 seats \n" +
                "Mechanical Engineering:120 seats \n"
              );
        holder.add(ob6);




        Model ob7=new Model();
        ob7.setImage(R.drawable.img_6);
        ob7.setName("Shivajirao Jondhale College of Engineering");
        ob7.setUrl("https://slrtce.in/");
        ob7.setDescription("Foundation:" +
                "Civil Engineering:60 seats\n" +
                "Computer Engineering:60 seats\n" +
                "Mechanical Engineering:120 seats\n" +
                "Electronics and Telecommuncation:90 seats\n");
        holder.add(ob7);

        return holder;









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        MenuItem item=menu.findItem(R.id.search_menu);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);
                return false;


            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}