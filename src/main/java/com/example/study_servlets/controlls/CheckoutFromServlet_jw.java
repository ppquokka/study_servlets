package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutFromServlet")
public class CheckoutFromServlet_jw extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CheckoutFromServlet - doGet()");
        try {
            String first_name = "request.getParameter(first_Name)";
            String last_name ="request.getParameter(last_Name)";
            String username ="request.getParameter(username)";
            String email_optional ="request.getParameter(email_optional)";
            String adress ="request.getParameter(adress)";
            String address2_oprtional ="request.getParameter(address2_oprtional)";
            String country ="request.getParameter(country)";
            String state ="request.getParameter(state)";
            String zip ="request.getParameter(zip)";
            PrintWriter printWriter = response.getWriter();
            String contents ="<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\" data-bs-theme=\"light\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <title>Check Out Form</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"../static/checkoutform_jw.css\">\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body class=\"base\">\r\n" + //
                    "    <main class=\"title\">\r\n" + //
                    "        <div class=\"py-5 text-center\">\r\n" + //
                    "            <img src=\"https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg\" alt width=\"72\" height=\"57\">\r\n" + //
                    "            <h2>Checkout form</h2>\r\n" + //
                    "            <div>\r\n" + //
                    "                <div><p>Below is an example form built entirely with Bootstrap\u2019s form controls. Each required form group has a</p></div>\r\n" + //
                    "                <div><p>validation state that can be triggered by attempting to submit the form without completing it.</p></div>\r\n" + //
                    "            </div>\r\n" + //
                    "        </div>\r\n" + //
                    "    </main>\r\n" + //
                    "\r\n" + //
                    "\r\n" + //
                    "    <h3>Billding address</h3>\r\n" + //
                    "    <div>\r\n" + //
                    "        <form action=\"index.html\">\r\n" + //
                    "            First name <input type=\"text\" name="+first_name+">            \r\n" + //
                    "            Last name <input type=\"text\" name="+last_name+">\r\n" + //
                    "           \r\n" + //
                    "            <div>Username</div>\r\n" + //
                    "            <div>@<input type=\"text\" name="+username+" placeholder=\"Username\"></div>\r\n" + //
                    "           \r\n" + //
                    "            <div>Email(Optional)</div>\r\n" + //
                    "            <input type=\"email\" name="+email_optional+" placeholder=\"you@example.com\">\r\n" + //
                    "            <div>Adress</div>\r\n" + //
                    "            <input type=\"text\" name="+adress+" placeholder=\"1234 Main St\">\r\n" + //
                    "            <div>Address 2 (Optional)</div>\r\n" + //
                    "            <input type=\"text\" name="+address2_oprtional+" placeholder=\"Apartmentorsuite\">\r\n" + //
                    "            <div>\r\n" + //
                    "                <label for=\"country\">Country</label>\r\n" + //
                    "                <select name=\"country\" id=\"country\">\r\n" + //
                    "                    <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                    <option value=\"korea\">Korea</option>\r\n" + //
                    "                    <option value=\"china\">China</option>\r\n" + //
                    "                    <option value=\"japan\">Japan</option>\r\n" + //
                    "                    <option value=\"canada\">Canada</option>\r\n" + //
                    "                </select>\r\n" + //
                    "           \r\n" + //
                    "                <label for=\"state\">State</label>\r\n" + //
                    "                <select name=\"state\" id=\"state\">\r\n" + //
                    "                    <option value=\"\" selected>Choose...</option>\r\n" + //
                    "                    <option value=\"seoul\">Seoul</option>\r\n" + //
                    "                    <option value=\"busan\">Busan</option>\r\n" + //
                    "                    <option value=\"jeju\">Jeju</option>\r\n" + //
                    "                    <option value=\"gwangju\">Gwangju</option>\r\n" + //
                    "                </select>\r\n" + //
                    "           \r\n" + //
                    "            Zip <input type=\"text\" name="+zip+">\r\n" + //
                    "           </div>\r\n" + //
                    "            <hr>\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>\r\n" + //
                    "\r\n" + //
                    "</html>";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
