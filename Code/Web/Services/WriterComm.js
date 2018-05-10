(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.service('WriterComm', ['$http', 'APIAddress', function ($http, APIAddress) {

        var baseUrl = "http://" + APIAddress + ":8080/writer";

        this.getAll = function(){

            return $http({
                method: 'GET',
                url: baseUrl + '/getAll'
            });

        };

    }])

})();