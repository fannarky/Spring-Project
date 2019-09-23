package br.com.bandtec.AgendaDeObjetivos.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuarios u where u.credenciais = :credencial")
	public Usuarios existe(@Param("credencial") Credenciais credencial);

}
