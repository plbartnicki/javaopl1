package commons;

import entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Zaimplementować możliwość dodawania na dowolna -ita pozycje w liscie (pewnego typu)
 * obiektu tego samego typu
 */

public class DataStructureCommonsTest
{
	@Test
	public void testAddToEmptyListWithSuccess() {
		//given
		List<Employee> employees = new ArrayList<>(  );
		Employee emp1 = new Employee(1, "Kasia", "Xyz", 9999999.0);
		//when
		DataStructureCommons.add(employees, emp1,0);


		//then
		assertThat(employees.size()).isEqualTo(1);
		assertThat(employees.get( 0 )).isEqualTo(emp1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddToNotEmptyListWithoutSuccess()  {
		//given
		List<Employee> employees = new ArrayList<>(  );
		employees.add( new Employee(1, "Kasia", "Xyz", 9999999.0) );
		Employee emp2 = new Employee(1, "Kasia", "Xyz", 9999999.0);
		//when
		DataStructureCommons.add(employees, emp2,3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddToNullListWithoutSuccess()  {
		//given
		Employee emp1 = new Employee(1, "Kasia", "Xyz", 9999999.0);
		//when
		DataStructureCommons.add(null, emp1,3);
	}
}
