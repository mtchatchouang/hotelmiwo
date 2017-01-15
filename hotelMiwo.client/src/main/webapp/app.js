/**
 * Created by mtc on 22.05.16.
 */
"use strict";

angular.module('hotelmiwo', [
    'ngRoute',
    'ui.bootstrap',
    'ngCookies',
    'pascalprecht.translate',
    'hotelmiwo.home',
    'hotelmiwo.login',
    'hotelmiwo.content',
    'hotelmiwo.ranking',
    'hotelmiwo.logout'
]).config(function($routeProvider){
    $routeProvider
        .when('/', {
            template: '<home></home>'
        }).when('/login', {
            template: '<login></login>'
        }).when('/login/:error', {
            template: '<login></login>'
        }).when('/logout', {
            template: '<logout></logout>'
        }).when('/ranking', {
            template: '<ranking></ranking>'
        }).when('/content', {
            template: '<content></content>'
        }).otherwise({ redirectTo: '/' });
}).run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        //$rootScope.$on('$locationChangeStart', function (event, next, current) {
        //    // redirect to login page if not logged in
        //    if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
        //        $location.path('/login');
        //    }
        //});
    }])
    .factory('authInterceptor', function($q, $location) {
        var authInterceptor = {
            response: function(response) {
                if (response.status === 401){
                    $location.path('/login/error');
                    return $q.reject(response);
                }
                return response;
            },
            responseError: function(response) {
                if (response.status === 401){
                    $location.path('/login/error');
                }
                return $q.reject(response);
            }
        };
        return authInterceptor;
    })
    .config(['$httpProvider', function($httpProvider) {
        $httpProvider.interceptors.push('authInterceptor');
    }])
    .config(function ($translateProvider) {
        $translateProvider.useStaticFilesLoader({
            prefix: 'assets/lang/',
            suffix: '.json'
        });

        $translateProvider.useSanitizeValueStrategy('sanitizeParameters');
        $translateProvider.preferredLanguage('de');
    });