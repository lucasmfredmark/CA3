'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
  factory('TeamFactory', ['$http', '$q', function ($http, $q) {
    var apiUrl = 'api/team/';
    
    return {
      getTeams: function() {
        var q = $q.defer();
        
        $http.get(apiUrl).then(function(response) {
            q.resolve(response.data);
        }, function(response) {
            q.reject(response.data);
        });
        
        return q.promise;
      }
    };
  }]);