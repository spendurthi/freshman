'use strict';
var App = angular.module('myApp',[])
	.controller('UserController', ['$scope','UserService','$location', function($scope,UserService,$location) {
    var self = this;
    self.user={id:null,userName:'',address:'',email:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.searchUsers = searchUsers;
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
	
	
    fetchAllUsers();
    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
            	self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
    
    function findUser(id){
        UserService.getUser(id)
            .then(
            function(d) {
                self.users = d;
                for(var i = 0; i < self.users.length; i++){
                    if(self.users[i].id === id) {
                        alert(self.users[i].id);
                    }
                }
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }

    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null,userName:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
    function searchUsers(){
        UserService.search(self.user.srch)
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

}]);