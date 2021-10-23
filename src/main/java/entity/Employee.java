package entity;

import java.util.Objects;

public class Employee
{
	private int id;
	private String name;
	private String lastname;
	private Double salary;

	public Employee( int id, String name, String lastname, Double salary )
	{
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.salary = salary;
	}

	public int getId( )
	{
		return id;
	}

	public String getName( )
	{
		return name;
	}

	public String getLastname( )
	{
		return lastname;
	}

	public Double getSalary( )
	{
		return salary;
	}

	public void setSalary( Double salary )
	{
		this.salary = salary;
	}

	@Override public boolean equals( Object o )
	{
		if ( this == o )
			return true;
		if ( o == null || getClass( ) != o.getClass( ) )
			return false;
		Employee employee = ( Employee ) o;
		return id == employee.id && Objects.equals( name, employee.name ) && Objects
			.equals( lastname, employee.lastname ) && Objects.equals( salary, employee.salary );
	}

	@Override public int hashCode( )
	{
		return Objects.hash( id, name, lastname, salary );
	}
}
