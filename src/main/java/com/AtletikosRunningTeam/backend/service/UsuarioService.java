package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.dto.request.CrearUsuarioRequest;
import com.AtletikosRunningTeam.backend.model.Usuario;
import com.AtletikosRunningTeam.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public void crearUsuario(CrearUsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(
                usuarioRequest.getNombre(),
                usuarioRequest.getApellido(),
                usuarioRequest.getEmail(),
                usuarioRequest.getContrasena(),
                usuarioRequest.getTelefono(),
                "USUARIO",
                LocalDate.now());
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> encontrarPorID(Integer id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarPorID (Integer id) {
        usuarioRepository.findById(id).ifPresent(usuarioRepository::delete);
    }
}
