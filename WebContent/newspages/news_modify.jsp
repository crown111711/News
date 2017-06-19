<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form action="doNewsModify"  method="post">
      <table>
               <tr>
                   <td>
                主题：<s:select name="newsinfo.topic.id" list="#request.topicList" listKey="id" listValue="name" cssClass="opt_input" 
               />
                   </td>
               </tr>
               <tr>
                     <td>
                <s:textfield  label="标题" name="newsinfo.title" value="%{#request.news.title}"></s:textfield>
                     </td>
               </tr>
               <tr>
                    <td>
                <s:textfield  label="摘要" name="newsinfo.summary"  value="%{#request.news.summary}"></s:textfield>       
                    </td>
               </tr>
               
               <tr>
                    <td>
                        <s:textfield  label="内容" name="newsinfo.content" value="%{#request.news.content}" ></s:textfield>
                    </td>
               </tr>
               
              <tr>
                    <td>
                         <s:submit label="提交" ></s:submit>
                    </td>
              </tr>
         
        
      </table>
      
</s:form>
