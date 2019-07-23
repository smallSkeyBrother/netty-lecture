package com.xiaotiangege.netty.webcontainer.utils;

import com.google.common.base.Strings;

import java.util.Objects;

/**
 * @author wangfeilong
 * @version v1.0
 * @Description //TODO
 * @Date 2019/7/23 16:15
 **/
public class UriUtil {

    /**
     * 检查目标uri是否符合正则规则
     *
     * @param target
     * @param regex
     * @return
     */
    public static boolean checkUri(String target, String regex) {
        boolean flag = false;
        if (Strings.isNullOrEmpty(target) || Strings.isNullOrEmpty(regex)) {
            flag = false;
        } else if (target.length() < regex.length()) {
            flag = false;
        } else if (target.length() == regex.length() && target.equals(regex)) {
            flag = true;
        } else if (regex.contains("*")) {
            int idx = regex.indexOf("*");
            if (target.substring(0, idx).equals(regex.substring(0, idx))) {
                flag = true;
            }
        }
        return flag;
    }
}
