package com.Assig3.Assig3.BusinessLogic.DataTransferObjects;

public class ArticleDTO {

    private int id;
    private String title;
    private String articleAbstract;
    private String body;

    private String writerUsername;
    private String writerName;
    private String writerSurname;

    public ArticleDTO(int id, String title, String articleAbstract, String body, String writerUsername, String writerName, String writerSurname) {
        this.id = id;
        this.title = title;
        this.articleAbstract = articleAbstract;
        this.body = body;
        this.writerUsername = writerUsername;
        this.writerName = writerName;
        this.writerSurname = writerSurname;
    }

    public ArticleDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriterUsername() {
        return writerUsername;
    }

    public void setWriterUsername(String writerUsername) {
        this.writerUsername = writerUsername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterSurname() {
        return writerSurname;
    }

    public void setWriterSurname(String writerSurname) {
        this.writerSurname = writerSurname;
    }
}
