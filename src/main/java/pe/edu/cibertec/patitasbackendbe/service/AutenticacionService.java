package pe.edu.cibertec.patitasbackendbe.service;
import pe.edu.cibertec.patitasbackendbe.DTO.LoginRequestDTO;
import pe.edu.cibertec.patitasbackendbe.DTO.LogoutRequestDTO;

import java.io.IOException;
import java.util.Date;

public interface AutenticacionService {

    String[] validarUsuario(LoginRequestDTO loginRequestDTO) throws IOException;

    Date cerrarSesionUsuario(LogoutRequestDTO logoutRequestDTO) throws IOException;

}