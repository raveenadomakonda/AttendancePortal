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
      when('/organizers', {
        templateUrl: 'partials/organizers.html',
        controller: 'organizersCtrl'
      }).
      when('/people-us', {
        templateUrl: 'partials/people-us.html',
        controller: 'peopleCtrlUS'
      }).
      when('/travel-us', {
        templateUrl: 'partials/travel-us.html',
        controller: 'travelCtrlUS'
      }).
      when('/schedule-us', {
        templateUrl: 'partials/schedule-us.html',
        controller: 'scheduleCtrlUS'
      }).
      when('/people-br', {
        templateUrl: 'partials/people-br.html',
        controller: 'peopleCtrlBR'
      }).
      when('/travel-br', {
        templateUrl: 'partials/travel-br.html',
        controller: 'travelCtrlBR'
      }).
      when('/schedule-br', {
        templateUrl: 'partials/schedule-br.html',
        controller: 'scheduleCtrlBR'
      }).
      when('/collaboration-br', {
          templateUrl: 'partials/collaboration-br.html',
          controller: 'collaborationCtrlBR'
      }).
      when('/photos-br', {
          templateUrl: 'partials/photos-br.html',
          controller: 'photosCtrlBR'
      }).
      when('/addProfile', {
        templateUrl: 'partials/profile.html',
        controller: 'profileCtrl'
      }). 
      when('/samplePage', {
          templateUrl: 'partials/samplePageHTML.html',
          controller: 'sampleCtrl'
        }). 
      otherwise({
        redirectTo: '/home'
      });
  }]);