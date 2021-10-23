package basictesting;

import excepions.EmptyListException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringHelper
{
		/*
	ii) metoda, która zwraca true, jeśli w podanej jako argument liście napisów, nie występuje duplikat a false - w przeciwnym wypadku.
Na przykład dla przekazanej jako argument listy [“asercja”, “test jednostkowy”, “asercja”, “test integracyjny”]  funkcja powinna zwrócić false,
 natomiast dla listy [“test manualny”, “mockowanie”] - true
Jeśli lista jest pusta, metoda powinna rzucić wyjątek EmptyListException
	 */

	public static boolean noDuplicate( List<String> words) throws EmptyListException
	{
		if( words == null || words.isEmpty()) {
			throw new EmptyListException();
		}

		Set<String> noDuplicates = new HashSet<>( words );  //inicjalizacja zbioru oraz dodanie elementow z tablicy do zbioru (czyli eliminacja duplikatow)
		return words.size() == noDuplicates.size();
	}
}
