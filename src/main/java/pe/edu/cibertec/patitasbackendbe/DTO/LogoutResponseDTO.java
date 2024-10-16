package pe.edu.cibertec.patitasbackendbe.DTO;

import java.util.Date;

public record LogoutResponseDTO(Boolean resultado, Date fecha, String mensajeError) {
}