package org.cc.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class MyDefineClassLoader extends ClassLoader {
    //指定路径
    private String path;


    public MyDefineClassLoader(String classPath) {
        path = classPath;
    }

    @Override
    protected Class<?> findClass(String name) {
        Class log = null;
        byte[] classData = getData();

        if (classData != null) {
            log = defineClass(name, classData, 0, classData.length);
        }
        return log;

    }

    private byte[] getData() {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size;
                while ((size = in.read(buffer)) != -1) {
                    for(int i = 0;i< size ;i++){
                        buffer[i] = (byte) (255 - buffer[i]);
                    }
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        MyDefineClassLoader myDefineClassLoader = new MyDefineClassLoader("C:\\Users\\Thomas\\Desktop\\Hello\\Hello.xlass");
        Class helloClass =  myDefineClassLoader.findClass("Hello");
        Method method = helloClass.getMethod("hello");
        method.invoke(helloClass.newInstance());
    }
}
