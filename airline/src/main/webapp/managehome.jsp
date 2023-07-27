<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Manager Home Page</title>

<style>
		

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;	
	font-family: Raleway, sans-serif;
}

body {

	
	background: linear-gradient(to top right, #000066 0%, #ccccff 62%);
}

.container {
	display: flex;
	align-items: center;
	justify-content: center;
	min-height: 100vh;
}

.screen {		
	background: linear-gradient(90deg, #5D54A4, #7C78B8);		
	position: relative;	
	height: 600px;
	width: 360px;	
	box-shadow: 0px 0px 24px #5C5696;
}

.screen__content {
	z-index: 1;
	position: relative;	
	height: 100%;
}

.screen__background {		
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	z-index: 0;
	-webkit-clip-path: inset(0 0 0 0);
	clip-path: inset(0 0 0 0);	
}

.screen__background__shape {
	transform: rotate(45deg);
	position: absolute;
}

.screen__background__shape1 {
	height: 520px;
	width: 520px;
	background: #FFF;	
	top: -50px;
	right: 120px;	
	border-radius: 0 72px 0 0;
}

.screen__background__shape2 {
	height: 220px;
	width: 220px;
	background: #6C63AC;	
	top: -172px;
	right: 0;	
	border-radius: 32px;
}
.ss{
   
   margin-left:450px;
	font-size: 36px;
	color:#000099  ;
	font-family:"georgia",serif;
	 margin-bottom: 50x;
}
.ss{
   
   margin-left:450px;
	font-size: 36px;
	color:#000000  ;
	font-family:"georgia",serif;
}
.sss{
   
   margin-left:450px;
 margin-bottom: 50px;
}

.cccc {
  display: inline-block;
  border-radius: 10px;
  background-color:  #000000;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 60px;
  width: 500px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 10px;
}

.cccc span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.cccc span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.cccc:hover span {
  padding-right: 25px;
}

.cccc:hover span:after {
  opacity: 1;
  right: 0;
}
.image{
    float: left;
  }

  .logo{
    font-family: Georgia;
    color: #000000;
    font-weight: 900;
    font-size: 45px;
    padding: 8px;
    margin-top: 10px;
    margin-left: 10px;
  }

  .loginbtn{
    padding: 10px;
    position: relative;
    border-radius: 10px;
    border-style: none;
    font-family: 'Arvo', serif;
    font-size: 18px;
    background-color: #D2B4DE;
  }

  .nav{
    width:100%;
    background-image: linear-gradient(to right, #00BFFF, #000066);
    height: 150px;
  }
  
  .qqq {
  background-color: #000000; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
    margin-left:650px;
}
	</style>
	
</head>
<body>
	<section>
         <div class = "nav">
            <ul>
              
                  <li class = "logo">ONE WORLD AIRLINE</li>
                 
                  
            </ul>
         </div>
      </section>
      
			<div class ="ss">
				 <h1>MANAGER DASHBOARD</h1><br><br><br>
			</div>
	     
	   <div class ="sss">
	     <form action ="calculate" method = "Get">
	     
	      <a href="/airline/CalEmployee" class="SalaryInsert" ><button  class="cccc"><span>Insert Sallary Details For Employee</span></button></a><br><br>
	      
	      
	     
	     </form>
	     
	      <form action ="view-sallary" method = "Get">
	     
	      <a href="/airline/ViewSallary" class="SalaryInsert" ><button class="cccc" ><span>View Sallary details for Employee</span></button></a>
	       </form>
	      </div> 
	       <form action="logout" method="post">
	       				
	       				<div class="qqq">
	       				
					<button type="submit" name="submit" >Logout</button>
					</div>
	
</form>

</body>
</html>

