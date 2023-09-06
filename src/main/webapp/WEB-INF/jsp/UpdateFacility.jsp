<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateFacility</title>
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>


<!-- jQuery Form Validation code -->
<script>
	// When the browser is ready...
	$(function() {

		// Setup form validation on the #register-form element
		$("#update-form").validate({

			// Specify the validation rules
			rules : {
				f_name : "required",
				f_addr1 : "required",
				f_addr2 : "required",
				f_zip : {
					required : true,
					minlength : 6,
					maxlength : 6,
					number : true
				},
				f_state : "required",
				f_country : "required",
			},

			// Specify the validation error messages
			messages : {
				f_name : "Please enter your facility name",
				f_addr1 : "Please enter address line one",
				f_addr2 : "Please enter address line two",
				f_zip : "Please enter correct ZIPCODE",
				f_state : "Please enter state",
				f_country : "Please enter country",
			},

			submitHandler : function(updateFacility) {
				updateFacility.submit();
			}
		});

	});
</script>


</head>
<body>

<a href="logout.do">LogOut</a>

	<form name="updateFacility" action="updateFacility.do" method="post"
		id="update-form">
	<input type="hidden" id="f_id" name="f_id" value="${dto.f_id}" />
		<table>
			<tr>
				<td>
					<p style="color: blue">Update Facility Form</p>
				</td>
			</tr>

			<tr>
				<td>Facility Name:</td>
				<td><input type="text" name="f_name" id="f_name"
					value="${dto.f_name}"></td>
			</tr>
			<br>

			<tr>
				<td>Facility Address Line 1:</td>
				<td><input type="text" name="f_addr1" id="f_addr1"
					value="${dto.f_addr1}"></td>
			</tr>
			<br>

			<tr>
				<td>Facility Address Line 2:</td>
				<td><input type="text" name="f_addr2" id="f_addr2"
					value="${dto.f_addr2}"></td>
			</tr>
			<br>

			<tr>
				<td>Facility Zip</td>
				<td><input type="number" name="f_zip" id="f_zip"
					value="${dto.f_zip}"></td>
			</tr>
			<br>


			<tr>
				<td>Facility State:</td>
				<td><input type="text" name="f_state" id="f_state"
					value="${dto.f_state}"></td>
			</tr>
			<br>

			<tr>
				<td>Facilty Country:</td>
				<td><input type="text" name="f_country" id="f_country"
					value="${dto.f_country}"></td>
			</tr>
			<br>

			<%-- <tr>
				<td>Company ID:</td>
				<td><input type="number" name="c_id" id="c_id"
					value="${dto.c_id}"></td>
			</tr>

 --%>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>
	</form>



</body>
</html>