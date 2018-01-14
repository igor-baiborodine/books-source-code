<!DOCTYPE html>
<%@ page errorPage = "error.jsp" %>
<!-- wsimport-generated artifacts -->
<%@ page import = "tempConvertClient.TempConvertService" %>
<%@ page import = "tempConvertClient.TempConvert" %>
<html>
  <head>
  <style type = 'text/css'>
    a {color: #151b8d; text-decoration:none;}
    a:visited {color: #151b8d;}
    a:hover {color: #fff; background-color: #666;}
    .p {color: blue; font-size: large;}
    legend {color:#990000; font-size: large;}
    fieldset {width: 600px; background-color: rgb(225, 225, 225);}
  </style>
  <%! private float f2c, c2f, temp; %>
  <%
     String tempStr = request.getParameter("temperature"); // HTML textbox name
     if (tempStr != null) this.temp = Float.parseFloat(tempStr.trim());

     this.f2c = this.c2f = this.temp;
     TempConvert port = new TempConvertService().getTempConvertPort();
     c2f = port.c2F(temp);
     f2c = port.f2C(temp);
  %>
  <body>
    <fieldset>
      <legend>Temperature conversions</legend>
      <p><%= this.temp %>F = <%= this.c2f %>C</p>
      <p><%= this.temp %>C = <%= this.f2c %>F</p>
    </fieldset>
    <hr/>
    <a href = 'index.html'>Try another</a>
  </body>
</html>
