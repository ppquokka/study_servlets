package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/checkoutFormServlet")
public class CheckoutFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("CheckoutFormServlet - doGet()");
        try {
            PrintWriter printWriter = response.getWriter();
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "\r\n" + //
                    "    <title>Forms</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <div class=\"fs-3 text-center \">\r\n" + //
                    "            <img class=\"mt-4 mb-4\" src=\"../images/vespa.png\" alt=\"\uB85C\uACE0\">\r\n" + //
                    "            <p class=\"lead\">\r\n" + //
                    "                Checkout form\r\n" + //
                    "Below is an example form built entirely with Bootstrap\u2019s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.\r\n" + //
                    "            </p>\r\n" + //
                    "            \r\n" + //
                    "        </div>\r\n" + //
                    "        \r\n" + //
                    "        <form action=\"checkoutResponseServlet\">\r\n" + //
                    "            <h4 class=\"mb-4\">CheckOut Form</h4>\r\n" + //
                    "            <div class=\"row\">\r\n" + //
                    "                <div class=\"col-sm-6\">\r\n" + //
                    "                    <label for=\"firstname\" class=\"form-label\">First name</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" id=\"firstname\" name=\"first_name\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-sm-6\">\r\n" + //
                    "                    <label for=\"secondName\" class=\"form-label\">Second name</label>\r\n" + //
                    "                    <input class=\"form-control\" type=\"text\" id=\"secondname\" name=\"second_name\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-12\">\r\n" + //
                    "                    <label for=\"username\" class=\"form-label\">username</label>\r\n" + //
                    "                    <input type=\"text\" class=\"form-control\" id=\"username\" name=\"username\" placeholder=\"Username\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div>\r\n" + //
                    "                    <label for=\"email\" class=\"form-label\">E-mail</label>\r\n" + //
                    "                    <input type=\"email\" class=\"form-control\" id=\"username\" name=\"email\" placeholder=\"you@example.com\">\r\n" + //
                    "                </div>      \r\n" + //
                    "                <div>\r\n" + //
                    "                    <label for=\"address\" class=\"form-label\">Address</label>\r\n" + //
                    "                    <input type=\"text\"  class=\"form-control\" name=\"adderss\" placeholder=\"1234 Main St\">\r\n" + //
                    "                </div>\r\n" + //
                    "               <div>\r\n" + //
                    "                    <label for=\"address_2\" class=\"form-label\">Address2</label>\r\n" + //
                    "                    <input type=\"text\"  class=\"form-control\" name=\"adderss_2\" placeholder=\"APT or SUIT\">\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-md-5\">\r\n" + //
                    "                    <label for=\"country\" class=\"form-label\">Country </label>\r\n" + //
                    "                        <select class=\"form-select\" name=\"country\" id=\"country\">\r\n" + //
                    "                            <option value=\"\" selected>-----</option>\r\n" + //
                    "                            <option value=\"korea\" >Korea</option>\r\n" + //
                    "                            <option value=\"japan\">japan</option>\r\n" + //
                    "                            <option value=\"usa\">usa</option>\r\n" + //
                    "                        </select>\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-md-4\">\r\n" + //
                    "                    <label for=\"state\" class=\"form-label\">State </label>\r\n" + //
                    "                        <select class=\"form-select\" name=\"state\" id=\"state\">\r\n" + //
                    "                            <option value=\"\" selected>------</option>\r\n" + //
                    "                            <option value=\"gyeonggi-do\">Gyeonggi-do</option>\r\n" + //
                    "                            <option value=\"gwangju\">Gwangju</option>\r\n" + //
                    "                            <option value=\"pusan\">Pusan</option>\r\n" + //
                    "                        </select>\r\n" + //
                    "                </div>\r\n" + //
                    "                <div class=\"col-md-3 mb-4\">\r\n" + //
                    "                    <label for=\"zip\" class=\"form-label\">zip </label>\r\n" + //
                    "                    <input type=\"text\" class=\"form-control\" name=\"zip\" placeholder=\"12345\">\r\n" + //
                    "                </div> \r\n" + //
                    "                <button type=\"submit\">click</button>       \r\n" + //
                    "        </form>            \r\n" + //
                    "            <hr>\r\n" + //
                    "                ";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
