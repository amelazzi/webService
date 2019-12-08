<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Persistence product">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/home"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/setting/product"><fmt:message key="product.list"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="product.new"/></li>
			  </ol>
			</nav>
			<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="product.new"/></h1>
			        <hr>
			        <div class="container">
					    <div class="card card-register mx-auto mt-5">
					      <div class="card-header"><fmt:message key="product.create"/></div>
					      <div class="card-body">
					      	<c:url value="/admin/product/save" var ="urlSave" />
					      	<f:form action="${urlSave}" modelAttribute="product" method="POST" role="form" enctype="multipart/form-data">
					          <f:hidden path="idProduct"/>
					          <f:hidden path="image"/>
					          <div class="form-group">
					            <div class="form-row">
					              <div class="col-md-6">
					                <div class="form-label-group">
					                	<label for="title"><fmt:message key="product.title"/></label>
					                  	<f:input path="title" type="text" id="title" class="form-control" placeholder="Titre" required="required" />
					                </div>
					              </div>
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="price"><fmt:message key="product.price"/></label>
					                  	<f:input path="price" type="number" id="price" class="form-control" placeholder="" required="required"/>
					                </div>
					              </div>
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="price"><fmt:message key="product.quantity"/></label>
					                  	<f:input path="quantity" type="number" id="quantity" class="form-control" placeholder="" required="required"/>
					                </div>
					              </div>
					            </div>
					          </div>
					          <div class="form-group">
					            <div class="form-label-group">
					              	<label for="description"><fmt:message key="product.description"/></label>
    								<f:textarea path="description"  class="form-control" id="description" rows="3" placeholder="" required="required"/>
					            </div>
					          </div>
					          <div class="form-group">
					            <div class="form-row">
					              <div class="col-md-6">
					                <div class="form-label-group">
					                	<label for="available"><fmt:message key="product.available"/></label>
					                  	<select name="available" class="form-control" id="available">
									      <option value="1"><fmt:message key="common.yes"/></option>
									      <option value="0"><fmt:message key="common.no"/></option>
									    </select>
					                </div>
					              </div>
					              <div class="col-md-6">
					                <div class="form-label-group">
					                	<label for="photo"><fmt:message key="common.image"/></label>
					                  	<input name="photo" type="file" id="photo" class="form-control" placeholder="Photo Couverture"/>
					                </div>
					              </div>
					            </div>
					          </div>
					          <div class="d-flex justify-content-between">
					          	<a class="btn btn-danger btn-6" href="<c:url value="/admin/product"/>" tabindex= -1><fmt:message key="common.cancel"/></a>
					          	<button class="btn btn-primary" type="submit"><i class="fa fa-save">&nbsp;</i><fmt:message key="common.save"/></button>
					          </div>
					        </f:form>	
					      </div>
					    </div>
					 </div>
				</div>
			</div>
	    </section>
	</jsp:attribute>
</t:template>

