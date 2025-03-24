package com.example.moviedatabaseapp;

public class Movie {
    private String title;
    private int year;
    private String genre;
    private String poster;

    public Movie(String title, int year, String genre, String poster) {
        this.title = (title == null || title.isEmpty()) ? "Unknown Title" : title;
        this.year = (year > 1800 && year < 2100) ? year : 0;
        this.genre = (genre == null || genre.isEmpty()) ? "Unknown Genre" : genre;
        this.poster = (poster == null || poster.isEmpty()) ? "default_poster" : poster;
    }

    public String getTitle() { return title; }
    public int getYear() { return year; }
    public String getGenre() { return genre; }
    public String getPoster() { return poster; }
}
