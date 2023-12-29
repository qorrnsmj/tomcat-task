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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        switch (req.getParameter("command")) {
            case "open":
                open(req, resp);
                break;
            case "close":
                close(req, resp);
                break;
            case "deposit":
                deposit(req, resp);
                break;
            case "withdraw":
                withdraw(req, resp);
                break;
            case "balance":
                balance(req, resp);
                break;
        }
    }

    private void open(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int result = bank.open(name);

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

    private void close(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int result = bank.close(name);

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>口座解約結果</title></head>");

        out.println("<body>");
        out.println("<h1>口座解約結果</h1>");

        String tmp = (result < 0) ? "失敗" : "成功";
        out.println(name + "さんの口座解約に" + tmp + "しました<br>");

        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</body></html>");
    }


    private void deposit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        int result = bank.deposit(name, amount);

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>預金結果</title></head>");

        out.println("<body>");
        out.println("<h1>預金結果</h1>");

        if (result < 0) {
            out.println(name + "さんの預金に失敗しました<br>");
        } else {
            out.println(name + "さんの口座に" + amount + "円預金しました<br>");
        }

        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</body></html>");
    }

    private void withdraw(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String amount = req.getParameter("amount");
        int result = bank.withdraw(name, amount);

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>引き落とし結果</title></head>");

        out.println("<body>");
        out.println("<h1>引き落とし結果</h1>");

        if (result < 0) {
            out.println(name + "さんの引き落としに失敗しました<br>");
        } else {
            out.println(name + "さんの口座から" + amount + "円引き落としました<br>");
        }

        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</body></html>");
    }

    private void balance(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int result = bank.showBalance(name);

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<head><title>残高照会結果</title></head>");

        out.println("<body>");
        out.println("<h1>残高照会結果</h1>");

        if (result < 0) {
            out.println(name + "さんの残高照会に失敗しました<br>");
        } else {
            out.println(name + "さんの残高は" + result + "円です<br>");
        }

        out.println("<a href='index.jsp'>戻る</a>");
        out.println("</body></html>");
    }
}
