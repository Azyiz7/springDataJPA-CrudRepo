package www.esprit.tn.examen2023.Entite;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Transaction")
    private Long idTransaction;
    private Double montant;
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;
    @Temporal(TemporalType.DATE)
    private Date dateTransaction;
    @ManyToOne(cascade = CascadeType.ALL)
    Compte expediteur;
    @ManyToOne(cascade = CascadeType.ALL)
    Compte destinataire;
}
