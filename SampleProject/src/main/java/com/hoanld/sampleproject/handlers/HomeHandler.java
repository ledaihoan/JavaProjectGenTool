package com.hoanld.sampleproject.handlers;

import com.hoan.common.logging.HLogger;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HomeHandler extends HttpServlet {
    static Logger _logger = HLogger.getLogger(HomeHandler.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String str = request.getParameter("id");
        long id = 0;
        try {
            id = Long.parseLong(str);
        } catch(NumberFormatException e) {

        }
        String url = "/home";
        if(id != 0) {
            url = "/abc-" + (id/10) + ".html";
        }
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        String content = "<p>Your request url form like this: <a href=\"" + url + "\">" + url + "</a></p><p>" +
                "But url rewrite filter make it equals to this: <a href=\"/home?id=" + id + "\">/home?id=" + id + "</a></p>";

        try {
            response.setCharacterEncoding("utf-8");
            out = response.getWriter();
            out.print(content);
            out.close();
        } catch (Throwable ex) {
            _logger.error(ex.getMessage(), ex);
        } finally {
            if(out != null) out.close();
        }
    }
}
