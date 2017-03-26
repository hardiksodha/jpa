
/**
 * Created by Hardik on 08-03-2017.
 */

var myApp = angular.module('myApp', ['ngRoute','ui.grid','ui.grid.pagination']);

// configure our routes
var routeFunction = function($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl : '../pages/home.html',
            controller  : 'mainController'
        })

        // route for the about page
        .when('/about', {
            templateUrl : '../pages/about.html',
            controller  : 'aboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl : '../pages/contact.html',
            controller  : 'contactController'
        })

        .when('/schedule', {
            templateUrl : '../pages/schedule.html',
            controller  : 'scheduleController',
            controllerAs: 'mySchedule'

        });

    ;
};
myApp.config(routeFunction);


