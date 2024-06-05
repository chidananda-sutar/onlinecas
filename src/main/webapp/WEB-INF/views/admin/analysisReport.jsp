<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Analysis Report</title>
<%@ include file="navbar.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
<link
	rel="https://cdnjs.datatables/1.12.1/css/dataTables.bootstrap4.min.css">
<!-- Option 1: Include in HTML -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>


<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link
	href="
https://cdn.jsdelivr.net/npm/sweetalert2@11.7.12/dist/sweetalert2.min.css
"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.12/dist/sweetalert2.all.min.js
"></script>
</head>

<body>


<div class="container mt-5">
    <h3 class="text-center text-danger mb-4">Analysis Report</h3>
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h5 class="mb-0">Reports</h5>
        </div>
        <div class="card-body">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="./registerCandidatesReport" style="cursor:pointer;">Registered Candidates</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./appearedCandidatesReport" style="cursor:pointer;">Appeared Candidates</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./notAppearedCandidatesReport" style="cursor:pointer;">Not Appeared Candidates</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./qualifiedCandidatesReport" style="cursor:pointer;">Qualified Candidates</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./yearlyReport" style="cursor:pointer;">MIS Report</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>

</html>