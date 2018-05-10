(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.controller('EditArticlePageController', ['APIAddress', '$scope', 'ArticleComm', 'WriterComm', 'AuthComm', '$location', '$routeParams', function (APIAddress, $scope, ArticleComm, WriterComm, AuthComm, $location, $routeParams) {

        $scope.init = function () {

            ArticleComm.get($routeParams.id).then(function successCallback(response){

                $scope.title = response.data.title;
                $scope.abstract = response.data.abstract;
                $scope.body = response.data.body;

            }, function errorCallback(response){

            });

        };

        $scope.editArticle = function(){

            var data = {
                id: $routeParams.id,
                title: $scope.title,
                articleAbstract: $scope.abstract,
                body: $scope.body
            };

            ArticleComm.updateArticle(data).then(function successCallback(response){
                console.log("Success");
            }, function errorCallback(response){
                console.log("Error");
            })

        }

    }]);

})();