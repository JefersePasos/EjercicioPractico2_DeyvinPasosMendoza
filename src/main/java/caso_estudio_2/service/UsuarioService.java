package caso_estudio_2.service;

import caso_estudio_2.domain.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);

    //Busquedas de usuarios
    List<Usuario> buscarPorRol(Long rolId);

    List<Usuario> buscarPorNombreOEmail(String texto);

    List<Usuario> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

    long contarActivos();

    long contarInactivos();

    List<Usuario> ordenarPorFechaCreacion();

}