package com.example.moviedatabaseapp;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String poster;

    public Movie(String title, Object year, String genre, String poster) {
        this.title = (title == null || title.isEmpty()) ? "Unknown Title" : title;
        this.year = parseYear(year);
        this.genre = (genre == null || genre.isEmpty()) ? "Unknown Genre" : genre;
        this.poster = (poster == null || poster.isEmpty()) ? "default_poster" : poster;
    }

    private int parseYear(Object year) {
        if (year instanceof Double) {
            return ((Double) year).intValue();  // Handle decimal years like 1972.5
        } else if (year instanceof String) {
            try {
                return Integer.parseInt((String) year);  // Handle "2014" (as string)
            } catch (NumberFormatException e) {
                return 0;  // Default to 0 if invalid format (e.g., "nineteen-ninety-four")
            }
        } else if (year instanceof Integer) {
            return ((int) year >= 1800 && (int) year <= 2100) ? (int) year : 0;  // Valid years only
        }
        return 0;  // Default to 0 for missing or invalid values
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public String getPoster() { return poster; }
}
