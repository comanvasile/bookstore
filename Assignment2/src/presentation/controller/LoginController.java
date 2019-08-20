package presentation.controller;

import Main.Bookstore;
import model.User;
import presentation.view.LoginView;
import utils.impl.ContexHolderImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private LoginView loginView;


    public LoginController(LoginView loginView){
        this.loginView=loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source==loginView.getB1()){
            User user=loginView.getUserService().login(loginView.getT1().getText(),loginView.getT2().getText());
            if(user!=null && user.isAdmin()){
                Bookstore.openAdminView();
                ContexHolderImpl.setCurrentUser(user);
            }
            else if(user!=null && !user.isAdmin()){
                Bookstore.openUserView();
                ContexHolderImpl.setCurrentUser(user);

            }
            else{
                JOptionPane.showMessageDialog(loginView,"Credentialele nu sunt corecte");
            }
        }

    }
}
