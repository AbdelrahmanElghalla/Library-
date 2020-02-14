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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Library lib = Library.getInstance();
        CareTaker caretaker = CareTaker.getInstance();
        Scanner sc = new Scanner(System.in); 
        String command;
        System.out.println("Welcome to the Library System!");
        System.out.println("You can enter of the following commands or Exit when done.");
        System.out.println("Add: to add a new book");
        System.out.println("Remove: to remove a book");
        System.out.println("Update: to update a book by ISBN");
        System.out.println("Find: to find a book by ISBN");
        System.out.println("View: to view all the books inside the library");
        do{
            System.out.print("Enter command: ");
            command = sc.nextLine();
            switch(command){
                case "Add":
                    System.out.println("Enter title");
                    String title = sc.nextLine();
                    System.out.println("Enter ISBN");
                    String ISBN = sc.nextLine();
                    System.out.println("Enter number of pages");
                    int pages_num = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter publishing date");
                    String publishing_date = sc.nextLine();
                    
                    ArrayList<String> genres = new ArrayList<>();
                    System.out.println("Enter genre or Done when finished");
                    String genre;
                    do{
                        genre = sc.nextLine();
                        genres.add(genre);
                    }while(!genre.equals("Done"));
                    ArrayList<String> authors = new ArrayList<>();
                    System.out.println("Enter author or Done when finished");
                    String author;
                    do{
                        author = sc.nextLine();
                        authors.add(author);
                    }while(!author.equals("Done"));
                    System.out.println("Enter format");
                      System.out.println("Choose one of these formats ( PRINTEDBOOKS,E_BOOKS,CDs and DVDs ) ");
                    String format = sc.nextLine();
                    lib.add_book(title, ISBN, pages_num, publishing_date, authors, genres, format);                 
                    System.out.println("Book added successfully");
                    break;
               
                case "Remove":
                    System.out.println("Enter book ISBN.");
                    String ISBN_rem = sc.nextLine();
                    lib.remove_book(ISBN_rem);
                    System.out.println("Book removed succesfully");
                    break;
                case "Find":
                    System.out.println("Enter book ISBN.");
                    String ISBN_r =  sc.nextLine();
                    boolean found = lib.find(ISBN_r);
                    if(!found){
                        System.out.println("Book not found.");
                    }
                    break;
                    
                case "View":
                    System.out.println("Printing available books");
                    lib.view();
                    break;
                    
                case "Update":
                    System.out.println("Enter ISBN of the book you want to update.");
                    String ISBN_1 = sc.nextLine();
                    
                    System.out.println("Enter title");
                    String title_1 = sc.nextLine();
                    
                    System.out.println("Enter number of pages");
                    int pages_num_1 = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter publishing date");
                    String publishing_date_1 = sc.nextLine();
                    
                    ArrayList<String> genres_1 = new ArrayList<>();
                    System.out.println("Enter genre or Done when finished");
                    String genre_1;
                    do{
                        genre_1 = sc.nextLine();
                        genres_1.add(genre_1);
                    }while(!genre_1.equals("Done"));
                    ArrayList<String> authors_1 = new ArrayList<>();
                    System.out.println("Enter author or Done when finished");
                    String author_1;
                    do{
                        author_1 = sc.nextLine();
                        authors_1.add(author_1);
                    }while(!author_1.equals("Done"));
                    System.out.println("Enter format");
                    String format_1 = sc.nextLine();
                    boolean found_1 = lib.update_book(title_1, ISBN_1, pages_num_1, publishing_date_1, authors_1, genres_1, format_1);
                    if(found_1){
                        System.out.println("Book updated successfully");
                    }else{
                        System.out.println("ISBN entered can't be found.");
                    }
                    break;
                case "Exit":
                    caretaker.saveToDisk();
                    break;
                default:
                    System.out.println("Wrong command. Please enter a correct one");
            }
            
        }while(!command.equals("Exit"));
    }
    
}
