package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";

    ArrayList<String> MountainsArray;

    RecyclerView recyclerView;

    private Mountain[] Mountains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hämta lokal JSON-data
        //new JsonFile(this, this).execute(JSON_FILE);

        //Starta nedladdning av JSON-data
        new JsonTask(this).execute(JSON_URL);

        //recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Mountains = gson.fromJson(json,Mountain[].class);

        MountainsArray = new ArrayList<>();

        for (Mountain mountain : Mountains) { // This line = "for (int i = 0; i < Mountains.length; i++){"


            String name = mountain.getName();
            MountainsArray.add(name);
            MountainsArray.add("\n");

            //Log.d("==>","Namn: " + name);
            //Log.d("MainActivity==>","Mountain: "+Mountains[i].getName());

        }
        recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(MountainsArray));
    }
}
