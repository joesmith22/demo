package com.joe.numbercount.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		String url = "https://gitee.com/crossoverJie/Java-Interview" ;
		String https = url.replaceAll("^((https|http|ftp|rtsp|mms)?:\\/\\/)[^\\s]+", "");
		System.out.println(https);
	}

	@Test
	public void recursiveFile(){
		getFile("/Users/joe22/Downloads/qrscan-master");
		System.out.println("recursiveCount="+recursiveCount);
	}

	private int recursiveCount = 0 ;

	public void getFile(String path){
		recursiveCount ++ ;
		File f = new File(path) ;

		File[] files = f.listFiles();
		for (File file : files) {
			if (file.isDirectory()){
				String path1 = file.getPath();
				getFile(path1);
			}else {

				String path1 = file.getPath();
				if (!path1.endsWith(".md")){
					continue;
				}
				System.out.println(path1);

			}
		}
	}
}
