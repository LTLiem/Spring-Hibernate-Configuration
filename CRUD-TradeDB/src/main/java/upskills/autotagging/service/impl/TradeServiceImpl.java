package upskills.autotagging.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upskills.autotagging.dao.TradeDao;
import upskills.autotagging.model.Trade;
import upskills.autotagging.model.TradeId;
import upskills.autotagging.service.TradeService;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {
	
	@Autowired
	private TradeDao tradeDao;

	@Override
	public void createTrade(Trade trade) {
		tradeDao.create(trade);
	}

	@Override
	public void deleteTrade(Trade trade) {
		tradeDao.delete(trade);		
	}

	@Override
	public void updateTrade(Trade trade) {
		tradeDao.update(trade);
	}

	@Override
	public List<Trade> getAllTrade() {
		return tradeDao.getAll();
	}

	@Override
	public Trade getTradeByNbAndField(TradeId tradeId) {
		return tradeDao.getTradeByNbAndField(tradeId);
	}

	@Override
	public List<Trade> getTradeByNb(int nb) {
		return tradeDao.getTradeByNb(nb);
	}

	@Override
	public Integer deleteTradeByKey(TradeId tradeId) {
		return tradeDao.deleteTradeByKey(tradeId);
	}
	
	
}
