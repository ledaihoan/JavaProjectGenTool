package com.hoanld.sampleproject.handlers;

import com.hoan.common.logging.HLogger;
import com.hoan.common.servlet.ServletUtils;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeHandler extends HttpServlet {
    static Logger _logger = HLogger.getLogger(HomeHandler.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        long id = ServletUtils.getLongParameter(request, "id", 0);
        String url = "/home";
        if(id != 0) {
            url = "/abc-" + (id/10) + ".html";
        }        
        String content = "<p>Your request url form like this: <a href=\"" + url + "\">" + url + "</a></p><p>" +
                "But url rewrite filter make it equals to this: <a href=\"/home?id=" + id + "\">/home?id=" + id + "</a></p>";
	ServletUtils.printHtml(response, content);
    }
}
