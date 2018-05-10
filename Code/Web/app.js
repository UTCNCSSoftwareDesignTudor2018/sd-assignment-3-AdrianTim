(function(){
    
        'use strict'
    
        console.log("Starting....");
        
        var app = angular.module('Assig3', ['ngRoute', 'ngMaterial', 'ngMessages']);
    
        app.config(function($routeProvider){
    
            $routeProvider
                .when("/landing", {
                    templateUrl: "Views/LandingPage.html",
                    controller: "LandingPageController",
                    controllerAs: "ctrl"
                })
                .when("/articles", {
                    templateUrl: "Views/ArticlesPage.html",
                    controller: "ArticlesPageController",
                    controllerAs: "ctrl"
                })
                .when("/viewArticle/:id", {
                    templateUrl: "Views/ViewArticlePage.html",
                    controller: "ViewArticlePageController",
                    controllerAs: "ctrl"
                })
                .when("/editArticle/:id", {
                    templateUrl: "Views/EditArticlePage.html",
                    controller: "EditArticlePageController",
                    controllerAs: "ctrl"
                })
                .when("/writer", {
                    templateUrl: "Views/WriterPage.html",
                    controller: "WriterPageController",
                    controllerAs: "ctrl"
                })
                .otherwise({
                    redirectTo: "/landing"
                });
    
        });
    
        app.value('APIAddress', 'localhost');
    
    })();