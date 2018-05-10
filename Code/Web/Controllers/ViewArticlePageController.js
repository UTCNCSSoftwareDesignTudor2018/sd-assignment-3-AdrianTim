(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.controller('ViewArticlePageController', ['APIAddress', '$scope', 'ArticleComm', 'WriterComm', 'AuthComm', '$location', '$routeParams', function (APIAddress, $scope, ArticleComm, WriterComm, AuthComm, $location, $routeParams) {

        $scope.init = function () {

            
            ArticleComm.get($routeParams.id).then(function successCallback(response){

                $scope.article = response.data;

            }, function errorCallback(response){
                console.log("Error retrieving the article");
            });

        };

    }]);

})();