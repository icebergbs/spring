package com.example.spring.beans;

import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CircleAlias {
    //alias : name
    private static final Map<String, String> aliasMap = new ConcurrentHashMap<>(16);

    public static void main(String[] args) {
        //alias 循环检查
        //当 A-> B 存在是, 若再次出现 B -> C -> A      abca环

    }

    /**
     * alias是否已存在，已存在则抛出IllegalStateException异常
     */
    private static void checkForAliasCircle(String name, String alias) {
        // 注意hasAlias的入参
        if (hasAlias(alias, name)) {
            throw new IllegalStateException("Cannot register alias '" + alias +
                    "' for name '" + name + "': Circular reference - '" +
                    name + "' is a direct or indirect alias for '" + alias + "' already");
        }
    }

    /**
     * 指定alias是否已存在
     */
    public static boolean hasAlias(String name, String alias) {
        String registeredName = aliasMap.get(alias);
        /**
         * 禁止的两种情况：
         *  1、map容器(carA:car)，指定(carA,car)
         *  2、map容器(carA:car,carC:carA)，指定(carC,car)
         */
        return ObjectUtils.nullSafeEquals(registeredName, name) || (registeredName != null
                && hasAlias(name, registeredName));
    }
}
