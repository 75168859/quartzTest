package quartzTest;

import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {
	public static void main(String[] args) throws Exception {
//		test1();
//		test2();
		test3byXML();
	}
	
	private static void test3byXML() throws Exception {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
	}

	public static void test1() throws Exception{
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = new JobDetail("helloQuartzJob", 
                Scheduler.DEFAULT_GROUP, HelloQuartzJob.class);

        SimpleTrigger simpleTrigger = new SimpleTrigger("simpleTrigger", 
                Scheduler.DEFAULT_GROUP);

        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()));
        simpleTrigger.setRepeatInterval(5000);
        simpleTrigger.setRepeatCount(10);

        scheduler.scheduleJob(jobDetail, simpleTrigger);
        scheduler.start();
        
	}
	
	public static void test2() throws Exception{
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = new JobDetail("helloQuartzJob", 
                Scheduler.DEFAULT_GROUP, HelloQuartzJob.class);

        String cronExpression = "30/5 * * * * ?"; // 每分钟的30s起，每5s触发任务        
        CronTrigger cronTrigger = new CronTrigger("cronTrigger", 
                Scheduler.DEFAULT_GROUP, cronExpression);
        scheduler.scheduleJob(jobDetail, cronTrigger);
        
        scheduler.start();
        
	}
	
	
	
	
}	
