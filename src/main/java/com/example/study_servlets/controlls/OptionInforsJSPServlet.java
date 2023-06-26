package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.commons.Commons;
import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsJSPServlet")
public class OptionInforsJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String search = request.getParameter("search");

            // DB연결
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = optionInforsDao.SelectWithSearch(search);  // for문을 jsp에서 돌리기 위해 넘겨야 함. 여기까지는 servlet의 영역

            // for문 : html 영역으로 넘어가기
            request.setAttribute("search", search);   // search 넘겨주기
            request.setAttribute("optionInforList", optionInforList);  // jsp로 넘겨주기

            // getWriter 전에 charset 하기
            response.setContentType("text/html;charset=UTF-8");

            // JSP호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp"); // 특정 폴더에 넣어서 분류 가능
            requestDispatcher.forward(request, response);             

            /*
            // HTML쪽
            for(int i=0; i< optionInforList.size(); i=i+1) {
                HashMap optionInforRecord = new HashMap<>();
                optionInforRecord = (HashMap) optionInforList.get(i);
                // contents = contents + "                <tr>\r\n" + //
                //         "                    <td>"+optionInforRecord.get("OPTION_INFOR_ID")+"</td>\r\n" + //
                //         "                    <td>"+optionInforRecord.get("OPTION_NAME")+"</td>\r\n" + //
                //         "                </tr>\r\n";
            }
            */

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}