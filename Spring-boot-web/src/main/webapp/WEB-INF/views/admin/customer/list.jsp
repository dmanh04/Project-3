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
                                <form:form  modelAttribute="customerDTO" method="GET" id="listForm" >
                                    <div class="row">
                                        <div class="col-xs-4">
                                            <label >Tên khách hàng</label> <br>
                                            <div class="form-group">
                                                <form:input path="fullname" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>Di động</label>
                                            <div class="form-group">
                                                <form:input path="phone" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-xs-4">
                                            <label>Email</label>
                                            <div class="form-group">
                                                <form:input path="email" class="form-control"/>
                                            </div>
                                        </div>

                                        <security:authorize access="hasRole('MANAGER')">
                                        <div class="col-xs-3">

                                                <label>Nhân viên quản lý</label>
                                                <div class="form-group">
                                                    <form:select path="staffId" class="form-control">
                                                        <form:option value="" label="---Chon nhan vien---"/>
                                                        <form:options items="${staffs}"/>
                                                    </form:select>
                                                </div>

                                        </div>
                                        </security:authorize>
                                        <div class="col-xs-3">
                                                <label>Trạng thái</label>
                                                <div class="form-group">
                                                    <form:select path="status" class="form-control">
                                                        <form:option value="" label="---Chon trạng thái---"/>
                                                        <form:options items="${status}"/>
                                                    </form:select>
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

                    <security:authorize access="hasRole('MANAGER')">
                        <div class="inner-button text-right">
                            <a href="/admin/customer-edit">
                                <button title="Thêm tòa nhà" class="btn btn-sm btn-primary">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building" viewBox="0 0 16 16">
                                        <path d="M4 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zM4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                        <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1zm11 0H3v14h3v-2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V15h3z"/>
                                    </svg>
                                </button>
                            </a>
                            <button title="Xóa tòa nhà" class="btn btn-sm btn-danger" id="btnDeleteCustomers">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-building-dash" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6.5a.5.5 0 0 1-1 0V1H3v14h3v-2.5a.5.5 0 0 1 .5-.5H8v4H3a1 1 0 0 1-1-1z"/>
                                    <path d="M4.5 2a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm-6 3a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm3 0a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </div>
                    </security:authorize>


                    <h3 class="header smaller lighter blue">

                    </h3>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <display:table name="customerDTO.listResult"   cellspacing="0" cellpadding="0"
                                               requestURI="/admin/customer-list" partialList="true" sort="external"
                                               size="${customerDTO.totalItems}" defaultsort="2" defaultorder="ascending"
                                               id="tableList" pagesize="${customerDTO.maxPageItems}"
                                               export="false"
                                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                               style="margin: 3em 0 1.5em;">
                                    <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                    headerClass="center select-cell">
                                        <fieldset>
                                            <input type="checkbox" name="checkList" value="${tableList.id}"
                                                   id="checkbox_${tableList.id}" class="check-box-element"/>
                                        </fieldset>
                                    </display:column>
                                    <display:column headerClass="text-left" property="fullName" title="Tên khách hàng"/>
                                    <display:column headerClass="text-left" property="phone" title="Di động"/>
                                    <display:column headerClass="text-left" property="email" title="Email"/>
                                    <display:column headerClass="text-left" property="demand" title="Nhu cầu"/>
                                    <display:column headerClass="text-left" property="createdBy" title="Người thêm"/>
                                    <display:column headerClass="text-left" property="createdDate" title="Ngày thêm"/>
                                    <display:column headerClass="text-left" property="status" title="Tình trạng"/>

                                    <
                                    <display:column headerClass="col-actions" title="Thao tác">
                                        <div>
                                            <security:authorize access="hasRole('MANAGER')">
                                                <button class="btn btn-sm btn-success" title="Giao tòa nhà" onclick="assignmentCustomer(${tableList.id})">
                                                    <i class="icon-only ace-icon fa fa-align-justify"></i>
                                                </button>
                                            </security:authorize>
                                            <a href="/admin/customer-edit-${tableList.id}">
                                                <button class="btn btn-sm btn-info" title="Sửa khách hàng">
                                                    <i class="ace-icon fa fa-pencil-square-o"></i>
                                                </button>
                                            </a>
                                            <security:authorize access="hasRole('MANAGER')">
                                                <button class="btn btn-sm btn-danger" title="Xóa tòa nhà" onclick="removeCustomer(${tableList.id})">
                                                    <i class="ace-icon fa fa-trash-o"></i>
                                                </button>
                                            </security:authorize>
                                        </div>
                                    </display:column>
                                </display:table>
                            </div>
                        </div>
                    </div>

                    <!-- PAGE CONTENT ENDS -->
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->


<div class="modal fade" id="assignmentCustomerModal"  role="dialog">
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
                <input type="hidden" id="customerId" name="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignmentCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>

            </div>
        </div>
    </div>
</div>

<script>

    $('#btnSearch').click(function (e){
        e.preventDefault();
        $('#listForm').submit();
    })

    function assignmentCustomer(customerId){
        $('#assignmentCustomerModal').modal();
        $('#customerId').val(customerId);
        loadStaffs(customerId);
    }

    function loadStaffs(customerId){
        $.ajax({
            type: "GET",
            url: "/api/customers/" + customerId + "/staffs",
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

    $('#btnAssignmentCustomer').click(function(e){
        e.preventDefault();
        var data = {};
        data['customerId'] = $('#customerId').val();
        var staffs = $('#staffList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['staffs'] = staffs;
        $.ajax({
            type: "PUT",
            url: "/api/customers",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(response){
                alert('Giao khach thanh cong');
            },
            error:function(response){
                console.log("failed");
            }
        });
    });

    $('#btnDeleteCustomers').click(function(e){
        e.preventDefault();
        var data = {};
        var customerIds = $('#tableList').find('tbody input[type = checkbox]:checked').map(function(){
            return $(this).val();
        }).get();
        data['customerIds'] = customerIds;
        deleteBuilding(data);
    });

    function removeCustomer(customerId){
        var data = {};
        data['customerIds'] = customerId;
        deleteBuilding(data);
    }

    function deleteBuilding(data){
        $.ajax({
            type: "DELETE",
            url: "/api/customers/" + data['customerIds'],
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function(response){
                alert("success");
                window.location.replace("/admin/customer-list");
            },
            error: function(response){
                console.log("failed");
                console.log(response);
            }
        });
    }



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
