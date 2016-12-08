'use strict';

angular.module('myApp.teams', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/teams', {
    templateUrl: 'app/teams/teams.html',
    controller: 'TeamCtrl',
    controllerAs : 'team'
  });
}])

.controller('TeamCtrl', ['$uibModal', 'teamFactory', function($uibModal, teamFactory) {
  var self = this;
  
  self.openCreateTeamModal = function() {
    var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'createTeamModal.html',
        controller: function ($scope, $uibModalInstance) {
            $scope.createTeam = function(name) {
                teamFactory.createTeam(name).then(function(response) {
                    console.log(response.data);
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