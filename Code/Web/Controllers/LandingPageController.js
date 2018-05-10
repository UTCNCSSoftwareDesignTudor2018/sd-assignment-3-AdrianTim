(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.controller('LandingPageController', ['APIAddress', '$scope', 'ArticleComm', 'WriterComm', 'AuthComm', '$location', function (APIAddress, $scope, ArticleComm, WriterComm, AuthComm, $location) {

        $scope.init = function () {

            
            
        };

        $scope.writeArticle = function(){

            $location.path("/writer");

        };

        $scope.goToArticles = function(){

            $location.path("/articles");

        }

        $scope.login = function(){

            var data = {
                username: $scope.username,
                password: $scope.password
            };

            AuthComm.login(data).then(function successCallback(response){

                localStorage['writer'] = response.data.username;
                $location.path("/writer");

            }, function errorCallback(response){

                console.log(response);
                console.log("Error logging in");

            });

        }

    }]);

})();