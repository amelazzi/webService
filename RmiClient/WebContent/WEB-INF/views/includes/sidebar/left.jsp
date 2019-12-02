<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<nav class="col-md-2 d-none d-md-block sidebar">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
            	<c:url value="/home" var="home"/>
                <a class="nav-link" href="home">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span data-feather="home">
                    	<fmt:message key="common.dashboard"/>
                    </span>
                </a>
            </li>
            <li class="nav-item">
            	<c:url value="/emprunt" var="emprunt"/>
                <a class="nav-link" href="#">
                	<i class="fas fa-book-reader"></i>
                    <span data-feather="file"></span>
                    <fmt:message key="user.lend"/>
                </a>
            </li>
            <li class="nav-item">
            	<c:url value="/demande" var="demand"/>
                <a class="nav-link" href="#">
                	<i class="fab fa-buffer"></i>
                    <span data-feather="shopping-cart"></span>
                    <fmt:message key="user.lend.request"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                	<c:url value="/achat" var="achat"/>
                	<i class="fa fa-shopping-cart"></i>
                    <span data-feather="shopping-cart"></span>
                    <fmt:message key="user.buy"/>
                </a>
            </li>

		    <li class="nav-item dropdown">
			  <a class="dropdown-toggle nav-link" href="#" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    <i class="fas fa-tools"></i>
			    <fmt:message key="common.setting"/>
			  </a>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
			  	<c:url value="/setting/product" var="settingProduct"/>
			    <a class="dropdown-item" href="product"><fmt:message key="common.product"/></a>
			    <c:url value="/setting/user" var="settingUser"/>
			    <a class="dropdown-item" href=""><fmt:message key="user"/></a>
			    <c:url value="/setting/emprunt" var="settingEmprunt"/>
			    <a class="dropdown-item" href="settingEmprunt"><fmt:message key="common.lend"/></a>
			    <c:url value="/setting/demand" var="settingDemand"/>
			    <a class="dropdown-item" href=""><fmt:message key="common.lend.request"/></a>
			  </div>
			</li>
            
        </ul>
    </div>
</nav>