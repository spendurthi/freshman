'use strict';
var deptApp = angular.module('deptAppSearch',[])
	.controller('deptController', ['$scope','deptService','$location', function($scope,deptService,$location) {
    var self = this;
    self.dept={deptId:null,deptName:'',deptLoc:''};
    self.depts=[];

    self.searchDepts = searchDepts;
    // Below code is to read value after DOM ready since angular jas issue with hidden fields access in controllers.
    /*
    angular.element(document).ready(function () {
    	userID=document.getElementById('uid').value;
    	if (userID!=''){
    		findUser(userID);
    	}else{
    		fetchAllUsers();
    	}    	
    });
	*/
	

    function reset(){
    	self.dept={deptId:null,deptName:'',deptLoc:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
    function searchDepts(){
        deptService.search(self.dept.deptId,self.dept.deptName,self.dept.deptLoc)
            .then(
            function(d) {
                self.depts = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

}]);