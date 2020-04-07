package com.rigel.basic.base.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    private String loaderName;
    private String path;

    public MyClassLoader(String path, String loaderName) {
        this.loaderName = loaderName;
        this.path = path;
    }

    @Override
    public Class findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
        String allName = path + name + ".class";
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(new File(allName));
            out = new ByteArrayOutputStream();
            int i = 0;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
