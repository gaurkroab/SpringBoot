package com.gk.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gk.document.StockDetails;
import com.gk.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService service;
	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("------------------------ save document operation ------------------");
		StockDetails details = new StockDetails(new Random().nextInt(1000),"ICICI",9999,"BSE");
		String result = service.registerStockDetails(details);
		System.out.println(result);*/
		/*
		System.out.println("---------------------------- insertAll(-) to save multiple document -------------");
		StockDetails details1 = new StockDetails(new Random().nextInt(1000),"NMDC",114.23,"BSE");
		StockDetails details2 = new StockDetails(new Random().nextInt(1000),"SBI",520.50,"BSE");
		StockDetails details3 = new StockDetails(new Random().nextInt(1000),"JUBLFOOD",448.15,"BSE");
		StockDetails details4 = new StockDetails(new Random().nextInt(1000),"ADAVIPORTS",654.95,"NSE");
		StockDetails details5 = new StockDetails(new Random().nextInt(1000),"COALINDIA",213.35,"NSE");
		StockDetails details6 = new StockDetails(new Random().nextInt(1000),"ITC",380.65,"NSE");
		String msg = service.registerStockDetailsBatch(List.of(details1,details2,details3,details4,details5,details6));
		System.out.println(msg);*/
		
		/*
		System.out.println("---------------- find(-,-) for selecting the documents ----------------");
		service.fetchStocksDetailsByExchange("BSE").forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------------------");
		service.fetchStocksDetailsByPriceRange(100.0, 2000.0).forEach(System.out::println);*/
		
		
		//System.out.println("188 stockId Stock details are :: "+service.fetchStockDetailsByStockId(188));
		//System.out.println(service.fetchAndUpdateStockDetailsByStockId(188, 400.0, "BSE"));
		//System.out.println(service.modifyExchangeByStockPriceRange(100.0, 1000.0, "NSE"));
		//System.out.println(service.registerOrUpdateStockByStockName("ITC", 380.50, "BSE"));
		System.out.println(service.fetchAndRemoveByStockName("ITC"));
		
	}

}
