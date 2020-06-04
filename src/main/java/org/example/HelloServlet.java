package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  public static final Logger LOG = LogManager.getLogger(HelloServlet.class);

  private String fakeObjectToString(Object o) {
    return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
  }

  @Override
  public void init() throws ServletException {
    super.init();
    LOG.info("{} initialized!", this.getClass().getName());
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    LOG.trace("doGet(req: {}, res: {})", req, fakeObjectToString(res));
    LOG.info("This is an info message message from");
    System.out.println("This is a message from System.out");
    System.err.println("This is a message from System.err");

    LOG.trace("A message at TRACE");
    LOG.debug("A message at DEBUG");
    LOG.info("A message at INFO");
    LOG.warn("A message at WARN");
    LOG.error("A message at ERROR");

    out.println("Hello, world!");
    out.close();
  }
}
