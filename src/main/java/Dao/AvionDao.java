package Dao;
import Connection.Connexion;
import model.Avion;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class AvionDao {

    public ArrayList<HashMap<String, Object>>  liste() throws Exception {
        ArrayList<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
        try {
            String requete = "select*from Avion";
            Connexion con=new Connexion(requete,"hh");
            ResultSet res=con.getResultset();
            Avion dept;
            String nomavion="",photo="";
            while (con.getResultset().next()) {
                int id= res.getInt(1);
                nomavion = res.getString(2);
                int capacite = res.getInt(3);
                int envergue = res.getInt(4);
                int hauteur = res.getInt(5);
                int masse_au_decollage = res.getInt(6);
                int vitesse_de_croisiere = res.getInt(7);
                int vitesse_max = res.getInt(8);
                int rayon_max = res.getInt(9);
                int capacite_kerosene = res.getInt(10);
                photo = res.getString(11);
                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("idavion",id);
                result.put("nomavion",nomavion);
                result.put("capacite",capacite);
                result.put("envergue",envergue);
                result.put("hauteur",hauteur);
                result.put("masse_au_decollage",masse_au_decollage);
                result.put("vitesse_de_croisiere",vitesse_de_croisiere);
                result.put("vitesse_max",vitesse_max);
                result.put("rayon_max",rayon_max);
                result.put("capacite_kerosene",capacite_kerosene);
                result.put("photo",photo);
                liste.add(result);
            }
            return liste;
        } catch (Exception e) {
            return null;
        }
    }

    public void insererAvion(String photo) throws Exception {
        try {
            String requete ="insert into avion(nomavion, capacite, envergue, hauteur, masse_au_decollage, vitesse_de_croisiere, vitesse_max, rayon_max, capacite_kerosene,photo) values ('Boeing 747',400,68.5, 19.3, 441000,913,945,8700,238000,'"+photo+"')";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
//
        } catch (Exception exc) {
            throw exc;
        } finally {
        }
    }
    public void updateProfil(int idavion,String photo) throws Exception {
        try {
            String requete = "update Avion set photo='"+photo+"' where idavion="+idavion+" ";
            Connexion con = new Connexion(requete);
            System.out.println("la requete est" + requete);
        } catch (Exception exc) {
            throw exc;
        }
    }

    public ArrayList<HashMap<String, Object>>  listeAvionExpirer(int mois) throws Exception {
        ArrayList<HashMap<String, Object>> liste = new ArrayList<HashMap<String, Object>>();
        try {
            Date expiration = Date.valueOf(LocalDate.now().plusMonths(mois));
            String requete = "select a.* from avion a inner join AssuranceAvion av using(idavion) where av.dateFin > '"+expiration+"' ";
            Connexion con=new Connexion(requete,"hh");
            ResultSet res=con.getResultset();
            Avion dept;
            String nomavion="",photo="";
            while (con.getResultset().next()) {
                int id= res.getInt(1);
                nomavion = res.getString(2);
                int capacite = res.getInt(3);
                int envergue = res.getInt(4);
                int hauteur = res.getInt(5);
                int masse_au_decollage = res.getInt(6);
                int vitesse_de_croisiere = res.getInt(7);
                int vitesse_max = res.getInt(8);
                int rayon_max = res.getInt(9);
                int capacite_kerosene = res.getInt(10);
                photo = res.getString(11);
                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("idavion",id);
                result.put("nomavion",nomavion);
                result.put("capacite",capacite);
                result.put("envergue",envergue);
                result.put("hauteur",hauteur);
                result.put("masse_au_decollage",masse_au_decollage);
                result.put("vitesse_de_croisiere",vitesse_de_croisiere);
                result.put("vitesse_max",vitesse_max);
                result.put("rayon_max",rayon_max);
                result.put("capacite_kerosene",capacite_kerosene);
                result.put("photo",photo);
                liste.add(result);
            }
            return liste;
        } catch (Exception e) {
            return null;
        }
    }
}
