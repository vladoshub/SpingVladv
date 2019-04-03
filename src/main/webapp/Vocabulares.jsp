<%@ page import="java.util.List" %>
<form method="post">
    <label>List of operations:
        <%
            out.println("Message:"+s);
            out.println("Message:"+s);
            out.println("Message:"+s);
            out.println("Message:"+s);
            String s =  (String)request.getAttribute("req");
            if(s!=null)
                out.println("Message:"+s);

        %>
    </label>
    <br />
    <label>enter operation number:
        <input type="text" name="req"><br />
    </label>
    <button type="submit">Submit</button>

</form>