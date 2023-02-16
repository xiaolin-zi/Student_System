package com.lxg.test;

public class Caretaker {
    private Memento memento;
    public Memento getMemento(){
        return memento;
    }
    public void setMemento(Memento memento){
        this.memento = memento;
    }

    private Caretaker() {
    }
    private static Caretaker caretaker = null;
    public static Caretaker getInstance(){
        if(caretaker == null){
            caretaker = new Caretaker();
        }
        return caretaker;
    }
}
