package com.example.study_servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter(urlPatterns = "/*")   // *는 all을 의미함
/* 서블릿 필터는 클라이언트 요청과 서블릿 또는 JSP로 가는 경로 사이에서 요청과 응답을 가로채고 처리할 수 있도록 도와주는 컴포넌트입니다.
  필터는 웹 애플리케이션에서 공통적으로 수행해야 하는 작업을 구현하고, 요청에 대한 사전 또는 사후 처리를 수행할 수 있습니다.
  예를 들어, 인증, 권한 부여, 로깅, 압축 등의 작업을 수행할 수 있습니다. */
public class SessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            System.out.println(request.getRemoteHost()); // .get으로 클라이언트의 정보를 알 수 있다
            System.out.println(request.getRemoteAddr());
            // chain.doFilter(request, response); // 정상적일 때 사용
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloWorldServlet");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new UnsupportedOperationException("Unimplemented method 'doFilter'");
    }

}
