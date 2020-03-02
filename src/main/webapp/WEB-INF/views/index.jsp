<%@page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html; ISO-8859-1" isELIgnored="false"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1css/bootstrap.min.css">  

</head>
<body>

<div class="container" align="center">

<h2> News Application</h2>

<form  name=form method=POST action="saveNews" modelAttribute="news">
 
    <div class="form-group">  
      <label class="control-label col-sm-2" for="title">News Id :</label>  
      <div class="col-sm-10">  
        <input type="text" class="form-control"   name="newsId" placeholder="Enter news Id">  
      </div>  
    </div>   
    
    <div class="form-group">  
      <label class="control-label col-sm-2" for="title">News Title :</label>  
      <div class="col-sm-10">  
        <input type="text" class="form-control"   name="title" placeholder="Enter News Title">  
      </div>  
    </div>   
    
    <div class="form-group">  
      <label class="control-label col-sm-2" for="titel">Author Name :</label>  
      <div class="col-sm-10">  
        <input type="text" class="form-control" name="author" placeholder="Enter News Author">  
      </div>  
    </div> 
     
   <div class="form-group">  
      <label class="control-label col-sm-2" for="title">News Description :</label>  
      <div class="col-sm-10">  
        <input type="text" class="form-control" name="description" placeholder="Enter News Description">  
      </div>  
    </div> 
    
    <div class="form-group">  
      <label class="control-label col-sm-2" for="titel">News Content :</label>  
      <div class="col-sm-10">  
        <input type="text" class="form-control"  name="content" placeholder="Enter News Content">  
      </div>  
    </div> 

  <button type="submit" class="btn btn-success">Add News</button>  

</form>

<h4>News Details</h4>

<div>
 <table class="table" border="2">
		<tr style="font-weight: bold">
			<td>NewsId</td>
			<td>Title</td>
			<td>Author Name</td>
			<td>News Description</td>
			<td>News Content </td>
			<td>Published At </td>
			<td>Action </td>
		</tr>
		
		<c:forEach var="allNews" items="${newsList}">
			<tr>
				<td>${allNews.newsId}</td>
				<td>${allNews.title}</td>
				<td>${allNews.author}</td>
				<td>${allNews.description}</td>
				<td>${allNews.content}</td>
				<td>${allNews.publishedAt}</td>
			
				<td><a href="deleteNews?newsId=${allNews.newsId}">Delete</a>
				
			</tr>
			
		</c:forEach>
	</table>
	</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>  

	<!-- Create a form which will have text boxes for News ID, title, author,description, content
		 along with a Send button. Handle errors like empty fields -->

	<!-- display all existing news in a tabular structure with News ID, title, author,description,content
		publishedAt and Action(delete button) -->
</body>
</html>