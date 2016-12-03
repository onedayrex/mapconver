package com.git.onedayrex.mapconver.util;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/12/4.
 */
public class MapConverUtilTest {
    @Test
    public void mapListToBeanList() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("cat_id", "1020");
        map.put("cat_Name", "book");
        map.put("loanPmt", new BigDecimal("100"));
        Map<String, Object> map2 = new HashMap<>();
        map2.put("cat_id", "1030");
        map2.put("cat_Name", "pen");
        list.add(map);
        list.add(map2);
        List<CatProd> catProds = MapConverUtil.mapListToBeanList(list, CatProd.class);
        System.out.println(catProds);
    }

}