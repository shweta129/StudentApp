/**
 * UserService
 */

app.factory('UserService',function($http){
  var BASE_URL="http://localhost:8080/StudentAppRest/"
	
  var userService={}
  
  userService.registerUser = function(user){
	  // http://localhost:8080/StudentAppRest/  /registeruser
	  //Base_URL                               + "registeruser"
	 
	  return $http.post(BASE_URL + "registeruser",user) //step:4 
  }

  return userService;
  
})