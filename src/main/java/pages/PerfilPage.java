package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import util.AbstractTest;

public class PerfilPage extends AbstractTest {

	public void acessarPerfil(String usuario) throws InterruptedException {
		WebElement inputBusca = driver.findElement(By.xpath("//input[@placeholder='Busca']"));
		wait.until(ExpectedConditions.elementToBeClickable(inputBusca));
		try {
			inputBusca.click();
		}catch(ElementClickInterceptedException e ) {
			Thread.sleep(3000);
			actions.click(inputBusca).perform();
		}
		inputBusca.clear();
		inputBusca.sendKeys(usuario);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/"+usuario+"/'][.//span[contains(text(), '"+usuario+"')]]")));
		actions.click(driver.findElement(By.xpath("//a[@href='/"+usuario+"/'][.//span[contains(text(), '"+usuario+"')]]"))).perform();
		
	}
	
	public void clicarSeguidores(String usuario) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/"+usuario+"/followers/']")));
		WebElement usuarioBuscado = driver.findElement(By.xpath("//a[@href='/"+usuario+"/followers/']"));
		usuarioBuscado.click();
	}

	public void pularNotificacoes() {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.aOOlW:nth-child(2)")));
		driver.findElement(By.cssSelector("button.aOOlW:nth-child(2)")).click();
	}
}
