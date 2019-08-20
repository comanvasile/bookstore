package factory;

import model.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class ReportCSV implements ReportI {
    @Override
    public void generate(List<Book> books) {
        try (PrintWriter writer = new PrintWriter(new File("Report.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(';');
            sb.append("Title");
            sb.append(';');
            sb.append("Author");
            sb.append(';');
            sb.append("Genre");
            sb.append('\n');
            for(Book b:books){
                sb.append(b.getId());
                sb.append(';');
                sb.append(b.getTitle());
                sb.append(';');
                sb.append(b.getAuthor());
                sb.append(';');
                sb.append(b.getGenre());
                sb.append('\n');

            }



            writer.write(sb.toString());



        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
