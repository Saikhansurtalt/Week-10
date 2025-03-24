package com.example.moviedatabaseapp;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movies = JSONUtility.loadMoviesFromJSON(this, "movies.json");
        if (movies.isEmpty()) {
            Toast.makeText(this, "Error loading movies", Toast.LENGTH_LONG).show();
        } else {
            adapter = new MovieAdapter(movies);
            recyclerView.setAdapter(adapter);
        }
    }
}
