<%-- <%@ include file="/WEB-INF/views/includes/includes.jsp" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Home">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content pt-3">
	    	<nav aria-label="breadcrumb" class="">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="#"><fmt:message key="common.dashboard"/></a></li>
			  </ol>
			</nav>
			
			<div class="row">
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-primary o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-box-open fa-2x"></i>
	                </div>
	                <div class="mr-5">${products.size()} Products</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="#">
	                
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-dark o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-users fa-2x"></i>
	                </div>
	                <div class="mr-5">${users.size()} Users</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="#">
	                
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-success o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-book-reader fa-2x"></i>
	                </div>
	                <div class="mr-5">${emprunts.size()} Emprunts</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="#">
	                
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-danger o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-comments fa-2x"></i>
	                </div>
	                <div class="mr-5">${comments.size()} Comments</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="#">
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	        </div>
        
			<div class="row">
				<c:forEach var="product" items="${products}" >
					<div class="col-md-4">
			          <div class="card mb-4 shadow-sm">
			            <img class="card-img-top" src="${product.getImage()}" width="100%" height="225">
			            <div class="card-body">
			              <h5 class="card-title">${product.getTitle()}</h5>
			              <p class="card-text"><c:out value="${product.getDescription()}" /></p>
			              <div class="d-flex justify-content-between align-items-center">
			                <div class="btn-group">
			                  <c:choose>
			                  	<c:when test="${product.getQuantity()>0}">
			                  		<a href="<c:url value="/emprunter/${product.getIdProduct()}"/>" class="btn btn-sm btn-primary">
			                  			<i class="fas fa-book-reader"></i> 
			                  			<fmt:message key="common.lending"/>
			                  		</a>
			                  		<a href="" class="btn btn-sm btn-outline-secondary">
			                  			<i class="fa fa-shopping-cart"></i> <fmt:message key="common.buying"/>
			                  		</a>
			                  	</c:when>
				              	<c:otherwise>
			                  		<a href="<c:url value="/emprunter/${product.getIdProduct()}"/>" class="btn btn-sm btn-outline-primary"><i class="fab fa-buffer"></i> <fmt:message key="common.reserve"/></a>
			                  	</c:otherwise>
				              </c:choose>
			                </div>
			                <div class="btn-group">
			                	<a href="<c:url value="/product/${product.getIdProduct()}"/>" class="btn btn-sm btn-dark">+Détails</a>
			                </div>
			                
			              </div>
			            </div>
			          </div>
				     </div>
			     </c:forEach>
			</div>
	    </section>
	</jsp:attribute>
</t:template>

