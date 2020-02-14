/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library2;

/**
 *
 * @author dell
 */
import java.util.*;
import java.io.*;

public class CareTaker{
    private ArrayList<Momento> momentos = new ArrayList<>();
    private static CareTaker instance = new CareTaker();
    /*
    Private constructor for the singleton class.
    It reads the information stored in the Library.ser file from before. 
    */
    private CareTaker(){
        // Load the file here.
        try {
           FileInputStream fileIn = new FileInputStream("Library.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           momentos = (ArrayList<Momento>) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i) {
           //i.printStackTrace();
           return;
        }catch(ClassNotFoundException c) {
           System.out.println("Momento class not found");
           c.printStackTrace();
           return;
        }
        if(momentos.size()>0){
            Library.getInstance().restore(getMomento());
        }
    }
    /*
    It stores the momentos into the Library.ser file for later reference. 
    */
    public void saveToDisk(){
        
        // Save file here.
        try {
           FileOutputStream fileOut = new FileOutputStream("Library.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(momentos);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in Library.ser");
        }catch(IOException i) {
           i.printStackTrace();
        }
    }
    public static CareTaker getInstance(){
        return instance;
    }
   /*
    It adds a momento to the momentos list.
    */
    public void addMomento(Momento m) {
        momentos.add(m);
    }

    public Momento getMomento(){
        return momentos.get(momentos.size()-1);
    }
}
