package com.spduniversity.spdulib.entity;

public class ConcreteOnlineCourseInfo extends AbstractDisplayInfo {
    private OnlineCourse onlineCourse;

    ConcreteOnlineCourseInfo(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    String displayInfo() {
        String str = "";
        str += "Id: " + onlineCourse.getId() + "\n";
        str += "Title: " + onlineCourse.getTitle() + "\n";
        str += "Link: " + onlineCourse.getUrl() + "\n";
        str += "Source: " + onlineCourse.getSource() + "\n";
        str += "Level: " + onlineCourse.getLevel() + "\n";
        str += "Authors: " + String.join(", ", onlineCourse.getAuthors()) + "\n";
        str += "Duration In Weeks: " + onlineCourse.getDurationInWeeks() + "\n";
        str += "Genre: " + onlineCourse.getGenre() + "\n";
        str += "Language: " + onlineCourse.getLanguage() + "\n";
        str += "Rating: " + onlineCourse.getRating() + "\n";
        return str;
    }
}
