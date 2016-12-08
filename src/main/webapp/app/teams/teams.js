'use strict';

angular.module('myApp.teams', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/teams', {
    templateUrl: 'app/teams/teams.html',
    controller: 'TeamCtrl',
    controllerAs : 'teamCtrl'
  });
}])

.controller('TeamCtrl', ['$uibModal', 'userService', 'teamFactory', function($uibModal, userService, teamFactory) {
  var self = this;
  
  self.userService = userService;
  self.teamList = [];
  
  self.getTeamsByUsername = function(username) {
      teamFactory.getTeamsByUsername(username).then(function(response) {
          self.teamList = response.data;
      });
  };
  
  self.deleteTeam = function(teamId) {
      teamFactory.deleteTeam(teamId).then(function() {
          self.getTeamsByUsername(userService.getUsername());
      });
  };
  
  self.openCreateTeamModal = function() {
    var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'createTeamModal.html',
        controller: function ($scope, $uibModalInstance) {
            $scope.createTeam = function(name) {
                teamFactory.createTeam(name).then(function() {
                    $uibModalInstance.close();
                    self.getTeamsByUsername(userService.getUsername());
                });
            };
            $scope.closeModal = function () {
                $uibModalInstance.close();
            };
        },
        size: 'sm'
    });
};
}]);