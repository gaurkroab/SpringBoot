package com.gk.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.entity.MarriageSeeker;
import com.gk.service.IMarriageSeekerMgmtService;

@Component
public class LOBsTestRunner implements CommandLineRunner {

	@Autowired
	private IMarriageSeekerMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter person name::");
		String name=sc.next();
		
		System.out.println("Enter person addrs::");
		String addrs=sc.next();
		
		System.out.println("is person Indian ::");
		boolean indian = sc.nextBoolean();		
		
		System.out.println("Enter person photo file complete path :: ");
		sc.nextLine();
		String photoPath=sc.nextLine();
		
		System.out.println("Enter person biodata file complete path :: ");
		String biodataPath=sc.nextLine();
		
		// prepare byte[] representing photo file content 
		InputStream is = new FileInputStream(photoPath);
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes();
		
		// prepare char[] representing biodata file content
		File file=new File(biodataPath);
		Reader reader = new FileReader(file);
		char[] bioDataContent=new char[(int) file.length()];
		reader.read(bioDataContent);
		
		// prepare enttiy class obj
		MarriageSeeker seeker = new MarriageSeeker(name, addrs, photoData, bioDataContent, indian);
		System.out.println(service.registerMarriageSeeker(seeker));
		
		*/
		
		System.out.println("=====================================");
		Optional<MarriageSeeker> opt = service.searchSeekerById(1);
		if(opt.isPresent()) {
			MarriageSeeker seeker = opt.get();
			System.out.println(seeker.getId()+"  "+seeker.getName()+"  "+seeker.getAddrs()+"   "+seeker.isIndian());
			OutputStream os = new FileOutputStream("retieve_photo.jpg");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer = new FileWriter("retrieve_biodata.txt");
			writer.write(seeker.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("LOBs are retrieved");
		}else {
			System.out.println("Records not found");
		}
	}


}
