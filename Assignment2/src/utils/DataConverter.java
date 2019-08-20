package utils;

import model.Book;
import model.Sale;
import model.User;

import java.util.List;

public interface DataConverter {
    Object[][] userToTableData(List<User> users);

    String[] userToTableColumnNames();

    Object[][] bookToTableData(List<Book> books);

    String[] bookToTableColumnNames();
    Object[][] saleToTableData(List<Sale> sales);

    String[] saleToTableColumnNames();
}
