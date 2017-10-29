package com.spduniversity.spdulib;

import com.spduniversity.spdulib.entity.Book;
import com.spduniversity.spdulib.entity.OnlineCourse;
import com.spduniversity.spdulib.entity.UserItem;

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
                if (i == 0) {
                    Book book = (Book) dataStore.getItems()[i][j];
                    if (book.getGenre().equals(genre)) {
                        System.out.println("Book: \n" + book.toString());
                        numberOfFoundItems ++;
                    }
                } else {
                    OnlineCourse onlineCourse = (OnlineCourse) dataStore.getItems()[i][j];

                    /* TODO: What if some other type will be added in the datastore items array for i>1?
                   It's better to check object type with instanceof first before doing such type of casting.*/

                    if (onlineCourse.getGenre().equals(genre)) {
                        System.out.println("Online Course: \n" + onlineCourse.toString());
                        numberOfFoundItems ++;
                    }
                }
            }
        }

        if (numberOfFoundItems == 0) {
            System.out.println("No items with this genre.");
        }

    }

    private static void printByUser(String login) {
        int numberOfFoundUsers = 0;
        int numberOfUsers = 0;
        int i = 0;
        while (dataStore.getUserItems()[i] != null) {

            int j = 0;
            for (; j < dataStore.getUsers().length && dataStore.getUsers()[j] != null; j++) {
                if (!dataStore.getUsers()[j].getLogin().equals(login)) {
                    numberOfUsers++;
                }
            }

/* TODO: numberOfUsers == j looks like a little bit complicated. Why not to invert condition of this IF statement
and just to set some boolean that user exists instead of counting of how many of them are not good?
Also this part can be moved to some method that checks that user can login to get next information.
There can be more than one place in code that will need this check.
* */
            if (numberOfUsers == j) {
                System.out.println("User doesn't exist.");
                return;
            }

            UserItem userItem = dataStore.getUserItems()[i];

            if (userItem.getUser().getLogin().equals(login)) {
                System.out.println(userItem.getItem().toString());
                numberOfFoundUsers++;
            }
            i++;
        }

     if (numberOfFoundUsers == 0) {
            System.out.println("This user doesn't have any items.");
        }
    }
}