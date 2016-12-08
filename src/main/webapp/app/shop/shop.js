'use strict';

angular.module('myApp.shop', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/shop', {
    templateUrl: 'app/shop/shop.html',
    controller: 'ShopCtrl',
    controllerAs : 'shop'
  });
}])

.controller('ShopCtrl', ['$rootScope', 'userService', 'pokemonFactory', function($rootScope, userService, pokemonFactory) {
  var self = this;
  
  self.pokemonList = [];
  
  self.getAllPokemonPrices = function() {
      pokemonFactory.getAllPokemonPrices().then(function(response) {
          self.pokemonList = response.data;
      });
  };
  
  self.buyPokemon = function(pokedexId) {
      var price = self.pokemonList[pokedexId-1].price;
      
      if (userService.getPoints() < price) {
          $rootScope.openErrorModal("You can't afford that Pokémon!");
      } else {
          
      }
  };
}]);