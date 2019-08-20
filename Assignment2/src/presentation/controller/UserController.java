package presentation.controller;

import com.mysql.cj.util.StringUtils;
import model.Book;
import model.Sale;
import presentation.view.UserView;
import utils.impl.ContexHolderImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserController implements ActionListener {
    private UserView view;
    public UserController(UserView view){
        this.view=view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        view.getTable1().setVisible(false);
        view.getTable2().setVisible(false);
        view.getBookService().findAll().forEach(book->book.registerObserver(ContexHolderImpl.getCurrentUser()));
            Object source=e.getSource();
            if(source==view.getB1()){

                List<Book> books=view.getBookService().findAll().stream()
                        .filter(book-> (StringUtils.isNullOrEmpty(view.getT1().getText()) || book.getTitle().equals(view.getT1().getText())))
                        .filter(book->(StringUtils.isNullOrEmpty(view.getT2().getText()) || book.getAuthor().equals(view.getT2().getText())))
                        .filter(book->(StringUtils.isNullOrEmpty(view.getT3().getText()) || book.getGenre().equals(view.getT3().getText()))).collect(Collectors.toList());
                Object[][] data = view.getDataConverter().bookToTableData(books);
                String[] columns = view.getDataConverter().bookToTableColumnNames();
                refreshTable(data, columns,view.getTable1());
                view.getTable1().setVisible(true);
                view.getT1().setText(null);
                view.getT3().setText(null);
                view.getT2().setText(null);
                view.getT5().setText(view.getSaleService().calculate().toString());

            }
            else if(source==view.getB2()){
                long id=(long)view.getTable1().getValueAt(view.getTable1().getSelectedRow(),0);

                Optional<Book> book=view.getBookService().findAll().stream().filter(book1->book1.getId()==id).findFirst();

                Book b=book.get();
                b.registerObserver(ContexHolderImpl.getCurrentUser());
                Integer quantity=new Integer(view.getT4().getText());
                if(quantity<0){
                    JOptionPane.showMessageDialog(view,"The quantity must pe positive");

                }else if(quantity>b.getQuantity()||b.getQuantity()==0){
                    JOptionPane.showMessageDialog(view,"The quantity is too big or we are out of stocks");

                }
                else{
                    b.setQuantity(b.getQuantity()-quantity);
                    view.getBookService().save(b);
                    Sale s=new Sale();
                    s.setBook(b);
                    s.setSellingDate(new Date(System.currentTimeMillis()));
                    s.setPrice(quantity*b.getPrice());
                    s.setQuantity(quantity);
                    view.getSaleService().save(s);
                    s.getBook().change(s.getBook());
                    view.getT4().setText(null);
                }
                view.getT5().setText(view.getSaleService().calculate().toString());

            }
            else if(source==view.getB3()){
                List<Sale> sales=view.getSaleService().findAll();
                Object[][] data = view.getDataConverter().saleToTableData(sales);
                String[] columns = view.getDataConverter().saleToTableColumnNames();
                List<Book> books=view.getBookService().findAll();
                Object[][] data2 = view.getDataConverter().bookToTableData(books);
                String[] columns2 = view.getDataConverter().bookToTableColumnNames();
                refreshTable(data, columns,view.getTable2());
                view.getTable2().setVisible(true);
                view.getT4().setText(null);
                refreshTable(data2, columns2,view.getTable1());
                view.getTable1().setVisible(true);
                view.getT5().setText(view.getSaleService().calculate().toString());
            }
    }
    private void refreshTable(Object[][] data, String[] columnNames, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();

    }
}
