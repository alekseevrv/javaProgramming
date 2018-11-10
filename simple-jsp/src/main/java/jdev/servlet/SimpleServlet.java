package jdev.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setCharacterEncoding("Windows-1251");
        response.setContentType("text/html; Windows-1251");
        response.getWriter().print(
                "<html>\n" +
                "<head>\n" +
                "    <title>Index File</title>\n" +
                "</head>\n" +
                "<body>");
        response.getWriter().print("GET from SimpleServlet\n");
        double random = Math.random();
        if (random > 0.95) {
            response.getWriter().print("<p>Удача улыбнулась Вам!\n");
        } else {
            response.getWriter().print("<p>Жизнь есть жизнь ...\n");
        }
        response.getWriter().print("<p>(" + random + ")");
        response.getWriter().print(" <a href=\"" + request.getRequestURI() + "\""  + "><h3>Испытайте удачу ещё!</h3></a>" );
        response.getWriter().print("</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.getWriter().print("POST from SimpleServlet");
    }
}
