package com.joe.numbercount.demo.config;

import com.joe.numbercount.demo.Filter.FilterProcess;
import com.joe.numbercount.demo.impl.HttpFilterProcess;
import com.joe.numbercount.demo.impl.WrapFilterProcess;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.*;

/**
 * @author joe22
 * @date 2018/12/10
 */
public class ProcessConfig {
    private int corePoolSize = 4;

    private int maxPoolSize = 4;

    @Bean
    public ExecutorService sendMessageExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("scan-number-%d").build();

//        ForkJoinPool
        ExecutorService executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        return executor;
    }

    /**
     * Set the capacity for the ThreadPoolExecutor's BlockingQueue.
     */
    private int queueCapacity = 256;

    @Bean("httpFilterProcess")
    public FilterProcess httpFilterProcess() {
        return new HttpFilterProcess();
    }

    @Bean("numberFilterProcess")
    public FilterProcess numberFilterProcess() {
        return new WrapFilterProcess();
    }

}
