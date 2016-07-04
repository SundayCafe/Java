<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>解决问题</title>
		<link rel="stylesheet" href="../css/main.css" />
		<link rel="stylesheet" href="../css/reset.css" />
	</head>

	<body>
		<header class="headerBar">
			<a href="teacherindex.jsp" class="welcome_tit fl">西工答疑 · 知识之渊</a>
			<span class="active_user">当前用户<i class="user_name">laoshi</i>&nbsp;&nbsp;<a href="teacherindex.jsp">&nbsp;首页</a></span>
		</header>
		<div class="hr_35"></div>
		<div class="listTit comWidth">
			<div class="q_title_content">
				<h3 class="question_title">求解Java对象与类</h3>
				<div class="q_details">
					<h2 class="q_descript">详细描述</h2> 前天编写程序，突然发现import java.until.前面总是有黄色的感叹号，提示我import java.until. is never used，但是我运行程序后，控制台死活显示不出内容，但是停止键又是亮着的，Scanner sc=new Scanner(System.in)以下的语句，都无法显示，不知道怎么回事，第一次遇见，没有提示error，没有红色感叹号，有谁能帮忙解决啊，停止重启eclipse，或者重新安装都没用!以前没用出现过这种情况，第一次碰到，实在没辙了,语句应该没事，是突然出现这个问题的
					<br />
					<input type="text" value="提问者" class="q_author" /><span class="answer_user">130611106</span>
				</div>
			</div>
			<div class="hr_25"></div>
			<div class="addAnswer">
				<h3 class="addAnswer_title">添加回答</h3>
				<form action="" method="post">
					<textarea type="text" name="answercon" class="addAnswer_content" /></textarea>
					<button type="submit" class="addAnswer_btn" value="">提交答案</button>
				</form>
			</div>
 	</body>
</html>