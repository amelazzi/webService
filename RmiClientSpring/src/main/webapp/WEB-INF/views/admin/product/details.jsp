<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
					<div class="preview col-md-6">
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="http://placekitten.com/400/252" width="100%"/></div>
						</div>
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">${product.getTitle()}</h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							<span class="review-no">41 reviews</span>
						</div>
						<p class="product-description">
							${product.getDescription()}
						</p>
						<h4 class="price"><fmt:message key="product.price"/> <span>${product.getPrice()}</span></h4>
						<!-- <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>  -->
						<!-- <h5 class="sizes">sizes:
							<span class="size" data-toggle="tooltip" title="small">s</span>
							<span class="size" data-toggle="tooltip" title="medium">m</span>
							<span class="size" data-toggle="tooltip" title="large">l</span>
							<span class="size" data-toggle="tooltip" title="xtra large">xl</span>
						</h5>
						<h5 class="colors">colors:
							<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
							<span class="color green"></span>
							<span class="color blue"></span>
						</h5>-->
						<div class="action">
							<c:choose>
			                  	<c:when test="${product.getQuantity()>0}">
			                  		<a href="" class="btn btn-sm btn-primary">
			                  			<i class="fas fa-book-reader"></i> 
			                  		<fmt:message key="common.lending"/></a>
			                  		<a href="" class="btn btn-sm btn-outline-secondary">
			                  			<i class="fa fa-shopping-cart"></i> <fmt:message key="common.buying"/>
			                  		</a>
			                  	</c:when>
				              	<c:otherwise>
			                  		<a href="" class="btn btn-sm btn-outline-primary"><i class="fab fa-buffer"></i> <fmt:message key="common.reserve"/></a>
			                  	</c:otherwise>
				            </c:choose>
							<!--<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>-->
						</div>
					</div>
				</div>
	    	<!-- /Details -->
	    	<div class="divider"></div>
	    	<!-- Comment -->
	    	<div class="row">
			    <div class='col-8 pt-5'>
			    	<p class="h2">Avis</p>
					 <div class="media comment-box">
			            <div class="media-left mr-4">
			                <a href="#">
			                    <img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
			                </a>
			            </div>
			            <div class="media-body">
			                <h4 class="media-heading">Azar Hank</h4>
			                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
			              
			            </div>
	        		</div>
				</div>
			</div>
	    	<!-- EndComment -->
	    </section>
	</jsp:attribute>
</t:template>

