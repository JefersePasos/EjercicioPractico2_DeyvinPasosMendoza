package caso_estudio_2.service;

import caso_estudio_2.domain.Rol;
import java.util.List;

public interface RolService {
    List<Rol> listar();
    Rol obtenerPorId(Long id);
    Rol guardar(Rol rol);
    void eliminar(Long id);
}