<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api/building"/>
<html>
<head>
    <title>Thay đổi</title>
</head>
<body>
<div class="main-content">
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
                    <li class="active">Dashboard</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class="page-header" >
                    <h1 style="font-family: 'Times New Roman', Times, serif;">
                        Thêm tòa nhà
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            overview &amp; stats
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div class="row" style="font-family:'Times New Roman', Times, serif">
                    <form:form modelAttribute="buildingEdit" id="listForm" method="GET">
                        <div class="col-xs-12">
                            <form class="form-horizontal" role="form-edit" id="form-edit">
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Tên tòa nhà
                                    </label>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="name"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">Quận hiện có</label>
                                    <div class="col-xs-3">
                                        <form:select class="form-control" path="district">
                                            <form:option value="">--Chọn Quận--</form:option>
                                            <form:options items="${districts}"/>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phường
                                    </label>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="ward"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Đường
                                    </label>
                                    <div class="col-xs-9">
                                        <form:input class="form-control" path="street"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Kết cấu
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="structure" name="structure">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Số tầng hầm
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="numberofbasement" name="numberofbasement">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Diện tích sàn
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="floorarea" name="floorarea">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Hướng
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="direction" name="direction">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Hạng
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="level" name="level">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Diện tích thuê
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="rentarea" name="rentarea">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Gía thuê
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="rentprice" name="rentprice">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Mô tả giá
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="rentpricedescription" name="rentpricedescription">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phí dịch vụ
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="servicefee" name="servicefee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phí ô tô
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="carfee" name="carfee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phí mô tô
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="motorbikefee" name="motorbikefee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phí ngoài giờ
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="overtimefee" name="overtimefee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Tiền điện
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="electricityfee" name="electricityfee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Đặt cọc
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="deposit" name="deposit">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Thanh toán
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="payment" name="payment">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Thời hạn thuê
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="renttime" name="renttime">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Thời gian trang trí
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="decorationtime" name="decorationtime">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Tên quản lý
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="managername" name="managername">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        SĐT quản lý
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="managerphonenumber" name="managerphonenumber">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Phí môi giới
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="number" id="brokeragefee" name="brokeragefee">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Loại tòa nhà
                                    </label>
                                    <div class="col-xs-6">
                                        <form:checkboxes path="typeCode" items="${typeCodes}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                        Ghi chú
                                    </label>
                                    <div class="col-xs-9">
                                        <input class="form-control" type="text" id="note" name="note">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-xs-3">
                                    </label>
                                    <div class="col-xs-9" style="margin: 0em 25em 0em">
                                        <c:if test="${not empty buildingEdit.id}">
                                            <button class="btn-xs btn-info" id="btnAddOrUpdateBuilding">Cập nhật tòa nhà</button>
                                            <button class="btn-xs btn-info" id="btnCancel">Hủy thao tác</button>
                                        </c:if>
                                        <c:if test="${empty buildingEdit.id}">
                                            <button class="btn-xs btn-info" id="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
                                            <button class="btn-xs btn-info" id="btnCancel" >Hủy thao tác</button>
                                        </c:if>
                                    </div>
                                </div>
                                <form:hidden path="id" id="buildingId"/>
                                <%--bien lap ra de gui id--%>
                            </form>
                        </div>
                    </form:form>

                </div>
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->




</div><!-- /.main-container -->
<script src="assets/js/jquery.2.1.1.min.js"></script>
<script>
    $('#btnAddOrUpdateBuilding').click(function(e){
        var data={};
        var typeCode= [];
        var formData=$('#listForm').serializeArray();
        $.each(formData, function(i, v){
            if(v.name!='typeCode'){
                data[""+v.name+""]=v.value;
            }
            else{
                typeCode.push(v.value);
            }

        });
        data ['typeCode']=typeCode;
        if(typeCode !=''){
            addOrUpdateBuilding(data);
        }
        else{
            e.preventDefault();// ngan chan hanh dong mac dinh cua form giup chay dong ben duoi call ve api cu
            window.location.href = "<c:url value="/admin/building-edit?typeCode=require"/>";
        }
    });
    function addOrUpdateBuilding(data){
        $.ajax({
            type:"POST",
            url:"${buildingAPI}",
            data: JSON.stringify(data),
            contentType:"application/json",
            dataType:"JSON",
            success:function (respond){
                console.log("Success");
            },
            error: function(respond){
                console.log("failed");
                console.log(respond);
            }
        });
    }
    $('#btnCancel').click(function(e){
        e.preventDefault();
        // giup huy thao tac mac dinh cua form vi du nhu submit de co the chạy dòng bên dưới
        window.location.href ="<c:url value="/admin/building-list?message=error"/>";
    });
</script>
</body>
</html>
