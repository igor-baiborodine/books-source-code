<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
  <head>
    <style type = 'text/css'>
      a {color: #151b8d; text-decoration:none;}
      a:visited {color: #151b8d;}
      a:hover {color: #fff; background-color: #666;}
      .p {color: red; font-size: large;}
    </style>
  </head>
  <body>
    <% response.setStatus(400); %> <!-- bad request -->
    <p class = 'p'>Numbers only, please.</p>
    <hr/>
    <a href = 'index.html'>Try again.</a>
  </body>
</html>
