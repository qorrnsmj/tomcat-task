package qj.system.jsp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Withdraw", urlPatterns = "/withdraw")
public class Withdraw extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head>");
        out.println("<head><title>引き出し</title></head>");

        out.println("<body>");
        out.println("<h1>引き出し</h1>");
        out.println("<p class=\"text\">引き出しする口座名と引き出し額を入力して「OK」をおしてください</p>");

        out.println("<form action='bank' method='GET'>");
        out.println("<div class='text'>");

        // TODO: type=hiddenは2個でいい？
        out.println("口座名 : <input type='text' name='name' size='20'/><br>");
        out.println("引き出し額 : <input type='text' name='amount' size='20'/><br>");
        out.println("<input type='hidden' name='command' value='deposit'/>");
        out.println("<input type='hidden' name='command' value='deposit'/>");
        out.println("<input type='submit' value='OK'/>");
        out.println("<input type='reset' value='CANCEL'/><br>");

        out.println("</form>");
        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</div></body></html>");
    }
}
