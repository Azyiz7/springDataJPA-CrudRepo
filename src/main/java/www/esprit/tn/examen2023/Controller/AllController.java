package www.esprit.tn.examen2023.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import www.esprit.tn.examen2023.Entite.Bank;
import www.esprit.tn.examen2023.Entite.Compte;
import www.esprit.tn.examen2023.Service.IallService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AllController {
    IallService allService;
    @PostMapping("/addBank")
public Bank ajouterBank(@RequestBody Bank bank){
        return  allService.ajouterBank(bank);
    }
    @PostMapping("/ajouterCompteEtAffecterAAgence/{agence}")
    public Compte ajouterCompteEtAffecterAAgence(@RequestBody Compte compte,@PathVariable String agence){
        return allService.ajouterCompteEtAffecterAAgence(compte, agence);
    }
}
