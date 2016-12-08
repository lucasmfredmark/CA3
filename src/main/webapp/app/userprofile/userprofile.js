angular.module('myApp.userprofile', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/userprofile/:username', {
                    templateUrl: 'app/userprofile/userprofile.html',
                    controller: 'userprofileCtrl',
                    controllerAs: 'userprofile'
                });
            }])

        .controller('userprofileCtrl', ['$routeParams', 'userFactory', 'followFactory', 'userService', function ($routeParams, userFactory, followFactory, userService) {
                var self = this;
                self.username = $routeParams.username;
                self.currentUser = userService.getUsername();
                self.usersFollowed = [];
                
                self.test = function () {
                    console.log(self.username);
                };
                self.getUserByUsername = function (username) {
                    userFactory.getUserByUsername(username).then(function (response) {
                    });
                };
                self.getAllUsersFollowed = function () {
                    followFactory.getAllUsersFollowed().then(function (response) {
                        self.usersFollowed = response.data;
                    });
                };
                self.getAllUsersFollowedByUsername = function (username) {
                    followFactory.getAllUsersFollowedByUsername(username).then(function (response) {
                        self.usersFollowed = response.data;
                    });
                };
                self.followAUser = function (username) {
                    followFactory.followAUser(username).then(function (response) {
                    });
                };
            }]);