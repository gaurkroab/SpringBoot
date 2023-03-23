package com.gk.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.document.Medal;
import com.gk.document.Player;
import com.gk.document.Sport;
import com.gk.service.IPlayerMgmtService;

@Component
public class OneToManyAssociationTestRunner implements CommandLineRunner {

	@Autowired
	IPlayerMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*try {
			// parent object 
			Player player = new Player();
			player.setPid(new Random().nextInt(1000));
			player.setPname("gaurav");
			player.setPaddrs("aligarh");
			
			// child object
			Sport sport1=new Sport();
			sport1.setSid(new Random().nextInt(10));
			sport1.setType("Batminton");
			sport1.setKititems(new String[] {"cock","bat","net"});
			
			Sport sport2=new Sport();
			sport2.setSid(new Random().nextInt(20));
			sport2.setType("Tennis");
			sport2.setKititems(new String[] {"ball","bat","net"});
			
			// child2 object
			Medal m1=new Medal();
			m1.setMid(1001);
			m1.setMname("Gold-Batminton");
			m1.setEvent("World Championship");
			m1.setPlace("newyork");
			
			Medal m2=new Medal();
			m2.setMid(1002);
			m2.setMname("Silver-Tennis");
			m2.setEvent("World Championship");
			m2.setPlace("Tokyo");
			
			// perform asociation
			player.setSports(Set.of(sport1,sport2));
			player.setMedals(Map.of("Gold",m1,"Silver",m2));
			
			// use service
			
			System.out.println(service.registerPlayer(player));
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		
	}

}
