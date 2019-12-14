package botinstagram;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import enums.Navegadores;
import pages.PerfilPage;
import util.Conta;

public class BotInstagram {

	static PerfilPage pagePerfil = new PerfilPage();
	static Navegadores navegador = Navegadores.PADRAO;
	static Conta conta = new Conta("ertettry","asdfghjkl123");
	
	@BeforeClass
	public static void login() {
		pagePerfil.login(conta, navegador);
	}
	
//	@AfterClass
//	public static void logout() {
//		pagePerfil.logout();
//	}
	
	@Test
	public void fazerLogin() throws InterruptedException {
		try {
			pagePerfil.acessarPerfil("victorhugofr_");
		}catch(NoSuchElementException e) {
			pagePerfil.pularNotificacoes();
			pagePerfil.acessarPerfil("victorhugofr_");
		}
		pagePerfil.clicarSeguidores("victorhugofr_");
	}
}
