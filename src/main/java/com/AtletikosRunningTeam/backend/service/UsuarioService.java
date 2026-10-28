package com.AtletikosRunningTeam.backend.service;

import com.AtletikosRunningTeam.backend.dto.request.CrearUsuarioRequest;
import com.AtletikosRunningTeam.backend.dto.request.LoginUsuario;
import com.AtletikosRunningTeam.backend.dto.response.ListarUsuarios;
import com.AtletikosRunningTeam.backend.model.Usuario;
import com.AtletikosRunningTeam.backend.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registrarUsuario(CrearUsuarioRequest crearUsuario) {
        // verificar que el email no este ya tomado
        if (usuarioRepository.findByEmail(crearUsuario.getEmail()).isPresent()) {
            return false;
        }

        // Encriptar la contraseña antes de guardarla
        crearUsuario.setContrasena(passwordEncoder.encode(crearUsuario.getContrasena()));

        usuarioRepository.save(crearUsuario.convertirUsuario(crearUsuario));
        return true;
    }

    public boolean login(LoginUsuario usuarioLogin) {
        Optional<Usuario> userOpt = usuarioRepository.findByEmail(usuarioLogin.getEmail());

        if (userOpt.isPresent()) {
            Usuario usuario = userOpt.get();
            // passwordEncoder.matches compara la contraseña ingresada con el hash de la BD
            return passwordEncoder.matches(usuarioLogin.getContrasena(), usuario.getContrasena());
        }

        return false;
    }

    public List<ListarUsuarios> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new ListarUsuarios(
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getFechaNacimiento(),
                        usuario.getFechaRegistro()
                ))
                .toList();
    }

    public Optional<Usuario> encontrarPorID(long id) {
        return usuarioRepository.findById(id);
    }

    public void eliminarPorID(long id) {
        usuarioRepository.findById(id).ifPresent(usuarioRepository::delete);
    }
}
