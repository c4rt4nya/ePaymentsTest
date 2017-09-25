'use strict';

angular.module('miFinityApp').controller('CreditCardController',
    ['CreditCardService', '$scope','UserService', '$window', function( CreditCardService, $scope, UserService, $window) {

        var self = this;
        self.creditCard = {};
        self.creditCardList = [];
        
        self.addCreditCard = addCreditCard;
        self.searchCreditCard = searchCreditCard;
        self.redirectToCreditCardPage = redirectToCreditCardPage;
        self.redirectToLogin = redirectToLogin;
        self.redirectToList = redirectToList;
        self.doLogout = doLogout;
        
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.isLogged = isLogged;
        
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function addCreditCard() {
            console.log('About to add a credit card');
            var user = UserService.user;
            if(!isLogged()){
                console.log('Not logged in');
                self.successMessage = '';
                self.errorMessage = 'You are not logged in';
            }
            else{
	            self.creditCard.user = user;
	            CreditCardService.addCreditCard(self.creditCard)
	                .then(
	                    function (response) {
	                        console.log('Credit card added successfully');
	                        self.successMessage = 'Credit card added successfully';
	                        self.errorMessage ='';
	                        self.done = true;
	                        self.user={};
	                        $scope.myForm.$setPristine();
	                    },
	                    function (errorResponse) {
	                        console.error('Error while adding the credit card ');
	                        self.errorMessage = 'Error while adding the credit card: ' + errorResponse.data.errorMessage;
	                        self.successMessage='';
	                    }
	                );
            }
        }
        
        function searchCreditCard() {
            console.log('Searching credit card');
            if(!isLogged()){
                console.log('Not logged in');
                self.successMessage = '';
                self.errorMessage = 'You are not logged in';
            }
            else{
	            CreditCardService.searchCreditCard(self.creditCard.cardNumber, UserService.user.id) 
	            .then(
	                    function (response) {
	                        console.log('Credit card listed successfully');
	                        self.successMessage = 'Credit cards listed successfully';
	                        self.errorMessage = '';
	                        self.done = true;
	                        self.creditCardList = response;
	                        $scope.myForm.$setPristine();
	                    },
	                    function (errorResponse) {
	                        console.error('Error while searching the credit cards');
	                        self.errorMessage = 'Error while searching the credit cards: ' + errorResponse.data.errorMessage;
	                        self.successMessage = '';
	                    }
	            );
            }
        }
        
        function redirectToLogin(){
            $window.location.href = '/MiFinityApp/#/user';        	
        }
        
        function redirectToCreditCardPage(){
            $window.location.href = '/MiFinityApp/#/add-card';        	
        }
        
        function redirectToList(){
            $window.location.href = '/MiFinityApp/#/cards-list';        	
        }
        
        function isLogged(){
        	var isLogged = false;
        	var user = UserService.user;
	        if(user && user.id){
	        	isLogged = true;
	        }
	        return isLogged;
	    }
        
        function doLogout(){
        	UserService.logout();
            $window.location.href = '/MiFinityApp/#/user';        	
        }
    }
    ]);