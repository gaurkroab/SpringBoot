package com.gk.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.document.PlayerInfo;
import com.gk.service.IPlayerMgmtService;

@Component
public class SpecialTypesTestRunner implements CommandLineRunner {

	@Autowired
	IPlayerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		
		/*	PlayerInfo info = new PlayerInfo();
			info.setPid(new Random().nextInt(1000));
			info.setPname("jadeja");
			info.setPaddrs("Ahamadabad");
			info.setNikNames(List.of("jaddu","sir ravindra jadeja"));
			info.setFriends(new String[] {"dhoni","ashwin","raina","kohali"});
			info.setImpKnoks(Map.of("asia cup","35 runs","2019 world cup semi-final","60+ runs"));
			info.setContactNumbers(Set.of(99999999L,88888888L,7777777L));
			Properties props = new Properties();
			props.put("aadhar","99999L123");
			props.put("panCard","88888L5455");
			info.setIdDetails(props);
			System.out.println(service.registerPlayer(info));
		*/
		
		System.out.println(service.searchPlayer(942));
	}

}
