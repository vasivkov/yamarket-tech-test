package com.vasivkov.Utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    protected static BufferedInputStream bis;
    protected  static  final String PATH_TO_FILE = "src/main/resources/config.properties";
    protected static Properties properties;

    static {
        try {
            bis = new BufferedInputStream(new FileInputStream(PATH_TO_FILE));
            System.out.println(bis);
            properties = new Properties();
            properties.load(bis);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public  static String getTestProperty (String key){
        return properties.getProperty(key);
    }

}
