package com.spduniversity.spdulib.entity;

public class OnlineCourse extends Item {
    private String sourse;  // Coursera, udemy, edx, Prometheus, etc.
    private String level;   // Basic, Intermediate, Advanced, Hard
    private String[] authors; // Course authors
    private int durationInWeeks; // 6 weeks
    private String language;    // English, Russian, Ukrainian, etc.
    private String genre;       // Programming, Business, Computer Science
    private double rating;      // 4.9
}
