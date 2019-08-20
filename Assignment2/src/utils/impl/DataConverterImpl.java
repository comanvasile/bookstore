package utils.impl;

import model.Book;
import model.Sale;
import model.User;
import utils.DataConverter;

import java.util.Date;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public Object[][] userToTableData(List<User> users) {
        Object[][] data = new Object[users.size()][5];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = users.get(row).getId();
            data[row][1]=users.get(row).getName();
            data[row][2] = users.get(row).getUsername();
            data[row][3] = users.get(row).getPassword();
            data[row][4] = users.get(row).isAdmin();

        }
        return data;
    }

    @Override
    public String[] userToTableColumnNames() {
        return new String[]{"Id","Name","Username","Password","Admin"};
    }

    @Override
    public Object[][] bookToTableData(List<Book> books) {
        Object[][] data = new Object[books.size()][6];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = books.get(row).getId();
            data[row][1]=books.get(row).getTitle();
            data[row][2] = books.get(row).getAuthor();
            data[row][3] = books.get(row).getGenre();
            data[row][4] = books.get(row).getPrice();
            data[row][5]=books.get(row).getQuantity();

        }
        return data;
    }

    @Override
    public String[] bookToTableColumnNames() {
        return new String[]{"Id","Title","Author","Genre","Price","Quantity"};
    }

    @Override
    public Object[][] saleToTableData(List<Sale> sales) {
        Object[][] data = new Object[sales.size()][7];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = sales.get(row).getId();
            data[row][1]=sales.get(row).getBook().getId();
            data[row][2] = sales.get(row).getBook().getTitle();
            data[row][3] = sales.get(row).getBook().getAuthor();
            data[row][4] = sales.get(row).getSellingDate();
            data[row][5]=sales.get(row).getQuantity();
            data[row][6]=sales.get(row).getPrice();


        }
        return data;
    }

    @Override
    public String[] saleToTableColumnNames() {
        return new String[]{"Id","Id Book","Title","Author","Selling Date","Quantity","Price"};
    }
}
