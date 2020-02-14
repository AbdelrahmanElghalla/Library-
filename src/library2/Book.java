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
public class Book implements java.io.Serializable{
    private String title;
    private String ISBN;
    private int num_pages;
    private String publishing_date;
    private ArrayList<String> genre = new ArrayList<>();
    private ArrayList<String> authors = new ArrayList<>();
    private Format format;
    
    enum Format{
        PRINTEDBOOKS,
        E_BOOKS,
        CDs,
        DVDs
    }
    /*
    Constructor. 
    */
    public Book(String title, String ISBN, int num_pages, String publishing_date, ArrayList<String> authors, ArrayList<String> genre, String format) {
        this.title = title;
        this.ISBN = ISBN;
        this.num_pages = num_pages;
        this.publishing_date = publishing_date;
        this.genre = genre;
        this.authors = authors;
        this.format = Format.valueOf(format);
    }
    /*
    Function: This function prints the details of the book.
    */
    public void view(){
        System.out.println("Title: " +  title);
        System.out.println("ISBN: " +  ISBN);
        System.out.println("Number of pages: " + num_pages);
        System.out.println("Publishing Data: " + publishing_date);
        for(String g: genre){
            System.out.println("Genre: " + genre);
        }
        for(String a: authors){
            System.out.println("Author: " + a);
        }
        System.out.println("Format: " + format);
        
    }

    
    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public String getPublishing_date() {
        return publishing_date;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }
    public Format getFormat(){
        return format;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNum_pages(int num_pages) {
        this.num_pages = num_pages;
    }

    public void setPublishing_date(String publishing_date) {
        this.publishing_date = publishing_date;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    
    public void setFormat(String format){
        this.format = Format.valueOf(format);
    }
}
