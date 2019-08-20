package Main;

import factory.ReportFactory;
import factory.ReportI;
import factory.ReportType;
import model.Book;
import model.User;
import presentation.view.AdminView;
import presentation.view.LoginView;
import presentation.view.UserView;
import repository.BookRepository;
import repository.SaleRepository;
import repository.UserRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.JDBConnectionWrapper;
import repository.impl.SaleRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.BookService;
import service.SaleService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.SaleServiceImpl;
import service.impl.UserServiceImpl;
import utils.DataConverter;
import utils.impl.DataConverterImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  Bookstore<obs> {
    private static final String SCHEMA_NAME = "bookstore";
    private static UserService userService;
    private static SaleService saleService;
    private static BookService bookService;
    private static UserRepository userRepository;
    private static SaleRepository saleRepository;
    private static BookRepository bookRepository;
    private static JDBConnectionWrapper jdbConnectionWrapper;
    private static DataConverter dataConverter;
    private  static ReportFactory reportFactory;
    public static void main(String[] args) {
         jdbConnectionWrapper = new JDBConnectionWrapper(SCHEMA_NAME);

         userRepository=new UserRepositoryImpl(jdbConnectionWrapper);
         saleRepository=new SaleRepositoryImpl(jdbConnectionWrapper);
         bookRepository=new BookRepositoryImpl(jdbConnectionWrapper);

         userService=new UserServiceImpl(userRepository);
         bookService=new BookServiceImpl(bookRepository);
         saleService=new SaleServiceImpl(saleRepository);

         dataConverter=new DataConverterImpl();
        reportFactory=new ReportFactory();
         openLoginView();

    }
    public static void openLoginView(){
        LoginView loginView=new LoginView("Login",userService);
    }
    public static void openAdminView(){
        AdminView adminView=new AdminView("Admin",userService,bookService,dataConverter);
    }
    public static void openUserView(){
        UserView userView=new UserView("User",dataConverter,bookService,saleService);
    }
    public static void generate(ReportType type, List<Book> books){
        ReportI reportI=reportFactory.getReport(type);
        reportI.generate(books);
    }
}