package com.phuong.livestreamapi.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ConvertResponseUtils {

    private static final HashMap<String, String> itemDocument = new HashMap<>() {{
    }};

    String convertResponseBlog(String item) {
        return itemDocument.getOrDefault(item, "");
    }

}
