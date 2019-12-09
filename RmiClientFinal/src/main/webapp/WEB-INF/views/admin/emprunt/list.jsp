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
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="lend.my"/></li>
			  </ol>
			</nav>
	    	<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="lend.my"/></h1>
			        <hr>
			      
			         <!-- DataTables Example -->
			        <div class="card mb-3">
			          <div class="card-header">
			            <i class="fas fa-table"></i>
			            	<fmt:message key="lend.list"/>
			            </div>
			          <div class="card-body">
			            <div class="table-responsive">
			              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			                <thead class="thead-dark">
			                  <tr>
			                  	<th><fmt:message key="common.firstname"/> <fmt:message key="common.firstname"/></th>
			                    <th><fmt:message key="lend.product"/></th>
			                    <th><fmt:message key="lend.createdAt"/></th>
			                    <th><fmt:message key="lend.toGiveBack"/></th>
			                    <th><fmt:message key="lend.isReturned"/></th>
			                    <th><fmt:message key="common.action"/></th>
			                  </tr>
			                </thead>
			                <tfoot>
			                  <tr>
			                  	<th><fmt:message key="common.firstname"/> <fmt:message key="common.firstname"/></th>
			                    <th><fmt:message key="lend.product"/></th>
			                    <th><fmt:message key="lend.createdAt"/></th>
			                    <th><fmt:message key="lend.toGiveBack"/></th>
			                    <th><fmt:message key="lend.isReturned"/></th>
			                    <th><fmt:message key="common.action"/></th>
			                  </tr>
			                </tfoot>
			                <tbody>
			                  <c:forEach items="${emprunts}" var="emprunt">
				                  <tr>
				                  	<td>
				                    	<a href="">
				                    		${emprunt.getUser().getFirstName()}&nbsp;${emprunt.getUser().getLastName()}
				                    	</a>
				                    </td>
				                    <td>
				                    	<a href="<c:url value="/product/${emprunt.getProduct().getIdProduct()}"/>">
				                    		${emprunt.getProduct().getTitle()}
				                    	</a>
				                    </td>
				                    <td>${emprunt.getCreatedAt()}</td>
				                    <td>${emprunt.getToGiveBackAt()}</td>
				                    <td>${emprunt.getIsReturned()}</td>
				                    <td>
				                    	<c:if test="${!emprunt.getIsReturned()}">
				                    		<a onClick="return confirm('Confirmer vous la restitution?')"  class="btn btn-outline-dark" href="<c:url value="/emprunt/restitution/${emprunt.getIdEmprunt()}"/>">
				                    			Restituer
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
	      		</div>
	    	</div>
      <!-- /.container-fluid -->
	    </section>
	</jsp:attribute>
</t:template>

