'use strict';

angular.module('myApp.shop', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/shop', {
    templateUrl: 'app/shop/shop.html',
    controller: 'ShopCtrl',
    controllerAs : 'shop'
  });
}])

.controller('ShopCtrl', ['$rootScope', 'userService', 'userFactory', 'pokemonFactory', function($rootScope, userService, userFactory, pokemonFactory) {
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
          $rootScope.openBaseModal("Not enough points", "You can't afford that Pokémon!");
      } else {
          userFactory.buyPokemon(pokedexId).then(function() {
              userService.setPoints(userService.getPoints() - price);
              $rootScope.openBaseModal("Congratulations!", "Your Pokémon has been transferred to your storage.");
          });
      }
  };
}]);