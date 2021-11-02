<%@ include file="common/header.jspf" %>											<!-- header -->
<%@ include file="common/navigation.jspf" %>										<!-- navigation bar -->
<div class="container">
	<form:form method="post" modelAttribute="premiere">								<!-- a field for entering the name of a premiere -->
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">												<!-- a field for entering the date of a premiere -->
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">												<!-- three radio buttons which enable the user to choose a premier's type -->
			<form:radiobutton path="type" value="Movie" required="required" /> Movie
			<p></p>
			<form:radiobutton path="type" value="Book" required="required" /> Book
			<p></p>
			<form:radiobutton path="type" value="Game" required="required" /> Game
			<form:errors path="type" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Add</button>					<!-- a button which enables the user to submit a premiere -->
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>