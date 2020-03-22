package org.dependencycheck.testing;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 278457735741304509L;

    private String message;

    @Override
    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>" + message + "</h1></body></html>");
    }

}
