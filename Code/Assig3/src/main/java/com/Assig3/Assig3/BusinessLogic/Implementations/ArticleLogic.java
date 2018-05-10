package com.Assig3.Assig3.BusinessLogic.Implementations;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;
import com.Assig3.Assig3.BusinessLogic.IArticleLogic;
import com.Assig3.Assig3.BusinessLogic.ObservableDP.ArticleObservable;
import com.Assig3.Assig3.DataAccess.Entities.Article;
import com.Assig3.Assig3.DataAccess.Entities.Writer;
import com.Assig3.Assig3.DataAccess.Repositories.ArticleRepository;
import com.Assig3.Assig3.DataAccess.Repositories.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@Service
public class ArticleLogic implements IArticleLogic {

    private ArticleRepository articleRepository;
    private WriterRepository writerRepository;
    private DTOFactory dtoFactory;

    @Autowired
    public ArticleLogic(ArticleRepository articleRepository, WriterRepository writerRepository, DTOFactory dtoFactory){

        this.articleRepository = articleRepository;
        this.writerRepository = writerRepository;
        this.dtoFactory = dtoFactory;

    }

    @Override
    public void addArticle(ArticleDTO articleDTO) {

        Article newArticle = new Article();
        newArticle.setTitle(articleDTO.getTitle());
        newArticle.setArticleAbstract(articleDTO.getArticleAbstract());
        newArticle.setBody(articleDTO.getBody());

        Writer writer = writerRepository.findById(articleDTO.getWriterUsername()).orElse(null);

        if(writer != null){

            writer.addArticle(newArticle);
            //writerRepository.save(writer);
            articleRepository.save(newArticle);

        }


    }

    @Override
    public void deleteArticle(int id) {

        Article toBeDeleted = articleRepository.findById(id).orElse(null);

        if(toBeDeleted != null){

            articleRepository.delete(toBeDeleted);

        }

    }

    @Override
    public void updateArticle(ArticleDTO articleDTO) {

        Article article = articleRepository.findById(articleDTO.getId()).orElse(null);

        if(article != null){

            article.setBody(articleDTO.getBody());
            article.setArticleAbstract(articleDTO.getArticleAbstract());
            article.setTitle(articleDTO.getTitle());

            articleRepository.save(article);

        }

    }

    @Override
    public ArticleDTO getArticle(int id) {

        Article article = articleRepository.findById(id).orElse(null);

        if(article != null){

            return dtoFactory.createDTO(article);

        }

        return null;

    }

    @Override
    public List<ArticleDTO> getArticles() {

        List<ArticleDTO> articleDTOS = new LinkedList<>();

        articleRepository.findAll().forEach(a -> articleDTOS.add(dtoFactory.createDTO(a)));

        return articleDTOS;

    }

    @Override
    public void updateReaders() {

        List<ArticleDTO> newArticles = new LinkedList<>();
        articleRepository.findAll().forEach(a -> newArticles.add(dtoFactory.createDTO(a)));

        ArticleObservable.getInstance().updateAll(newArticles);

    }
}
