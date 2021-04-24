<%@page trimDirectiveWhitespaces="true"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%> 
<%@ page import="javax.naming.NameClassPair"%>
<%@ page import="javax.naming.NamingEnumeration"%>
<%@ page import="java.util.Hashtable"%>

<%! 
    Context initial = null;

	public void jspInit() {
		try {
            // Hashtable env = new Hashtable();
            // env.put(Context.PROVIDER_URL, "akda.ak.blm.gov:1099");
            // env.put(Context.PROVIDER_URL, "localhost");
			// initial = new InitialContext(env);
			
			initial = new InitialContext();

		} catch (Exception ex) {
			System.out.println("Unexpected Exception: " +
					ex.getMessage());
		}
 	}
%>

<html>
<head>
<title>JNDI Browser</title>
</head>
<body bgcolor=white>
<center>
<h1>JNDI Browser</h1>
<hr>
<p>
<table bgcolor="#e0e0e0" border=2 cellpadding=5>
<form>
<tr>
  <td>Enter path to browse:</td>
  <td><input type="text" name="path" ></td>
</tr>
<tr>
  <td>Display Properties:</td>
  <td><input type="radio" name="is_display" value="y"/>Yes
      <input type="radio" name="is_display" value="n" checked />No
  </td>
</tr>
<tr>
  <td>
    <input type="submit">
  </td>
</tr>
<tr colspan=2>
  <td>
   total memory: <%= (Runtime.getRuntime().totalMemory()/1000000.0)%> mb<br>
   max memory: <%= (Runtime.getRuntime().maxMemory()/1000000.0)%> mb<br>
   free memory: <%= (Runtime.getRuntime().freeMemory()/1000000.0)%> mb<br>
  </td>
</tr>
<%  if (request.getParameter("path")!=null) {
       try {

         // What is bound to this thing?
         String name = request.getParameter("path");
         // returns an enumeration of NameClassPair objects.
         NamingEnumeration ne = initial.list(name);
%>
         <tr><td>Current JNDI path:</td><td><%=name%></td>
<%
         while(ne.hasMore()) {
           NameClassPair nameClassPair = (NameClassPair) ne.next();
%>
           <tr>
             <td valign="top">JNDI bound object: </td>
             <td>
               <a href="<%=request.getRequestURL()%>?path=<%=name%>/<%= nameClassPair.getName() %>">
               <%= nameClassPair.getName() %></a><br>
               Class: <%= nameClassPair.getClassName() %>
             </td>
           </tr>
<%       }
       } catch (Exception e) { %>    
         <tr><td>Error:</td><td><%=e.getMessage()%></td></tr>
<%  
       } 
     }     
%>

<%
    if ("y".equals((String)request.getParameter("is_display"))) {

      // print out initial environment
      Hashtable env = initial.getEnvironment();
      java.util.Set keys = env.keySet();
      java.util.Iterator i = keys.iterator();
%>
      <tr><td colspan='2'>InitialContext environment:</td></tr>
<%
      while(i.hasNext()) {
        Object key = i.next();
%>
        <tr><td><%=key%></td><td><%=env.get(key)%></td></tr>
<%
      }

      java.util.Properties properties = System.getProperties();
      java.util.Enumeration e = properties.propertyNames();
%>
        <tr><td colspan='2'>System properties:</td></tr>
<%
      while(e.hasMoreElements()) { 
        Object object = e.nextElement(); %>
        <tr><td><%=object%></td><td><%=properties.getProperty(object.toString())%></td></tr>
<%  }
  }
%>
</form>
</table>
</body></html>
