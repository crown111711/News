 <%--   <s:action name="indexsidebar" namespace="/" executeResult="true" />
     
   <s:iterator id="topic" value="#request.topicList">
         <a href="index?newsinfo.topic.id=${topic.id}" >
              <b>${topic.name}</b>
         </a>
   </s:iterator>  
   <ul>
     <s:iterator id="news" value="#request.newsinfoList">
           <li><a href="newsread?id=${news.id}">${news.title}</a>
           <span>${newsinfo.createDate}</span> </li>
     </s:iterator>
   </ul> 
      <br> <br>
       <s:if test="pager.curPage>1" >
            <a href='index?newsinfo.topic.id=${requestScope.newsinfo.topic.id}&
             pager.curPage=1 '>首页</a>
             <a href='index?newsinfo.topic.id=${requestScope.newsinfo.topic.id}&
             pager.curPage=${pager.curPage-1}'>上一页</a>
       </s:if>
       <s:if test="pager.curPage<pager.pageCount">
              <a href='index?newsinfo.topic.id=${requestScope.newsinfo.topic.id}
              &pager.curPage=${pager.curPage+1}' >下一页</a>
              <a href='index?newsinfo.topic.id=${requestScope.newsinfo.topic.id }
              &pager.curPage=${pager.pageCount}'>尾页</a>
       </s:if> --%>
       
 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
      <%-- <jsp:include page="index-elements/index_top.jsp" /> --%>
      <jsp:include page="index-elements/index_top.jsp" />
<div id="container">

<s:action name="indexsidebar" namespace="/" executeResult="true" />

  <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      	<li id='class_month'>    
      	 <!-- 循环显示主题列表 -->  	
      	 <s:iterator id="topic" value="#request.topicList">
      	 	<a href="index?newsinfo.topic.id=${topic.id}"><b>${topic.name}</b></a>
      	 </s:iterator>
      </ul>
      <ul class="classlist"> 
        <!-- 循环显示当前页新闻列表 -->     
        <s:iterator id="news" value="#request.newsinfoList">
            <li><a href="newsread?id=${news.id}"> ${news.title} </a>
      	    <span> ${newsinfo.createDate}</span></li>
        </s:iterator>            
        
        <!-- 分页超链接部分 -->
        <s:if test="pager.curPage>1">
            <p align="center">
			    <a href='index?pager.curPage=1&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>首页</a>
			    <a href='index?pager.curPage=${pager.curPage-1 }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>上一页</a>
		    </p>
		</s:if>		
		
		<s:if test="pager.curPage < pager.pageCount">
		  <p align="center">
			<a href='index?pager.curPage=${pager.curPage+1}&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>下一页</a>
			<a href='index?pager.curPage=${pager.pageCount }&newsinfo.topic.id=${requestScope.newsinfo.topic.id}'>尾页</a>
		  </p>
		</s:if>
       </ul>
    </div>   
  </div>
</div>