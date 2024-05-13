<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h1 style="font-family: 'Times New Roman', Times, serif;">Sửa hoặc thêm tòa nhà
                </h1>
            </div><!-- /.page-header -->

            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <form:form modelAttribute="buildingEdit" id="form-edit">
                        <form  class="form-horizontal" >
                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Tên tòa nhà</label>
                                <div class="col-xs-8">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Quận</label>
                                <div class="col-xs-3">
                                   <form:select path="district" class="form-control">
                                       <form:option value="" label="---Chon quận---"></form:option>
                                       <form:options items="${districtCode}"></form:options>
                                   </form:select>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phường</label>
                                <div class="col-xs-8">
                                    <form:input path="ward" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Đường</label>
                                <div class="col-xs-8">
                                    <form:input path="street" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Kết cấu</label>
                                <div class="col-xs-8">
                                    <form:input path="structure" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Số tầng hầm</label>
                                <div class="col-xs-8">
                                    <form:input path="numberOfBasement" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Diện tích sàn</label>
                                <div class="col-xs-8">
                                    <form:input path="floorArea" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Hướng</label>
                                <div class="col-xs-8">
                                    <form:input path="direction" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Hạng</label>
                                <div class="col-xs-8">
                                    <form:input path="level" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Diện tích thuê</label>
                                <div class="col-xs-8">
                                    <form:input path="rentArea" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Giá thuê</label>
                                <div class="col-xs-8">
                                    <form:input path="rentPrice" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Mô tả giá</label>
                                <div class="col-xs-8">
                                    <form:input path="rentPriceDescription" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phí dịch vụ</label>
                                <div class="col-xs-8">
                                    <form:input path="serviceFee" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phí ô tô</label>
                                <div class="col-xs-8">
                                    <form:input path="carFee" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phí mô tô</label>
                                <div class="col-xs-8">
                                    <form:input path="motoFee" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phí ngoài giờ</label>
                                <div class="col-xs-8">
                                    <form:input path="overtimeFee" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Tiền điện</label>
                                <div class="col-xs-8">
                                    <form:input path="electricityFee" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label class="col-xs-4">Đặt cọc</label>
                                <div class="col-xs-8">
                                    <form:input path="deposit" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label class="col-xs-4">Thanh toán</label>
                                <div class="col-xs-8">
                                    <form:input path="payment" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Thời hạn thuê</label>
                                <div class="col-xs-8">
                                    <form:input path="rentTime" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Thời gian trang trí</label>
                                <div class="col-xs-8">
                                    <form:input path="decorationTime" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Tên quản lí</label>
                                <div class="col-xs-8">
                                    <form:input path="managerName" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Số điện thoại quản lí</label>
                                <div class="col-xs-8">
                                    <form:input path="managerPhone" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group" style="display: flex; align-items: center;">
                                <label  class="col-xs-4">Phí môi giới</label>
                                <div class="col-xs-8">
                                    <form:input path="brokerageFee" class="form-control"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label  class="col-xs-4">Loại tòa nhà</label>
                                <form:checkboxes  path="typeCode" items="${typeCodes}"></form:checkboxes>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 no-padding-right">Hình đại diện</label>
                                <input class="col-sm-3 no-padding-right" type="file" id="uploadImage"/>
                                <div class="col-sm-9">
                                    <c:if test="${not empty buildingEdit.image}">
                                        <c:set var="imagePath" value="/repository${buildingEdit.image}"/>
                                        <img src="${imagePath}" id="viewImage" width="300px" height="300px" style="margin-top: 50px">
                                    </c:if>
                                    <c:if test="${empty buildingEdit.image}">
                                        <img src="../admin/assets/images/default-user.png" id="viewImage" width="300px" height="300px">
                                    </c:if>
                                </div>
                            </div>



                            <div class="col-xs-12">
                                <h3 class="header smaller lighter blue">

                                </h3>
                            </div>


                            <div class="inner-button text-center" style="margin-top: 120px;">
                                <c:if test="${empty buildingEdit.id}">
                                    <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm mới</button>
                                </c:if>

                                <c:if test="${ not empty buildingEdit.id}">
                                    <button type="button" class="btn btn-primary btn-warning" id="btnAddOrUpdateBuilding">Cập nhật</button>
                                    <input type="hidden" id="builidingIdTest" value="${buildingEdit.id}">
                                </c:if>

                                <a href="/admin/building-list" class="btn btn-primary">
                                    Hủy thao tác
                                </a>

                                <img src="/img/loading.gif" style="display: none; height: 100px" id="loading_image">
                            </div>

                        </form>
                    </form:form>


                </div>





                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div>
</div><!-- /.main-content -->



<script>

    var imageBase64 = '';
    var imageName = '';

    $('#btnAddOrUpdateBuilding').click(function() {
        var data = {};
        var typeCode = [];
        var buildingId = $('#builidingIdTest').val();
        var formData = $('#form-edit').serializeArray();
        $.each(formData, function(i, it){
            console.log(it);
            if ('' !== imageBase64) {
                data['imageBase64'] = imageBase64;
                data['imageName'] = imageName;
            }
            if(it.name != 'typeCode'){
                data["" + it.name + ""] = it.value;
            }
            else{
                typeCode.push(it.value);
            }
        });

        $('#loading_image').show();
        data['typeCode'] = typeCode;
        if(typeCode.length == 0){
            alert("Loại tòa nhà không được thiếu");
        }
        if(typeof buildingId === "undefined" ){
            btnAddOrUpdate(data);
        }
        else{
            data['id'] = buildingId;
            btnAddOrUpdate(data);
        }


    });
    function btnAddOrUpdate(data){
        $.ajax({
            type: "POST",
            url: "/api/buildings",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "text",
            success: function (res) {
                $('#loading_image').hide();
                window.location.replace("/admin/building-list");
            },
            error: function () {
                $('#loading_image').hide();
                window.location.replace("/admin/building-list");
            }
        })
    }

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        console.log($(this));
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            console.log(e);
            imageBase64 = e.target.result;
            imageName = file.name; // ten hinh khong dau, khoang cach. vd: a-b-c
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
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
