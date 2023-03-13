package com.gk.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.entity.Person;
import com.gk.entity.PhoneNumber;
import com.gk.repository.IPersonRepository;
import com.gk.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociatoinMappingServiceImpl implements IOToMAssociationMgmtService {

	@Autowired
	private IPersonRepository personRepo;
	
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	@Override
	public void saveDataUsingParent() {
	
		// create Parent object
		Person per = new Person("akash","aligarh");
		// create child objects
		PhoneNumber ph1 = new PhoneNumber(9756937763L,"jio","personal");
		PhoneNumber ph2 = new PhoneNumber(8279791423L,"jio","personal");
		
		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		// add childs to parent 
		 Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>();
		 phoneSet.add(ph1);
		 phoneSet.add(ph2);
		 per.setContactDetails(phoneSet);
		 
		 // save the parent object
		 personRepo.save(per);
		 System.out.println("Person and his associated phone numbers ar saved (Parent to child)");

	}// method
	
	@Override
	public void saveDateUsingChild() {
		// create Parent object
		Person per = new Person("harendra","agra");
		// create child object
		PhoneNumber ph1=new PhoneNumber(9457007538L,"jio","personal");
		PhoneNumber ph2=new PhoneNumber(8218147580L,"jio","personal");
		
		// add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		// add child to parent
		
		Set<PhoneNumber> phoneSet = new HashSet<PhoneNumber>();
		phoneSet.add(ph1);
		phoneSet.add(ph2);
		per.setContactDetails(phoneSet);
		
		// save the child object
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);
		System.out.println("Person and his associated phoneNumbers are saved(child to parent)");
	
	}// method
	
	@Override
	public void loadDataUsingParent() {
		Iterable<Person> it = personRepo.findAll();
		it.forEach(per->{
			System.out.println("parent :: "+per);
			// get childs of each parent
			Set<PhoneNumber> childs = per.getContactDetails();
			System.out.println("childs count :: "+childs.size());
			childs.forEach(ph->{
				System.out.println("child :: "+ph.getMobileNo());
			});
		});
		
	}

}
