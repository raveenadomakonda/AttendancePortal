'use strict';

/* App Module */

var webApp = angular.module('webApp', [
  'ngRoute',
  'webControllers'
]);

webApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/home', {
        templateUrl: 'partials/home.html',
        controller: 'webCtrl'
      }).
      when('/samplePage', {
          templateUrl: 'partials/samplePageHTML.html',
          controller: 'sampleCtrl'
        }). 
      otherwise({
        redirectTo: '/home'
      });
  }]);