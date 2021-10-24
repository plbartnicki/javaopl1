package mockdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//@Service

/*
  Z ta klasa moga byc zwiazane problemy
  1. nie dokonczona klasa
  2. zamiast z Files korzystamy z zewnetrznego serwisu (nie powinnismy uzaleniac testow od zewnetrznego serwisu, nawet jest dziala on poprawnie
  3. Frontend -> Controler -> ServiceA -> ServiceB -> RepositoryA
 */
public class FileAccessService
{
	private String path;
	public FileAccessService(String path) {
		this.path = path;
	}

	public List<String> load() throws IOException {
		return Files.readAllLines( Paths.get( path));  //zalozmy ze Files to jest zewnetrzna aplikacja
	}
}
