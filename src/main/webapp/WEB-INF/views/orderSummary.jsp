<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
       <%-- <h3><a href="${pageContext.servletContext.contextPath}/downloadPDF">Download PDF Document</a></h3> --%>
       		<form:form method="POST"
		action="downloadPDF"
		modelAttribute="orderConfirmation">
				<c:forEach
					items="${orderConfirmation.personListContainer.productList}"
					var="Person" varStatus="i" begin="0">
					<tr class="person">
						<form:hidden path="personListContainer.productList[${i.index}].productName"/>
						<form:hidden path="personListContainer.productList[${i.index}].productId"/>
						<form:hidden path="personListContainer.productList[${i.index}].quantity"/>
						<form:hidden path="personListContainer.productList[${i.index}].price"/>
						<br><form:hidden path="total"/>
					</tr>
				</c:forEach>
       		<form:button>Download PDF Document</form:button>
       </form:form>