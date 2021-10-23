package basictesting;

import excepions.EmptyListException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StringHelperTest
{
	@Test
	public void testNoDuplicateWithAtLeastOneDuplicate() throws EmptyListException
	{
		//given
		//funkcja powinna zwrócić false, natomiast dla listy [“test manualny”, “mockowanie”] - true
		final List<String> words = Arrays.asList("asercja", "test jednostkowy", "asercja", "test integracyjny" );

		//when
		boolean result = StringHelper.noDuplicate( words );

		//then
		assertFalse(result);
	}

	@Test
	public void testNoDuplicateWithNoDuplicate() throws EmptyListException
	{
		//given
		final List<String> words = Arrays.asList("test manualny", "test jednostkowy");

		//when
		boolean result = StringHelper.noDuplicate( words );

		//then
		assertTrue(result);
	}

	@Test
	public void testNoDuplicateWithEmptyList()
	{
		//given
		final List<String> words = Arrays.asList();
		final List<String> words2 = null;
		boolean exception = false;
		boolean exception2 = false;

		//when
		try
		{
			StringHelper.noDuplicate( words );
		} catch ( Exception ex) {
			exception = true;
		}

		try
		{
			StringHelper.noDuplicate( words2 );
		} catch ( Exception ex) {
			exception2 = true;
		}

		//then
		assertTrue(exception);
		assertTrue(exception2);
	}

	//testowanie wyjatkow mozna tez zroic krocej za pomoca parametru expected adnotacji @Test
	@Test(expected = EmptyListException.class)
	public void testNoDuplicateWithEmptyListUsingTestAnnotationParameter() throws EmptyListException
	{
		//given
		final List<String> words = Arrays.asList();
		StringHelper.noDuplicate( words );
	}
}
