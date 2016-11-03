'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngAnimate',
  'angular-jwt',
  'ui.bootstrap',
  'myApp.security',
  'myApp.index',
  'myApp.teams',
  'myApp.filters',
  'myApp.directives',
  'myApp.factories',
  'myApp.services',
  'myApp.controllers',
  'myApp.pokeapi'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}]).
config(function ($httpProvider) {
   $httpProvider.interceptors.push('AuthInterceptor');
});