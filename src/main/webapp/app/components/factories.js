'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
  factory('teamFactory', ['$http', function ($http) {
    var baseUrl = 'api/team';
    var teamFactory = {};
    
    teamFactory.createTeam = function(team) {
        return $http.put(baseUrl, team);
    };
    
    teamFactory.deleteTeam = function(teamId) {
        return $http.delete(baseUrl + '/' + teamId);
    };
    
    teamFactory.getTeamsByUsername = function(username) {
        return $http.get(baseUrl + "/username/" + username);
    };
    
    return teamFactory;
  }]);