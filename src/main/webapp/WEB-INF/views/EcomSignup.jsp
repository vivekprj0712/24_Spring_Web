<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700,900" rel="stylesheet">
  <link rel="stylesheet" href="dist/fonts/icomoon/style.css">

  <link rel="stylesheet" href="dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="dist/css/jquery-ui.css">
  <link rel="stylesheet" href="dist/css/owl.carousel.min.css">
  <link rel="stylesheet" href="dist/css/owl.theme.default.min.css">
  <link rel="stylesheet" href="dist/css/owl.theme.default.min.css">

  <link rel="stylesheet" href="dist/css/jquery.fancybox.min.css">

  <link rel="stylesheet" href="dist/css/bootstrap-datepicker.css">

  <link rel="stylesheet" href="dist/fonts/flaticon/font/flaticon.css">

  <link rel="stylesheet" href="dist/css/aos.css">
  <link href="dist/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

  <link rel="stylesheet" href="dist/css/style.css">
</head>
<body>
 <div class="site-section ftco-subscribe-1 site-blocks-cover pb-4" >
        <div class="container">
          <div class="row align-items-end justify-content-center text-center">
            <div class="col-lg-7">
              <h2 class="mb-3">Register</h2>
              <p></p>
            </div>
          </div>
        </div>
      </div>

    <div class="site-section">
        <div class="container">
			<form action="esignup" method = "post" enctype="multipart/form-data">
            <div class="row justify-content-center">
                <div class="col-md-5">
                    <div class="row">
      	                
      	                <div class="col-md-12 form-group">
                            <label for="userName">UserName</label>
                            <input type="text" id="userName" name = "userName"  class="form-control form-control-lg">
                        </div>
                        
                        <div class="col-md-12 form-group">
                            <label for="email">Email</label>
                            <input type="email" id="email" name = "email" class="form-control form-control-lg">
                        </div>
                        
                        <div class="col-md-12 form-group">
                            <label for="password">Password</label>
                            <input type="password" id="password" name = "password"  class="form-control form-control-lg">    
                        </div>
                        
                        <div class="col-md-12 form-group">
                            <label for="profilePic">Profile Image</label>
                            <input type="file" name= "profilePic" id="profilePic" class="form-control form-control-lg">
                        </div>
                        
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <input type="submit" value="Register" class="btn btn-primary btn-lg px-5 mt-3">
                        </div>
                        <div class="col-6">
                            <input type="reset" value="Reset" class="btn  btn-primary btn-lg px-5 mt-3">
                        </div>
                        
                    </div>
                    <div class="row mt-3">
                    	<a href="elogin" class="text-left  px-5 form-group">I already have a membership</a>
                    </div>
                   
                </div>
            </div>
            
          </form>
        </div>
    </div>

</body>
</html>