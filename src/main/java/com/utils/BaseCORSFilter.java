package com.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ZhenXi on 2016/5/16.
 */
public class BaseCORSFilter {

    private static final Set<String> EMPTY = new HashSet<String>();

    private Set<String> parseAllowedOrigins(String allowedOriginsString) {
        if(!StringUtils.isEmpty(allowedOriginsString)) {
            return new HashSet<String>(Arrays.asList(allowedOriginsString.split(",")));
        } else {
            return EMPTY;
        }

    }

    public Set<String> getAllowedOrigins(String allowedOriginsString) {
        return parseAllowedOrigins(allowedOriginsString);
    }
}
