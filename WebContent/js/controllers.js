var webControllers = angular.module('webControllers', []);

webControllers.controller('webCtrl', ['$scope', '$http',function ($scope,$http) {
    
}]);

webControllers.controller('organizersCtrl', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('peopleCtrlUS', [ '$scope', '$http', function($scope, $http) {
	
	$scope.profiles = "Empty";
	$http.get('/USBrazilSec/rest/getProfilesUS').success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.profiles = data;
		});

}]);

webControllers.controller('scheduleCtrlUS', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('travelCtrlUS', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('sampleCtrl', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('peopleCtrlBR', [ '$scope', '$http', function($scope, $http) {
	
	$scope.profiles = "";
	$http.get('/USBrazilSec/rest/getProfilesBR').success(function(data) {
		  console.log("Profile data"+ data);  
		  $scope.profiles = data;
		});

}]);

webControllers.controller('scheduleCtrlBR', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('travelCtrlBR', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('collaborationCtrlBR', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('photosCtrlBR', [ '$scope', '$http', function($scope, $http) {

}]);

webControllers.controller('profileCtrl', [ '$scope', '$http','$route', function($scope, $http, $route) {

	$scope.uploadFlag = false;	
	$scope.formFlag = true;
	$scope.uploadingFlag = false;
	$scope.uploadSuccessFlag = false;
	$scope.uploadResultFlag = false;
	$scope.info = { 'photoUrl' : 's3.amazon.com1245123'};
	$scope.locations = ["US", "Brazil", "Both"];
	$scope.info.code = "";
	
	$scope.sendData = function(){
		console.log("button clicked!!");
     	//alert("Profile Updated in People Page");
     	$scope.formFlag = false;
     	$scope.uploadingFlag = true;
		$http.post('/USBrazilSec/rest/uploadProfile',$scope.info).success(function(data) {
			  $scope.uploadingFlag = false;
			  $scope.uploadSuccessFlag = true;
			  $scope.uploadResultFlag = data.status;
			  console.log("Data Sent"+$scope.info);  
			  console.log("Response: " + data.status);
		    		  });
	};
	

	$scope.reloadPage = function() {
				$route.reload();
			}
	
	$scope.uploadPicture = function(){
		
		$http.post('/USBrazilSec/rest/uploadPicture', $scope.file, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(data){
        	$scope.info.photoUrl = data.link;
			$scope.uploadFlag = true;
        })
        .error(function(){
        });
	}
	
	$scope.printFilename = function(){
		console.log("File name: " + $scope.file);
	}
	
	$scope.uploadFile = function(files) {
	    var fd = new FormData();
	    //Take the first selected file
	    fd.append("file", files[0]);
	    console.log("Read to upload! ");
	    $scope.file = fd;
	    $scope.printFilename();
	    for (var key in FormData) {
	        console.log("Entry in FD "+key+" "+ FormData[key]);
	    }
	    $scope.uploadPicture();

	};
	
	

}]);




















