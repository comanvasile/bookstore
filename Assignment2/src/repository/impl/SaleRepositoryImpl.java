package repository.impl;

import model.Book;
import model.Sale;
import repository.SaleRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SaleRepositoryImpl extends Observable implements SaleRepository {
    private JDBConnectionWrapper jdbConnectionWrapper;
    private ArrayList<Observer> observers=new ArrayList<Observer>();
    public SaleRepositoryImpl(JDBConnectionWrapper jdbConnectionWrapper){
        this.jdbConnectionWrapper=jdbConnectionWrapper;
    }
    @Override
    public List<Sale> findAll() {
        Connection connection = jdbConnectionWrapper.getConnection();
        List<Sale> sales = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from bookstore.book as b inner join bookstore.sale as s on b.id=s.id_book");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Sale sale=new Sale();
                Book book=new Book();

                book.setId(resultSet.getLong(1));
                book.setTitle(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setGenre(resultSet.getString(4));
                book.setPrice(resultSet.getDouble(5));
                book.setQuantity(resultSet.getInt(6));

                sale.setId(resultSet.getLong(7));
                sale.setBook(book);
                sale.setSellingDate(resultSet.getDate(9));
                sale.setQuantity(resultSet.getInt(10));
                sale.setPrice(resultSet.getDouble(11));

                sales.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    @Override
    public Sale create(Sale sale) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sale (id_book,sellingDate,quantity,price) VALUES( ?, ?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1,sale.getBook().getId());
            preparedStatement.setDate(2,sale.getSellingDate());
            preparedStatement.setInt(3,sale.getQuantity());
            preparedStatement.setDouble(4, sale.getPrice());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                sale.setId(resultSet.getLong(1));
                return sale;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public Sale update(Sale sale) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE sale SET id_book=?, sellingDate=?,quantity=?,price=?  WHERE id=?",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, sale.getBook().getId());
            preparedStatement.setDate(2, sale.getSellingDate());
            preparedStatement.setInt(3,sale.getQuantity() );
            preparedStatement.setDouble(4, sale.getPrice());

            preparedStatement.setLong(5, sale.getId());

            int changedRows = preparedStatement.executeUpdate();

            if (changedRows > 0) {
                return sale;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = jdbConnectionWrapper.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM sale WHERE id= ?");
            preparedStatement.setLong(1, id);

            int updatedRows = preparedStatement.executeUpdate();

            return updatedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;    }

}
