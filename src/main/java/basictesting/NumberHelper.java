package basictesting;

import excepions.AllValuesLeesThan0;
import excepions.EmptyListException;

import java.util.List;

public class NumberHelper
{
//	metoda która zwraca najmniejszą spośród dodatnich liczb przekazanych metodzie w postaci listy.
//	Np. dla listy [-3.0, -10.6, 13.001, -2.0, 7.0]  metoda powinna zwrócić 7.0.
	// [-1, -2] -> rzuca wyjatek AllValuesLeesThan0
	// dla [] albo null -> rzuca wyjatek EmptyListException
//	Jeśli lista jest pusta (albo null), metoda powinna rzucić wyjątek EmptyListException (dodaj taką, własną klasę wyjątka).
	public static Double minValueGreaterThan0( List<Double> numbers) throws EmptyListException, AllValuesLeesThan0
	{
		//O(n) (zlozonosc liniowa (klasa zlozonosci)) - wymagana zlonososc czasowa   n + 1 porownan, 2*n porownan - to sa funkcje liniowe
		if(numbers == null || numbers.size() == 0) {
			throw new EmptyListException();
		}

		Double minCandidate = null;  //kandydat na najmniejsza wartosc dodatnia
		int k = 0;
		while(k < numbers.size()) {  //szukamy pierwsza dodatnia liczbe
			if(numbers.get( k ) > 0) {
				minCandidate = numbers.get( k );
				break;
			}
			k++;
		}

		if(minCandidate == null) {
			throw new AllValuesLeesThan0();
		}

		for(int i = k + 1; i < numbers.size(); i++) {
			Double nextValue = numbers.get( i );
			if(nextValue > 0 &&  nextValue < minCandidate) {
				minCandidate = nextValue;
			}
		}

		return minCandidate;
	}
}
