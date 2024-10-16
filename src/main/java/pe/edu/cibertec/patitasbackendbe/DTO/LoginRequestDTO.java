package pe.edu.cibertec.patitasbackendbe.DTO;

public record LoginRequestDTO(String tipoDocumento, String numeroDocumento, String password) {
}