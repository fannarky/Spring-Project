package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	
	@Test
	public void loginComSucesso() {
		LoginController controller = new LoginController();
		
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login", "senha"));
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	
	}
	
	
	public void loginComErro() {
		LoginController controller = new LoginController();
		
		controller.validarLogin(new Credenciais("loginErrado", "senhaErrada"));
		
	}
}
