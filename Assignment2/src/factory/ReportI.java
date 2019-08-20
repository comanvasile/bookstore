package factory;

import model.Book;

import java.util.List;

public interface ReportI {
    public void generate(List<Book> books);
}
