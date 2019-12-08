<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Detail produit">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<c:url value="/home"/>"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="common.lending"/></li>
			  </ol>
			</nav>
			<!-- Details -->
			<div class="wrapper row">
					<div class="preview col-md-8">
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="${product.getImage()}" width="100%"/></div>
						</div>
					</div>
					<div class="details col-md-4">
						<h3 class="product-title display-4">${product.getTitle()}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews </span>
						</div>
						<p class="product-description">
							${product.getDescription()}
						</p>
						<h5 class="price"><fmt:message key="product.price"/> <span>${product.getPrice()}</span></h5>
						<h5 class="detail"><fmt:message key="lend.detail"/></h5>
						<div class="h6" >
							<span><fmt:message key="lend.toGiveBack"/>&nbsp;</span>
							<span class="font-weight-light">${emprunt.getToGiveBackAt()}</span>
						</div>
						<div class="h6"><span><fmt:message key="user"/></span>: <br>
							<i class="far fa-user"></i> <span class="font-weight-light">${user.getFirstName()} ${user.getLastName()}</span><br>
							<i class="far fa-envelope"></i> <span class="font-weight-light">${user.getEmail()}</span><br>
							<i class="fas fa-phone-alt"></i> <span class="font-weight-light">${user.getPhone()}</span><br>  
							<i class="fas fa-id-card-alt"></i> <span class="font-weight-light">${user.getMatricule()}</span><br>    
						</div>
						<div class="divider"></div>
						<div class="action">
							<c:choose>
			                  	<c:when test="${product.getQuantity()>0}">
			                  		<c:url value="/emprunt/save" var ="urlSave" />
				                  	<f:form modelAttribute="emprunt" action="${urlSave}" method="post">
				                  		<f:hidden path="user"/>
										<f:hidden path="product"/>
				                  		<button class="btn btn-sm btn-primary">
			                  				<i class="fas fa-book-reader"></i> 
			                  				<fmt:message key="common.validate"/>
			                  			</button>
				                  	</f:form>
			                  	</c:when>
				              	<c:otherwise>
			                  		<a href="" class="btn btn-sm btn-outline-primary"><i class="fab fa-buffer"></i> <fmt:message key="common.reserve"/></a>
			                  	</c:otherwise>
				            </c:choose>
						</div>
					</div>
				</div>
	    	<!-- /Details -->
	    	<div class="divider"></div>
	    	
	    </section>
	</jsp:attribute>
</t:template>

