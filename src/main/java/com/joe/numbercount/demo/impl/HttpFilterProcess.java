package com.joe.numbercount.demo.impl;

import com.joe.numbercount.demo.Filter.FilterProcess;

/**
 * @author joe22
 * @date 2018/12/10
 */
public class HttpFilterProcess implements FilterProcess {
    @Override
    public String process(String msg) {
        msg = msg.replaceAll("^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+","");

        return msg ;
    }
}
