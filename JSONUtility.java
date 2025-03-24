package com.example.moviedatabaseapp;

import android.util.Log;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.Context;

public class JSONUtility {
    public static List<Movie> loadMoviesFromJSON(Context context, String fileName) {
        List<Movie> movies = new ArrayList<>();
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            // Debug log: Print JSON content
            Log.d("JSONUtility", "Loaded JSON: " + json);

            // Try parsing JSON
            movies = new Gson().fromJson(json, new TypeToken<List<Movie>>() {}.getType());

            Log.d("JSONUtility", "Successfully parsed movies: " + movies.size() + " movies");

        } catch (Exception e) {
            Log.e("JSONUtility", "Error loading JSON: " + e.getMessage());
        }
        return movies;
    }
}

