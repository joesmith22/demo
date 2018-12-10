package com.joe.numbercount.demo.impl;

import com.joe.numbercount.demo.Filter.FilterProcess;

/**
 * @author joe22
 * @date 2018/12/10
 */
public class WrapFilterProcess implements FilterProcess {
    @Override
    public String process(String msg) {

        msg = msg.replaceAll("\\s*", "");

        return msg;
    }
}
