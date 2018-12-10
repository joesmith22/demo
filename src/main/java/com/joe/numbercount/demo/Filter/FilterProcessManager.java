package com.joe.numbercount.demo.Filter;

import com.joe.numbercount.demo.impl.TotalWords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author joe22
 * @date 2018/12/10
 */
@Service
public class FilterProcessManager {

    @Autowired
    private TotalWords totalWords;

    @Resource(name = "numberFilterProcess")
    private FilterProcess numberFilterProcess;

    @Resource(name = "httpFilterProcess")
    private FilterProcess httpFilterProcess;

    private List<FilterProcess> filterProcesses = new ArrayList<>(10);

    @PostConstruct
    public void start() {
        this.addProcess(numberFilterProcess)
                .addProcess(httpFilterProcess);
    }

    public FilterProcessManager addProcess(FilterProcess process) {
        filterProcesses.add(process);
        return this;
    }

    /* 处理
     * @param msg
     */
    public void process(String msg) {
        for (FilterProcess filterProcess : filterProcesses) {
            msg = filterProcess.process(msg);
        }
        totalWords.sum(msg.toCharArray().length);
    }
}
