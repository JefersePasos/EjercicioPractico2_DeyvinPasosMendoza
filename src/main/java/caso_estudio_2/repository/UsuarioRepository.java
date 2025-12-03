package caso_estudio_2.repository;

import caso_estudio_2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuarios por rol
    List<Usuario> findByRolId(Long rolId);

    // Buscar useuarios por nombre o correo
    List<Usuario> findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(String nombre, String email);

    // Buscar usuarios creados entre fechas
    List<Usuario> findByFechaCreacionBetween(LocalDateTime inicio, LocalDateTime fin);

    // Contar activos vs inactivos
    long countByActivoTrue();
    long countByActivoFalse();

    // Orden por fecha de creación
    List<Usuario> findAllByOrderByFechaCreacionDesc();
}