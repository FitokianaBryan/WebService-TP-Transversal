package RestController;

import model.V_mouvement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
public class MouvementRestController {

    //detail mouvement d'un avion
    @GetMapping("/mouvement/{idavion}")
    public ResponseEntity<ArrayList<HashMap<String, Object>>> liste_v_assurance(@PathVariable int idavion){
        try{
            System.out.println("AUTHORIZED");
            return new ResponseEntity<ArrayList<HashMap<String, Object>>>(new V_mouvement().v_mouvement(idavion), HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    }


