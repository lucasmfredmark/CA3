/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
                self.pokeApiTest = pokeApiFactory.factoryTest();
//                self.getPokemonById = function (id) {
//                    console.log("Getting pokemon by id: " + id);
//                    pokeApiFactory.getPokemonById(id)
//                            .then(function (response) {
//                                console.log("Response is: " + response);
//                                self.pokemon = response.data;
//                                console.log(self.countries_all);
//                            }, function (error) {
//                                self.status = 'Unable to load customer data: ' + error.message;
//                            });
//                };
            }])

        .factory('pokeApiFactory' [function () {
            var pokeapi = {};
//            var baseUrl = "http://pokeapi.com/api/v2/pokemon/";
            pokeapi.factoryTest = function () {
                return "Response from pokeapi.getPokemonById";
            };
//            pokeapi.getPokemonById = function (id) {
//                return $http.get(baseUrl + id);
//            };
            return pokeapi;
        }]);
