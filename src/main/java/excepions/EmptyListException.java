package excepions;

public class EmptyListException extends Exception
{
	public EmptyListException( )
	{
		super("Empty or null list");
	}
}
