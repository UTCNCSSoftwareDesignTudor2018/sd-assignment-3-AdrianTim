(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.controller('WriterPageController', ['APIAddress', '$scope', 'ArticleComm', 'WriterComm', 'AuthComm', '$location', function (APIAddress, $scope, ArticleComm, WriterComm, AuthComm, $location) {

        $scope.init = function () {



        };

        $scope.addArticle = function(){

            var data = {
                title: $scope.title,
                articleAbstract: $scope.abstract,
                body: $scope.body,
                writerUsername: localStorage['writer']
            };

            ArticleComm.addArticle(data).then(function successCallback(response){
                console.log(response.data);
                $scope.title = "";
                $scope.abstract = "";
                $scope.body = "";
            }, function errorCallbac(response){
                console.log("Error adding new article!");
            });

        };

        $scope.editArticle = function (id){
            $location.path("/editArticle/"+ id);
        }

    }]);

})();