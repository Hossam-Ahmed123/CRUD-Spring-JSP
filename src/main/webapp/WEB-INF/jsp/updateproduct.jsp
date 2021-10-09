<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot JSP CRUD</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>

	<div class="container">
		<spring:url value="/updatePro" var="saveURL" />
		<h2>
			Edit Product
			<spring:url value="/cancelInsertOrUpdate" var="cancelURL" />
			<a class="btn btn-primary" href="${cancelURL}" role="button">Cancel</a>
		</h2>
		<form:form modelAttribute="itemForm" method="post" action="${saveURL}"
			cssClass="form">



			<form:hidden path="id" />
			<div class="form-group">
				<label>Product Name</label>
				<form:input path="name" cssClass="form-control" id="nome" />
			</div>
			<div class="form-group">
				<label>Category</label>
				<form:input path="category" cssClass="form-control" id="category" />
			</div>
			<div class="form-group">
				<label>Description</label>
				<form:input path="description" cssClass="form-control"
					id="description" />
			</div>

			<div class="form-group">
				<label>Price</label>
				<form:input path="price" cssClass="form-control" id="price" />
			</div>
			<div class="form-group">
				<label>Quantity</label>
				<form:input path="quantity" cssClass="form-control" id="quantity" />
			</div>
			<div class="form-group">
				<label>Rate</label>
				<form:input path="rating" cssClass="form-control" id="rating" />
			</div>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>

</body>
</html>