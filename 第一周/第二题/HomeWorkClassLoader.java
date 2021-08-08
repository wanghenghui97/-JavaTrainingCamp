package jvm;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HomeWorkClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Object hello = new HomeWorkClassLoader().findClass("Hello").newInstance();
            Method hello1 = hello.getClass().getMethod("hello");
            hello1.invoke(hello);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("src/main/java/jvm/Hello.xlass");
        File file1 = new File("src/main/java/jvm/Hello.class");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file1);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int len = bufferedInputStream.available();
            byte[] bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                byte read = (byte) (~bufferedInputStream.read());
                bytes[i] = read;
            }
            fileOutputStream.write(bytes);
            System.out.println(Arrays.toString(bytes));
            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return null;
        }


    }
}
