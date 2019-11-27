 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <nav class="navbar navbar-expand navbar-dark bg-dark static-top d-flex justify-content-between">
        <!-- <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">WebService | RMI</a>-->
        <a class="mr-0 text-light h3" href="">WebService | Rmi</a>
        
        <ul class="navbar-nav ml-auto ml-md-0">
          <li class="nav-item dropdown no-arrow mx-1">
	        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          
	          <i class="fas fa-globe-africa"></i>
	        </a>
	        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
	        	<c:url value="/langue?l=fr_FR" var="fr"/>
	        	<c:url value="/langue?l=en_US" var="en"/>
	          <a class="dropdown-item" href="${fr}">Fr: Français</a>
	          <a class="dropdown-item" href="${en}">En: English</a>
	        </div>
	      </li>
	      
	      <li class="nav-item dropdown no-arrow">
	        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          <i class="fas fa-user-circle fa-fw"></i>
	        </a>
	        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
	          <a class="dropdown-item" href="#">Profil</a>
	          <div class="dropdown-divider"></div>
	          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
	        </div>
	      </li>
	    </ul>
    </nav>