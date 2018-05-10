package com.Assig3.Assig3.BusinessLogic.ObservableDP;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Observable {

    private Set<Observer> observers;

    public void Observable(){
        observers = new HashSet<Observer>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void updateAll(List<ArticleDTO> newArticles){

        observers.forEach(o -> o.update(newArticles));

    }

}
