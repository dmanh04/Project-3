<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tòa nhà</title>
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
                <h1>Danh sách tòa nhà
                </h1>
            </div><!-- /.page-header -->

            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->
                    <div class="widget-box" style="font-family: 'Times New Roman', Times, serif;">
                        <div class="widget-header">
                            <h4 class="widget-title">Masked Input</h4>

                            <span class="widget-toolbar">
											<a href="#" data-action="reload">
												<i class="ace-icon fa fa-refresh"></i>
											</a>

											<a href="#" data-action="collapse">
												<i class="ace-icon fa fa-chevron-up"></i>
											</a>
										</span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <form:form action="/admin/building-list" modelAttribute="modelSearch" method="GET" id="listForm" >
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <label >Tên tòa nhà</label> <br>
                                            <div class="form-group">
                                                <form:input path="name" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-6">
                                            <label>Diện tích sàn</label>
                                            <div class="form-group">
                                                <form:input path="floorArea" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-2">
                                            <label>Quận</label>
                                            <div class="form-group">
                                              <form:select path="district" class="form-control">
                                                   <form:option value="" label="Chọn quận"></form:option>
                                                   <form:options items="${districtCode}"></form:options>
                                               </form:select>
                                            </div>
                                        </div>
                                        <div class="col-xs-5">
                                            <label>Phường</label>
                                            <div class="form-group">
                                                <form:input path="ward" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-5">
                                            <label>Đường</label>
                                            <div class="form-group">
                                                <form:input path="street" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <label >Số tầng hầm</label>
                                            <div class="form-group">
                                                <form:input path="numberOfBasement" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>Hướng</label>
                                            <div class="form-group">
                                                <form:input path="direction" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <label >Hạng</label>
                                            <div class="form-group">
                                                <form:input path="level" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-3">
                                            <label >Diện tích từ</label>
                                            <div class="form-group">
                                                <form:input path="areaFrom" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-3">
                                            <label >Diện tích đến</label>
                                            <div class="form-group">
                                                <form:input path="areaTo" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-3">
                                            <label>Giá thuê từ</label>
                                            <div class="form-group">
                                                <form:input path="rentPriceFrom" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-3">
                                            <label >Giá thuê đến</label>
                                            <div class="form-group">
                                                <form:input path="rentPriceTo" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <label >Tên quản lý</label>
                                            <div class="form-group">
                                                <form:input path="managerName" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-4">
                                            <label>Số điện thoại quản lí</label>
                                            <div class="form-group">
                                                <form:input path="managerPhone" class="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-xs-3">
                                            <label>Nhân viên quản lý</label>
                                            <div class="form-group">
                                               <form:select path="staffId">
                                                   <form:option value="" label="---Chon nhan vien---"></form:option>
                                                   <form:options items="${staffs}"></form:options>
                                               </form:select>
                                            </div>
                                        </div>

                                        <div class="col-xs-6">

                                            <div class="form-group">
                                                <form:checkboxes path="typeCode" items="${typeCodes}"></form:checkboxes>
                                            </div>

                                        </div>

                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <button type="button" class="btn btn-sm btn-primary" id="btnSearch">Tìm kiếm</button>
                                            </div>
                                        </div>

                                    </div>
                                </form:form>

                            </div>
                        </div>

                    </div>

                    <div class="inner-button text-right">
                        <a href="/admin/building-edit">
                            <button title="Thêm tòa nhà" class="btn btn-sm btn-primary">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
                                    <path d="M4 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1zm11 0H3v14h3v-2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V15h3z"/>
                                </svg>
                            </button>
                        </a>
                        <button title="Xóa tòa nhà" class="btn btn-sm btn-danger" id="btnDeleteBuildings">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>

                    <h3 class="header smaller lighter blue">

                    </h3>

                    <div class="row"  style="font-family: 'Times New Roman', Times, serif;">
                        <div class="col-xs-12">
                            <table class="table table-striped table-bordered table-hover" id="buildingList">

                                <thead>
                                <tr>
                                    <th class="center">
                                        <label class="pos-rel">
                                            <input type="checkbox" id="btnAll" class="ace">
                                            <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th>Ngày</th>
                                    <th>Tên sản phẩm</th>
                                    <th>Địa chỉ</th>
                                    <th>Số tầng hầm</th>
                                    <th>Tên quản lí</th>
                                    <th>Số điện thoại</th>
                                    <th>D.T sàn</th>
                                    <th>D.T thuê</th>
                                    <th>D.T trống</th>
                                    <th>Giá thuê</th>
                                    <th>Phí dịch vụ</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="item" items="${buildings}">
                                    <tr>
                                        <td class="center">
                                            <label class="pos-rel">
                                                <input type="checkbox" class="ace"  value="${item.id}">
                                                <span class="lbl"></span>
                                            </label>
                                        </td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.name}</td>
                                        <td>${item.address}</td>
                                        <td>${item.numberOfBasement}</td>
                                        <td>${item.managerName}</td>
                                        <td>${item.managerPhoneNumber}</td>
                                        <td>${item.floorArea}</td>
                                        <td>${item.rentArea}</td>
                                        <td>${item.emptyArea}</td>
                                        <td>${item.rentPrice}</td>
                                        <td>${item.serviceFee}</td>
                                        <td>
                                            <div>
                                                <button class="btn btn-sm btn-success" title="Giao tòa nhà" onclick="assignmentBuilding(${item.id})">
                                                    <i class="icon-only ace-icon fa fa-align-justify"></i>
                                                </button>
                                                <a href="/admin/building-edit-${item.id}">
                                                    <button class="btn btn-sm btn-info" title="Sửa tòa nhà">
                                                        <i class="ace-icon fa fa-pencil-square-o"></i>
                                                    </button>
                                                </a>
                                                <button class="btn btn-sm btn-danger" title="Xóa tòa nhà" onclick="removeBuilding(${item.id})">
                                                    <i class="ace-icon fa fa-trash-o"></i>
                                                </button>
                                            </div>

                                        </td>
                                    </tr>
                                </c:forEach>


                                </tbody>

                            </table>
                        </div>
                    </div>

                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->


