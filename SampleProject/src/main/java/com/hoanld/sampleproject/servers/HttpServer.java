package com.hoanld.sampleproject.servers;


import com.hoan.common.servers.JettyWebServer;
import com.hoanld.sampleproject.handlers.HomeHandler;
import com.hoanld.sampleproject.util.UrlRewriteFilter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class HttpServer {
    public boolean setupAndStart() {
        JettyWebServer servers = new JettyWebServer("demoserver");
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HomeHandler.class, "/home");
        EnumSet<DispatcherType> set = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        handler.addFilter(UrlRewriteFilter.class, "/*", set);
        //Static file
        ContextHandler resourceHandler = new ContextHandler("/static");
        resourceHandler.setResourceBase("./public");
        resourceHandler.setHandler(new ResourceHandler());
        GzipHandler gzip = new GzipHandler();
        gzip.setHandler(handler);
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, gzip, handler});

        servers.setup(handlers);
        return servers.start();
    }
}
