package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.Navegadores;

public class AbstractTest{
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	public void login(Conta conta, Navegadores navegador) {
		Setup login = new Setup();
		driver = login.setNavegador(navegador);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 5);
		driver.get("https://www.instagram.com/accounts/login/");
		//PREENCHENDO LOGIN
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Número de telefone, nome de usuário ou email']")));
		WebElement nomeUsuario = driver.findElement(By.xpath("//input[@aria-label='Número de telefone, nome de usuário ou email']"));
		nomeUsuario.click();
		nomeUsuario.clear();
		nomeUsuario.sendKeys(conta.getLogin());
		
		//PREENCHENDO SENHA
		WebElement nomeSenha = driver.findElement(By.xpath("//input[@aria-label='Senha']"));
		nomeSenha.click();
		nomeSenha.clear();
		nomeSenha.sendKeys(conta.getSenha());
		// BOTAO ENTRAR
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		actions = new Actions(driver);
		
	}
	
	public void logout() {
		driver.quit();
	}
	
}
