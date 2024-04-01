package www.esprit.tn.examen2023.Entite;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Bank")
public class Bank implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Bank")
    private Long idBank;
    private String nom;
    private  String agence;
    private String adresse;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Compte> Comptes;
}
