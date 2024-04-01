package www.esprit.tn.examen2023.Entite;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Compte")
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Compte")
    private Long idCompte;
    private Long code;
    private Double solde;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}
