<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />



    <!-- Boxicons -->
    <link
      href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
      rel="stylesheet"
    />

    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <!-- Swiper js -->
    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <!-- Custom StyleSheet -->
    
     <link href="./css/agents.css" rel="stylesheet">
<title>Agents</title>
</head>
<body>

<!-- Header -->
    <header class="header" id="header">
      <div class="navigation">
        <div class="nav-center container d-flex">
          <a href="/" class="logo" ><h1>WELCOME TO RS REAL ESTATE</h1></a>

          <ul class="nav-list d-flex">
            <li class="nav-item">
              <a href="homePageController" class="nav-link">Home</a>
              
            </li>
            <li class="nav-item">
              <a href="PersonInfoController" class="nav-link">Person Details</a>
            </li>
           
            </li>
            <li class="nav-item">
            	<a href="AgentsInfoController" class="nav-link">Agents Details</a>
            </li>
            
            <li class="nav-item">
              <a href="#terms" class="nav-link">Properties</a>
            </li>
            
            <li class="nav-item">
              <a href="#about" class="nav-link">About</a>
            </li>
            
            <li class="nav-item">
              <a href="#contact" class="nav-link">Contact</a>
            </li>
          </ul>

          <div class="hamburger">
            <i class="bx bx-menu-alt-left"></i>
          </div>
        </div>
      </div>
 
    </header>
    <section>
    
    <section class = "section rent">
    
    <div class="title">
        <h1> Agents Details </h1>
         <form action="AgentsInfoController" method="post">
         <div class="boxnewAgent">
		<input  id="buttonSubmit" type="submit" value="  Add New Agent  " name="addNewAgentButton" /> 
		</div>
        </form>
        <p>
     
        </p>
      </div>
    
        
        
       <div class="rent-center container">
       
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-1.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Kaiara Spencer <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-2.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Dave Simpson <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-3.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Ben Thompson <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-4.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Stuart Redman <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-5.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Rich Moffatt <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/agent-6.jpg" alt="Realtor 1" />
            </div>
            <div class="pos">
            
            </div>
          </div>
          <div class="bottom">
            <p>Kyla Stewart <br> <h4>Real Estate Agent</h4>
            </p>        
          </div>
        </div>
        
        </div>

   
  
</section>

  <section class="section rent">
      <div class="title">
        <h1>Discover Our Featured Listings</h1>
        <p>
          These featured listings contain exclusive real estate opportunities
          within the city
        </p>
      </div>

      <div class="rent-center container">
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/pic2.jpg" alt="" />
            </div>
            <div class="pos">
              <span>FEATURED</span>
              <span>BUY</span>
            </div>
          </div>
          <div class="bottom">
            <p>Luxury villa in Novi</p>
            <div>
              <span>$700</span>
              <span><i class="far fa-eye"></i></span>
            </div>
          </div>
        </div>
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/pic4.jpg" alt="" />
            </div>
            <div class="pos">
              <span>FEATURED</span>
              <span>BUY</span>
            </div>
          </div>
          <div class="bottom">
            <p>Luxury villa in Farmington</p>
            <div>
              <span>$700</span>
              <span><i class="far fa-eye"></i></span>
            </div>
          </div>
        </div>
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/pic5.jpg" alt="" />
            </div>
            <div class="pos">
              <span>FEATURED</span>
              <span>BUY</span>
            </div>
          </div>
          <div class="bottom">
            <p>Luxury villa in Birmingham</p>
            <div>
              <span>$700</span>
              <span><i class="far fa-eye"></i></span>
            </div>
          </div>
        </div>
        <div class="box">
          <div class="top">
            <div class="overlay">
              <img src="./images/pic1.jpg" alt="" />
            </div>
            <div class="pos">
              <span>FEATURED</span>
              <span>BUY</span>
            </div>
          </div>
          <div class="bottom">
            <p>Luxury villa in Mackinac island </p>
            <div>
              <span>$700</span>
              <span><i class="far fa-eye"></i></span>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
      <div class="row">
        <div class="col d-flex">
          <h4>INFORMATION</h4>
          <a href="">About us</a>
          <a href="">Contact Us</a>
          <a href="">Term & Conditions</a>
          <a href="">Shipping Guide</a>
        </div>
        <div class="col d-flex">
          <h4>USEFUL LINK</h4>
          <a href="">Online Store</a>
          <a href="">Customer Services</a>
          <a href="">Promotion</a>
          <a href="">Top Brands</a>
        </div>
        <div class="col d-flex">
          <span><i class="bx bxl-facebook-square"></i></span>
          <span><i class="bx bxl-instagram-alt"></i></span>
          <span><i class="bx bxl-github"></i></span>
          <span><i class="bx bxl-twitter"></i></span>
          <span><i class="bx bxl-pinterest"></i></span>
        </div>
      </div>
    </footer>

</body>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script src="./js/slider.js"></script>
  <script src="./js/index.js"></script>
</html>