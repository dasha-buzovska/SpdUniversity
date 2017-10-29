package com.spduniversity.spdulib;

import com.spduniversity.spdulib.constants.BookGenre;
import com.spduniversity.spdulib.constants.Gender;
import com.spduniversity.spdulib.constants.OnlineCourseGenre;
import com.spduniversity.spdulib.constants.UserRole;
import com.spduniversity.spdulib.entity.*;

public class DataStore {
    private static final int TOTAL_USER_COUNT = 10;
    private static final int ITEM_TYPES_COUNT = 2;

    private User[] users = new User[TOTAL_USER_COUNT];
    private Item[][] items = new Item[ITEM_TYPES_COUNT][TOTAL_USER_COUNT];  // Our library
    private UserItem[] userItems = new UserItem[ITEM_TYPES_COUNT*TOTAL_USER_COUNT]; // User has some items

    /* TODO: If you see that code can be splitted into different parts according to its logical
    functionality it's better to move them into different methods. Good names of such methods allows to read code
    more quickly. I see 3 or 4 different methods inside this one for initialization of each data list.
    * */

    public DataStore() {
        users[0] = new User.Builder()
                .id(1)
                .login("alex")
                .password("alexpassw")
                .firstName("Alex")
                .lastName("Boiko")
                .gender(Gender.MALE)
                .role(UserRole.MODERATOR)
                .build();
        users[1] = new User.Builder()
                .id(2)
                .login("tim")
                .password("timpassw")
                .firstName("Tim")
                .lastName("Lee")
                .gender(Gender.MALE)
                .role(UserRole.USER)
                .build();
        users[2] = new User.Builder()
                .id(3)
                .login("jacky")
                .password("jackypassw")
                .firstName("Jacky")
                .lastName("Tompson")
                .gender(Gender.MALE)
                .role(UserRole.EDITOR)
                .build();
        users[3] = new User.Builder()
                .id(4)
                .login("Ann")
                .password("annpassw")
                .firstName("Ann")
                .lastName("Smith")
                .gender(Gender.FEMALE)
                .role(UserRole.USER)
                .build();
        users[4] = new User.Builder()
                .id(5)
                .login("alen")
                .password("alenpassw")
                .firstName("Alena")
                .lastName("Tirel")
                .gender(Gender.FEMALE)
                .role(UserRole.EDITOR)
                .build();

        items[0][0] = new Book.Builder()
                .id(2000)
                .title("Design Patterns: Elements of Reusable Object-Oriented Software")
                .url("https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612/")
                .publicationYear(1994)
                .publisher("Addison-Wesley Professional")
                .authors(new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"})
                .genre(BookGenre.DESIGN_PATTERN)
                .language("English")
                .amazonRating(4.5)
                .build();
        items[0][1] = new Book.Builder()
                .id(2001)
                .title("Refactoring: Improving the Design of Existing Code")
                .url("https://www.amazon.com/Refactoring-Improving-Design-Existing-Code/dp/0201485672/")
                .publicationYear(1999)
                .publisher("Addison-Wesley Professional")
                .authors(new String[]{"Martin Fowler", "Kent Beck"})
                .genre(BookGenre.OBJECT_ORIENTED_DESIGN)
                .language("English")
                .amazonRating(4.5)
                .build();
        items[0][2] = new Book.Builder()
                .id(2002)
                .title("The Power of Habit: Why We Do What We Do in Life and Business")
                .url("https://www.amazon.com/Power-Habit-What-Life-Business/dp/081298160X")
                .publicationYear(2012)
                .publisher("Random House Trade Paperback Edition")
                .authors(new String[]{"Charles Duhigg"})
                .genre(BookGenre.OTHER)
                .language("English")
                .amazonRating(4.63)
                .build();
        items[0][3] = new Book.Builder()
                .id(2003)
                .title("A Game of Thrones")
                .url("https://en.wikipedia.org/wiki/A_Game_of_Thrones")
                .publicationYear(1996)
                .publisher("Bantam Spectra")
                .authors(new String[]{"George R. R. Martin"})
                .genre(BookGenre.OTHER)
                .language("English")
                .amazonRating(4.7)
                .build();
        items[0][4] = new Book.Builder()
                .id(2004)
                .title("Clean Code: A Handbook of Agile Software Craftsmanship")
                .url("https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882")
                .publicationYear(2008)
                .publisher("Prentice Hall")
                .authors(new String[]{"Robert C. Martin"})
                .genre(BookGenre.PROGRAMMING)
                .language("English")
                .amazonRating(4.5)
                .build();

        items[1][0] = new OnlineCourse.Builder()
                .id(1000)
                .title("Algorithms, Part I")
                .url("https://www.coursera.org/learn/algorithms-part1")
                .source("Coursera")
                .level("Intermediate")
                .authors(new String[]{"Kevin Wayne,  Robert Sedgewick"})
                .durationInWeeks(6)
                .language("English")
                .genre(OnlineCourseGenre.COMPUTER_SCIENCE)
                .rating(4.9)
                .build();
        items[1][1] = new OnlineCourse.Builder()
                .id(1001)
                .title("Functional programming principles on Scala")
                .url("https://www.coursera.org/learn/progfun1")
                .source("Coursera")
                .level("Intermediate")
                .authors(new String[]{"Martin Odersky"})
                .durationInWeeks(6)
                .language("English")
                .genre(OnlineCourseGenre.SOFTWARE_DEVELOPMENT)
                .rating(4.8)
                .build();
        items[1][2] = new OnlineCourse.Builder()
                .id(1002)
                .title("Learning How to Learn")
                .url("https://www.coursera.org/learn/learning-how-to-learn")
                .source("Coursera")
                .level("Basic")
                .authors(new String[]{"Dr. Barbara Oakley", " Dr. Terrence Sejnowski"})
                .durationInWeeks(6)
                .language("English")
                .genre(OnlineCourseGenre.BUSINESS)
                .rating(4.8)
                .build();
        items[1][3] = new OnlineCourse.Builder()
                .id(1003)
                .title("Introduction to jQuery")
                .url("https://www.edx.org/course/introduction-jquery-microsoft-dev208x-3")
                .source("Edx")
                .level("Intermediate")
                .authors(new String[]{"Christopher Harrison"})
                .durationInWeeks(3)
                .language("English")
                .genre(OnlineCourseGenre.COMPUTER_SCIENCE)
                .rating(4)
                .build();
        items[1][4] = new OnlineCourse.Builder()
                .id(1004)
                .title("Artificial Intelligence")
                .url("https://www.edx.org/course/artificial-intelligence-ai-columbiax-csmm-101x-4")
                .source("Edx")
                .level("Advanced")
                .authors(new String[]{"Professor Ansaf Salleb-Aouissi"})
                .durationInWeeks(12)
                .language("English")
                .genre(OnlineCourseGenre.COMPUTER_SCIENCE)
                .rating(4.2)
                .build();

        userItems[0] = new UserItem(users[0], items[0][3]);
        userItems[1] = new UserItem(users[3], items[1][4]);
        userItems[2] = new UserItem(users[2], items[0][2]);
    }

    public User[] getUsers() {
        return users;
    }

    public Item[][] getItems() {
        return items;
    }

    public UserItem[] getUserItems() {
        return userItems;
    }
}
