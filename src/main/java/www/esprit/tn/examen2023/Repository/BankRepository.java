package www.esprit.tn.examen2023.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import www.esprit.tn.examen2023.Entite.Bank;

public interface BankRepository extends JpaRepository<Bank,Long> {
    Bank findByAgence(String agence);
}
