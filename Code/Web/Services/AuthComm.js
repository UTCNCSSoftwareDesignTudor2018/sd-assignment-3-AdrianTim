(function () {

    'use strict'

    var app = angular.module('Assig3');

    app.service('AuthComm', ['$http', 'APIAddress', function ($http, APIAddress) {

        var baseUrl = "http://" + APIAddress + ":8080/auth";

        this.login = function(data){

            return $http({
                method: 'POST',
                url: baseUrl + '/login',
                data: data
            });

        };

    }])

})();