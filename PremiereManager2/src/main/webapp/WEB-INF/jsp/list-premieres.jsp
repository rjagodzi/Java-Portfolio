<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>List of premieres:</caption>
			<thead>
				<tr>
					<th>Premiere Name</th>
					<th>Target Date</th>
					<th>Type</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${premieres}" var="premiere">
					<tr>
						<td>${premiere.desc}</td>
						<td><fmt:formatDate value="${premiere.targetDate}" pattern="dd.MM.yyyy"/></td>
						<td>${premiere.type}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-premiere?id=${premiere.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-premiere?id=${premiere.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-premiere">Add a Premiere</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>