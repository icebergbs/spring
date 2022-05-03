package com.example.spring.context;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

/**
 * 定义转换器
 */
public class String2DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        return new Date();
    }
}
