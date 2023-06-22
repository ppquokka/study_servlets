package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Common;

@WebServlet(urlPatterns = "/optioninforservlet")
public class OptionInforsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Common commons = new Common();
            Statement statement = commons.getStatement(); // Editor in workbench
            String query = "SELECT *\n" + //
                    "FROM option_infors";
            ResultSet resultSet = statement.executeQuery(query);

            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n"
                    + //
                    "    <title>Document</title>\r\n" + //
                    "</head>\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <table class=\"table table-bordered table-hover\">\r\n" + //
                    "            <thead>\r\n" + //
                    "                <tr>\r\n" + //
                    "                    <th>OPTION_INFOR_ID</th>\r\n" + //
                    "                    <th>OPTION_NAME</th>\r\n" + //
                    "                </tr>\r\n" + //
                    "            </thead>\r\n" + //
                    "            <tbody>\r\n";
            while (resultSet.next()) {
                contents = contents + "                <tr>\r\n" + //
                        "                    <td>OI001</td>\r\n" + //
                        "                    <td>\uB124\uBE44\uAC8C\uC774\uC158</td>\r\n" + //
                        "                </tr>\r\n";
            }
            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "</html>";
            response.setContentType("text/html;charset=UTF-8"); // 클라이언트한테 보여지는 화면의 한글이 깨지는걸 방지해줌. getWriter 전에 charset
                                                                // 해줘야 함.
            PrintWriter printWriter = response.getWriter(); // 네트워크의 정보를 가져옴
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
