'use strict';

/* App Module */

var webApp = angular.module('webApp', [
  'ngRoute',
  'webControllers'
]);

webApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
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
      when('/faculty/:facultyId', {
          templateUrl: 'partials/faculty.html',
          controller: 'facultyCtrl'
      }).
      when('/login', {
          templateUrl: 'partials/login.html',
          controller: 'loginCtrl'
      }).
      when('/student/:studentId', {
          templateUrl: 'partials/student.html',
          controller: 'studentCtrl'
      }).
      when('/facultyAttendanceView/:facultyId', {
          templateUrl: 'partials/facultyAttendanceView.html',
          controller: 'facultyAttendanceViewCtrl'
      }).
      when('/studentAttendanceView/:studentId', {
          templateUrl: 'partials/studentAttendanceView.html',
          controller: 'studentAttendanceViewCtrl'
      }).
      when('/aboutUs', {
          templateUrl: 'partials/aboutUs.html',
          controller: 'aboutUsCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
  }]);