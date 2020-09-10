<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Sample</h1>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board List Page
				<button id="regBtn" type="button" class="btn btn-xs pull-right"
					style="background: #afa6a6;">Register New Board</button>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
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
						<c:forEach var="board" items="${list}">
							<tr>
								<td class="text-center"><a class="move"
									href='<c:out value="${board.bno}"/>'><c:out
											value="${board.bno}" /></a></td>
								<td><c:out value="${board.title}" /></td>
								<td><c:out value="${board.content}" /></td>
								<td class="text-center"><fmt:formatDate
										pattern="yyyy-MM-dd" value="${board.regDate}" /></td>
								<td class="text-center"><fmt:formatDate
										pattern="yyyy-MM-dd" value="${board.updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class='row'>
					<div class="col-lg-12">

						<form id='searchForm' action="/board/list" method='get'>
							<select name='type'>
								<option value=""
									<c:out value="${pageMaker.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.type eq 'C'?'selected':''}"/>>내용</option>
								<option value="W"
									<c:out value="${pageMaker.type eq 'W'?'selected':''}"/>>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.type eq 'TC'?'selected':''}"/>>제목
									or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.type eq 'TW'?'selected':''}"/>>제목
									or 작성자</option>
								<option value="TWC"
									<c:out value="${pageMaker.type eq 'TWC'?'selected':''}"/>>제목
									or 내용 or 작성자</option>
							</select> <input type='text' name='keyword'
								value='<c:out value="${pageMaker.keyword}"/>' /> <input
								type='hidden' name='pageNum'
								value='<c:out value="${pageMaker.pagenum}"/>' /> <input
								type='hidden' name='amount'
								value='<c:out value="${pageMaker.contentnum}"/>' />
							<button class='btn btn-default'>Search</button>
						</form>
					</div>
				</div>

				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a
								href="${pageMaker.getStartPage() -1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.getStartPage()}"
							end="${pageMaker.getEndPage()}">
							<li
								class="paginate_button  ${pageMaker.pagenum+1 == num ? 'active' : '' }">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button previous"><a
								href="${pageMaker.getEndPage() + 1 }">Next</a></li>
						</c:if>
					</ul>
				</div>
				<form id='actionForm' action="/board/list" method='get'>
					<input type='hidden' name='pagenum'
						value='<c:out value="${pageMaker.pagenum+1}"/>'>
					<input type='hidden' name='contentnum'
						value='<c:out value="${pageMaker.contentnum}"/>'>
					<input type='hidden' name='type'
						value='<c:out value="${pageMaker.type}"/>'>
					<input type='hidden' name='keyword'
						value='<c:out value="${pageMaker.keyword}"/>'>
				</form>


				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		var result = '<c:out value="${result}"/>';
		console.log(result);
		checkModal(result);

		history.replaceState({}, null, null);

		function checkModal(result) {
			if (result == '' || history.state) return;
			if (parseInt(result) > 0) {
				$('.modal-body').html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$('#myModal').modal("show");
		}

		$('#regBtn').click(function() {
			self.location = "/board/register";
		});

		var actionForm = $("#actionForm");

		$(".paginate_button a").on("click", function(e) {
			e.preventDefault();
			console.log('click');
			actionForm.find("input[name='pagenum']").val($(this).attr("href"));
			actionForm.submit();
		});

		$('.move').on("click", function(e) {
			e.preventDefault();
			actionForm.append("<input type='hidden' name = 'bno' value='"+ $(this).attr("href")+ "'>");
			actionForm.attr("action", "/board/get");
			actionForm.submit();
		});

		var searchForm = $('#searchForm');
		$("#searchForm button").on("click", function(e){
			if (!searchForm.find("option:selected").val()) {
				alert("검색종류를 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}

			searchForm.find("input[name='pagenum']").val("1");
			e.preventDefault();

			searchForm.submit();
		});
});
</script>
<%@ include file="../includes/footer.jsp" %>
