<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<nav class="col-md-2 d-md-block sidebar bg-light">
    <div class="sidebar-sticky">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link" href="${baseURL}/home">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span data-feather="home">
                    	<fmt:message key="common.dashboard"/>
                    </span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                	<i class="fas fa-book-reader"></i>
                    <span data-feather="file"></span>
                    <fmt:message key="user.lend"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                	<i class="fab fa-buffer"></i>
                    <span data-feather="shopping-cart"></span>
                    <fmt:message key="user.lend.request"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
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
			    <a class="dropdown-item" href="${baseURL}/setting/product"><fmt:message key="common.product"/></a>
			    <a class="dropdown-item" href=""><fmt:message key="user"/></a>
			    <a class="dropdown-item" href=""><fmt:message key="common.lend"/></a>
			    <a class="dropdown-item" href=""><fmt:message key="common.lend.request"/></a>
			  </div>
			</li>
        </ul>
        <img alt="" src="${baseURL}/assets/img/logo.png" class="fixed-bottom p-3" style="height:150px; width:250px;">
    </div>
</nav>