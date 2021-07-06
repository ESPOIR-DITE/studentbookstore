package company.ac.za.studentbookstore.factory.domain.book;

import company.ac.za.studentbookstore.domain.book.Book;
import company.ac.za.studentbookstore.util.MyIdGenerator;

public class BookFactory
{
    public static Book getBook(String title,String language,String edition,double price,String author)
    {
        return new Book.Builder()
                .buildedition(edition)
                .Id(MyIdGenerator.getId(BookFactory.class)) // MyIdGenerator is a class that generates Id.
                .buildTitle(title)
                .buildLanguage(language)
                .Price(price)
                .buildAuthor(author)
                .build();
    }

}
