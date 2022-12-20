package model;

import Connection.Connexion;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class V_mouvement {
    public int idavion;
    public String nomavion;
    public String numero;
    public String dateDepart;
    public String dateArrivee;
    public String lieu_depart;
    public String lieu_arrivee;
    public int kilometrage_effectuer;



    public V_mouvement() {
    }

    //detail voiture et kilometrage
    public ArrayList<HashMap<String, Object>> v_mouvement(int id) throws Exception {
        ArrayList<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
        try {
            String requete = "select a.idavion , a.nomavion , m.dateDepart , m.dateArrivee , m.lieu_depart , m.lieu_arrivee , m.kilometrage_effectuer from Avion a inner join Mouvement m using(idavion) where idavion="+id+" ";
            Connexion con=new Connexion(requete,"hh");
            ResultSet res=con.getResultset();
            Avion dept;
            String idavion="" , nomavion="", dateDepart="" , dateArrivee="" , lieu_depart="" , lieu_arrivee="";
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while (con.getResultset().next()) {
                idavion= res.getString(1);
                nomavion = res.getString(2);
                dateDepart = dateFormat.format(res.getDate(3));
                dateArrivee = dateFormat.format(res.getDate(4));
                lieu_depart = res.getString(5);
                lieu_arrivee = res.getString(6);
                int kilometrage_effectuer = res.getInt(7);
                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("idavion",idavion);
                result.put("nomavion",nomavion);
                result.put("dateDepart",dateDepart);
                result.put("dateArrivee",dateArrivee);
                result.put("lieu_depart",lieu_depart);
                result.put("lieu_arrivee",lieu_arrivee);
                result.put("kilometrage_effectuer",kilometrage_effectuer);
                liste.add(result);
            }
            return liste;
        } catch (Exception e) {
            return null;
        }
    }
}
