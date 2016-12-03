package com.git.onedayrex.mapconver.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Administrator on 2016/12/3.
 */
public class MapConverUtil {

    /**
     * 把数据库中的字段如
     * cat_id 转化成为 bean的字段 catId
     * @param map
     * @return
     */
    public static <T> T dbFiledToBean(Map<String,Object> map,Class<T> clazz){
        Set<String> allKeys = map.keySet();
        Map<String, Object> reslut = new HashMap<>();
        for (String allKey : allKeys) {
            String[] split = allKey.split("_");
            StringBuilder keySb = new StringBuilder();
            Object o = map.get(allKey);
            for (int i = 0; i < split.length; i++) {
                StringBuilder filed = new StringBuilder();
                filed.append(split[i]);
                if (i != 0) {
                    char c = split[i].charAt(0);
                    c = Character.toUpperCase(c);
                    filed.replace(0, 1, String.valueOf(c));
                }
                keySb.append(filed);
            }
            reslut.put(keySb.toString(), o);
        }
        Field[] fields = clazz.getDeclaredFields();
        T obj = null;
        try {
            obj = (T) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        for (Field field : fields) {
            if (reslut.containsKey(field.getName())) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    //如果有setter方法
                    if (method.getName().startsWith("set")) {
                        /**构造setter方法名**/
                        StringBuilder sb = new StringBuilder();
                        StringBuilder upCaseField = new StringBuilder();
                        sb.append("set");
                        upCaseField.append(field.getName());
                        char c = upCaseField.charAt(0);
                        c = Character.toUpperCase(c);
                        upCaseField.replace(0, 1, String.valueOf(c));
                        sb.append(upCaseField);
                        if (method.getName().equals(sb.toString())) {
                            try {
                                Object o = reslut.get(field.getName());
                                method.invoke(obj, o);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return obj;
    }

    public static <T> List<T> mapListToBeanList(List<Map<String,Object>> maps,Class<T> clazz){
        List<T> list = new ArrayList<T>();
        for (Map<String, Object> map : maps) {
            T obj = dbFiledToBean(map,clazz);
            list.add(obj);
        }
        return list;
    }
}
