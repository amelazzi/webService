<%-- <%@ include file="/WEB-INF/views/includes/includes.jsp" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Demandes & Notifications">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content pt-3">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<c:url value="/home"/>"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="user.lend.request.notification"/></li>
			  </ol>
			</nav>
	    	<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="user.lend.request"/></h1>
			        <hr>
			      	 <div class="d-flex display-conten-between">
			      	 	<!-- DataTables Demande -->
				        <div class="card mb-3 col-6">
				          <div class="card-header bg-primary text-white">
				            <i class="fas fa-table"></i>
				            	<fmt:message key="request.list"/>
				            </div>
				          <div class="card-body">
				            <div class="table-responsive">
				              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				                <thead class="thead-dark">
				                  <tr>
				                    <th><fmt:message key="common.product"/></th>
				                    <th><fmt:message key="common.createdAt"/></th>
				                    <th><fmt:message key="common.status"/></th>
				                    <th><fmt:message key="common.action"/></th>
				                  </tr>
				                </thead>
				                <tfoot>
				                  <tr>
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
					                    	<a href="<c:url value="/product/${demande.getProduct().getIdProduct()}"/>">
					                    		${demande.getProduct().getTitle()}
					                    	</a>
					                    </td>
					                    <td>${demande.getCreatedAt()}</td>
					                    <td>${demande.getIsDone()}</td>
					                    <td>
					                    	<c:if test="${!demande.getIsDone()}">
					                    		<a onClick="return confirm('Confirmer vous la restitution?')"  class="btn btn-outline-dark" href="<c:url value="/demande/cancel/${demande.getIdDemande()}"/>">
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
			      	 	
			      	 	<!-- DateTable Notification -->
			      	 	<div class="card mb-3 col-6">
				          <div class="card-header bg-danger text-white">
				            <i class="fas fa-table"></i>
				            	<fmt:message key="lend.list"/>
				            </div>
				          <div class="card-body">
				            <div class="table-responsive">
				              <table class="table table-bordered" id="dataTable2" width="100%" cellspacing="0">
				                <thead class="thead-dark">
				                  <tr>
				                    <th><fmt:message key="common.product"/></th>
				                    <th><fmt:message key="notif.sendAt"/></th>
				                    <th><fmt:message key="common.msg"/></th>
				                    <th><fmt:message key="common.action"/></th>
				                  </tr>
				                </thead>
				                <tfoot>
				                  <tr>
				                    <th><fmt:message key="common.product"/></th>
				                    <th><fmt:message key="notif.sendAt"/></th>
				                    <th><fmt:message key="common.msg"/></th>
				                    <th><fmt:message key="common.action"/></th>
				                  </tr>
				                </tfoot>
				                <tbody>
				                  <c:forEach items="${notifications}" var="notif">
					                  <tr>
					                    <td>
					                    	<a href="<c:url value="/product/${notif.getDemande().getProduct().getIdProduct()}"/>">
					                    		${notif.getDemande().getProduct().getTitle()}
					                    	</a>
					                    </td>
					                    <td>${notf.getSendAt()}</td>
					                    <td>${notf.getMessage()}</td>
					                    <td>
					                    	<c:if test="${!emprunt.getIsReturned()}">
					                    		<a  class="btn btn-outline-dark" href="<c:url value="/emprunter/${notif.getDemande().getProduct().getIdProduct()}"/>">
					                    			Emprunter
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
	    	</div>
      <!-- /.container-fluid -->
	    </section>
	</jsp:attribute>
</t:template>

