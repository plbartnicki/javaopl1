package basictesting;

import excepions.AllValuesLeesThan0;
import excepions.EmptyListException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Przed wrzuceniem zmiany do brancha zdalnego a tym bardziej przed ropoczeciem pull requesta (przed review) koniecznie tzeba
 * uruchomic wszystkie testy pokrywajace zmienion
 */
public class NumberHelperTest
{
	private static List<Double> commonValues = null;

	@BeforeClass  //dzieki tej adnotacji logika metody wykona sie raz i przed wszystkimi testami
	public static void setupBeforeClass() {
		System.out.println("W tej metodzie moze znajdowac sie logika, ktora np. inicjalizuje obiekty ktore będą czytane przez wszytskie metody testowe");
		System.out.println("Najczescie dodaje sie tutaj kod ktory wyciaga sie przed nawiast bo jest wspolny dla wszystkich metod testowych i dzieki temu mozna zredukowac kod");

		//na przyklad ponizej zamiast asList mozna napisac algorytm ktory wypelnia liste commonValues,  wspoldzielona przez wszystkie testy w tej klasie
		commonValues = Arrays.asList( 2.0, 3.0, 5.0, 7.0 );
	}

	//private Object element = null;  //testy nie powinny sie komunikowac (jeden test zmienia wartosc a drugi czyta) przez globalne wartosci

	@Before //dzieki tej adnotacji logika metody wykona za kazdym razem przed kazda metoda testowa
	public void setupBefore() {
		System.out.println("Method annotated before has been executed");
	}

	//Analogicznie dziala @AfterClass i @After

	@Test
	public void testMinValueGreaterThan0WithMixedValues() throws AllValuesLeesThan0, EmptyListException
	{
		//w testach nie powinno sie zawierac logowania informacji na ekrani
		System.out.println("testMinValueGreaterThan0WithMixedValues started");

		//given
		final List<Double> numbers = Arrays.asList( -3.0, -10.6, 13.001, -2.0, 7.0);
		//when
		final Double result = NumberHelper.minValueGreaterThan0( numbers );

		//then
		assertEquals(new Double(7.0), result);
	}

	@Test
	public void testMinValueGreaterThan0WitNull() throws AllValuesLeesThan0
	{
		//w testach nie powinno sie zawierac logowania informacji na ekrani
		System.out.println("testMinValueGreaterThan0WitNull started");

		//given
		final List<Double> numbers = null;
		//when then
		try
		{
			NumberHelper.minValueGreaterThan0( numbers );
			fail();
		} catch ( EmptyListException ex) {

		}
	}

	@Test
	public void testMinValueGreaterThan0WithEmpty() throws AllValuesLeesThan0
	{
		//given
		final List<Double> numbers = Arrays.asList(  );
		//when then
		try
		{
			NumberHelper.minValueGreaterThan0( numbers );
			fail();
		} catch ( EmptyListException ex) {

		}
	}

	@Test
	public void testMinValueGreaterThan0WithAllValuesLessThan0() throws EmptyListException
	{
		//given
		final List<Double> numbers = Arrays.asList( -2.0, -1.0, -10.98 );
		//when then
		try
		{
			NumberHelper.minValueGreaterThan0( numbers );
			fail();
		} catch ( AllValuesLeesThan0 ex) {

		}
	}
}
