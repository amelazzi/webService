<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:template title="Profil">
	<jsp:attribute name="content">
	    <!-- Main content -->
	    <section class="content">
	    	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<c:url value="/home/user/profil"/>"><fmt:message key="common.dashboard"/></a></li>
			    <li class="breadcrumb-item active" aria-current="page">Library</li>
			  </ol>
			</nav>
			<div class="row">
				<div class="col-sm-4">
					<div style="background-color:pink; height: 18rem">
						<img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png" style="width: 100%; height:100%;object-fit: cover" />
					</div>
		
				</div>
				<div class="col-sm-6">
					<div style="margin-top: 16px; display: flex;">
						<h1>${user.getFirstName()}</h1>
						<h1 style="margin-left: 16px">${user.getLastName()}</h1>
					</div>
					<h5 style="color:#3F3F3F"> ${user.getDomain()} | ${user.getStatus()} | ${user.getGraduate()}</h5>
					<h5 style="color:#3F3F3F"> <i class="fas fa-envelope" style="margin-right: 8px"></i>${user.getEmail()} </h5>
					<h5 style="color:#3F3F3F"> <i class="fas fa-phone-alt" style="margin-right: 8px"></i>${user.getPhone()} </h5>
					<h6 style="color:#3F3F3F"> Empreunts: ${user.getEmprunts().size()} </h6>
					<h6 style="color:#3F3F3F"> Demandes en attente: ${user.getDemandes().size()} </h6>
					<button class="btn btn-primary" type="submit"><i class="fa fa-edit"> Edit Profil</i></button>
				
				</div>
				
			</div>
		
	    </section>
	</jsp:attribute>
</t:template>

