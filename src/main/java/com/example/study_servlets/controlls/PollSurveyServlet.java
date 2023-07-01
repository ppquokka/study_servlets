package com.example.study_servlets.controlls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.study_servlets.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyServlet")
public class PollSurveyServlet  extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // String contents = "Yoju Lab !";
            String contents = request.getParameter("company");

            PollsDao pollsDao = new PollsDao();
            ArrayList surveyList = pollsDao.SelectWithSearch(contents);  //매서드 호출함. 그러면 리턴값을 배출함(=변수가 있다): inforlist. 근데 받는애는 걔의 내용을 받아야함.
                                                  // 받을 땐 변수 타입이 중요함(이름은 중요하지 않음). 타입 볼 수 있는 방법은 pollsDao의 퍼블릭 클래스 다음줄에서 확인 가능 
            
            // 문항과 답항 출력시키기
            // for(int i=0; i< surveyList.size(); i=i+1){
            //     HashMap survey = (HashMap)surveyList.get(i);
            //     String questions = (String) survey.get("QUESTIONS");
            //     String choice = (String) survey.get("CHOICE");
            //     System.out.println(questions +", " + choice);


            // 과제: 질문1_답1,답2,답3 | 질문2_답1,답2,답3...
            String compare = "";
            for(int i=0; i< surveyList.size(); i=i+1){
                HashMap survey = (HashMap)surveyList.get(i);
                String questions = (String)survey.get("QUESTIONS");
                String questionsId = (String)survey.get("QUESTIONS_ID");
                String choice = (String)survey.get("CHOICE");
                if(!compare.equals(questionsId)){   // 같이 않으면 프린트해라
                System.out.println(questions);
                System.out.println(choice);
                compare = questionsId;
                } else {
                    System.out.println(choice);  // 숫자가 안들어가는게 좋다. 루핑이 유연하면 좋다
                }
            }

            request.setAttribute("contents", contents);
            request.setAttribute("surveyList", surveyList);
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/surveys/survey.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
