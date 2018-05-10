package com.Assig3.Assig3.BusinessLogic.ObservableDP;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;

import java.util.List;

public interface Observer {

    void update(List<ArticleDTO> newArticle);

}
