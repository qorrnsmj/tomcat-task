package qj.exercise.jsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sample3", value = "/sample3")
public class Sample3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String inputText = req.getParameter("cars");
        System.out.println(inputText);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>" + inputText + "</title></head>");
        out.println("<body>");
        out.println("<h2>" + inputText + "</h2>");
        out.println("お買い上げありがとうございました。<br>");
        out.println("</body>");
        out.println("</html>");
    }
}