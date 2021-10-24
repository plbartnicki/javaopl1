package paramdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import paramtestdemo.ArithmeticalHelper;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

//klasa testowa z testami sparametryzowanymi
@RunWith( Parameterized.class)
public class ArithmeticalHelperTest {
	private Double val1; //pierwszy argument testowanej metody
	private Double val2; //drugi argument testowanej metody
	private Double val3; //wartosci zwracana

	public ArithmeticalHelperTest(Double val1, Double val2, Double val3) {
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
	}

    /*Metoda ktora przygotowuje konkrente dane testowe ktore będą aplikowane automatycznie
      przez framework
     */
	@Parameterized.Parameters
	public static Collection<Object[]> getParameters() {
		//dwuwymiarowa tablica obiektow - danych do testu - przypadkow testowych
		Object[][] params = new Object[][] {
			{-2.0, 2.0, 0.0},   //{val1, val2, val3}
			{4.5, 2.3, 6.8 },
			{-4.5, -2.3, -6.8 },
			{-5.6, 10.0, 4.4 }
		};

		return Arrays.asList(params);
	}

	@Test
	public void testSum() {
		assertEquals(val3, ArithmeticalHelper.sum(val1, val2));
	}


}
