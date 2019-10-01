package br.com.bandtec.AgendaDeObjetivos.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TodosUsuarios extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuarios u where u.credenciais = :credencial")
	public Usuarios existe(@Param("credencial") Credenciais credencial);

	//@Query("select u from Usuario u where u.nome = :nome")
	@Query("from Usuario where nome = :nome")
	public List<Usuario> findByName(@Param("nome") String nome);

	@Query("from Usuarion where idade = :idade")
	public List<Usuario> findByAge(@Param("idade") Integer idade);


}
