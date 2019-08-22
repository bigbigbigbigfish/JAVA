package com.cao.http;

import java.util.HashMap;
import java.util.Map;

public class MINEType {
    private static final MINEType instance  = new MINEType();

    private static final String DEFAULT_CONTENT_TYPE = "text/plain";
    private final Map<String, String> supported = new HashMap<>();



    private MINEType() {
        supported.put("html", "text/html");
        supported.put("css", "text/css");
        supported.put("js", "application/javascript");
        supported.put("json", "application/json");
    }

    public String getContentType(String filename) {
        String suffix = getSuffix(filename);
        if(suffix == null) {
            return DEFAULT_CONTENT_TYPE;
        }

        String contentType = supported.get(suffix);
        if(contentType == null) {
            return DEFAULT_CONTENT_TYPE;
        }
        return contentType;
    }

    private String getSuffix(String filename) {
        int index = filename.lastIndexOf(".");
        if(index == -1) {
            return null;
        }
        return filename.substring(index+1);
    }


}
