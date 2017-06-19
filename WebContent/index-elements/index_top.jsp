<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body onload="focusOnLogin()">
       <div id="header">
             <s:if test="#session.admin==null">
                 <form action="validateLogin" method=post onsubmit="return check()">
                         <label>用户名</label>
                         <input type="text" id="loginName" name="loginName" value="" class="login_input" />
                         <label>密 &#160; &#160; 码</label>
                         <input type="password" id="loginPwd" name="loginPwd" value="" class="login_input" />
                         <input type="submit" class="login_sub" value="登录" />
                         <img src="Images/friend_logo.gif" alt="Google" id="friend_logo" />
                </form>
             </s:if>
             <s:if test="#session.admin!=null">
                                  欢迎你:<s:property value="#session.admin.loginName" />
                                 &nbsp;&nbsp;&nbsp;&#160;
                                 <a href="/News/admin" >登陆台</a> &nbsp;
                                 <a href="logout">退出</a>
             </s:if>
       </div>
        
       <div id="nav" >
                <table>
                        <tr>
                        
                           <td>
                               <div id="logo">
                                   <img src="Images/logo.jpg" alt="新闻" />
                                 
                               </div>
                               
                            </td>
                            
                            <td>
                                 <img src="Images/a_b-1.gif" alt="" />
                            </td>
                       </tr>
                </table>
               
       
       </div>
        
</body>
</html>