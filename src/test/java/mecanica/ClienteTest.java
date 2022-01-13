package mecanica;

import org.junit.Assert;
import org.junit.Test;

import br.com.fns.mecanica.modelo.Cliente;

public class ClienteTest {

	@Test
	public void test() {
		Cliente c = new Cliente(1L, "Caroline", "Caroline FNS", "carolfns");
		Assert.assertEquals(c.getNomeResumido(), "Caroline");
	}

}
