<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 4/26/2024
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới hoặc sửa tòa nhà</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>

                <li>
                    <a href="#">UI &amp; Elements</a>
                </li>
                <li class="active">Content Sliders</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content">


            <div class="page-header">
                <h1 style="font-family: 'Times New Roman', Times, serif;">Sửa hoặc thêm khách hàng
                </h1>
            </div><!-- /.page-header -->

            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form modelAttribute="customerDTO" id="form-edit">
                        <form  class="form-horizontal" >
                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Tên khách hàng</label>
                                <div class="col-xs-8">
                                    <form:input path="fullName" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Số điện thoại</label>
                                <div class="col-xs-8">
                                    <form:input path="phone" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Email</label>
                                <div class="col-xs-8">
                                    <form:input path="email" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Tên công ty</label>
                                <div class="col-xs-8">
                                    <form:input path="companyName" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Nhu cầu</label>
                                <div class="col-xs-8">
                                    <form:input path="demand" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                    <label class="col-xs-4">Tình trạng</label>
                                    <div class="form-group col-xs-4">
                                        <form:select path="status" class="form-control">
                                            <form:options items="${status}"/>
                                        </form:select>
                                    </div>
                            </div>

                            <div class="col-xs-12">
                                <h3 class="header smaller lighter blue">

                                </h3>
                            </div>

                            <div class="inner-button text-center" style="margin-top: 120px;">
                                <c:if test="${empty customerDTO.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateCustomer">Thêm mới</button>
                                </c:if>

                                <c:if test="${ not empty customerDTO.id}">
                                    <security:authorize access="hasRole('MANAGER')">
                                        <button type="button" class="btn btn-primary btn-warning" id="btnAddOrUpdateCustomer">Cập nhật</button>
                                        <input type="hidden" id="idCustomer" value="${customerDTO.id}">
                                    </security:authorize>
                                </c:if>

                                <a href="/admin/customer-list" class="btn btn-primary">
                                    Hủy thao tác
                                </a>
                            </div>
                        </form>
                    </form:form>


                </div>





                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
            <c:forEach var="item" items="${transactionType}">
                <div class="col-xs-12">
                    <h3 class="header smaller lighter blue">${item.value}</h3>
                    <button class="btn btn-lg btn-primary" onclick="transactionType('${item.key}', ${customerDTO.id})">
                        <i class="orange ace-icon fa fa-location-arrow bigger-130"></i>Add
                    </button>
                </div>
                <c:if test="${item.key == 'CSKH'}">
                    <div class="col-xs-12">
                        <table id="simple-table" class="table table-striped table-bordered table-hover">
                            <thead>
                                 <tr>
                                     <th>Ngày tạo</th>
                                     <th>Người tạo</th>
                                     <th>Ngày sửa</th>
                                     <th>Người sửa</th>
                                     <th>Chi tiết giao dịch</th>
                                     <th>Thao tác</th>
                                 </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${transactionCSKH}" var="tran1">
                                    <tr>
                                        <td>${tran1.createdDate}</td>
                                        <td>${tran1.createdBy}</td>
                                        <td>${tran1.modifiedDate}</td>
                                        <td>${tran1.modifiedBy}</td>
                                        <td>${tran1.note}</td>
                                        <td>
                                            <div class="hidden-sm hidden-xs btn-group">
                                                <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Sửa thông tin giao dịch"
                                                        onclick="updateTransaction(${tran1.id}, `${tran1.note}`)">
                                                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
                <c:if test="${item.key == 'DDX'}">
                    <div class="col-xs-12">
                        <table id="simple" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Ngày tạo</th>
                                <th>Người tạo</th>
                                <th>Ngày sửa</th>
                                <th>Người sửa</th>
                                <th>Chi tiết giao dịch</th>
                                <th>Thao tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${transactionDDX}" var="tran2">
                                <tr>
                                    <td>${tran2.createdDate}</td>
                                    <td>${tran2.createdBy}</td>
                                    <td>${tran2.modifiedDate}</td>
                                    <td>${tran2.modifiedBy}</td>
                                    <td>${tran2.note}</td>
                                    <td>
                                        <div class="hidden-sm hidden-xs btn-group">
                                            <button class="btn btn-xs btn-info" data-toggle="tooltip" title="Sửa thông tin giao dịch"
                                                    onclick="updateTransaction(${tran2.id}, `${tran2.note}`)">
                                                <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </c:forEach>




            <div class="modal fade" id="transactionTypeModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Nhập giao dịch</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group has-success">
                            <label for="transactionDetail" class="col-xs-12 col-sm-3 control-label no-padding-right">Chi thiết giao dich</label>
                            <div class="col-xs-12 col-sm-9">
                                <span class="block input-icon input-icon-right">
                                <input type="text" id="transactionDetail" class="width-100">
                                </span>
                            </div>
                        </div>
                        <input type="hidden" name="customerId" id="customerId" value="">
                        <input type="hidden" name="code" id="code" value="">
                        <input type="hidden" name="id" id="id" value="">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" id="btnAddOrUpdateTransaction">Thêm giao dịch</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">bóng</button>
                    </div>
                </div>
            </div>
        </div>



        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div>
