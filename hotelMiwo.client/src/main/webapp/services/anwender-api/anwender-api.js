/**
 * Created by mtc on 31.05.16.
 */
"use strict";

angular.module('hotelmiwo.anwender-api', [])
    .factory('anwenderApi', function($http){
        var service = {};
        if (!window.location.origin) {
            window.location.origin = window.location.protocol + "//"
                + window.location.hostname
                + (window.location.port ? ':' + window.location.port : '');
        }

        var userUrl = window.location.origin + "/hotelMiwo.server/intern/user";

        service.getUsers = function (callback) {
            $http({
                method  : 'GET',
                url     : userUrl + "/getUsers"
            }).success(function (response) {
                callback(response);
            }).error(function (response) {
                callback(response);
            });

        };

        return service;
    });