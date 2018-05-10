(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.controller('ArticlesPageController', ['APIAddress', '$scope', 'ArticleComm', 'WriterComm', 'AuthComm', '$location', function (APIAddress, $scope, ArticleComm, WriterComm, AuthComm, $location) {

        //var ws;
        var stompClient = null;
        $scope.articles = [];

        $scope.init = function () {

            // ws = new WebSocket("ws://localhost:8080/socket");

            // ws.onmessage = function(event){

            //     console.log("The list of articles is coming up");
            //     $scope.articles = event.data;

            // };

            var socket = new SockJS("http://localhost:8080/websocket");
            stompClient = Stomp.over(socket);

            stompClient.connect({}, function(frame){
                console.log("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                console.log("Connected " + frame);
                stompClient.subscribe("/subscribe", function(message){
                    $scope.articles = JSON.parse(message.body);
                    $scope.$apply();
                    console.log(JSON.parse(message.body).content);
                    console.log(message);
                    console.log("I am somehow subscribed???");
                });
            });

            ArticleComm.getAll().then(function successCallback(response){

                console.log("Receiving list of articles");
                $scope.articles = response.data;

            }, function errorCallback(response){

                console.log("Error receiving list of articles");

            })

        };

        $scope.viewArticle = function(id){

            console.log("Opening article with id : " + id);
            if(stompClient != null){
                stompClient.disconnect();
            }
            $location.path("/viewArticle/" + id);

        }

    }]);

})();
