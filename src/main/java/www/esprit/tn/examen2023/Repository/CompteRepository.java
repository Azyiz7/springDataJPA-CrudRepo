package www.esprit.tn.examen2023.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import www.esprit.tn.examen2023.Entite.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    Compte findByCode(Long code);
}
