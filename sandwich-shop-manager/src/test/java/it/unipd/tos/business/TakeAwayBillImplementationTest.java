package it.unipd.tos.business;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import it.unipd.tos.business.TakeAwayBillImplementation;
import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItemImplementation;

@RunWith(Parameterized.class)
public class TakeAwayBillImplementationTest {
	@Parameters
    public static Collection<Object[]> data() {
    	MenuItem dummyPanino = new MenuItemImplementation("panino vegano", ItemType.Panino,8.0);
    	MenuItem dummyFritto = new MenuItemImplementation("fritto misto", ItemType.Fritto,30.0);
    	MenuItem dummyBevanda = new MenuItemImplementation("acqua", ItemType.Bevanda,50.0);
    	MenuItem[] duplicateArray = new MenuItemImplementation[30];
    	Arrays.fill(duplicateArray, dummyPanino);
        return Arrays.asList(new Object[][] {     
                 { Arrays.asList(dummyPanino), 8.5 }, 
                 { Arrays.asList(dummyPanino, dummyPanino), 16.0 }, 
                 { Arrays.asList(dummyPanino,dummyPanino, dummyPanino, dummyPanino, dummyPanino, new MenuItemImplementation("panino carne", ItemType.Panino, 6.0)), 43.0 },
                 { Arrays.asList(duplicateArray), 212.4 },
                 { Arrays.asList(dummyBevanda, dummyBevanda, dummyBevanda), 150.0 },
                 { Arrays.asList(dummyFritto, dummyFritto, dummyFritto), 81.0 }
           });
    }
    private List<MenuItem> input;
    private double priceExpected;
    private TakeAwayBillImplementation impl;
    public TakeAwayBillImplementationTest(List<MenuItem> input, Double priceExpected) {
        this.input = input;
        this.priceExpected = priceExpected;
    }

    @Before
    public void before() {
    	impl = new TakeAwayBillImplementation();
    }
    
	@Test
	public void testGetOrderPrice() {
		try {
			assertEquals(priceExpected, impl.getOrderPrice(input), 0.001);
		}catch (TakeAwayBillException e) {
			System.err.print(e);
		}	
	}
	
	@Test(expected = TakeAwayBillException.class)
	public void testGetOrderPrice_ThrowsException() throws TakeAwayBillException{
    	MenuItem dummyItem = new MenuItemImplementation("panino veegano", ItemType.Panino, 8.0);
    	MenuItem[] duplicateArray = new MenuItemImplementation[31];
    	Arrays.fill(duplicateArray, dummyItem);
		impl.getOrderPrice(Arrays.asList(duplicateArray));
	}
}