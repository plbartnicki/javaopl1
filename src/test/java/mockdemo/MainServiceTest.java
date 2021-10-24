package mockdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
public class MainServiceTest
{
	@Mock
	private FileAccessService fileAccessService;

	@InjectMocks
	private MainService mainService;

	@Test
	public void testNumOfLines() throws IOException
	{
		//given
		//definiujemy mockoweanie - jesli zostanie wywolana metoda load
		//to zamiast wykonywac jej implementacje (kod) zwracamy przykladowy wynik (atrapa)
		when(fileAccessService.load()).thenReturn( Arrays.asList( "one", "one"));

		//when
		int result = mainService.numOfLines();

		//then
		assertThat(result).isEqualTo( 2 );

	}

}
