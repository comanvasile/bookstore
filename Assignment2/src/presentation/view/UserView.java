package presentation.view;

import presentation.controller.UserController;
import service.BookService;
import service.SaleService;
import utils.DataConverter;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class UserView extends JFrame  {
    private static final long serialVersionUID=1L;
    private JPanel panel=new JPanel( new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();
    private UserController controller=new UserController(this);
    private DataConverter dataConverter;
    private BookService bookService;
    private SaleService saleService;
    private JLabel l1=new JLabel("Title");
    private JLabel l2=new JLabel("Author");
    private JLabel l3=new JLabel("Genre");
    private JLabel l4=new JLabel("Quantity");
    private JLabel l5=new JLabel("Total");

    private JTextField t1=new JTextField(5);
    private JTextField t2=new JTextField(5);
    private JTextField t3=new JTextField(5);
    private JTextField t4=new JTextField(5);
    private JTextField t5=new JTextField(5);

    private JButton b1=new JButton("Search");
    private JButton b2=new JButton("Sell");
    private JButton b3=new JButton("View");
    private JTable table1=new JTable();
    private JTable table2=new JTable();
    public UserView(String name, DataConverter dataConverter, BookService bookService, SaleService saleService){
        super(name);
        this.dataConverter=dataConverter;
        this.saleService=saleService;
        this.bookService=bookService;
        c.gridx=0;
        c.gridy=0;
        panel.add(l1,c);
        c.gridx=0;
        c.gridy=1;
        panel.add(l2,c);
        c.gridx=0;
        c.gridy=2;
        panel.add(l3,c);
        c.gridx=0;
        c.gridy=3;
        panel.add(l4,c);
        c.gridx=0;
        c.gridy=4;
        panel.add(l5,c);
        c.gridx=1;
        c.gridy=4;
        panel.add(t5,c);
        c.gridx=1;
        c.gridy=0;
        panel.add(t1,c);
        c.gridx=1;
        c.gridy=1;
        panel.add(t2,c);
        c.gridx=1;
        c.gridy=2;
        panel.add(t3,c);
        c.gridx=1;
        c.gridy=3;
        panel.add(t4,c);
        c.gridx=2;
        c.gridy=0;
        b1.addActionListener(controller);
        panel.add(b1,c);
        c.gridx=2;
        c.gridy=1;
        b2.addActionListener(controller);
        panel.add(b2,c);
        c.gridx=2;
        c.gridy=2;
        b3.addActionListener(controller);
        panel.add(b3,c);
        c.gridx=3;
        c.gridy=5;
        JScrollPane p1=new JScrollPane(table1);
        panel.add(p1,c);
        c.gridx=4;
        c.gridy=5;
        JScrollPane p2=new JScrollPane(table2);
        panel.add(p2,c);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);


    }

    public DataConverter getDataConverter() {
        return dataConverter;
    }

    public BookService getBookService() {
        return bookService;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public JTextField getT2() {
        return t2;
    }

    public JTextField getT4() {
        return t4;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JTable getTable1() {
        return table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public JTextField getT1() {
        return t1;
    }

    public JTextField getT3() {
        return t3;
    }

    public JTextField getT5() {
        return t5;
    }
}
