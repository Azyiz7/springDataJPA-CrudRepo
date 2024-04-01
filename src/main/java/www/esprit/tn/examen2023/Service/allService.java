package www.esprit.tn.examen2023.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.esprit.tn.examen2023.Entite.*;
import www.esprit.tn.examen2023.Repository.BankRepository;
import www.esprit.tn.examen2023.Repository.CompteRepository;
import www.esprit.tn.examen2023.Repository.TransactionRepository;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class allService implements IallService {
    @Autowired
    private final BankRepository bankRepository;
    @Autowired
    private final CompteRepository compteRepository;
    @Autowired
    private final TransactionRepository transactionRepository;
    @Override
    public Bank ajouterBank(Bank bank) {

        return  bankRepository.save(bank);
    }

    @Override
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agence) {
        Bank bank = bankRepository.findByAgence(agence);

        compteRepository.save(compte);

        bank.getComptes().add(compte);

        return compte;
    }

    @Override
    public String ajouterVirement(Transaction transaction) {
        String message = "";
        Compte expiditeur = compteRepository.findByCode(transaction.getExpediteur().getCode());
        Compte destinateur = compteRepository.findByCode(transaction.getDestinataire().getCode());

        if (transaction.getType() == TypeTransaction.VIREMENT && expiditeur.getType() == TypeCompte.EPARGNE) {
            message = "On ne peut pas faire un virement à partir d’un compte épargne";
        } else if (transaction.getType() == TypeTransaction.VIREMENT && expiditeur.getType() != TypeCompte.EPARGNE) {
            if (expiditeur.getSolde() > (transaction.getMontant() + 3)){
                transaction.setType(TypeTransaction.VIREMENT);
                transaction.setMontant(transaction.getMontant());
                transaction.setDateTransaction(Date.valueOf(LocalDate.now()));
                expiditeur.setSolde(expiditeur.getSolde() - (transaction.getMontant() + 3));
                destinateur.setSolde(destinateur.getSolde() + transaction.getMontant());
                transaction.setExpediteur(expiditeur);
                transaction.setDestinataire(destinateur);

                message = "VIREMENT DE : " + transaction.getMontant() + "DT de compte " + expiditeur.getCode() + " vers le compte " + destinateur.getCode() + " approuvé avec succès.";

                transactionRepository.save(transaction);
            } else {
                message = "On ne peut pas faire un virement : Solde insuffisant";
            }
        }

        return message;






    }
}

