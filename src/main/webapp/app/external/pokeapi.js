
'use strict';

angular.module('myApp.pokeapi', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/pokeapi', {
                    templateUrl: 'app/external/apitest.html',
                    controller: 'pokeApiCtrl',
                    controllerAs: 'pokeapi'
                });
            }])

        .controller('pokeApiCtrl', ['pokeApiFactory', function (pokeApiFactory) {
                var self = this;
                self.controllerTest = "Hello from controller";
                self.pokeApiFactoryTest = pokeApiFactory.factoryTest;
                self.getPokemonById = pokeApiFactory.getPokemonById(130).then(function (response) {
                                self.pokemon = response.data;
                            }, function (error) {
                                self.status = 'Unable to load customer data: ' + error.message;
                            });
            }])
        .factory('pokeApiFactory', ['$http', function ($http) {
                var factory = {};
                var baseUrl = "http://pokeapi.co/api/v2/pokemon/";
                factory.factoryTest = "Hello from factory";
                factory.getPokemonById = function(id) {
//                    console.log($http.get(baseUrl + id));
//                    return "Get pokemon with id: " + id + " & url: " + baseUrl;
                    return $http.get(baseUrl + id);
                };
                return factory;
            }]);
