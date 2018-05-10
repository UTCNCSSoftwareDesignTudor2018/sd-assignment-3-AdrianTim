package com.Assig3.Assig3.RouterLayer;

import com.Assig3.Assig3.BusinessLogic.DataTransferObjects.ArticleDTO;
import com.Assig3.Assig3.BusinessLogic.IArticleLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/article")
public class ArticleController {

    private IArticleLogic articleLogic;
    private WebSocketController webSocketController;

    @Autowired
    public ArticleController(IArticleLogic articleLogic, WebSocketController webSocketController) {
        this.articleLogic = articleLogic;
        this.webSocketController = webSocketController;
    }

    @PostMapping("/add")
    public @ResponseBody void addArticle(@RequestBody ArticleDTO newArticle){

        articleLogic.addArticle(newArticle);
        //articleLogic.updateReaders();
        webSocketController.updateArticles();


    }

    @PostMapping(path = "/update")
    public @ResponseBody void updateArticle(@RequestBody ArticleDTO article){

        articleLogic.updateArticle(article);

    }

    @GetMapping(path = "/delete")
    public @ResponseBody void deleteArticle(@RequestParam int id){

        articleLogic.deleteArticle(id);

    }

    @GetMapping(path = "/getAll")
    public @ResponseBody List<ArticleDTO> getAll(){

        return articleLogic.getArticles();

    }

    @GetMapping(path = "/get")
    public @ResponseBody ArticleDTO get(@RequestParam int id){

        return articleLogic.getArticle(id);

    }

}
