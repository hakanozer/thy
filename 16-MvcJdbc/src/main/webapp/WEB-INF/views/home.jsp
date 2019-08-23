<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    	<meta charset="UTF-8">
        <title>Insert title here</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
 
 <script>
	function alert() {
		var answer = confirm("Silmek istediğinizden emin misiniz ?");
		return answer;
	}
 </script>
    
    
    <body>
    	<div class="container">
			
			<div class="row">
				<div class="col-sm-4">
					<h1>Product Add</h1>
					<c:if test="${not empty param.error }">
						<div class="alert alert-warning alert-dismissible fade show" role="alert">
						  <strong>Hata!</strong>${param.error}
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
					</c:if>
					
					<c:if test="${ empty pr }">
					<form action='<s:url value="/addProduct"></s:url>'  method=post>
						<div class="form-group"><input name="ptitle" type="text" placeholder="Title" class="form-control form-control-lg" /></div>
						<div class="form-group"><input name="pdesc"  type="text" placeholder="Desc" class="form-control form-control-lg" /></div>
						<div class="form-group"><input name="pprice" type="number" required="required" step="any" placeholder="Price" class="form-control form-control-lg" /></div>
						<div class="form-group"><input name="pphoto"  type="text" placeholder="Photo URL" class="form-control form-control-lg" /></div>
						<div class="form-group"><input type="submit" class="btn btn-success btn-lg" value="Save"></div>
					</form>
					</c:if>
					
					<c:if test="${ not empty pr }">
					<form action='<s:url value="/updateProduct"></s:url>'  method=post>
						<div class="form-group"><input value="${pr.ptitle }" name="ptitle" type="text" placeholder="Title" class="form-control form-control-lg" /></div>
						<div class="form-group"><input value="${pr.pdesc }" name="pdesc"  type="text" placeholder="Desc" class="form-control form-control-lg" /></div>
						<div class="form-group"><input value="${pr.pprice }" name="pprice" type="number" step="any" required="required"  placeholder="Price" class="form-control form-control-lg" /></div>
						<div class="form-group"><input value="${pr.pphoto }" name="pphoto"  type="text" placeholder="Photo URL" class="form-control form-control-lg" /></div>
						<div class="form-group"><input type="submit" class="btn btn-success btn-lg" value="Update"></div>
					</form>
					</c:if>
					
					
				</div>
				<div class="col-sm-8">
					<h1>Product List</h1>
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Title</th>
					      <th scope="col">Desc</th>
					      <th scope="col">Price</th>
					      <th scope="col">Photo</th>
					      <th scope="col">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  
					  <c:if test="${not empty ls }">
					  	<c:forEach items="${ls }" var="item">
						    <tr>
						      <td>${item.ptitle }</td>
						      <td>${item.pdesc }</td>
						      <td>${item.pprice }</td>
						      <td>
						      	<img src="${item.pphoto }" class="img-thumbnail" style="width: 80px; height: 80px">
						      </td>
						      <td>
						      	<a onclick="return alert();" href='<s:url value="/deleteItem/${item.pid }"></s:url>' class="btn btn-danger" >Delete</a>
						      	<a href='<s:url value="/updateItem/${item.pid }"></s:url>' class="btn btn-info" >Update</a>
						      </td>
						      
						    </tr>
					    </c:forEach>
					   </c:if>
					    
					  </tbody>
					</table>
				</div>
			</div>
			
        </div>
	</body>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</html>