package com.example.study_servlets.controlls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/connectDBServle")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { // study_javas에서 ConnectDBs_Servlet.java의 try~catch문 복붙함
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            // ~~ 3306/데이터베이스 입력 : 데이터베이스가 동일해야 작동함
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars"; // local 호스트가 내커퓨터 자체를 말함
            String user = "yojulab";
            String password = "!yojulab*";
            // input시 java.sql로 해야함
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");
            // 워크벤치에서 db더블클릭해서 볼드체로된 것 까지 완료

            /*
             * - query Edit
             * statement가 에디터
             */
            Statement statement = connection.createStatement();
            // 에디터 띄우기 완

            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 익시큐트, 마이sql에서 번개. 완
            while (resultSet.next()) { // 얘는 db용, arraylist는 다른 용도
                // next는 뭉치를 던져주고 다음으로 넘어감. 즉 row1이 나옴
                // resultSet.getString("Company_ID");
                // resultSet.getString("Company");
                // 겟스트링은 그 데이터 타입을 따라감
                System.out.println(resultSet.getString("Company_ID") + resultSet.getString("Company"));
            }
            // 데이터 타입에 따라 getString등이 바뀐다. 우리는 string아니면 integer

            // SELECT COUNT(*) AS CNT FROM FACTORYS;
            query = "SELECT COUNT(*) AS CNT FROM FACTORYS";
            resultSet = statement.executeQuery(query);
            // 얘를 변수에담아서 활용하기
            int totalCount = 0;
            // ↓ 커서가 맨 앞으로 감
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalCount = resultSet.getInt("CNT");
            }

            /*
             * insert into FACTORYS
             * (COMPANY_ID, COMPANY)
             * value
             * ('car-01', 'AUDI');)
             */
            String companyId = "car-01 ";
            String company = "AUDI ";
            query = "insert into FACTORYS " +
                    "(COMPANY_ID, COMPANY) " +
                    " value " +
                    "('" + companyId + "', '" + company + "') ";

            int count = statement.executeUpdate(query); // table로 결과값 받을 필요 없으므로 이거 사용

            String Company_ID = "CAR-01 ";
            String Company = "페라리 ";
            query = "UPDATE factorys " +
                    "SET COMPANY = '" + Company + "' " +
                    "WHERE Company_ID = '" + Company_ID + "'";
            count = statement.executeUpdate(query);

            String deleteCompany_ID = "CAR-01 ";
            String deleteCompany = "페라리 ";
            query = "DELETE FROM factorys " +
                    "WHERE " +
                    "Company_ID = 'CAR-01' ";
            count = statement.executeUpdate(query);

            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        super.doGet(request, response);
    }
}

@WebServlet(urlPatterns = "/connectDBServlet")
public class ConnectDBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // - MySQL workbench 실행 : JDBC
            // - User/password와 접속 IP:port 접속
            String url = "jdbc:mysql://192.168.0.41:3306/db_cars";
            String user = "yojulab";
            String password = "!yojulab*";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB연결 성공\n");
            // - query Edit
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM factorys";
            ResultSet resultSet = statement.executeQuery(query); // 하면 결과값이 return됨. ..??
            while (resultSet.next()) {
                // query의 table을 가져올건데, 나올 값이 끝날때까지 돌기. next는 자체내에서 뭉치를 던지는 동작을함. 레코드가 다음레코드로
                // 넘어감.
                System.out.println(
                        resultSet.getString("COMPANY_ID") + " " + // getStting은 DB의 type을 따라가기때문에 getString
                                resultSet.getString("COMPANY"));
            }

            // SELECT count(*) AS CNT FROM factorys;
            query = "SELECT count(*) AS CNT FROM factorys";
            resultSet = statement.executeQuery(query);
            int totalcount = 0;
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("CNT"));
                totalcount = resultSet.getInt("CNT");
            }
            // INSERT INTO factorys
            // (COMPANY_ID,COMPANY)
            // value
            // ('CAR-01', 'AUDI');

            String COMPANY_ID = "CAR-01";
            String COMPANY = "AUDI";
            // query ="INSERT INTO factorys " + "(COMPANY_ID,COMPANY) " + "value " +
            // "('"+COMPANY_ID+"', '"+COMPANY+"') ";
            // // 변수를 넣어줄때 싱글 쿼테이션 '' 안에 더블 쿼테이션 ""을 넣고 ++사이에 변수를 넣어줘야한다.
            // int count = statement.executeUpdate(query);

            // UPDATE factorys
            // SET COMPANY = '패러리'
            // WHERE COMPANY_ID = 'CAR-01'
            COMPANY_ID = "CAR-01";
            COMPANY = "페라리";
            query = "UPDATE factorys " + "SET COMPANY ='" + COMPANY + "' " + "WHERE COMPANY_ID ='" + COMPANY_ID + "' "; // CAR-01
                                                                                                                        // AUDI를
                                                                                                                        // 페라리로
                                                                                                                        // 업데이트

            // DELETE FROM factorys
            // WHERE COMPANY_ID = 'CAR-01';
            query = "DELETE FROM factorys " + "WHERE COMPANY_ID = '" + COMPANY_ID + "'"; // CAR-01 페라리 삭제

            int count = statement.executeUpdate(query);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage()); // 에러 내용을 볼수 있는 명령문
            // TODO: handle exception
        }
        System.out.println();

    }

}
