<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">User </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.user.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Username</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.userName" id="uname" class="username form-control input-sm" placeholder="Enter your name" required/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="pass">Password</label>
	                        <div class="col-md-7">
	                            <input type="password" ng-model="ctrl.user.password" id="pass" class="form-control input-sm" placeholder="Enter your Password" required/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-actions floatRight">
	                    	<input type="submit"  value="Add user" ng-click="ctrl.signin = true;" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                    	<input type="submit"  value="Login" ng-click="ctrl.signin = false;" class="btn btn-primary btn-sm"> 
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
</div>