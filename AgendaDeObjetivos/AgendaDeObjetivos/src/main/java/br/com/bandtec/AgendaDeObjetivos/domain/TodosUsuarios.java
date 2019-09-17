package br.com.bandtec.AgendaDeObjetivos.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodosUsuarios extends JpaRepository<Usuarios, Long> {
	
	@Query("select u from Usuarios u where u.login = :login and u.senha = :senha")
	public Usuarios existe(@Param("login") String login,@Param("senha") String senha);

}
