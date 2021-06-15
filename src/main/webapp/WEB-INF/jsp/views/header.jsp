<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Simulateur | ${title}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/font-awesome/css/all.min.css"/>"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/steps.css"/>"/>
</head>
<body>
<%@include file="navbar.jsp" %>
<%@include file="sidebar.jsp" %>