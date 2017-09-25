var app = angular.module('miFinityApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/MiFinityApp',
    USER_SERVICE_API : 'http://localhost:8080/MiFinityApp/api/user/',
    CREDIT_CARD_SERVICE_API : 'http://localhost:8080/MiFinityApp/api/creditCard/add/',
    USER_LOGIN_SERVICE_API : 'http://localhost:8080/MiFinityApp/api/login/',
    CREDIT_CARD_SEARCH_SERVICE_API : 'http://localhost:8080/MiFinityApp/api/creditCard/search/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('user', {
                url: '/user',
                templateUrl: 'add-user',
                controller:'UserController',
                controllerAs:'ctrl'
            })
              .state('creditcard', {
                url: '/add-card',
                templateUrl: 'add-credit-card',
                controller:'CreditCardController',
                controllerAs:'ctrl'
            })
               .state('creditCardList', {
                url: '/cards-list',
                templateUrl: 'credit-card-list',
                controller:'CreditCardController',
                controllerAs:'ctrl'
            });
        $urlRouterProvider.otherwise('/user');
    }]);

