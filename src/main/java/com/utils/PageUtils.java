package com.utils;

/**
 * Created by ZhenXi on 2016/1/13.
 */
public class PageUtils {

    public static final Integer offset = 20;

    public static Integer getCursor(Integer page){
        if (page <= 0) {
            return 0;
        }
        return page  * offset - offset;
    }

    /*public static void main(String[] args) {
        System.out.print(getCursor(0, 10));
    }*/
}
