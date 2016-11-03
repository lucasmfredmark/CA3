/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

angular.module('myApp.pokeapi', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/pokeapi', {
    templateUrl: 'app/external/apitest.html',
    controller: 'pokeApiCtrl',
    controllerAs : 'pokeapi'
  });
}])

.controller('pokeApiCtrl', ['pokeApiFactory', function(pokeApiFactory) {
        var self = this;
        self.pokeApiTest = pokeApiFactory.getPokemonById();
}])

.factory('pokeApiFactory', [function(){
    var pokeapi = {};
    pokeapi.getPokemonById = function() {
        return "Response from pokeapi.getPokemonById";
    };
    
    return pokeapi;
}]);
