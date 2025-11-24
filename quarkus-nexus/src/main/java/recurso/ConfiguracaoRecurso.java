package recurso;

import entidades.Usuario;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/configuracoes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConfiguracaoRecurso {

    public static class ConfigDTO {
        public String nomeUsuario;
        public String emailUsuario;
        public String senhaUsuario;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Usuario atualizar(@PathParam("id") Long id, ConfigDTO dto) {

        Usuario usuario = Usuario.findById(id);

        if (usuario == null) {
            return null;
        }

        if (dto.nomeUsuario != null) usuario.nomeUsuario = dto.nomeUsuario;
        if (dto.emailUsuario != null) usuario.emailUsuario = dto.emailUsuario;
        if (dto.senhaUsuario != null) usuario.senhaUsuario = dto.senhaUsuario;

        return usuario;
    }
}