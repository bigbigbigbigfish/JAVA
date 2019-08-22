package com.cao;

import com.cao.http.Controller;
import com.cao.http.CustomerClassLoader;
import com.cao.http.Request;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebApp {

    private static final String HOME = System.getenv("HOME");
    private Map<String, String> mappings = new HashMap<>();
    private Map<String, String> classes = new HashMap<>();
    private Map<Class<? extends Controller>, Controller> objects = new HashMap<>();
    private WebApp() {
    }
    public static WebApp parseXML() throws IOException {
        WebApp webApp = new WebApp();
        String filename = HOME + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator + "web.xml";
        Documented documented = null;
        try {
            documented = (Documented) new SAXReader().read(filename);
        } catch (DocumentException e) {
            throw new IOException();
        }
        Iterator<Element> iterator = ((Document) documented).getRootElement().elementIterator();
        while (iterator.hasNext()) {
            Element element = iterator.next();
            switch (element.getName()) {
                case "controller" : {
                    String name = element.element("name").getText();
                    String cls = element.element("class").getText();
                    webApp.classes.put(name,cls);
                    break;
                }

                case "mapping" : {
                    String name = element.element("name").getText();
                    String urlPattern = element.element("url-pattern").getText();
                    webApp.mappings.put(name,urlPattern);
                    break;
                }
            }
        }
        return webApp;
    }

    public Controller findController(Request url) {
        String name = findName(url);
        if(name == null) {
            return null;
        }

        Class<? extends Controller> cls = findClass(name);
        if(cls == null) {
            return null;
        }
        //初始化控制器
        Controller controller = objects.get(cls);
        if(controller == null) {
            controller = initializeController(cls);
            controller.init();
        }
        return controller;


    }

    private Controller initializeController(Class<? extends Controller> cls) {
        try {
            Controller controller = (Controller)cls.newInstance();
            objects.put(cls,controller);
            return controller;
        } catch (IllegalAccessException | InstantiationException e) {
            return null;
        }
    }
    public void destroy() {
        for (Controller controller : objects.values()) {
            controller.destroy();
        }
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Controller> findClass(String name) {
        String className = classes.get(name);
        if(className == null) {
            return null;
        }

        Class<?> cls;
        try {
            cls = new CustomerClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            return null;
        }

        if(!Controller.class.isAssignableFrom(cls)) {
            return null;
        }
        return (Class<? extends Controller>)cls;
    }

    private String findName(Request url) {
        for (Map.Entry<String,String> entry : mappings.entrySet()) {
            Pattern pattern = Pattern.compile(entry.getValue());
            Matcher matcher = pattern.matcher((CharSequence) url);
            if(matcher.matches()) {
                return entry.getKey();
            }
        }
        return null;
    }

}
