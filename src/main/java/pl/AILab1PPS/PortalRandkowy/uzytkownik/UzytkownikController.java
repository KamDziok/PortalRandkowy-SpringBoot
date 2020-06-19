package pl.AILab1PPS.PortalRandkowy.uzytkownik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.AILab1PPS.PortalRandkowy.zwiazek.ProposedRelationship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/uzytkownik")
@CrossOrigin
public class UzytkownikController {


        @Autowired
        private UzytkownikRepository uzytkownikRepository;

        @GetMapping
        private ArrayList<Uzytkownik> getAllUzytkownik(){

            return (ArrayList<Uzytkownik>) uzytkownikRepository.findAll();
        }

    @GetMapping("/mail/{mail}/password/{password}")
    private Uzytkownik getUzytkownikByMailAndPassword(@PathVariable("mail") String mail, @PathVariable("password") String password){
        return uzytkownikRepository.findByMailAndHaslo(mail, password);
    }

    @GetMapping("/nick/{nick}/password/{password}")
    private Uzytkownik getUzytkownikByNickAndPassword(@PathVariable("nick") String nick, @PathVariable("password") String password){
        return uzytkownikRepository.findByNickAndHaslo(nick, password);
    }

    @GetMapping("/uzytkownik/{id}")
    private List<ProposedRelationship> getProposedRelationship(@PathVariable("id") Long id){
        Uzytkownik userCurrent = uzytkownikRepository.getOne(id);
        List<ProposedRelationship> proposedRelationshipList = new ArrayList<>();
        List<Uzytkownik> userList = (List<Uzytkownik>)uzytkownikRepository.findAll();
        userList.forEach(user -> {
            if(user.getId().intValue() != userCurrent.getId().intValue()){
                if(!user.isInRelationship(userCurrent)){
                    proposedRelationshipList.add(new ProposedRelationship(user.basicUzytkownik(),
                            user.countPointsForPodKategorie(userCurrent)));
                }
            }
        });
        sort(proposedRelationshipList, 0, proposedRelationshipList.size()-1);
        return proposedRelationshipList;
    }

    int partition(List<ProposedRelationship> proposedRelationshipList, int low, int high) {
        ProposedRelationship pivot = proposedRelationshipList.get(high);
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (proposedRelationshipList.get(j).getPoints() < pivot.getPoints())
            {
                i++;
                ProposedRelationship temp = proposedRelationshipList.get(i);
                proposedRelationshipList.set(i, proposedRelationshipList.get(j));
                proposedRelationshipList.set(j, temp);
            }
        }
        ProposedRelationship temp =  proposedRelationshipList.get(i+1);
        proposedRelationshipList.set(i+1, proposedRelationshipList.get(high));
        proposedRelationshipList.set(high, temp);

        return i+1;
    }

    void sort(List<ProposedRelationship> proposedRelationshipList, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(proposedRelationshipList, low, high);

            sort(proposedRelationshipList, low, pi-1);
            sort(proposedRelationshipList, pi+1, high);
        }
    }

    @PostMapping
        private Uzytkownik addUzytkownik(@RequestBody Uzytkownik uzytkownik){
            Uzytkownik user = uzytkownikRepository.save(uzytkownik);
            return uzytkownikRepository.getOne(user.getId());
        }

        @PutMapping
        private Uzytkownik updateUzytkownik(@RequestBody Uzytkownik uzytkownik){
            Uzytkownik user = uzytkownikRepository.save(uzytkownik);
            return uzytkownikRepository.getOne(user.getId());
        }

        @DeleteMapping
        private Uzytkownik deleteUzytkownik(@RequestBody Uzytkownik uzytkownik){
            uzytkownikRepository.delete(uzytkownik);
            return uzytkownik;
        }
}
