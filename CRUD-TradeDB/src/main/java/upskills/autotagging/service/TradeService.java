package upskills.autotagging.service;

import java.util.List;

import upskills.autotagging.model.Trade;
import upskills.autotagging.model.TradeId;

public interface TradeService {
	
	public void createTrade(Trade trade);
	
	public void deleteTrade(Trade trade);
	
	public void updateTrade(Trade trade);
	
	public List<Trade> getAllTrade(); 
	
	public Trade getTradeByNbAndField(TradeId tradeId);
	
	public List<Trade> getTradeByNb(int nb);
	
	public Integer deleteTradeByKey(TradeId tradeId);
	
}
