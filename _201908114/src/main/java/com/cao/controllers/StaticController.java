package com.cao.controllers;

import com.cao.http.Controller;
import com.cao.http.Request;
import com.cao.http.Response;


import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

public class StaticController extends Controller {
    private static final String HOME = System.getenv("HOME");

    @Override
    public void doGet(Request request, Response response) throws IOException {
        String filename =getFileName(request.getUrl());
        //String contentType =  MIMEType.getInstance().getContentType(filename);

    }

    private String getFileName(String url) throws IOException {
        if(url.equals("/")) {
            url = "index.html";
        }
        return HOME + File.separator + "webapp" + URLDecoder.decode(url, "UTF8").replace("/", File.separator);

    }



    private static void quitSort(int[] arr ,int start, int end) {
        if(start <end) {
            int stand = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= stand) {
                    high--;
                }
                arr[low] = arr[high];

                while (low < high && arr[low] <= stand) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;
            quitSort(arr, start, low);
            quitSort(arr, low + 1, end);
        }
    }
}