<div class="modal fade" id="assignmentBuildingModal"  role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="exampleModalLabel">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-striped table-bordered table-hover" id="staffList" style="font-family: 'Times New Roman', Times, serif;">

                    <thead>
                    <tr>
                        <th class="center">
                            Chọn
                        </th>
                        <th class="center">Tên nhân viên</th>
                    </tr>
                    </thead>

                    <tbody>

                    </tbody>

                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignmentBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>

            </div>
        </div>
    </div>
</div>

<script>
    function assignmentBuilding(buildingId){
        $('#assignmentBuildingModal').modal();
        $('#buildingId').val(buildingId);
        loadStaffs(buildingId);
    }

    function loadStaffs(buildingId){
        $.ajax({
            type: "GET",
            url: "/api/buildings/" + buildingId + "/staffs",
            dataType: "json",
            success: function(response){
                var row = "";
                $.each(response.data, function (index, item){
                    row += '<tr>';
                    row += '<td class="center"><input type="checkbox" value=' + item.staffId + '  id="checkbox_' + item.staffId
                    + '"  ' + item.checked + '/></td>';
                    row += '<td class="text-center">' + item.fullName + '</td>'
                    row += '</tr>';
                    $('#staffList tbody').html(row);

                });
            },
            error: function(response){
                console.log("failed");
                console.log(response);
            }
        });
    }

    $('#btnAssignmentBuilding').click(function(e){
        e.preventDefault();
        var data = {};
        data['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        $.ajax({
            type: "PUT",
            url: "/api/buildings",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(response){
                alert('Giao toa nha thanh cong');
            },
            error:function(response){
                console.log("failed");
            }
        });
    });

    $('#btnDeleteBuildings').click(function(e){
        e.preventDefault();
        var data = {};
        var buildingIds = $('#buildingList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['buildingIds'] = buildingIds;
        deleteBuilding(data);
    });

    function removeBuilding(buildingId){
        var data = {};
        data['buildingIds'] = buildingId;
        deleteBuilding(data);
    }

    function deleteBuilding(data){
        $.ajax({
            type: "DELETE",
            url: "/api/buildings/" + data['buildingIds'],
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: "text",
            success: function(response){
                alert(response);
                window.location.replace("/admin/building-list");
            },
            error: function(response){
                console.log("failed");
                console.log(response);
            }
        });
    }


    $('#btnSearch').click(function (e){
        e.preventDefault();
        $('#listForm').submit();
    })

    //--------btn-All-click----------
    var btnCheckAll = $('#btnAll');
    var btn = $('#buildingList tbody input[type="checkbox"]');
    btnCheckAll.change(function(){
        const isCheckAll = btnCheckAll.prop("checked");
        if(isCheckAll){
            btn.prop("checked", true);
        }
        else {
            btn.prop("checked", false);
        }
    })

    btn.change(function () {
        var isChecked = $('#buildingList tbody input[type="checkbox"]:checked').length;
        var bool = btn.length === isChecked;
        btnCheckAll.prop("checked", bool);
    })
    //---End btn click----


</script>



</body>



</html>
