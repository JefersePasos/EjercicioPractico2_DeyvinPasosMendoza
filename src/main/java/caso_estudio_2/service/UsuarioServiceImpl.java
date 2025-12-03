package caso_estudio_2.service;

import caso_estudio_2.domain.Usuario;
import caso_estudio_2.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    //Busquedas de usuarios
    @Override
    public List<Usuario> buscarPorRol(Long rolId) {
        return usuarioRepository.findByRolId(rolId);
    }

    @Override
    public List<Usuario> buscarPorNombreOEmail(String texto) {
        return usuarioRepository.findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(texto, texto);
    }

    @Override
    public List<Usuario> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return usuarioRepository.findByFechaCreacionBetween(inicio, fin);
    }

    @Override
    public long contarActivos() {
        return usuarioRepository.countByActivoTrue();
    }

    @Override
    public long contarInactivos() {
        return usuarioRepository.countByActivoFalse();
    }

    @Override
    public List<Usuario> ordenarPorFechaCreacion() {
        return usuarioRepository.findAllByOrderByFechaCreacionDesc();
    }

    
}