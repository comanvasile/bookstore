package model;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Book extends Observable {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private Double price;
    private Integer quantity;
    private ArrayList<Observer> observers=new ArrayList<>();
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void notifyObservers(Observable observable,Object obj)
    {
        for(Observer o: observers)
        {
            o.update(observable,obj);
        }
    }
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }
    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }
    public  void change(Book b){
        this.setChanged();
        this.notifyObservers(this,b.getTitle());
    }

}
