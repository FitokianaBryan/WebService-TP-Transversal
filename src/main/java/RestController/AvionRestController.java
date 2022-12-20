package RestController;

import Dao.AvionDao;
import Dao.TokenDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
public class AvionRestController {

    //liste des avions
    @GetMapping("/avions")
    public ResponseEntity<ArrayList<HashMap<String, Object>>> liste(){
        TokenDao td = new TokenDao();
        try{
            System.out.println("AUTHORIZED");
            return new ResponseEntity<ArrayList<HashMap<String, Object>>>(new AvionDao().liste(), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //modifier vehicule
    @PutMapping("/updateProfil/{idavion}")
    public ResponseEntity<Boolean> updateProfil(@PathVariable int idavion,@RequestParam(name="photo") String photo) throws  Exception{
        AvionDao ad = new AvionDao();
        ad.updateProfil(idavion,photo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    //ajout avion
    @PostMapping("/ajoutAvion")
    public ResponseEntity<Boolean> inserere(@RequestParam(name="photo") String photo) throws  Exception{
        AvionDao ad = new AvionDao();
        ad.insererAvion(photo);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //liste des vehicules lany assurance
    @GetMapping("/v_assurance/{mois}")
    public ResponseEntity<ArrayList<HashMap<String, Object>>> liste_v_assurance(@PathVariable int mois){
        try{
            System.out.println("AUTHORIZED");
            return new ResponseEntity<ArrayList<HashMap<String, Object>>>(new AvionDao().listeAvionExpirer(mois), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
