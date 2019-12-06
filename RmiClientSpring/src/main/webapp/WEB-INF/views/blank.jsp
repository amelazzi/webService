<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Blank Page">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<c:url value="/home"/>">Home</a></li>
			    <li class="breadcrumb-item active" aria-current="page">Library</li>
			  </ol>
			</nav>
			<div class="row">
				<h1>Blank page</h1>
			</div>
		
	    </section>
	</jsp:attribute>
</t:template>

