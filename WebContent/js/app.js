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
      when('/addFaculty', {
          templateUrl: 'partials/addFaculty.html',
          controller: 'addFacultyCtrl'
      }).
      when('/addStudent', {
          templateUrl: 'partials/addStudent.html',
          controller: 'addStudentCtrl'
      }).
      when('/admin', {
          templateUrl: 'partials/admin.html',
          controller: 'adminCtrl'
      }).
      when('/deleteFaculty', {
          templateUrl: 'partials/deleteFaculty.html',
          controller: 'deleteFacultyCtrl'
      }).
      when('/deleteStudent', {
          templateUrl: 'partials/deleteStudent.html',
          controller: 'deleteStudentCtrl'
      }).
      when('/enterAttendance', {
          templateUrl: 'partials/enterAttendance.html',
          controller: 'enterAttendanceCtrl'
      }).
      when('/faculty', {
          templateUrl: 'partials/faculty.html',
          controller: 'facultyCtrl'
      }).
      when('/login', {
          templateUrl: 'partials/login.html',
          controller: 'loginCtrl'
      }).
      when('/student', {
          templateUrl: 'partials/student.html',
          controller: 'studentCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);