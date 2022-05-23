package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";

    ArrayList<Mountain> mountainsArray;

    RecyclerView recyclerView;

    private Mountain[] Mountains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recyclerview);
        // Kopplar Adapter och RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(mountainsArray));

        //Hämta lokal JSON-data
        //new JsonFile(this, this).execute(JSON_FILE);

        //Starta nedladdning av JSON-data
        new JsonTask(this).execute(JSON_URL);

        //recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        //GSON objekt skapas
        Gson gson = new Gson();
        // Unmarshall JSON -> a single object
        Mountains = gson.fromJson(json,Mountain[].class);

        mountainsArray = new ArrayList<>();

        Collections.addAll(mountainsArray, Mountains);
        // Old code
        /*for (Mountain mountain : Mountains) { // This line = "for (int i = 0; i < Mountains.length; i++){"

            mountainsArray.add(mountain);

            String name = mountain.getName();
            mountainsArray.add(name);
            mountainsArray.add("\n");

            //Log.d("==>","Namn: " + name);
            //Log.d("MainActivity==>","Mountain: "+Mountains[i].getName());
        }*/
    }
}
