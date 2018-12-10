package com.joe.numbercount.demo.impl;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author joe22
 * @date 2018/12/10
 */
@Component
public class TotalWords {

    private AtomicLong sum = new AtomicLong() ;

//    private long sum = 0 ;

    public void sum(int count){
        sum.addAndGet(count) ;
    }

    public  long total(){
        return sum.get() ;
    }
}
