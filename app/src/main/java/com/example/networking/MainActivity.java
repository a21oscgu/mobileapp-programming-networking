package com.example.networking;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    RecyclerView recyclerView;
    private Mountain[] Mountains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recyclerview);
        recyclerView.setAdapter(new MyAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Hämta lokal JSON-data
        //new JsonFile(this, this).execute(JSON_FILE);
        //Starta nedladdning av JSON-data
        new JsonTask(this).execute(JSON_URL);

        //recyclerView.getAdapter().notifyDataSetChanged();
    }

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);

        Gson gson = new Gson();
        Mountains = gson.fromJson(json,Mountain[].class);
        for (int i = 0; i < Mountains.length; i++){
            Log.d("MainActivity==>","Mountain: "+Mountains[i].getName());
        }
    }
}
