var webControllers = angular.module('webControllers', []);

webControllers.controller('sampleCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$scope.sampleVar = "Hello World!!";
	$http.get('/AttendancePortal/rest/sampleRestApi').success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.restCallData = data;
		});
}]);

webControllers.controller('addFacultyCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.errorFlag = false;
    $scope.addFaculty = function(){
        $scope.errorFlag = false;
        $http.get('/AttendancePortal/rest/addFacultyDo', {params:{firstName:$scope.firstName, lastName:$scope.lastName, id:$scope.id, phoneNumber:$scope.phoneNumber, password:$password}}).success(function(data) {
            console.log("Got data from server")
            $scope.response = data;
            if(data == false) {
            	$scope.errorFlag = true;
            } else {
            		$location.path("admin");
            }
          }).error(function(){
              console.log("No reply from server");
              $scope.errorFlag = true;
            });

    	$scope.firstName = null;
    	$scope.lastName = null;
    	$scope.id = null;
    	$scope.phoneNumber = null;
    	$scope.password = null;
    }
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

webControllers.controller('loginCtrl', [ '$scope', '$http', '$location', function($scope, $http, $location) {
	$scope.errorFlag = false;
	$scope.restCallData = false;
	$http.get('/AttendancePortal/rest/loginDo', {params:{username:$scope.username, password:$scope.password}}).success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.restCallData = data;
		});
    $scope.loginCheck = function(){
    	$scope.id = $scope.username;
        $scope.errorFlag = false;
        $http.get('/AttendancePortal/rest/loginDo', {params:{username:$scope.username, password:$scope.password}}).success(function(data) {
            console.log("Got data from server")
            $scope.response = data;
            if(data.isValid == false) {
            	$scope.errorFlag = true;
            } else {
            	if(data.accountType == "Admin") {
            		$location.path("admin");
            	} else if(data.accountType == "Faculty") {
            		$location.path("faculty/" + $scope.id);
            	} else {
            		$location.path("student/" + $scope.id);
            	}
            }
          }).error(function(){
              console.log("No reply from server for getAttributionData request");
              $scope.errorFlag = true;
            });

    	$scope.username = null;
    	$scope.password = null;
    }
}]);

webControllers.controller('studentCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('studentAttendanceViewCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);

webControllers.controller('aboutUsCtrl', [ '$scope', '$http', function($scope, $http) {
	
}]);