package pe.edu.cibertec.patitasbackendbe.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.patitasbackendbe.DTO.LoginRequestDTO;
import pe.edu.cibertec.patitasbackendbe.DTO.LoginResponseDTO;
import pe.edu.cibertec.patitasbackendbe.DTO.LogoutRequestDTO;
import pe.edu.cibertec.patitasbackendbe.DTO.LogoutResponseDTO;
import pe.edu.cibertec.patitasbackendbe.service.AutenticacionService;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
@RestController
@RequestMapping("/autenticacion")
public class AutenticacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){

        try {

            Thread.sleep(Duration.ofSeconds(5));
            String[] datosUsuario = autenticacionService.validarUsuario(loginRequestDTO);
            System.out.println("Respuesta backend: " + Arrays.toString(datosUsuario));

            if (datosUsuario == null) {
                return new LoginResponseDTO("01", "Error: Usuario no encontrado", "", "");
            }
            return new LoginResponseDTO("00", "", datosUsuario[0], datosUsuario[1]);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new LoginResponseDTO("99", "Error: Ocurrió un problema", "", "");

        }

    }

    @PostMapping("/logout")
    public LogoutResponseDTO logout(@RequestBody LogoutRequestDTO logoutRequestDTO) {
        try {

            Thread.sleep(Duration.ofSeconds(5));
            Date fechaLogout = autenticacionService.cerrarSesionUsuario(logoutRequestDTO);
            System.out.println("Respuesta backend: " + fechaLogout);

            if (fechaLogout == null) {
                return new LogoutResponseDTO(false, null, "Error: No se pudo registrar auditoría");
            }
            return new LogoutResponseDTO(true, fechaLogout, "Sesion cerrada con exito");
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return new LogoutResponseDTO(false, null, "Error: Ocurrió un problema");
        }
    }

}