package es.magicwater.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.magicwater.jpa.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

}
