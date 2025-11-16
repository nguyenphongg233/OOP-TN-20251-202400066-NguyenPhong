// Trong com.hust.kstn.test.BookTest.java

package test;

import models.Book;
import models.BookAuthor;
import java.util.ArrayList;
import java.util.List;

public class BookTest {

    public static void main(String[] args) {

        BookAuthor author1 = new BookAuthor("Roberto Carlo", 1980, "Bio 1");
        BookAuthor author2 = new BookAuthor("Author Two", 1990, "Bio 2");

        List<BookAuthor> authorsList = new ArrayList<>();
        authorsList.add(author1);
        authorsList.add(author2);


        Book book1 = new Book("OOP Basics", "Programming", 25.5, 50000, authorsList);

        // 4. In thông tin sách (kiểm tra toString())
        System.out.println(book1);
    }
}