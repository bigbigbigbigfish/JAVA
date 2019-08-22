package com.cao.http;

import java.io.IOException;

public class Controller {
    public void doPost(Request request, Response response) throws IOException {
        if (request.getProtocol().endsWith("1.1")) {
            response.setStatus(Status.METHOD_NOT_ALLOWED);
            response.println(Status.METHOD_NOT_ALLOWED.getReason());
        } else {
            response.setStatus(Status.BAD_REQUEST);
            response.println(Status.BAD_REQUEST.getReason());
        }
    }

    public void doGet(Request request, Response response) throws IOException {
        if (request.getProtocol().endsWith("1.1")) {
            response.setStatus(Status.METHOD_NOT_ALLOWED);
            response.println(Status.METHOD_NOT_ALLOWED.getReason());
        } else {
            response.setStatus(Status.BAD_REQUEST);
            response.println(Status.BAD_REQUEST.getReason());
        }
    }
    public void init() {
    }
    public void destroy() {
    }

}
