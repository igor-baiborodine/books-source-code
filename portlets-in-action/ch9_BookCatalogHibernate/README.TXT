Installation Instructions
----------------------------------
1) Install mysql and create a myportaldb database in it.

2) If you are using Liferay bundled with tomcat, then create portal-ext.properties file 
in {TOMCAT_HOME}/webapps/ROOT/WEB-INF/classes directory and define the 
database properties as shown here:

jdbc.default.driverClassName=com.mysql.jdbc.Driver                       
jdbc.default.url=jdbc:mysql://localhost/myportaldb?useUnicode=true&characterEncoding=UTF-8&useFastDateParsing=false
jdbc.default.username=root                                               
jdbc.default.password=<password>

3) Run the sql scripts book_tbl.sql and toc_tbl.sql, which are located in the 'sql' folder of the project

4) Create JNDI-bound data source in Tomcat

If you are using Eclipse IDE to run the Tomcat server, then ensure that the following <Resource> 
and <ResourceLink> elements are added to the server.xml and context.xml files of the server 
configuration in Eclipse.

  4.1) Add <Resource> element in server.xml, inside <GlobalNamingResources> element.
  
  <GlobalNamingResources>
  ..
  <Resource name="jdbc/myportalDB"                                       
     auth="Container"                      
     type="javax.sql.DataSource" 
     username="root" password="root"
     driverClassName="com.mysql.jdbc.Driver" 
     factory="org.apache.commons.dbcp.BasicDataSourceFactory"                                        
     url="jdbc:mysql://localhost/myportaldb?useUnicode=true&amp;"
     maxActive="5"                                                       
     maxIdle="2"/>                                                      
   ..
  </GlobalNamingResources> 
  
  4.2) Add <ResourceLink> element in context.xml file, inside <Context> element.
  <Context>
	....
	<ResourceLink name="jdbc/myportalDB"
            global="jdbc/myportalDB"
            type="javax.sql.DataSource"/>
    ....
  </Context>
  
5) Publish the changes to context.xml and server.xml by using Publish option of server instance in Eclipse IDE

6) Restart Liferay portal server 

7) deploy Book Catalog portlet.