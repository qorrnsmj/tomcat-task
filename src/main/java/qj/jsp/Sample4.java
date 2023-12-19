package qj.jsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sample4", value = "/sample4")
public class Sample4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("season");
        System.out.println(value);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>ラジオボタン</title></head>");
        out.println("<body>");
        out.println("<h2>" + value + "が選択されました</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}