<%-- <%@ include file="/WEB-INF/views/includes/includes.jsp" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="List Product">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content pt-3">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="${baseURL}/home"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item"><a href="#"><fmt:message key="common.setting"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page"><fmt:message key="common.product"/></li>
			  </ol>
			</nav>
	    	<div class="row">
	    		<div class="container-fluid">
			        <!-- Page Content -->
			        <h1><fmt:message key="product.list"/></h1>
			        <hr>
			        <!-- Breadcrumbs-->
			        <ol class="breadcrumb">
			        	<c:url value="/user/new/" var="newProduct"/>
			        	<li><a href="${newProduct}">
			        		<i class="fas fa-plus"></i>
			        		<fmt:message key="product.new"/>
			        		</a>
			        	</li>
			        </ol>
			        
			         <!-- DataTables Example -->
			        <div class="card mb-3">
			          <div class="card-header">
			            <i class="fas fa-table"></i>
			            	<fmt:message key="product.list"/>
			            </div>
			          <div class="card-body">
			            <div class="table-responsive">
			              <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			                <thead class="thead-dark">
			                  <tr>
			                    <th><fmt:message key="product.title"/></th>
			                    <th><fmt:message key="product.price"/></th>
			                    <th><fmt:message key="product.available"/></th>
			                    <th><fmt:message key="common.createdat"/></th>
			                    <th><fmt:message key="common.action"/></th>
			                  </tr>
			                </thead>
			                <tfoot>
			                  <tr>
			                    <th><fmt:message key="product.title"/></th>
			                    <th><fmt:message key="product.price"/></th>
			                    <th><fmt:message key="product.available"/></th>
			                    <th><fmt:message key="common.createdat"/></th>
			                    <th><fmt:message key="common.action"/></th>
			                  </tr>
			                </tfoot>
			                <tbody>
			                  <c:forEach items="${products}" var="product">
				                  <tr>
				                    <td>${product.getTitle()}</td>
				                    <td>${product.getPrice()}</td>
				                    <td>${product.getAvailable()}</td>
				                    <td>${product.getCreatedAt()}</td>
				                    <td>
						        		<a href="" alt="Edit" title="Edit">
							        		<i class="fa fa-edit"></i>
						        		</a>&nbsp;|&nbsp;
						        		<a href="" alt="Delete" title="Delete">
							        		<i class="fa fa-trash text-danger"></i>
						        		</a>
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

