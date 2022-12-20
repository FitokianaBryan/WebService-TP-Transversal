package Connection;


import model.V_mouvement;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception{
        ArrayList<HashMap<String, Object>> liste = new V_mouvement().v_mouvement(1);
        for(int i=0;i<liste.size();i++)
        {
            System.out.println(liste.get(i).get("lieu_arrivee"));
        }

    }
}
