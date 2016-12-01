'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
  factory('teamFactory', ['$http', function ($http) {
    var baseUrl = 'api/team';
    var teamFactory = {};
    
    teamFactory.createTeam = function(team) {
        return $http.put(baseUrl + '/create', team);
    };
    
    teamFactory.deleteTeam = function(teamId) {
        return $http.delete(baseUrl + '/delete/' + teamId);
    };
    
    teamFactory.getTeamsByUsername = function(username) {
        return $http.get(baseUrl + "/username/" + username);
    };
    
    return teamFactory;
  }]).
  factory('userFactory', ['$http', function($http) {
    var baseUrl = 'api/user';
    var userFactory = {};
    
    /*userFactory.createTeam = function(team) {
        return $http.put(baseUrl + '/create', team);
    };
    
    userFactory.deleteTeam = function(teamId) {
        return $http.delete(baseUrl + '/delete/' + teamId);
    };
    
    userFactory.getTeamsByUsername = function(username) {
        return $http.get(baseUrl + "/username/" + username);
    };*/
    
    return userFactory;
  }]);