'use strict';

angular.module('deptAppSearch').factory('deptService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/freshman/dept/search';

    var factory = {
        search:search
    };

    return factory;

    function search(did,dn,dl) {
    	did = did == null ? "" : did;
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+did+"/dn"+dn+"/dl"+dl+'?'+ Math.random())
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);
