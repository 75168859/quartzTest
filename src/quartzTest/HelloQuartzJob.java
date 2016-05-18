package quartzTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloQuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("!! HelloQuartzJob!!! "
				+ new SimpleDateFormat("yyyy-mm-dd hh:mm:ss")
						.format(new Date()) + "!!!!!");
	}

}
