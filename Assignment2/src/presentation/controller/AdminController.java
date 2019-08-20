package presentation.controller;

import Main.Bookstore;
import factory.ReportType;
import model.Book;
import model.User;
import presentation.view.AdminView;
import utils.impl.ContexHolderImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class AdminController implements ActionListener {
    private AdminView view;

    public AdminController(AdminView view){
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.getTable1().setVisible(false);
        view.getTable2().setVisible(false);
        Object source=e.getSource();
        if(source==view.getB1()){
            List<User> users = view.getUserService().findAll();

            Object[][] data = view.getDataConverter().userToTableData(users);
            String[] columns = view.getDataConverter().userToTableColumnNames();

            refreshTable(data, columns,view.getTable1());
            view.getTable1().setVisible(true);

            List<Book> books=view.getBookService().findAll();

            Object[][] data2 = view.getDataConverter().bookToTableData(books);
            String[] columns2 = view.getDataConverter().bookToTableColumnNames();

            refreshTable(data2, columns2,view.getTable2());
            view.getTable2().setVisible(true);

        }
        else if(source==view.getB2()){
                if(!view.getC2().isSelected()) {
                    if (view.getT1().getText().isEmpty() || view.getT2().getText().isEmpty() || view.getT3().getText().isEmpty()) {

                        JOptionPane.showMessageDialog(view, "Please complete all the fields");
                    }
                   else if(view.getUserService().findByUsername(view.getT2().getText())!=null &&view.getT2().getText().equals(view.getUserService().findByUsername(view.getT2().getText()).getUsername()))
                    {
                        JOptionPane.showMessageDialog(view,"This username is already used");
                    }
                    else {
                        User user = new User();
                        user.setName(view.getT1().getText());
                        user.setUsername(view.getT2().getText());
                        user.setPassword(view.getT3().getText());
                        user.setAdmin(view.getC1().isSelected());
                        view.getUserService().save(user);
                        view.getT1().setText(null);
                        view.getT2().setText(null);
                        view.getT3().setText(null);

                    }
                }
                else{
                    if(view.getT4().getText().isEmpty()||view.getT5().getText().isEmpty()||view.getT6().getText().isEmpty()||view.getT7().getText().isEmpty()||view.getT8().getText().isEmpty()){
                        JOptionPane.showMessageDialog(view, "Please complete all the fields");

                    }
                    else if(new Double(view.getT7().getText())<0||new Integer(view.getT8().getText())<0){
                        JOptionPane.showMessageDialog(view, "The price and the quantity must be positive");

                    }
                    else{
                        Book book=new Book();
                        book.setTitle(view.getT4().getText());
                        book.setAuthor(view.getT5().getText());
                        book.setGenre(view.getT6().getText());
                        book.setPrice(new Double(view.getT7().getText()));
                        book.setQuantity(new Integer(view.getT8().getText()));
                        Book b=view.getBookService().save(book);
                        b.registerObserver(ContexHolderImpl.getCurrentUser());
                        view.getT4().setText(null);
                        view.getT5().setText(null);
                        view.getT6().setText(null);
                        view.getT7().setText(null);
                        view.getT8().setText(null);

                    }
                }
        }
        else if(source==view.getB3()){
                if(!view.getC2().isSelected()) {
                    long id = (long) view.getTable1().getValueAt(view.getTable1().getSelectedRow(), 0);
                    User u = view.getUserService().findById(id);
                    if (!view.getT1().getText().isEmpty())
                        u.setName(view.getT1().getText());
                    if (!view.getT2().getText().isEmpty())
                        u.setUsername(view.getT2().getText());
                    if (!view.getT3().getText().isEmpty())
                        u.setPassword(view.getT3().getText());
                    u.setAdmin(view.getC2().isSelected());
                    if(view.getUserService().findByUsername(view.getT2().getText())!=null &&view.getT2().getText().equals(view.getUserService().findByUsername(view.getT2().getText()).getUsername()) && u.getId()!=view.getUserService().findByUsername(view.getT2().getText()).getId()){
                        JOptionPane.showMessageDialog(view,"This username is already used");

                    }
                    else{
                    view.getUserService().save(u);
                    view.getT1().setText(null);
                    view.getT2().setText(null);
                    view.getT3().setText(null);
                    }
                }
                else{
                    long id = (long) view.getTable2().getValueAt(view.getTable2().getSelectedRow(), 0);
                    Book book=view.getBookService().findById(id);
                    book.removeObserver(ContexHolderImpl.getCurrentUser());
                    if(!view.getT4().getText().isEmpty())
                        book.setTitle(view.getT4().getText());
                    if(!view.getT5().getText().isEmpty())
                        book.setAuthor(view.getT5().getText());
                    if(!view.getT6().getText().isEmpty())
                        book.setGenre(view.getT6().getText());
                    if(!view.getT7().getText().isEmpty())
                        book.setPrice(new Double(view.getT7().getText()));
                    if(!view.getT8().getText().isEmpty())
                        book.setQuantity(new Integer(view.getT8().getText()));
                    Book b=view.getBookService().save(book);
                    b.registerObserver(ContexHolderImpl.getCurrentUser());
                    view.getT4().setText(null);
                    view.getT5().setText(null);
                    view.getT6().setText(null);
                    view.getT7().setText(null);
                    view.getT8().setText(null);

                }
        }
        else if(source==view.getB4()){
            if(!view.getC2().isSelected()){
                long id = (long) view.getTable1().getValueAt(view.getTable1().getSelectedRow(), 0);
                view.getUserService().delete(id);

            }
            else{
                long id = (long) view.getTable2().getValueAt(view.getTable2().getSelectedRow(), 0);
                view.getBookService().findById(id).removeObserver(ContexHolderImpl.getCurrentUser());
                view.getBookService().delete(id);
            }
        }
        else if(source==view.getB5()){
            List<Book> books=view.getBookService().findAll().stream().filter(book->book.getQuantity()==0).collect(Collectors.toList());
            Bookstore.generate((ReportType) view.getCb().getSelectedItem(),books);
        }

    }
    private void refreshTable(Object[][] data, String[] columnNames, JTable table) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setDataVector(data, columnNames);
        tableModel.setColumnIdentifiers(columnNames);
        tableModel.fireTableDataChanged();

    }
}
