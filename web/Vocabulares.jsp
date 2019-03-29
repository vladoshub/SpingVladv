<%@ page import="java.util.List" %>
<form method="post">
    <label>Message:
        <%
            String s =  (String)request.getAttribute("req");
            if(s!=null)
                out.println(s);

        %>
    </label>
    <br />
    <label>enter operation number:
        <input type="text" name="req"><br />
    </label>
    <button type="submit">Submit</button>

</form>