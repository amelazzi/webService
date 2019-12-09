<%@ tag language="java" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ attribute name="title" required="true" rtexprvalue="true" %>
<%@ attribute name="content" fragment="true"%>
<%@ attribute name="css" fragment="true"%>
<%@ attribute name="js" fragment="true"%>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>${title}</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/dashboard/">
	
	<!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet" type="text/css">
    
    <!-- icheck bootstrap -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  
   <!-- Google Font: Source Sans Pro -->
   <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
   
   <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet">
   
   <jsp:invoke fragment="css"></jsp:invoke>
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/dashboard/dashboard.css" rel="stylesheet">
</head>

<body class="bg-gradient-light">
    <!--top-->
	<%@ include file="/WEB-INF/views/includes/navbar/top.jsp" %>
	
    <div class="container-fluid">
        <div class="row">
            <!-- menu-->
			<%@ include file="/WEB-INF/views/includes/sidebar/left.jsp" %>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4 pt-5">
                <!--content-->
                <jsp:invoke fragment="content"></jsp:invoke>
            </main>
            
        </div>
        <footer class="main-footer d-flex justify-content-center fixed-bottom">
        	<div class="">
			    <strong>Copyright &copy; Amel & Hasmiou M2-SSIO-2019 <a href="https://github.com/Hasmiou/webService">Git-Hub</a>.</strong> All rights
			    reserved.
		    </div>
		    <div class="ml-3">
		      <b>Version</b> 1.0.0
		    </div>
		</footer>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <!-- jQuery -->
	<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!-- AdminLTE App -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.4.18/js/adminlte.min.js"></script>
	
	<!-- Data Table -->
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<jsp:invoke fragment="js"></jsp:invoke>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#dataTable').DataTable();
		    $('#dataTable2').DataTable();
		} );
	</script>
	    
</body>

</html>
