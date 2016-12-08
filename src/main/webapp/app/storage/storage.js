'use strict';

angular.module('myApp.storage', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/storage', {
    templateUrl: 'app/storage/storage.html',
    controller: 'StorageCtrl',
    controllerAs : 'storage'
  });
}])

.controller('StorageCtrl', ['pokemonFactory', 'userService', function(pokemonFactory, userService) {
        var self = this;
        self.test = "storage controller says hello";
        self.userService = userService;
        self.pokemon = [];
        self.getAllPokemonByUsername = function(username) {
            pokemonFactory.getAllPokemonByUsername(username).then(function(response) {
                console.log(response.data);
                self.pokemon = response.data;
            });
        };
}]);
