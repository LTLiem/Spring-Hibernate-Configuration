package upskills.autotagging.dao;

import java.util.List;

import upskills.autotagging.model.Trade;
import upskills.autotagging.model.TradeId;


public interface TradeDao extends Dao<Trade> {
	public Trade getTradeByNbAndField(TradeId tradeId);
	public List<Trade> getTradeByNb(int nb);
	public Integer deleteTradeByKey(TradeId tradeId);
}
