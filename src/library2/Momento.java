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
public class Momento implements java.io.Serializable{
    private ArrayList<Book> state = new ArrayList<>();
    /*
    Constructor.
    */
    public Momento(ArrayList<Book> state){
        this.state = state;
    }
    /*
    Return the state of the momento.
    */
    public ArrayList<Book> getState() {
        return state;
    }
}

