package com.Assig3.Assig3.BusinessLogic.Implementations;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;
import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.LoginDTO;
import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.WriterDTO;
import com.Assig3.Assig3.DataAccess.Entities.Article;
import com.Assig3.Assig3.DataAccess.Entities.Writer;
import org.springframework.stereotype.Service;

@Service
public class DTOFactory {

    public WriterDTO createDTO(Writer writer){

        WriterDTO writerDTO = new WriterDTO(writer.getName(), writer.getSurname());

        writer.getArticles().forEach(a -> writerDTO.getArticles().add(createDTO(a)));

        return writerDTO;

    }

    public ArticleDTO createDTO(Article article){

        return new ArticleDTO(article.getId(), article.getTitle(), article.getArticleAbstract(), article.getBody(), article.getWriter().getUsername(), article.getWriter().getName(), article.getWriter().getSurname());

    }

    public LoginDTO createDTO(String username, String password){

        return new LoginDTO(username, password);

    }

}
