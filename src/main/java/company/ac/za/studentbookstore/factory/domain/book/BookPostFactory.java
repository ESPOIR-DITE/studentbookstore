package company.ac.za.studentbookstore.factory.domain.book;

import company.ac.za.studentbookstore.domain.book.BookPost;
import company.ac.za.studentbookstore.util.MyIdGenerator;

import java.util.Date;

public class BookPostFactory
{
    public static BookPost getPostedBook(String email,String book_id,Date date, String locationId, String status, String description)
    {
        return new BookPost.Builder()
                           .BookId(book_id)
                           .Date(date)
                           .Description(description)
                           .Id(MyIdGenerator.getId(BookPostFactory.class))
                           .Email(email)
                           .LocationId(locationId)
                           .Status(status)
                           .build();
    }
}
