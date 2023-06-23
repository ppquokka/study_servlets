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
