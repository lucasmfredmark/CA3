'use strict';

/* Place your Global Services in this File */

// Demonstrate how to register services
angular.module('myApp.services', [])
  .service('userService', ['userFactory', function (userFactory) {
    var self = this;
    
    self.username = '';
    self.isAuthenticated = false;
    self.isAdmin = false;
    self.isUser = false;
    self.points = 0;
    
    self.userList = [];
    
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
        },
        getPoints: function() {
            return self.points;
        },
        setPoints: function(points) {
            self.points = points;
        },
        getAllUsers: function() {
            userFactory.getAllUsers().then(function(response) {
                self.userList = response.data;
                console.log(self.userList);
            }, function() {
                console.log('Couldn\'t get all users.');
            });
        },
        getUserList: function() {
            return self.userList;
        }
    };
  }])
  .service('teamService', ['teamFactory', function (teamFactory) {
    var self = this;
    
    self.teamList = [];
    
    return {
        getTeamsByUsername: function(username) {
            teamFactory.getTeamsByUsername(username).then(function(response) {
                self.teamList = response.data;
            }, function() {
                console.log('Couldn\'t get teams for user ' + username);
            });
        },
        getTeamList: function() {
            return self.teamList;
        }
    };
  }]);
