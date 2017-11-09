package com.spduniversity.spdulib;

import com.spduniversity.spdulib.entity.Book;
import com.spduniversity.spdulib.entity.OnlineCourse;
import com.spduniversity.spdulib.entity.UserItem;

//  java com.spduniversity.spdulib.App -p Items
//  java com.spduniversity.spdulib.App -p Items -fgenre <genre>
//  java com.spduniversity.spdulib.App -p Items --sortByItem
//  java com.spduniversity.spdulib.App -p Users -f <user_login>

public class App {
    private static DataStore dataStore = new DataStore();

    public static void main(String[] args) {

        if (args.length > 1 && args[0].equals("-p") && args[1].equals("Items")) {
            if (args.length == 2) {
                printLibrary();
            } else if (args.length == 3 && args[2].equals("--sortByItem")) {
                printLibraryByItem();
            } else if (args.length >= 4 && args[2].equals("-fgenre")) {
                String[] genreArray = new String[args.length - 3];
                for (int i = 3; i < args.length; i++) {
                    genreArray[i-3] = args[i];
                }
                printByGenre(String.join(" ", genreArray));
            }
        } else if (args.length == 4 && args[0].equals("-p") && args[1].equals("Users") && args[2].equals("-f")) {
            printByUser(args[3]);
        } else {
            System.out.println("Not correct message. Try to check.");
        }

    }

    private static void printLibrary() {
        for (int i = 0; i < dataStore.getItems().length; i++) {
            for (int j = 0; j < dataStore.getUsers().length && dataStore.getUsers()[j] != null; j++) {
                System.out.println(dataStore.getItems()[i][j].toString());
            }
        }
    }

    private static void printLibraryByItem() {
        for (int i = 0; i < dataStore.getItems().length; i++) {
            if (i == 0) {
                System.out.println("Books");
            } else {
                System.out.println("Online Courses");
            }
            for (int j = 0; j < 5; j++) {
                System.out.println(dataStore.getItems()[i][j].toString());
            }
        }
    }

    private static void printByGenre(String genre) {
        int numberOfFoundItems = 0;
        for (int i = 0; i < dataStore.getItems().length; i++) {
            for (int j = 0; j < 5; j++) {
                if (dataStore.getItems()[i][j] instanceof Book) {
                    Book book = (Book) dataStore.getItems()[i][j];
                    if (book.getGenre().equals(genre)) {
                        System.out.println("Book: \n" + book.toString());
                        numberOfFoundItems ++;
                    }
                } else if (dataStore.getItems()[i][j] instanceof OnlineCourse) {
                    OnlineCourse onlineCourse = (OnlineCourse) dataStore.getItems()[i][j];
                    if (onlineCourse.getGenre().equals(genre)) {
                        System.out.println("Online Course: \n" + onlineCourse.toString());
                        numberOfFoundItems ++;
                    }
                } else {
                    System.out.println("Not defined type of item.");
                }
            }
        }

        if (numberOfFoundItems == 0) {
            System.out.println("No items with this genre.");
        }

    }

    private static void printByUser(String login) {
        boolean isUserHasItem = false;
        int i = 0;

        if (!userExists(login)) {
            System.out.println("User doesn't exist.");
            return;
        }

        while (dataStore.getUserItems()[i] != null) {
            UserItem userItem = dataStore.getUserItems()[i];
            if (userItem.getUser().getLogin().equals(login)) {
                System.out.println(userItem.getItem().toString());
                isUserHasItem = true;
            }
            i++;
        }
        if (!isUserHasItem) {
            System.out.println("This user doesn't have any items.");
        }
    }

    private static boolean userExists(String login) {
        for (int j = 0; j < dataStore.getUsers().length && dataStore.getUsers()[j] != null; j++) {
            if (dataStore.getUsers()[j].getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

}