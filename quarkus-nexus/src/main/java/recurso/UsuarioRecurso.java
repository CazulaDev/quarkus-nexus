package recurso;

import entidades.Usuario;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/cadastro")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioRecurso {

    @POST
    @Transactional
    public Usuario cadastrar(Usuario usuario) {
        usuario.persist();
        return usuario;
    }

    @GET
    public List<Usuario> listar() {
        return Usuario.listAll();
    }

    @GET
    @Path("/{id}")
    public Usuario buscarPorId(@PathParam("id") Long id) {
        return Usuario.findById(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Usuario atualizar(@PathParam("id") Long id, Usuario dados) {
        Usuario usuario = Usuario.findById(id);

        if (usuario == null) {
            return null;
        }

        usuario.nomeUsuario = dados.nomeUsuario;
        usuario.emailUsuario = dados.emailUsuario;
        usuario.senhaUsuario = dados.senhaUsuario;

        return usuario;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletar(@PathParam("id") Long id) {
        Usuario.deleteById(id);
    }
}