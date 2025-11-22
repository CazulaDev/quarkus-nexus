package entidades;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Diagnostico extends PanacheEntityBase  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_diagnostico;
    public String nome;
    public String descricao;

    @ManyToMany(mappedBy = "diagnosticos")
    public List<Usuario> usuarios;

}
