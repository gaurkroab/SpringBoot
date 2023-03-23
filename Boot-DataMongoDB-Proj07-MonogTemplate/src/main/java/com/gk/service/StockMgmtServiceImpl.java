package com.gk.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.gk.document.StockDetails;
import com.mongodb.client.result.UpdateResult;

@Service("stockService")
public class StockMgmtServiceImpl implements IStockMgmtService {

	@Autowired
	private MongoTemplate template;
	@Override
	public String registerStockDetails(StockDetails details) {
		
		int idValue=template.save(details, "Stock").getStockId();
		return "Document is saved with id vlaue :: "+idValue;
	}
	
	@Override
	public String registerStockDetailsBatch(List<StockDetails> list) {
		int size = ((List<StockDetails>) template.insertAll(list)).size();
		return size+"  no. of documents are saved";
	}
	
	@Override
	public List<StockDetails> fetchStocksDetailsByExchange(String exchange) {
			Query query = new Query();
			query.addCriteria(Criteria.where("exchangeName").is(exchange));
			List<StockDetails> list = template.find(query, StockDetails.class);
			return list;
	}

	
	@Override
	public List<StockDetails> fetchStocksDetailsByPriceRange(double startPrice, double endPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}
	
	@Override
	public StockDetails fetchStockDetailsByStockId(int stockId) {
		return template.findById(stockId, StockDetails.class);
	}
	
	@Override
	public String fetchAndUpdateStockDetailsByStockId(int stockId, double newPrice, String newExchangeName) {
		// Query object for single doc retrieving 
		Query query = new Query();
		query.addCriteria(Criteria.where("stockId").is(stockId));
		// Update object for modification
		Update update =new Update();
		update.set("price", newPrice);
		update.set("exchangeName", newExchangeName);
		// call the method
		StockDetails details = template.findAndModify(query, update, StockDetails.class);
		return details==null?"stock does not found ":"stock found and update";
	}
	
	@Override
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchangeName) {
		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).andOperator(Criteria.where("price").lte(endPrice)));
		// update object
		Update update = new Update().set("exchangeName", newExchangeName);
		// call the method
		UpdateResult result = template.updateMulti(query, update, StockDetails.class);
		return result.getMatchedCount()+"  no. of records are effected" ;
	}
	
	@Override
	public String registerOrUpdateStockByStockName(String stockName, double newPrice, String newExchange) {
		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		// update object
		Update update = new Update();
		update.set("exchangeName", newExchange);
		update.setOnInsert("stockName", stockName);
		update.setOnInsert("stockId", new Random().nextInt(1000));
		update.set("price", newPrice);
		// invoke the method
		UpdateResult result = template.upsert(query, update, StockDetails.class);
		if(result.getModifiedCount()==0)
			return "new Document is inserted with id value ::"+result.getUpsertedId();
		else
			return "Existing doc is updated";
	}
	
	@Override
	public String fetchAndRemoveByStockName(String stockName) {
		// Query object for single doc retrieving
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		// call the method
		StockDetails details = template.findAndRemove(query, StockDetails.class);
		return details==null?"Stock not found":"Stock found and deleted";
	}
}
