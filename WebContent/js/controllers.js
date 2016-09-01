var webControllers = angular.module('webControllers', []);

webControllers.controller('sampleCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.sampleVar = "Hello World!!";
	$http.get('/AttendancePortal/rest/sampleRestApi').success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.restCallData = data;
		});
}]);

webControllers.controller('addFacultyCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('addStudentCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('adminCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('deleteFacultyCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('deleteStudentCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('enterAttendanceCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('facultyCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.param = 5435;
}]);

webControllers.controller('facultyAttendanceViewCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.val = $scope.param;
}]);

webControllers.controller('loginCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('studentCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('studentAttendanceViewCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);