/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library2;
import java.util.*;
/**
 *
 * @author dell
 */

/*
This class is both a Facade and a Signleton. 
Since we only need one instance of this class in the entire system, we have to make it a singleton class. 
To achieve this, we made the contructor private to prevent any other file from creating an onstance of it. 
Also, we created a static final instance of this class inside it so that it's the only accessible instance (getInstance). It's static so that
it can be called using the class name. 

It's a facade because we want to access our books and data only through it without exposing the inner files to security issues. 
*/
public class Library {
    
    private ArrayList<Book> books = new ArrayList<>();
    private static final Library Library_instance = new Library();
    /*
    Private Constructor.
    */
    private Library(){}
    /*
    Output: Libaray.
    Function: This function return the singleton object of this class.
    */
    public static Library getInstance(){
        return Library_instance;
    }
    /*
    Function: This function creates a bppk pbject using the entered fields and add it to the library
    then it save the current state of the libarary into a momento. 
    */
    public void add_book(String title, String ISBN, int num_pages, String publishing_date, ArrayList<String> authors, ArrayList<String> genre, String format){
        Book book = new Book(title, ISBN, num_pages, publishing_date, authors, genre, format);
        books.add(book);
        CareTaker.getInstance().addMomento(Library_instance.save());
    }
    /*
    Function: This function searches for the book that has the input ISBN
    Once it finds it, it updates the book content using the input fields 
    and returns true. If not, it returns false.
    */
    public boolean update_book(String title, String ISBN, int num_pages, String publishing_date, ArrayList<String> authors, ArrayList<String> genre, String format){
        Book book = null;
        for(Book b : books){
            if(b.getISBN().equals(ISBN)){
                book = b;
            }
        }
        if(book!=null){
            book.setTitle(title);
            book.setNum_pages(num_pages);
            book.setPublishing_date(publishing_date);
            book.setAuthors(authors);
            book.setGenre(genre);
            book.setFormat(format);
            return true;
        }
        return false;
    }
    /*
    Input: String(ISBN)
    Function: This function takes ISBN as input and search for the book that has this ISBN
    Once it finds it, it removes the book from the library and returns true. If not, it returns false.
    */
    public void remove_book(String ISBN){
        Book book = null;
        for(Book b : books){
            if(b.getISBN().equals(ISBN)){
                book = b;
            }
        }
        if(book != null){
            books.remove(book);
        }
    }
    /*
    Input: String(ISBN)
    Output: Boolean
    Function: This function takes ISBN as input and search for the book that has this ISBN
    Once it finds it, it prints the book details and returns true. If not, it returns false.
    */
    public boolean find(String ISBN){
        Book book = null;
        for(Book b : books){
            if(b.getISBN().equals(ISBN)){
                book = b;
            }
        }
        if(book!=null){
            book.view();
            return true;
        }
        return false;
    }
    /*
    Function: This function prints all the library's books content. 
    */
    public void view(){
        for(Book b: books){
            b.view();
        }
    }
    /*
    Output: Momento.
    Function: It creakes a Momento of the Library state and returns it. 
    */
    public Momento save() {
        System.out.println("Originator: Saving to Memento.");
        return new Momento(new ArrayList<Book>(books));
    }
    /*
    Input: Momento.
    Function: It restores the state of the momento into the library. 
    */
    public void restore(Momento m) {
        books = m.getState();
        System.out.println("Originator: State restored from Memento: ");
    }
    
}
