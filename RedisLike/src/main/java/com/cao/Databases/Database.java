package com.cao.Databases;
import java.util.*;

public class Database {
    private static Database database = new Database();
    private Database() {}

    public static Database getDatabase() {
        return database;
    }

    public static Map<String, String> str = new HashMap<>();

    public static Map<String, HashMap<String ,String>> map = new HashMap<>();

    public static Map<String,List<String>> list = new HashMap<>();

    public static Map<String,Set<String>> set = new HashMap<>();

    public static Map<String,LinkedList<String>> zset = new HashMap<>();


    public static HashMap<String,String> getMap(String key) {
        HashMap<String,String> Rmap =map.get(key);
        if(Rmap == null) {
            Rmap = new HashMap<>();
            map.put(key,Rmap);
        }
        return Rmap;
    }

    public static Set<String>  getSet(String key) {
        Set<String> hashSet = set.get(key);
        if(hashSet == null) {
            hashSet = new HashSet<>();
            set.put(key,hashSet);
            return hashSet;
        }
        return hashSet;
    }

    public static List<String> getList(String key) {
        List<String> lists = list.computeIfAbsent(key, k -> {
            return new ArrayList<>();
        });
        return lists;
    }

}
