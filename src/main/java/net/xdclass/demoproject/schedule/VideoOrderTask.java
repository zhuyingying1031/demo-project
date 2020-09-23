package net.xdclass.demoproject.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class VideoOrderTask {

	@Scheduled(fixedDelay = 4000)   //每个2秒执行
	//@Scheduled(cron = "*/1 * * * * *")
	public void  sum(){
		/**
		 * 正常都是查数据库的
		 */
		System.out.println(LocalDateTime.now()+"当前交易="+Math.random());
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
