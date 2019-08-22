package com.cao.Databases;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permanent {
    /***
     * 持久化数据
     */

    private static Permanent permanent = new Permanent();

    private static File listProfile = new File("D:" + File.separator + "File" + File.separator + "list.bin");
    private static File mapProfile = new File("D:" + File.separator + "File" + File.separator + "map.bin");

    public static Permanent getPermanent() {
        return permanent;
    }

    public void writetoListProfile() {
        //检查文件是否存在
        if (!listProfile.getParentFile().exists()) {
            listProfile.getParentFile().mkdirs();
        }
        //创建文件
        if(!listProfile.exists()) {
            try {
                listProfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(listProfile))) {
            os.writeObject(Database.list);
            System.out.println("向文件中写入数据" + Database.list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clearListProfile(){
        if (listProfile.exists() && listProfile.length()!=0) {
            try  {
                listProfile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 从文件中加载资源, 使用ObjectInputStream来接收
     */
    public  void readFromListProfile() {

        if (listProfile.exists() && listProfile.length()!=0) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(listProfile))) {
                Database.list = (Map<String, List<String>>) is.readObject();
                System.out.println(Database.list + "从文件中读数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public  void writetoMapProfile() {
        //检查文件是否存在
        if (!mapProfile.getParentFile().exists()) {
            mapProfile.getParentFile().mkdirs();
        }
        //创建文件
        if (!mapProfile.exists()) {
            try {
                mapProfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(mapProfile))) {
            os.writeObject(Database.map);
            System.out.println("向文件中写入数据" + Database.map);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }


    /*
     * 从文件中加载资源，使用ObjectIntputStream来接收
     * */

    public  void readFromMapProfile() {

        //要保证文件存在并且文件中有内容
        if (mapProfile.exists() && mapProfile.length()!=0) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(mapProfile))) {
                Database.map = (HashMap<String, HashMap<String,String>>) is.readObject();
                System.out.println(Database.map + "从文件中读数据");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




}
