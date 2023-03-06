package com.gk.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.entity.CallerTuneInfo;
import com.gk.service.ICallerTuneMgmtService;


@Component
public class VersioningAndTimeStampingTest implements CommandLineRunner {

	@Autowired
	private ICallerTuneMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			CallerTuneInfo info = new CallerTuneInfo("oo antava mama","puspa");
			System.out.println(service.saveCallerTuneInfo(info));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	*/
		try {
			System.out.println(service.updatedTuneInfoById(1, "joome jo pathan", "pathan"));
			System.out.println(service.showCallerTuneDetailsById(1));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
