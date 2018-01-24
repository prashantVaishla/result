<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <script src="js/dynamic_list_helper2.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Person List</h3>
        <div style="border:1px solid #eaeaea;padding:20px;width:400px">
            ${message}
        </div>
        <form:form action="${cp}/editpersonlistcontainer" modelAttribute="personListContainer" method="post" id="personListForm">
            <table>
                <thead>
                    <tr>
                        <th>ProductId</th>
                        <th>ProductName</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody id="personListContainer">
                    <c:forEach items="${personListContainer.productList}" var="Person" varStatus="i" begin="0" >
                        <tr class="person">    
                            <td><form:input path="productList[${i.index}].productName" id="productName${i.index}" /></td>
                            <td><form:input path="productList[${i.index}].productId" id="productId${i.index}" /></td>
                            <td><form:input path="productList[${i.index}].quantity" id="quantity${i.index}" /></td>
                            <td><form:input path="productList[${i.index}].price" id="price${i.index}" /></td>
                            <%--
                            <td><input type="text" name="personList[].name" value="${Person.name}" /></td>
                            <td><input type="text" name="personList[].age" value="${Person.age}" /></td>
                            --%>
                            <td><a href="#" class="removePerson">Remove Person</a></td>
                        </tr>
                    </c:forEach>
                    <%-- 
                        IMPORTANT 
                        There must always be one row.
                        This is to allow the JavaScript to clone the row.
                        If there is no row at all, it cannot possibly add a new row.
 
                        If this 'default row' is undesirable 
                            remove it by adding the class 'defaultRow' to the row
                        I.e. in this case, class="person" represents the row.
                        Add the class 'defaultRow' to have the row removed.
                        This may seem weird but it's necessary because 
                        a row (at least one) must exist in order for the JS to be able clone it.
                        <tr class="person"> : The row will be present
                        <tr class="person defaultRow"> : The row will not be present
                    --%>
                    <c:if test="${fn:length(personListContainer.productList) == 0}">
                        <tr class="person defaultRow">    
                            <td><input type="text" name="productList[].productName" value="" /></td>
                            <td><input type="text" name="productList[].productId" value="" /></td>
                            <td><input type="text" name="productList[].quantity" value="" /></td>
                            <td><input type="text" name="productList[].price" value="" /></td>
 
                            <td><a href="#" class="removePerson">Remove Person</a></td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <input type="submit" value="Save" id="submit" />&nbsp;&nbsp;
            <a href="#" id="addPerson">Add Person</a>&nbsp;&nbsp;
            <a href="?f=">Reset List</a>
        </form:form>
 
        <script type="text/javascript">
            function rowAdded(rowElement) {
                //clear the imput fields for the row
                $(rowElement).find("input").val('');
                //may want to reset <select> options etc
 
                //in fact you may want to submit the form
                saveNeeded();
            }
            function rowRemoved(rowElement) {
                saveNeeded();
                alert( "Removed Row HTML:\n" + $(rowElement).html() );
            }
 
            function saveNeeded() {
                $('#submit').css('color','red');
                $('#submit').css('font-weight','bold');
                if( $('#submit').val().indexOf('!') != 0 ) {
                    $('#submit').val( '!' + $('#submit').val() );
                }
            }
 
            function beforeSubmit() {
                alert('submitting....');
                return true;
            }
 
            $(document).ready( function() {
                var config = {
                    rowClass : 'person',
                    addRowId : 'addPerson',
                    removeRowClass : 'removePerson',
                    formId : 'personListForm',
                    rowContainerId : 'personListContainer',
                    indexedPropertyName : 'productList',
                    indexedPropertyMemberNames : 'productName,productId,quantity,price',
                    rowAddedListener : rowAdded,
                    rowRemovedListener : rowRemoved,
                    beforeSubmit : beforeSubmit
                };
                new DynamicListHelper(config);
            });
        </script>
 
    </body>
</html>