package com.Assig3.Assig3.RouterLayer;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;
import com.Assig3.Assig3.BusinessLogic.IArticleLogic;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Controller
public class WebSocketController {

    private IArticleLogic articleLogic;
    private SimpMessagingTemplate brokerMessagingTemplate;

    @Autowired
    public WebSocketController(IArticleLogic articleLogic, SimpMessagingTemplate brokerMessagingTemplate){
        this.articleLogic = articleLogic;
        this.brokerMessagingTemplate = brokerMessagingTemplate;
    }

    @MessageMapping("/addAndUpdate")
    @SendTo("/subscribe")
    public String addArticle(ArticleDTO article){

        articleLogic.addArticle(article);
        Gson gson = new Gson();
        String json = gson.toJson(articleLogic.getArticles());
        return json;

    }

    public void updateArticles(){
        Gson gson = new Gson();
        String json = gson.toJson(articleLogic.getArticles());
        this.brokerMessagingTemplate.convertAndSend("/subscribe", json);
    }

}
