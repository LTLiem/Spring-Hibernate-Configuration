package upskills.autotagging.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import upskills.autotagging.dao.TradeDao;
import upskills.autotagging.model.Trade;
import upskills.autotagging.model.TradeId;

@Repository
public class HbnTradeDao extends AbstractHbnDao<Trade> implements TradeDao {

	@Override
	public Trade getTradeByNbAndField(TradeId tradeId) {
		Trade result = null;
	
		result = (Trade)getSession()
					 .getNamedQuery("getTradeByNbAndField")
					 .setParameter("NB", tradeId.getNb())
					 .setParameter("field", tradeId.getField().trim())
					 .uniqueResult();		
		return result;
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trade> getTradeByNb(int nb) {
		List<Trade> result = null;			
		result = (List)getSession()
				 .getNamedQuery("getTradeByNb")
				 .setParameter("NB", nb)					
				 .list();	
		return result;	
	}
	
	/**
	 * Delete a row in trade table
	 * Return
	 * 		 > 0 : delete sucessful
	 * 		 = 0 : delete fail
	 */
	
	@Override
	public Integer deleteTradeByKey(TradeId tradeId) {
		int result = -1;
			
		result = (Integer)getSession()
				.getNamedQuery("deleteTradeByKey")
				.setParameter("NB", tradeId.getNb())
				.setParameter("field", tradeId.getField().trim())
				.executeUpdate();
	
		return result;	
	}
}
