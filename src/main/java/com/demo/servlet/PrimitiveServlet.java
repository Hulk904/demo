package com.demo.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yangyuan on 16-8-29.
 */
public class PrimitiveServlet implements Servlet{
    public void init(ServletConfig config) throws ServletException
    {
        System.out.println("init");
    }
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
    { System.out.println("from service");
        PrintWriter out = response.getWriter();
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }
    public void destroy()
    {
        System.out.println("destroy");
    }
    public String getServletInfo()
    {
        return null;
    }
    public ServletConfig getServletConfig() {
        return null;
    }
}
