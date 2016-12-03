package com.git.onedayrex.util;

import com.git.onedayrex.mapconver.util.CatProd;
import com.git.onedayrex.mapconver.util.MapConverUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/3.
 */
public class MapConverUtilTest {
    @Test
    public void dbFiledToBean() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("cat_id", "1020");
        CatProd cat = MapConverUtil.dbFiledToBean(map, CatProd.class);
        Assert.assertEquals(cat.getCatId(),"1020");
    }

}
