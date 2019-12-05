////////////////////////////////////////////////////////////////////
// [Enrico] [Galdeman] [1169549]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;
import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public interface TakeAwayBill {
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException;
}
