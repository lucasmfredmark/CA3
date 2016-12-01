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
    
    userFactory.addPoints = function(points, username) {
        return $http.post(baseUrl + '/' + username + '/points/add/' + points);
    };
    
    userFactory.removePoints = function(points, username) {
        return $http.post(baseUrl + '/' + username + '/points/remove/' + points);
    };
    
    userFactory.addPokemon = function(pokemon, username) {
        return $http.put(baseUrl + '/' + username + '/pokemon/add', pokemon);
    };
    
    userFactory.getUserByUsername = function(username) {
        return $http.get(baseUrl + '/' + username);
    };
    
    return userFactory;
  }]);