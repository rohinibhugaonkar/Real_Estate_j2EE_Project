<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList"  session="true" isErrorPage="false"%>
<%@ page import = "java.util.List" %>
<%@ page import = "assignment6.person.model.Person" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.text.*"%>
<%@ page import="java.sql.*, java.text.SimpleDateFormat" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
ArrayList<Person> list_person =new ArrayList<Person>();
list_person = ( ArrayList <Person>)request.getAttribute("updatePersonData"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Person</title>
 <!-- Custom StyleSheet -->
    
     <!-- Boxicons -->
    <link
      href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"
      rel="stylesheet"
    />
    
     <link href="./css/agents.css" rel="stylesheet">
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
    
   <section class = "section rent">
    
    <div align="center">
        <h1> Update Details <br>
        <div><br></div></h1>
         <form action="PersonInfoController" method="post">
         
         	<table id="agentsAdd">
         	
  
         	
         	
         	
         	 <%
        for(int i =0 ; i< list_person.size(); i++)
        {
        	Person p = (Person) list_person.get(i); 
       
        	
        	// Format the date as YYYY-MM-DD, which is the format required by the date input type
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String formattedDate = sdf.format(p.getBirthDate());
            %>
         	 	<tr>
	          	 <td>Person Name </td>          	
	          	 <td><span class="required"></span> <textarea id="PersonName" type="text" name="PersonName" > <%= p.getPersonName() %> </textarea> </td>
	           </tr>
         	
         		<tr>
	          	 	<td>SSN </td>
	           		<td> <span class="required"></span> <textarea id="SSN" type="text" name="SSN" readonly><%= p.getSsn() %></textarea> </td>
	           	</tr>
         	
         		<tr>
	           		<td>Driving License Number</td>
	           		<td> <textarea id="driversLicenseNr" type="text" name="driversLicenseNr"><%= p.getDriversLicenseNr() %></textarea> </td>
	           	</tr>
	           
	           	<tr> 
	           		<td>Birth Date</td>
	           		<td > <input id="BirthDate" type="date" name="BirthDate" value="<%= formattedDate %>"></textarea> </td>
	           	</tr>
	           
	           	<tr>
	           		<td>Birth Place</td>
	           		<td> <textarea id="BirthPlace" type="text" name="BirthPlace"> <%= p.getBirthPlace() %></textarea> </td>
	           	</tr>
       
            <%
        }
        %>

	          
	           
	           
	           
	           
       
       
        
   		</table> 
         <div class="boxnewAgent">
         <h1><br></h1>
		<input  id="buttonSubmit" type="submit" value="  Update  " name="updateAndSave" /> 
		</div>
        </form>
        <p>
     
        </p>
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
</html>