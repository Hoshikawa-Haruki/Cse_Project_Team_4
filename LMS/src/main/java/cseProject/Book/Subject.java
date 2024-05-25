package cseProject.Book;

import cseProject.Rental.Observer;
import java.util.ArrayList;

public abstract class Subject {

    protected ArrayList<Observer> observers;

    public void registerObserver(Observer o) {
    }

    public void removeObserver(Observer o) {
    }

    public void notifyObserver() {
    }

    public void notifyReturnObserver() {
    }
}
