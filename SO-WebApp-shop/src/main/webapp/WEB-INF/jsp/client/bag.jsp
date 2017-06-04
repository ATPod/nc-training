<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <title>SO-shop</title>
    </head>
    <body>

        <jsp:include page="navbar.jsp"/>

        <div class="mainBlock col-md-6 col-md-offset-3">
            <h1><spring:message code="msg.clientBagH1MakeOrdering"/></h1>
            <c:choose>
                <c:when test="${bag.size() == 0}">
                    <div class="alert alert-success">
                        <spring:message code="msg.alertEmptyBag"/>
                    </div>
                    <br/>
                </c:when>
                <c:otherwise>
                    <c:if test="${user.blacklist == 1}">
                        <div class="alert alert-danger">
                            <spring:message code="msg.alertBlackList"/>
                        </div>
                        <br/>
                    </c:if>
                    <table class="table table-hover table-striped">
                        <caption><spring:message code="msg.clientBagTableCaption"/></caption>
                        <thead>
                        <tr>
                            <th class="text-center"><strong>ID</strong></th>
                            <th class="text-center"><strong><spring:message code="msg.clientBagTableTitle"/></strong></th>
                            <th class="text-center"><strong><spring:message code="msg.clientBagTablePrice"/></strong></th>
                            <th></th>
                        </tr>
                        </thead>

                        <c:forEach var="product" items="${bag}">
                            <tr>
                                <td class="text-center"><c:out value="${product.id}" /></td>
                                <td class="text-center"><c:out value="${product.title}" /></td>
                                <td class="text-center"><c:out value="${product.price}" /> BYN</td>
                                <td class="text-center">
                                    <form method="POST" action="/client/remove_from_bag">
                                        <input type="hidden" name="productId" value="${ product.id }"/>
                                        <input type="submit" value="<spring:message code="msg.clientBagRemoveInput"/>" class="btn btn-danger"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>

                    <span class="total">Total price: ${sum} BYN</span>

                    <br/>
                    <br/>

                    <c:if test="${user.blacklist == 0}">
                        <form method="POST" action="/client/make_ordering">
                            <input type="submit" value="<spring:message code="msg.clientBagMakeOrderInput"/>" class="btn btn-success"/>
                        </form>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