</div><!-- /.main-content -->



<script>

    function  transactionType(code, customerId){
        $('#transactionTypeModal').modal();
        $('#customerId').val(customerId);
        $('#code').val(code);
    }
    function updateTransaction(id, note){
        $('#transactionTypeModal').modal();
        $('#id').val(id);
        $("#transactionDetail").val(note);
    }

    $('#btnAddOrUpdateTransaction').click(function (e){
        e.preventDefault();
        var data = {};
        data['id'] = $('#id').val();
        data['customerId'] = $('#customerId').val();
        data['code'] = $('#code').val();
        data['transactionDetail'] = $('#transactionDetail').val();
        addTransaction(data);
    })
    function addTransaction(data){
        $.ajax({
            type: "POST",
            url: "/api/customers/transactional",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "text",
            success: function (res) {
                alert("Add or Update Transactional Customer successful")
                window.location.replace("/admin/customer-edit-${customerDTO.id}");
            },
            error: function () {
                alert("Add or Update Customer not successful")
                window.location.replace("/admin/customer-edit-${customerDTO.id}");
            }
        })
    }


    function isNotNullOrEmpty(value) {
        return value !== null && value !== '';
    }

    $('#btnAddOrUpdateCustomer').click(function() {
        var data = {};
        var idCustomer = $('#idCustomer').val();
        var formData = $('#form-edit').serializeArray();
        $.each(formData, function(i, it){
            data["" + it.name + ""] = it.value;
        });
        if(isNotNullOrEmpty(data['fullName']) && isNotNullOrEmpty(data['phone'])){
            if(typeof idCustomer === "undefined" ){
                btnAddOrUpdate(data);
            }
            else{
                data['id'] = idCustomer;
                btnAddOrUpdate(data);
            }
        }
        else{
            alert("Full name and phone are required");
        }

    });
    function btnAddOrUpdate(data){
        $.ajax({
            type: "POST",
            url: "/api/customers",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "text",
            success: function (res) {
                alert("Add or Update Customer successful")
                window.location.replace("/admin/customer-list");
            },
            error: function () {
                alert("Add or Update Customer not successful")
                window.location.replace("/admin/customer-list");
            }
        })
    }



    function showMessageConfirmation(title, message, type, redirectUrl) {
        var statusBtn = ('success' === type) ? 'success' : 'danger';

        swal({
            title: title,
            text: message,
            type: type,
            showConfirmButton: true,
            confirmButtonText: "Xác nhận",
            confirmButtonClass: "btn btn-" + statusBtn,
            allowOutsideClick: true
        }).then(function(res) {
            if (res.value) {
                if ("" !== redirectUrl) {
                    window.location.href = redirectUrl;
                }
            }
        });
    }

</script>
</body>
</html>
