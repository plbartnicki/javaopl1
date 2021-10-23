package tddarrayhelper;

public class ArrayHelper
{
	public static  Double[] sumReverse(Double []arr1, Double []arr2) throws RangeArrayException{
		//sprawdzamy czy argumenty sa poprawne
		if(arr1.length != arr2.length) {
			throw new RangeArrayException();
		}

		Double []result = new Double[arr1.length];   //tablica z sumami
		for(int i = arr1.length - 1; i >= 0; i--) {
			result[result.length -  (i +1)] = arr1[i] + arr2[i];
		}

		return result;

	}
}
