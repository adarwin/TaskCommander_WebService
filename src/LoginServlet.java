package com.adarwin.csc435;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
  @Override
  protected void doGet (HttpServletRequest request,
                     HttpServletResponse response)
              throws ServletException, IOException
  {
    HttpSession session = request.getSession();
    PrintWriter out = response.getWriter();
    String htmlOutput = "<html><head></head><body>";
    htmlOutput += "<h1>" + Math.random() + "</h1>";
    htmlOutput += "</body></html>";
    out.println(htmlOutput);
  }

  @Override
  protected void doPost (HttpServletRequest request,
                      HttpServletResponse response)
              throws ServletException, IOException
  {
    HttpSession session = request.getSession();
    PrintWriter out = response.getWriter();
    String htmlOutput = "<html><head></head><body>";
    htmlOutput += "<h1>Got Post Request</h1>";
    htmlOutput += "<p>getAuthType() = " + request.getAuthType() + "</p>";
    htmlOutput += "<p>getContextPath() = " + request.getContextPath() + "</p>";
    //htmlOutput += "<p>getDateHeader() = " + request.getDateHeader() + "</p>";
    //htmlOutput += "<p>getHeader() = " + request.getHeader() + "</p>";
    htmlOutput += "<p>getMethod() = " + request.getMethod() + "</p>";
    htmlOutput += "<p>getPathInfo() = " + request.getPathInfo() + "</p>";
    htmlOutput += "<p>getPathTranslated() = " + request.getPathTranslated() + "</p>";
    htmlOutput += "<p>getQueryString() = " + request.getQueryString() + "</p>";
    htmlOutput += "<p>getRemoteUser() = " + request.getRemoteUser() + "</p>";
    htmlOutput += "<p>getRequestedSessionId() = " + request.getRequestedSessionId() + "</p>";
    htmlOutput += "<p>getRequestURI() = " + request.getRequestURI() + "</p>";
    htmlOutput += "<p>getServletPath() = " + request.getServletPath() + "</p>";
    htmlOutput += "<p>getParameter() = " + request.getParameter("username") + "</p>";
    htmlOutput += "<h2>getHeaderNames()</h2>";
    List<String> names = Collections.list(request.getHeaderNames());
    htmlOutput += "<ul>";
    for (String name : names)
    {
      htmlOutput += "<li>" + name + "</li>";
      try
      {
      htmlOutput += "<ul><li>" + request.getDateHeader(name) + ": " + request.getHeader(name) + "</li>";
      }
      catch (IllegalArgumentException ex)
      {
      htmlOutput += "<ul><li>" + request.getHeader(name) + "</li></ul>";
      }
      //htmlOutput += "<li>int version: " + request.getIntHeader(name) + "</li></ul>";
    }
    htmlOutput += "</ul>";
    htmlOutput += "<h1>And now for the session methods</h1>";
    htmlOutput += "<p>getCreationTime() = " + session.getCreationTime() + "</p>";
    htmlOutput += "<p>getId() = " + session.getId() + "</p>";
    htmlOutput += "<p>getLastAccessedTime() = " + session.getLastAccessedTime() + "</p>";
    htmlOutput += "<h2>getAttributeNames()</h2>";
    names = Collections.list(session.getAttributeNames());
    htmlOutput += "<ul>";
    for (String name : names)
    {
      htmlOutput += "<li>" + name + "</li>";
      /*
      try
      {
      htmlOutput += "<ul><li>" + session.getDateHeader(name) + ": " + request.getHeader(name) + "</li>";
      }
      catch (IllegalArgumentException ex)
      {
      htmlOutput += "<ul><li>" + request.getHeader(name) + "</li></ul>";
      }
      */
      //htmlOutput += "<li>int version: " + request.getIntHeader(name) + "</li></ul>";
    }
    htmlOutput += "</ul>";
    htmlOutput += "</body></html>";
    out.println(htmlOutput);
  }
}
