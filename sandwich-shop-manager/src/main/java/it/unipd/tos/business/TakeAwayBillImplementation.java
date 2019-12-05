////////////////////////////////////////////////////////////////////
// [Enrico] [Galdeman] [1169549]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

public class TakeAwayBillImplementation implements TakeAwayBill{
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException{
		if (itemsOrdered.size() > 30) {
			throw new TakeAwayBillException("Numero troppo elevato di ordini");
		}
		double sum=0.0;
		double sumPaniniFritti=0.0;
		int numPanini=0;
		double paninoMenoCaro=-1;
		for(MenuItem item: itemsOrdered) {
			sum+=item.getPrice();
			if(item.getType()==ItemType.Panino) {
				numPanini++;
				double prezzoPanino=item.getPrice();
				sumPaniniFritti+=prezzoPanino;
				if(prezzoPanino<paninoMenoCaro || paninoMenoCaro<0.0) {
					paninoMenoCaro=prezzoPanino;
				}
			}else if(item.getType()==ItemType.Fritto) {
				sumPaniniFritti+=item.getPrice();
			}
		}
		if(numPanini>5) {sum-=paninoMenoCaro/2;}
		if(sumPaniniFritti>50) {sum*=0.9;}
		if (sum<10) {sum+=0.5;}
		return sum;
	}
}