'use strict';

angular.module('miFinityApp').controller('UserController',
    ['UserService', '$scope', '$window', function( UserService, $scope, $window) {

        var self = this;
        self.user = {};
        self.users=[];

        self.signin = {};
        self.submit = submit;
        self.createUser = createUser;
        self.doLogout = doLogout;
        self.login = login;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        function submit() {
            console.log('Submitting');
            if (self.signin) {
                console.log('Saving New User', self.user);
                createUser(self.user);
            } else {
                console.log('Login ', self.user);
            	login(self.user);
            }
        }
        
        function login(user) {
            console.log('logging user: ', user.password);
            UserService.loginUser(user)
                .then(
                    function (response) {
                    	if(response){
	                        console.log('User logged successfully');
	                        self.successMessage = 'User logged successfully';
	                        self.errorMessage='';
	                        self.done = true;
	                        UserService.user.id = response;
	                        $scope.myForm.$setPristine();
	                        $window.location.href = '/MiFinityApp/#/cards-list';
                    	}
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }

        function createUser(user) {
            console.log('About to create user');
            UserService.createUser(user)
                .then(
                    function (response) {
                        console.log('User created successfully');
                        self.successMessage = 'User created successfully, you can login now';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
        
        function doLogout(){
        	UserService.logout();
            $window.location.href = '/MiFinityApp/#/user';        	
        }

    }


    ]);