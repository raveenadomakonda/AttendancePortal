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
