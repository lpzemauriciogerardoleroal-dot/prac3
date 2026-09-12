    UsuarioDto registrar(UsuarioDto usuarioDto);

    List<UsuarioDto> obtenerTodos();

    List<UsuarioDto> obtenerActivos();

    UsuarioDto registrarAdministrador(UsuarioDto usuarioDto);

    UsuarioDto modificar(Long id, UsuarioDto usuarioDto);

    void borrarFisico(Long id);

    void borrarLogico(Long id);
}