package com.Assig3.Assig3.BusinessLogic.DataTransferObjects;

import java.util.ArrayList;
import java.util.List;

public class WriterDTO {

    private String name;
    private String surname;

    private List<ArticleDTO> articles = new ArrayList<>();

    public WriterDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public WriterDTO(){

    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}
