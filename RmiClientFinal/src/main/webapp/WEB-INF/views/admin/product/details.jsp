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
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="common.product"/></li>
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
						<h3 class="product-title">${product.getTitle()}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
								<font class="badge badge-pill badge-secondary">3,7</font>
								<form action="<c:url value="/rating"/>" method="post">
									<input name="idProduct" type="hidden" value="${product.getIdProduct()}">
									<select name="rateValue">
										<c:forEach var="i" begin="1" end="5" step="1">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
									<button class="btn btn-outline-dark" type="submit">Voter</button>
								</form>
							</div>
							<span class="review-no">${comments.size()} commentaire(s)</span>
						</div>
						<p class="product-description">
							${product.getDescription()}
						</p>
						<h4 class="price"><fmt:message key="product.price"/> <span>${product.getPrice()}</span></h4>
					
						<div class="action">
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
							<!--<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>-->
						</div>
					</div>
				</div>
	    	<!-- /Details -->
	    	<div class="divider"></div>
	    	<!-- Comment -->
	    	<div class="row pb-5">
			    <div class='col-8 pt-5'>
			    	<div class="d-flex justify-content-between">
			    		<p class="h2">Avis</p>
			    		<a class="btn btn-outline-secondary" href="#addComment">Ajouter un avis</a>
			    	</div>
			    	<c:forEach var="avis" items="${comments}">
						 <div class="media comment-box mt-3">
				            <div class="media-left mr-4">
				                <a href="#">
				                    <img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
				                </a>
				            </div>
				            <div class="media-body">
				                <h4 class="media-heading">${avis.getUser().getFirstName()}</h4>
				               	<p>${avis.getContent()}</p>
				            </div>
		        		</div>
	        		</c:forEach>
	        		<div class="col-12 pt-5" id="addComment">
	        			<hr>
	        			<h4><fmt:message key="common.new"/></h4>
			        	<div>
			        	<c:url value="/comment/add" var="urlComment"/>
			        		<f:form action="${urlComment}" method="POST" modelAttribute="comment">
			       				<input name="idProduct" type="hidden" value="${product.getIdProduct()}">
			       				<input name="idUser" type="hidden" value="${user.getIdUser()}">
			        			<div class="form-group">
						            <div class="form-group">
						        		<textarea name="content" class="form-control" rows="5" required="required"></textarea>
					        		</div>
					        	</div>
					        	<div class="d-flex justify-content-end">
					        		<button class="btn btn-secondary btn-sm-4"><fmt:message key="common.save"/></button>
					        	</div>
			        		</f:form>
			        	</div>
	        		</div>
				</div>
			</div>
	    	<!-- EndComment -->
	    </section>
	</jsp:attribute>
</t:template>

