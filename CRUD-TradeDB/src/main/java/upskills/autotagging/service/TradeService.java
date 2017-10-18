package upskills.autotagging.service;

import java.util.List;

import upskills.autotagging.model.Trade;
import upskills.autotagging.model.TradeId;

public interface TradeService {
	
	public void createAccount(Trade trade);
	
	public void deleteAccount(Trade trade);
	
	public void updateAccount(Trade trade);
	
	public List<Trade> getAllAccount(); 
	
	public Trade getTradeByNbAndField(TradeId tradeId);
	
	public List<Trade> getTradeByNb(int nb);
	
	public Integer deleteTradeByKey(TradeId tradeId);
	
}
