package commons;


import java.util.List;

public class DataStructureCommons
{
	public static <T> void add( List<T> employees, T obj, int i )
	{
		if(employees != null && i >= 0 && i <= employees.size()  ) {
			employees.add( i, obj );
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}
