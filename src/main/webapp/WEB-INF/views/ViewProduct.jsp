<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<style type="text/css">

body{background-color: #000}.card{border:none}.product{background-color: #eee}.brand{font-size: 13px}.act-price{color:red;font-weight: 700}.dis-price{text-decoration: line-through}.about{font-size: 14px}.color{margin-bottom:10px}label.radio{cursor: pointer}label.radio input{position: absolute;top: 0;left: 0;visibility: hidden;pointer-events: none}label.radio span{padding: 2px 9px;border: 2px solid #ff0000;display: inline-block;color: #ff0000;border-radius: 3px;text-transform: uppercase}label.radio input:checked+span{border-color: #ff0000;background-color: #ff0000;color: #fff}.btn-danger{background-color: #ff0000 !important;border-color: #ff0000 !important}.btn-danger:hover{background-color: #da0606 !important;border-color: #da0606 !important}.btn-danger:focus{box-shadow: none}.cart i{margin-right: 10px}
</style>
</head>
<body>
<div class="container mt-5 mb-5">
    <div class="row d-flex justify-content-center">
        <div class="col-md-10">
            <div class="card">
                <div class="row">
                    <div class="col-md-6">
                        <div class="images p-3">
                            <div class="text-center p-4"> <img id="main-image" src="${product.productPicPath}" width="250" /> </div>
                            <div class="thumbnail text-center"> <img onclick="change_image(this)" src="${product.productPicPath}" width="30"> <img onclick="change_image(this)" src="${product.productPicPath}" width="30"> </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="product p-4">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex align-items-center"> <i class="fa fa-long-arrow-left"></i> <span class="ml-1"><a href="listuserproduct" class="link-dark text-decoration-none">Back</a></span> </div> <i class="fa fa-shopping-cart text-muted"></i>
                            </div>
                            <div class="mt-4 mb-3"> <span class="text-uppercase text-muted brand">${product.category}</span>
                                 <h5 class="text-uppercase">${product.productName}</h5>
                                <div class="price d-flex flex-row align-items-center"> <span class="act-price">${product.price}</span>
                                    <div class="ml-2"> <small class="dis-price">${product.price * 0.05 + product.price}</small> <span>5% OFF</span> </div>
                                </div>
                                <span class="text-uppercase text-muted brand">Qty: ${product.qty}</span>
                            </div>
                            <p class="about">Shop from a wide range of t-shirt from orianz. Pefect for your everyday use, you could pair it with a stylish pair of jeans or trousers complete the look.</p>
                           <div class="sizes mt-5">
                                <h6 class="text-uppercase">Size</h6> <label class="radio"> <input type="radio" name="size" value="1TB" checked> <span>1TB</span> </label> <label class="radio"> <input type="radio" name="size" value="512GB"> <span>512GB</span> </label> <label class="radio"> <input type="radio" name="size" value="256GB"> <span>256GB</span> </label> <label class="radio"> <input type="radio" name="size" value="128GB"> <span>128GB</span> </label> <!-- <label class="radio"> <input type="radio" name="size" value="XXL"> <span>XXL</span> </label> -->
                            </div> 
                            <div class="cart mt-4 align-items-center"> <a href="addtocart?productId=${product.productId}" class="link-dark text-decoration-none"> <button class="btn btn-danger text-uppercase mr-2 px-4">Add to cart</button></a> <i class="fa fa-heart text-muted"></i> <i class="fa fa-share-alt text-muted"></i> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>










<br>
<script type="text/javascript">
function change_image(image){

    var container = document.getElementById("main-image");

   container.src = image.src;
}



document.addEventListener("DOMContentLoaded", function(event) {
	
});


</script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
</body>
</html>