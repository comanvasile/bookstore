package presentation.view;

import factory.ReportType;
import presentation.controller.AdminController;
import service.BookService;
import service.UserService;
import utils.DataConverter;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private static final long serialVersionUID=1L;
    private JPanel panel=new JPanel( new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();
    private AdminController controller=new AdminController(this);
    private JLabel l1=new JLabel(" Name");
    private JLabel l2=new JLabel("Username");
    private JLabel l3=new JLabel("Password");
    private JLabel l4=new JLabel("Admin");
    private JLabel l5=new JLabel(" Title");
    private JLabel l6=new JLabel("Author");
    private JLabel l7=new JLabel("Genre");
    private JLabel l8=new JLabel("Price");
    private JLabel l9=new JLabel("Quantity");
    private JLabel l10=new JLabel("For book");
    private JLabel l11=new JLabel("Reports");
    private JComboBox<ReportType> cb=new JComboBox<>();
    private JButton b5=new JButton("Generate");
    private JTextField t1=new JTextField(5);
    private JTextField t2=new JTextField(5);
    private JPasswordField t3=new JPasswordField(5);
    private JTextField t4=new JTextField(5);
    private JTextField t5=new JTextField(5);
    private JTextField t6=new JTextField(5);
    private JTextField t7=new JTextField(5);
    private JTextField t8=new JTextField(5);
    private JCheckBox c1=new JCheckBox();
    private JCheckBox c2=new JCheckBox();
    private JButton b1=new JButton("View All");
    private JButton b2=new JButton("Add ");
    private JButton b3=new JButton("Update");
    private JButton b4=new JButton("Delete");
    private UserService userService;
    private BookService bookService;
    private JTable table1=new JTable();
    private JTable table2=new JTable();
    private DataConverter dataConverter;
    public AdminView(String name, UserService userService, BookService bookService, DataConverter dataConverter){
        super(name);
        this.userService=userService;
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
        panel.add(l10,c);
        c.gridx=1;
        c.gridy=4;
        panel.add(c2,c);
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
        panel.add(c1,c);
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
        c.gridx=2;
        c.gridy=3;
        b4.addActionListener(controller);
        panel.add(b4,c);
        c.gridx=3;
        c.gridy=0;
        panel.add(l5,c);
        c.gridx=3;
        c.gridy=1;
        panel.add(l6,c);
        c.gridx=3;
        c.gridy=2;
        panel.add(l7,c);
        c.gridx=3;
        c.gridy=3;
        panel.add(l8,c);
        c.gridx=3;
        c.gridy=4;
        panel.add(l9,c);
        c.gridx=4;
        c.gridy=0;
        panel.add(t4,c);
        c.gridx=4;
        c.gridy=1;
        panel.add(t5,c);
        c.gridx=4;
        c.gridy=2;
        panel.add(t6,c);
        c.gridx=4;
        c.gridy=3;
        panel.add(t7,c);
        c.gridx=4;
        c.gridy=4;
        panel.add(t8,c);
        c.gridx=0;
        c.gridy=5;
        panel.add(l11,c);
        c.gridx=1;
        c.gridy=5;
        cb.addItem(ReportType.CSV);
        cb.addItem(ReportType.TXT);
        panel.add(cb,c);
        c.gridx=2;
        c.gridy=5;
        b5.addActionListener(controller);
        panel.add(b5,c);
        c.gridx=5;
        c.gridy=6;
        JScrollPane p1=new JScrollPane(table1);
        panel.add(p1,c);
        c.gridx=6;
        c.gridy=6;
        JScrollPane p2=new JScrollPane(table2);
        panel.add(p2,c);
        this.userService=userService;
        this.bookService=bookService;
        this.dataConverter=dataConverter;
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public JTextField getT1() {
        return t1;
    }

    public JTextField getT2() {
        return t2;
    }

    public JPasswordField getT3() {
        return t3;
    }

    public JCheckBox getC1() {
        return c1;
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

    public JButton getB4() {
        return b4;
    }

    public JComboBox<ReportType> getCb() {
        return cb;
    }

    public JButton getB5() {
        return b5;
    }

    public JTextField getT4() {
        return t4;
    }

    public JTextField getT5() {
        return t5;
    }

    public JTextField getT6() {
        return t6;
    }

    public JTextField getT7() {
        return t7;
    }

    public JTextField getT8() {
        return t8;
    }

    public JCheckBox getC2() {
        return c2;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public JTable getTable1() {
        return table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public DataConverter getDataConverter() {
        return dataConverter;
    }
}
