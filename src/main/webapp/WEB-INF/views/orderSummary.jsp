<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  <title>Invoice Details</title>
       <%-- <h3><a href="${pageContext.servletContext.contextPath}/downloadPDF">Download PDF Document</a></h3> --%>
       		<form:form method="POST"
		action="downloadPDF"
		modelAttribute="orderConfirmation">
		<table>
			<thead>
				<tr>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					items="${orderConfirmation.personListContainer.productList}"
					var="Person" varStatus="i" begin="0">
					<tr class="person">
						<td>${Person.productName}</td><form:hidden path="personListContainer.productList[${i.index}].productName"/>
						<td>${Person.productId}</td><form:hidden path="personListContainer.productList[${i.index}].productId"/>
						<td>${Person.quantity}</td><form:hidden path="personListContainer.productList[${i.index}].quantity"/>
						<td>${Person.price}</td><form:hidden path="personListContainer.productList[${i.index}].price"/>
						<br><form:hidden path="total"/>
					</tr>
				</c:forEach>
				</tbody>
				</table>
				<h5>Total: ${orderConfirmation.total}</h5>
       		<form:button id="downloadPDF">Download PDF Document</form:button>
       </form:form>
<button id="printPage" onclick="myFunction()">Print this page</button>

<script>
function myFunction() {
	var printButton = document.getElementById("printPage");
    //Set the print button visibility to 'hidden' 
    printButton.style.visibility = 'hidden';
    var pdfButton = document.getElementById("downloadPDF");
    //Set the print button visibility to 'hidden' 
    pdfButton.style.visibility = 'hidden';
    window.print();
    printButton.style.visibility = 'visible';
    pdfButton.style.visibility = 'visible';
}
</script>