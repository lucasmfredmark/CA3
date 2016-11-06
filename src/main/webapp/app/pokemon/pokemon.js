'use strict';

angular.module('myApp.pokemon', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/pokemon/:pokedexId', {
                    templateUrl: 'app/pokemon/pokemon.html',
                    controller: 'PokemonCtrl',
                    controllerAs: 'pokemon'
                });
            }])

        .controller('PokemonCtrl', ['PokemonFactory', '$routeParams', function (PokemonFactory, $routeParams) {
                var self = this;
                self.isLoaded = false;

                PokemonFactory.getPokemonByPokedexId($routeParams.pokedexId).then(function (response) {
                    self.pokemon = response.data;
                    self.isLoaded = true;
                    console.log(self.pokemon);
                });
            }])
        .factory('PokemonFactory', ['$http', function ($http) {
                var factory = {};
                var baseUrl = "http://pokeapi.co/api/v2/pokemon/";

                factory.getPokemonByPokedexId = function (pokedexId) {
                    return $http({
                        url: baseUrl + pokedexId,
                        skipAuthorization: true,
                        method: 'GET'
                    });
                };

                return factory;
            }]);