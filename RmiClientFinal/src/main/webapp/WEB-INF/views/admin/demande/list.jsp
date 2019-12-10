<%-- <%@ include file="/WEB-INF/views/includes/includes.jsp" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="List emprunt">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content pt-3">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<c:url value="/home"/>"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item"><a href="#"><fmt:message key="common.setting"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="request.list"/></li>
			  </ol>
			</nav>
	    	<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="request.list"/></h1>
			        <hr>
			      	 	<!-- DataTables Demande -->
				        <div class="card mb-3">
				          <div class="card-header bg-primary text-white">
				            <i class="fas fa-table"></i>
				            	<fmt:message key="request.list"/>
				            </div>
				          <div class="card-body">
				            <div class="table-responsive">
				              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				                <thead class="thead-dark">
				                  <tr>
				                  	<th><fmt:message key="user"/></th>
				                    <th><fmt:message key="common.product"/></th>
				                    <th><fmt:message key="common.createdAt"/></th>
				                    <th><fmt:message key="common.status"/></th>
				                    <th><fmt:message key="common.action"/></th>
				                  </tr>
				                </thead>
				                <tfoot>
				                  <tr>
				                  	<th><fmt:message key="user"/></th>
				                    <th><fmt:message key="common.product"/></th>
				                    <th><fmt:message key="common.createdAt"/></th>
				                    <th><fmt:message key="common.status"/></th>
				                    <th><fmt:message key="common.action"/></th>
				                  </tr>
				                </tfoot>
				                <tbody>
				                  <c:forEach items="${demandes}" var="demande">
					                  <tr>
					                  	<td>
					                    	<a href="<c:url value="/product/${demande.getUser().getIdUser()}"/>">
					                    		${demande.getUser().getFirstName()} ${demande.getUser().getLastName()}
					                    	</a>
					                    </td>
					                    <td>
					                    	<a href="<c:url value="/product/${demande.getProduct().getIdProduct()}"/>">
					                    		${demande.getProduct().getTitle()}
					                    	</a>
					                    </td>
					                    <td>${demande.getCreatedAt()}</td>
					                    <td>${demande.getIsDone()}</td>
					                    <td>
					                    	<c:if test="${!demande.getIsDone()}">
					                    		<a onClick="return confirm('Confirmer vous l'annulation?')"  class="btn btn-outline-dark" href="<c:url value="/demande/cancel/${demande.getIdDemande()}"/>">
					                    			Annuler
					                    		</a>
					                    	</c:if>
					                    </td>
					                  </tr>
				                  </c:forEach>
				                </tbody>
				              </table>
				            </div>
				          </div>
				        </div>
			      	 	
				    <!-- End Date Tables -->
	      		</div>
	    	</div>
      <!-- /.container-fluid -->
	    </section>
	</jsp:attribute>
</t:template>

