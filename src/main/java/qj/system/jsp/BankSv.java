package qj.system.jsp;

import qj.system.Bank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Bank", urlPatterns = "/bank")
public class BankSv extends HttpServlet {
    private final Bank bank = new Bank();

    public BankSv() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get name
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int result = bank.open(name);

        // Print
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>口座開設結果</title></head>");

        out.println("<body>");
        out.println("<h1>口座開設結果</h1>");

        String tmp = (result == 0) ? "成功" : "失敗";
        out.println(name + "さんの口座開設に" + tmp + "しました<br>");

        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</body></html>");
    }
}
