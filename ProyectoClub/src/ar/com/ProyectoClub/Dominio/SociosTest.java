package ar.com.ProyectoClub.Dominio;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SociosTest {
	private Socios socio;
	
	@Before
	public void SetUp() throws Exception{
		socio = new Socios();
	}
	
	@Test
	public void TestSetandDniSocio(){
		Integer testdni= 1239899;
		assertNull(socio.getDniSocios());
		socio.setDniSocios(testdni);
		assertEquals(testdni, socio.getDniSocios());
	}
	

}
