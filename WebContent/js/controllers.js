var webControllers = angular.module('webControllers', []);

webControllers.controller('webCtrl', ['$scope', '$http',function ($scope,$http) {
    
}]);

webControllers.controller('peopleCtrlUS', [ '$scope', '$http', function($scope, $http) {
	
	$scope.profiles = "Empty";
	$http.get('/USBrazilSec/rest/getProfilesUS').success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.profiles = data;
		});

}]);

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
	
}]);

webControllers.controller('loginCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('studentCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);