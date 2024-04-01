package www.esprit.tn.examen2023.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import www.esprit.tn.examen2023.Entite.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
