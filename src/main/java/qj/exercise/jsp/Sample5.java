package qj.exercise.jsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Sample5", value = "/sample5")
public class Sample5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<String> values = Arrays.asList(req.getParameterValues("season"));
        System.out.println(values);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>チェックボックス</title></head>");
        out.println("<body>");
        out.println("<h2>");

        values.forEach(value -> out.println(value + " "));

        out.println("</body>");
        out.println("</html>");
    }
}