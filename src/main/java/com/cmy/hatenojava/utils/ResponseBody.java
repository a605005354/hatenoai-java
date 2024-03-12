package com.cmy.hatenojava.utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: hateno-java
 * @package: com.cmy.hatenojava.utils
 * @className: ResponseBody
 * @author: Terry Cai
 * @description: Response Body for http response
 * @date: 2/27/24 9:51 AM
 * @version: 1.0
 */
@Data
public class ResponseBody {

    public static Object ok() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object fail(String err) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", -1);
        obj.put("errmsg", err);
        return obj;
    }
}
