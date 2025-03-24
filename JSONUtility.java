package com.example.moviedatabaseapp;

import android.util.Log;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

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

            Log.d("JSONUtility", "Loaded JSON: " + json);

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.optJSONObject(i);

                if (obj != null && obj.has("title")) {  // Ignore empty objects
                    movies.add(new Movie(
                            obj.optString("title", "Unknown Title"),
                            obj.opt("year"),  // Can be String, Integer, or Double
                            obj.optString("genre", "Unknown Genre"),
                            obj.optString("poster", "default_poster")
                    ));
                }
            }

            Log.d("JSONUtility", "Successfully parsed movies: " + movies.size() + " movies");

        } catch (Exception e) {
            Log.e("JSONUtility", "Error loading JSON: " + e.getMessage());
        }
        return movies;
    }
}

