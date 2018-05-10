(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.service('ArticleComm', ['$http', 'APIAddress', function ($http, APIAddress) {

        var baseUrl = "http://" + APIAddress + ":8080/article";

        this.addArticle = function (data) {

            return $http({
                method: 'POST',
                url: baseUrl + '/add',
                data: data
            });

        };

        this.addArticleSocket = function (data) {

            return $http({
                method: 'POST',
                url: baseUrl + "/add",
                data: data
            });

        };

        this.updateArticle = function (data) {

            return $http({
                method: 'POST',
                url: baseUrl + '/update',
                data: data
            });

        };

        this.deleteArticle = function (id) {

            return $http({
                method: 'GET',
                url: baseUrl + '/delete',
                params: {
                    id: id
                }
            });

        };

        this.getAll = function () {

            return $http({
                method: 'GET',
                url: baseUrl + '/getAll'
            });

        };

        this.get = function (id) {

            return $http({
                method: 'GET',
                url: baseUrl + '/get',
                params: {
                    id: id
                }
            });

        };

    }])

})();