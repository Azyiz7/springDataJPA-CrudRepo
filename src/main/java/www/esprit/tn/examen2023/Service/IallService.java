package www.esprit.tn.examen2023.Service;

import www.esprit.tn.examen2023.Entite.Bank;
import www.esprit.tn.examen2023.Entite.Compte;
import www.esprit.tn.examen2023.Entite.Transaction;

public interface IallService {
    public Bank ajouterBank(Bank bank);
    public Compte ajouterCompteEtAffecterAAgence(Compte compte, String agence);
    public String ajouterVirement(Transaction transaction);

}
