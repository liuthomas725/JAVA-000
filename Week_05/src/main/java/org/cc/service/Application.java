package org.cc.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String packName = "org.cc.service";
        Map<String,Object> map = new HashMap<>();
        URL url = Thread.currentThread().getContextClassLoader().getResource(packName.replaceAll("\\.", "/"));
        url.getPath();
        File file = new File(url.getPath());
        for(File f : file.listFiles()){
            try {
                Class<?> serviceClass = Thread.currentThread().getContextClassLoader().loadClass(packName + "." +f.getName().substring(0,f.getName().indexOf(".")));
                if(serviceClass.isAnnotationPresent(Service.class)){
                    map.put(serviceClass.getSimpleName(),serviceClass.newInstance());
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
