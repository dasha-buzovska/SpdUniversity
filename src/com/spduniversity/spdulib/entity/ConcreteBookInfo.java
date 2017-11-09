package com.spduniversity.spdulib.entity;

public class ConcreteBookInfo extends AbstractDisplayInfo {

    private Book book;

    ConcreteBookInfo(Book book) {
        this.book = book;
    }

    public String displayInfo() {
        String str = "";
        str += "Id: " + book.getId() + "\n";
        str += "Title: " + book.getTitle() + "\n";
        str += "Link: " + book.getUrl() + "\n";
        str += "Publication Year: " + book.getPublicationYear() + "\n";
        str += "Publisher: " + book.getPublisher() + "\n";
        str += "Authors: " + String.join(", ", book.getAuthors()) + "\n";
        str += "Genre: " + book.getGenre() + "\n";
        str += "Language: " + book.getLanguage() + "\n";
        str += "Amazon rating: " + book.getAmazonRating() + "\n";
        return str;
    }
}
