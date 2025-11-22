package entidades;

import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class historico extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_historico;
    public String pergunta;
    public String resposta;
    public LocalDate data_interacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    public Usuario usuario;
    
}
 