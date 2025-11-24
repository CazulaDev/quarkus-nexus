package recurso;

import entidades.Usuario;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginRecurso {

    public static class LoginDTO {
        public String nomeUsuario;
        public String senhaUsuario;
    }

    @POST
    public Usuario login(LoginDTO dto) {
        return Usuario.find("nomeUsuario = ?1 AND senhaUsuario = ?2",
                dto.nomeUsuario, dto.senhaUsuario).firstResult();
    }
}
