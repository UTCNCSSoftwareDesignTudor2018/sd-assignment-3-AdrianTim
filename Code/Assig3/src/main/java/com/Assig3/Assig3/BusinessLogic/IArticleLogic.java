package com.Assig3.Assig3.BusinessLogic;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;

import java.util.List;

public interface IArticleLogic {

    void addArticle(ArticleDTO articleDTO);
    void deleteArticle(int id);
    void updateArticle(ArticleDTO articleDTO);
    ArticleDTO getArticle(int id);
    List<ArticleDTO> getArticles();
    void updateReaders();

}
