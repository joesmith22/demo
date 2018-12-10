package com.joe.numbercount.demo.scan;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author joe22
 * @date 2018/12/10
 */
@Component
public class ScannerFile {

    private List<String> allFile = new ArrayList<>(10);

    public List<String> getAllFile(String path){

        File f = new File(path) ;
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                String directoryPath = file.getPath();
                getAllFile(directoryPath);
            }else {
                String filePath = file.getPath();
                if (!filePath.endsWith(".md")){
                    continue;
                }
                allFile.add(filePath) ;
            }
        }

        return allFile ;
    }
}
