<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<%@ page import = "java.util.ArrayList"  session="true" isErrorPage="false"%>
<%@ page import = "java.util.List" %>
<%@ page import = "assignment6.person.model.Person" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
ArrayList<Person> list_person =new ArrayList<Person>();
list_person = ( ArrayList <Person>)request.getAttribute("personData"); %>

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
<title>Person Details</title>
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
   
    
     <div align="center">
     <div><h1><br></h1></div>
        <h1>Person  Details</h1>
        <div><h1><br></h1></div>

        <form action= "PersonInfoController" method="post">

         <table style:"80%" id="persons">
         <tr>
           <th>Person ID</th>
           <th>Person Name</th>
           <th>SSN</th>
           <th>Driving License Number</th>
           <th>Birth Date</th>
           <th>Birth Place</th>
           <th>Delete</th>
        </tr>

        <%
        for(int i =0 ; i< list_person.size(); i++)
        {
            %>
            <tr onclick="selectRow(this)">
            <% Person p = (Person) list_person.get(i); %>
            	<td> <%= p.getPersonId() %> </td>
                <td> <%= p.getPersonName() %></td>
                <td> <%= p.getSsn() %></td>
                <td> <%= p.getDriversLicenseNr() %></td>
                <td> <%= p.getBirthDate() %></td>
                <td> <%= p.getBirthPlace() %></td>
               
	        		<td>
	        				<div class="boxnewPerson">		
	        				<input type="hidden" name="PersonId" id="PersonId">
						  	<input type="submit" value="Delete${p.getPersonId()}">
						  </div>
						
					</td>
					
					
            </tr>
            <%
        }
        %>

          
         
         </table>
        </form>
        
        <script>

			function selectRow(row) {
				// Extract data from row
				var PersonId = row.cells[0].innerText;
				var PersonName = row.cells[1].innerText;
				var ssn = row.cells[2].innerText;
				var drivingLicNo = row.cells[3].innerText;
				var birthDate = row.cells[4].innerText;
				var birthPlace = row.cells[5].innerText;

				// Set hidden input field values
				document.getElementById("PersonId").value = PersonId;
				document.getElementById("update").value = PersonId;
				
				//document.getElementById("update").value = PersonId;
				var personId = document.getElementById("PersonId").value;
	
				
			}
	
		</script>

	</div>
          
          <div><h1><br></h1></div>
	    <div class="title">
	       
	         <form action="PersonInfoController" method="post">
	         	<div class="boxnewPerson">
					<input  id="buttonSubmit" type="submit" value="  Add New Person Details  " name="addNewPersonButton" /> 
				&nbsp &nbsp &nbsp
				
				
  
					<input type="text" name="personIdUpdate" placeholder="Enter person Id to update" id="buttonUpdateInput"/> &nbsp&nbsp
					<input  id="buttonUpdate" type="submit" value=" Update  " name="updateDetails" /> 
				</div>
				<p>
				<br>
				</p>
	        </form>

	      </div>
	      


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