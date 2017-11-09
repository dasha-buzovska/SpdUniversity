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

    public DataStore() {
        users[0] = new User(1, "alex", "alexpassw", "Alex","Boiko",
                Gender.MALE, UserRole.MODERATOR);
        users[1] = new User(2, "tim", "timpassw", "Tim","Lee",
                Gender.MALE, UserRole.USER);
        users[2] = new User(3, "jacky", "jackypassw", "Jacky","Tompson",
                Gender.MALE, UserRole.EDITOR);;
        users[3] = new User(4, "ann", "annpassw", "Ann","Smith",
                Gender.FEMALE, UserRole.USER);;
        users[4] = new User(5, "alen", "alenpassw", "Alena","Tirel",
                Gender.FEMALE, UserRole.EDITOR);;

        items[0][0] = new Book(2000,"Design Patterns: Elements of Reusable Object-Oriented Software",
                "https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612/",
                1994, "Addison-Wesley Professional",
                new String[]{"Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"},
                BookGenre.DESIGN_PATTERN,
                "English",
                4.5);
        items[0][1] = new Book(2001, "Refactoring: Improving the Design of Existing Code",
                "https://www.amazon.com/Refactoring-Improving-Design-Existing-Code/dp/0201485672/",
                1999, "Addison-Wesley Professional",
                new String[]{"Martin Fowler", "Kent Beck"}, BookGenre.OBJECT_ORIENTED_DESIGN,
                "English", 4.5);
        items[0][2] = new Book(2002, "The Power of Habit: Why We Do What We Do in Life and Business",
                "https://www.amazon.com/Power-Habit-What-Life-Business/dp/081298160X", 2012,
                "Random House Trade Paperback Edition", new String[]{"Charles Duhigg"},
                BookGenre.OTHER, "English", 4.36);
        items[0][3] = new Book(2003, "A Game of Thrones", "https://en.wikipedia.org/wiki/A_Game_of_Thrones",
                1996, "Bantam Spectra",  new String[]{"George R. R. Martin"},
                BookGenre.OTHER, "English", 4.7);
        items[0][4] = new Book(2004, "Clean Code: A Handbook of Agile Software Craftsmanship",
                "https://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882",
                2008, "Prentice Hall", new String[]{"Robert C. Martin"},
                BookGenre.PROGRAMMING, "English", 4.5);

        items[1][0] = new OnlineCourse(1000,"Algorithms, Part I", "https://www.coursera.org/learn/algorithms-part1",
                "Coursera", "Intermediate", new String[]{"Kevin Wayne,  Robert Sedgewick"},
                6, "English", OnlineCourseGenre.COMPUTER_SCIENCE,4.9);
        items[1][1] = new OnlineCourse(1001,"Functional programming principles on Scala",
                "https://www.coursera.org/learn/progfun1", "Coursera", "Intermadiate",
                new String[]{"Martin Odersky"},6,"English",OnlineCourseGenre.SOFTWARE_DEVELOPMENT,4.8);
        items[1][2] = new OnlineCourse(1002, "Learning How to Learn",
                "https://www.coursera.org/learn/learning-how-to-learn", "Coursera", "basic",
                new String[]{"Dr. Barbara Oakley", " Dr. Terrence Sejnowski"}, 4, "English",
                OnlineCourseGenre.BUSINESS, 4.8);
        items[1][3] = new OnlineCourse(1003, "Introduction to jQuery",
                "https://www.edx.org/course/introduction-jquery-microsoft-dev208x-3", "Edx", "Intermediate",
                new String[]{"Christopher Harrison"}, 3, "English", OnlineCourseGenre.COMPUTER_SCIENCE,4);
        items[1][4] = new OnlineCourse(1004, "Artificial Intelligence",
                "https://www.edx.org/course/artificial-intelligence-ai-columbiax-csmm-101x-4",
                "Edx", "Advanced",
                new String[]{"Professor Ansaf Salleb-Aouissi"}, 12, "English", OnlineCourseGenre.COMPUTER_SCIENCE,4.2);

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
