package mockdemo;

import java.io.IOException;

public class MainService
{
	private FileAccessService fileAccessService;

	public MainService( FileAccessService fileAccessService )
	{
		this.fileAccessService = fileAccessService;
	}

	public int numOfLines() throws IOException
	{
		//tutaj moze byc dodatkowa logika
		return fileAccessService.load().size();
	}
}
