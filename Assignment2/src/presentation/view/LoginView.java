package presentation.view;

import presentation.controller.LoginController;
import service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private static final long serialVersionUID=1L;
    private JPanel panel=new JPanel( new GridBagLayout());
    GridBagConstraints c=new GridBagConstraints();
    private JLabel l1=new JLabel("Username");
    private JTextField t1=new JTextField(20);
    private JLabel l2=new JLabel("Password");
    private JPasswordField t2=new JPasswordField(20);
    private JButton b1=new JButton("Login");
    private LoginController controller=new LoginController(this);
    private UserService userService;



    public LoginView(String name, UserService userService){
        super(name);
        c.gridx=0;
        c.gridy=0;
        panel.add(l1,c);
        c.gridx=0;
        c.gridy=1;
        panel.add(t1,c);
        c.gridx=0;
        c.gridy=2;
        panel.add(l2,c);
        c.gridx=0;
        c.gridy=3;
        panel.add(t2,c);
        c.gridx=0;
        c.gridy=4;
        panel.add(b1,c);
        b1.addActionListener(controller);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.userService=userService;

    }

    public JButton getB1() {
        return b1;
    }
    public UserService getUserService() {
        return userService;
    }

    public JTextField getT1() {
        return t1;
    }

    public JPasswordField getT2() {
        return t2;
    }
}
