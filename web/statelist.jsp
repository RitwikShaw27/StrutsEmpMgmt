<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<option value="">Select a state</option>
<c:forEach items="${StateList}" var="province">
    <option value=${province.getProvinceCode()} <c:if test="${province.getProvinceCode()==User.getStateCode()}" > selected </c:if>>
        ${province.getProvinceName()} 
    </option>

</c:forEach>