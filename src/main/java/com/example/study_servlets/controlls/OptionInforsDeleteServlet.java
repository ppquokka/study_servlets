package com.example.study_servlets.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsDeleteServlet")
public class OptionInforsDeleteServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
            String unique_id = request.getParameter("unique_id");   // 유니크아이디를 스트링으로 던지고, 인트로 받고, 그안에서는 딜리트 쿼리 동작
           
            OptionInforsDao optonInforsDao = new OptionInforsDao(); 
            int count = optonInforsDao.DeleteWithUniqueID(unique_id);

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter(); 
            String contents = "Delete count : "+count;
            printWriter.println(contents); 
            printWriter.close(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        super.doGet(request, response);
    }
}
