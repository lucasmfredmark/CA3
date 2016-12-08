'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
  factory('userFactory', ['$http', function($http) {
    var baseUrl = 'api/user';
    var userFactory = {};
    
    userFactory.addPoints = function(points) {
        return $http.post(baseUrl + '/points/add/' + points);
    };
    
    userFactory.removePoints = function(points) {
        return $http.post(baseUrl + '/points/remove/' + points);
    };
    
    userFactory.addPokemon = function(pokemon) {
        return $http.put(baseUrl + '/pokemon/add', pokemon);
    };
    
    userFactory.getUserByUsername = function(username) {
        return $http.get(baseUrl + '/' + username);
    };
    
    userFactory.getAllUsers = function() {
        return $http.get(baseUrl + '/all');
    };
    
    return userFactory;
  }]).
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
  factory('followFactory', ['$http', function ($http) {
    var baseUrl = 'api/follow';
    var followFactory = {};
    
    followFactory.getAllUsersFollowed = function() {
        return $http.get(baseUrl + '/me');
    };
    
    followFactory.followAUser = function(username) {
        return $http.get(baseUrl + '/add/' + username);
    };
    
    return followFactory;
  }]);