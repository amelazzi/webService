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
			    <li class="breadcrumb-item"><a href="<c:url value="/home"/>"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item"><a href="<c:url value="/admin/user"/>"><fmt:message key="user.list"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="user.new"/></li>
			  </ol>
			</nav>
			<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="user.new"/></h1>
			        <hr>
			        <div class="container">
					    <div class="card card-register mx-auto mt-5">
					      <div class="card-header"><fmt:message key="user.create"/></div>
					      <div class="card-body">
					      	<c:url value="/admin/user/save" var ="urlSave" />
					      	<f:form action="${urlSave}" modelAttribute="user" method="POST" role="form">
					          <f:hidden path="idUser"/>
					          <div class="form-group">
					            <div class="form-row">
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="firstname"><fmt:message key="common.firstname"/></label>
					                  	<f:input path="firstName" type="text" id="firstname" class="form-control" placeholder="" required="required" />
					                </div>
					              </div>
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="lastname"><fmt:message key="common.lastname"/></label>
					                  	<f:input path="lastName" type="text" id="lastname" class="form-control" placeholder="" required="required"/>
					                </div>
					              </div>
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="email"><fmt:message key="common.email"/></label>
					                  	<f:input path="email" type="email" id="email" class="form-control" placeholder="" required="required"/>
					                </div>
					              </div>
					            </div>
					          </div>
					          <div class="form-group">
					            <div class="form-row">
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="matricule"><fmt:message key="user.matricule"/></label>
					                  	<f:input path="matricule" type="text" id="matricule" class="form-control" placeholder="" required="required" />
					                </div>
					              </div>
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="graduation"><fmt:message key="user.graduation"/></label>
					                  	<f:input path="graduate" type="text" id="graduation" class="form-control" placeholder="ex: Master 1" required="required"/>
					                </div>
					              </div>
					              <div class="col-md-4">
					                <div class="form-label-group">
					                	<label for="domain"><fmt:message key="user.domain"/></label>
					                  	<f:input path="domain" type="text" id="domain" class="form-control" placeholder="ex: SSIO or Cryptography" required="required"/>
					                </div>
					              </div>
					            </div>
					          </div>
					          <div class="form-group">
					            <div class="form-row">
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="birthday"><fmt:message key="user.birthday"/></label>
					                  	<f:input path="birthday" type="date" id="birthday" class="form-control" placeholder="" required="required" />
					                </div>
					              </div>
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="phone"><fmt:message key="user.phone"/></label>
					                  	<f:input path="phone" type="text" id="phone" class="form-control" placeholder="" required="required" />
					                </div>
					              </div>
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="status"><fmt:message key="user.status"/></label>
					                  	<select name="status" class="form-control" id="status">
									      <option value="student"><fmt:message key="user.status.student"/></option>
									      <option value="teacher"><fmt:message key="user.status.teacher"/></option>
									    </select>
					                </div>
					              </div>
					              <div class="col-md-3">
					                <div class="form-label-group">
					                	<label for="role"><fmt:message key="user.role"/></label>
					                  	<select name="role" class="form-control" id="role">
									      <option value="user"><fmt:message key="user.role.user"/></option>
									      <option value="admin"><fmt:message key="user.role.admin"/></option>
									    </select>
					                </div>
					              </div>
					            </div>
					          </div>
					          
					          <div class="d-flex justify-content-between pt-5">
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

