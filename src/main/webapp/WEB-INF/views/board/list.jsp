<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>

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
                            Board List Page
                            <button id="regBtn" type="button" class="btn btn-xs pull-right" style="background: #afa6a6;">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover" >
                                <thead>
                                    <tr>
                                        <th class="text-center">#번호</th>
                                        <th class="text-center">제목</th>
                                        <th class="text-center">작성자</th>
                                        <th class="text-center">작성일</th>
                                        <th class="text-center">수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var = "board" items="${list}">
                                	<tr>
                                		<td class="text-center">
                                			<a href='/board/get?bno=<c:out value="${board.bno}"/>'><c:out value="${board.bno}"/></a>
                                		</td>
                                		<td><c:out value="${board.title}"/></td>
                                		<td><c:out value="${board.content}"/></td>
                                		<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/></td>
                                		<td class="text-center"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                                	</tr>
                                	</c:forEach>
                            	</tbody>
                            </table>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
											처리가 완료되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        <!-- /#page-wrapper -->
<script type="text/javascript">

            $(document).ready(function(){
            	var result = '<c:out value="${result}"/>';
            	console.log(result);
            	checkModal(result);

            	history.replaceState({}, null, null);


            	function checkModal(result){
            		if(result == '' || history.state)
            			return;

            		if(parseInt(result) > 0){
            			$('.modal-body').html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
            		}
	            	$('#myModal').modal("show");
            	}

            	$('#regBtn').click(function(){
            		self.location = "/board/register";
            	});

            });
</script>
        <%@ include file="../includes/footer.jsp" %>
