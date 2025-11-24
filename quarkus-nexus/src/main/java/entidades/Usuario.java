package entidades;


import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import java.util.List;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends PanacheEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nomeUsuario;
    public String emailUsuario;
    public String senhaUsuario;
    public LocalDate data_cadastro;

    @Enumerated(EnumType.STRING)
    public TipoDiagnostico tipo;

    @OneToMany(mappedBy = "usuario")
    public List<historico> historico;

    @ManyToMany
    @JoinTable(
    name = "Usuario_has_Diagnostico",
    joinColumns = @JoinColumn(name = "Usuario_idUsuario"),
    inverseJoinColumns = @JoinColumn(name = "Diagnostico_idDiagnostico")
)
public List<Diagnostico> diagnosticos;




    
}
