<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <table width="80%" align="center">
              <tr>
                    <td colspan="2" align="center">${request.newsinfo.title}</td>
              </tr>
              <tr>
                     <td colspan="2" align="center"> <hr></td>
             </tr>
             <tr>
                    <td align="center">
                                作者:${newsinfo.author}&nbsp;&nbsp;
                                类型:<a href="index?tid=${newsinfo.topic.id}"> ${newsinfo.topic.name}</a> 
                               发布时间 :${newsinfo.createDate }                  
                    </td>
                 
             </tr>
             <tr>
                <td align="left" ><strong>摘要:${newsinfo.summary}</strong> </td>
             </tr>
             <tr>
                  <td colspan="2" align="center"></td>
             </tr>
             <tr>
                  <td colspan="2" align="center">${newsinfo.content}</td>
             </tr>
             
     </table>
</body>
</html>