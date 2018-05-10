package com.Assig3.Assig3.BusinessLogic.ObservableDP;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;

import java.util.List;

public class ArticleObservable extends Observable{

    private static ArticleObservable ourInstance = new ArticleObservable();

    public static ArticleObservable getInstance() {
        return ourInstance;
    }

    private ArticleObservable() {
        super.Observable();
    }

    public void triggerNotification(List<ArticleDTO> newArticles){
        updateAll(newArticles);
    }

}
