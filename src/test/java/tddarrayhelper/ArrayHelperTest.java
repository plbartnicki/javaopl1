package tddarrayhelper;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ArrayHelperTest
{
	@Test
	public void testSumReverseValidArgs( ) throws RangeArrayException
	{
		Double t1[] = { 2.3, -4.0, 1.5 };
		Double t2[] = { 4.5, 4.0, 2.1 };
		Double t3[] = null;
		t3 = ArrayHelper.sumReverse( t1, t2 );

		assertTrue( t3[ 0 ].equals( 3.6 ) && t3[ 1 ].equals( 0.0 ) && t3[ 2 ].equals( 6.8 ) );

	}

	@Test( expected = RangeArrayException.class )
	public void testSumReverseInValidArgs( ) throws RangeArrayException
	{
		Double t1[] = { 2.3, -4.0 };
		Double t2[] = { 4.5, 4.0, 2.1 };
		Double t3[] = null;
		t3 = ArrayHelper.sumReverse( t1, t2 );
	}

	@Test( expected = RangeArrayException.class )
	public void testSumReverseInValidArgsV2( ) throws RangeArrayException
	{
		Double t1[] = { 2.3, -4.0 };
		Double t2[] = { 4.5, 4.0, 2.1 };
		Double t3[] = t3 = ArrayHelper.sumReverse( t1, t2 );
	}
}
