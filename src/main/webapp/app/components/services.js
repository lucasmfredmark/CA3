'use strict';

/* Place your Global Services in this File */

// Demonstrate how to register services
angular.module('myApp.services', [])
  .service('userService', [function () {
    var self = this;
    
    self.username = '';
    self.isAuthenticated = false;
    self.isAdmin = false;
    self.isUser = false;
    
    return {
        getUsername: function () {
            return self.username;
        },
        setUsername: function (username) {
            self.username = username;
        },
        getIsAuthenticated: function () {
            return self.isAuthenticated;
        },
        setIsAuthenticated: function (isAuthenticated) {
            self.isAuthenticated = isAuthenticated;
        },
        getIsAdmin: function () {
            return self.isAdmin;
        },
        setIsAdmin: function (isAdmin) {
            self.isAdmin = isAdmin;
        },
        getIsUser: function () {
            return self.isUser;
        },
        setIsUser: function (isUser) {
            self.isUser = isUser;
        }
    };
  }])
  .service('teamService', ['teamFactory', function (teamFactory) {
    var self = this;
    
    self.teamList = [];
    
    self.getTeamsByUsername = function(username) {
        teamFactory.getTeamsByUsername(username).then(function(teams) {
            self.teamList = teams;
        }, function() {
            console.log('Couldn\'t get teams for user ' + username);
        });
    };
  }]);