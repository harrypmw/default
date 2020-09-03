<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){

		$('#listBtn').click(function(){
			self.location = "/board/list";
		});
	});
</script>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Sample</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Register
                            <button id="listBtn" type="button" class="btn btn-xs pull-right" style="background: #afa6a6;">Board List Page</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
							<form role="form" action="/board/register" method="post">
								<div class="form-group">
									<label>Title</label>
									<input class="form-control" name="title">
								</div>
								<div class="form-group">
									<label>Text area</label>
									<textarea class="form-control" rows="3" name="content"></textarea>
								</div>
								<div class="form-group">
									<label>Writer</label>
									<input class="form-control" name="writer">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
								<button type="reset" class="btn btn-default">Reset Button</button>
							</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        <!-- /#page-wrapper -->
        <%@ include file="../includes/footer.jsp" %>
