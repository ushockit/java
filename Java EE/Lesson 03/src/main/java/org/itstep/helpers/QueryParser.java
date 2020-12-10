package org.itstep.helpers;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {
    public static Map<String, String> parse(String query) {
        Map<String, String> map = new HashMap<>();
        if (query == null){
            return map;
        }

        var params = query.split("&");
        for (String param : params) {
            var vals = param.split("=");
            map.put(vals[0], vals[1]);
        }

        return map;
    }
}
