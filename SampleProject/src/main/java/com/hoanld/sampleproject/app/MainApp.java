package com.hoanld.sampleproject.app;

import com.hoanld.sampleproject.servers.HttpServer;

public class MainApp {
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        if(!server.setupAndStart()) {
            System.out.println("Could not start httpserver! Exiting...");
            System.exit(-1);
        }
    }
}
