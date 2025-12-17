package com.pinkitec.aps.utils;

public final class UUID {
    public static String randomUUID(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SnowTebuflakeUtils.snowflakePkIdSign);
        stringBuilder.append(SnowTebuflakeUtils.snowflake.nextId());
        return String.valueOf(stringBuilder);
    }
}
