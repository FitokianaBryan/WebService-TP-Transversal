package Dao;

import Connection.Connexion;
import model.Admin;

import java.sql.ResultSet;

public class AdminDao {

 /*    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "connection");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();*/

    public String login(String user,String mdp) throws Exception
    {
        String idadmin = "";
        try {
            String requete= "select idadmin from Admin where users='"+user+"' and mdp='"+mdp+"' ";
            Connexion c = new Connexion(requete,"");
            ResultSet res = c.getResultset();
            c.getResultset().next();
            idadmin = res.getString(1);
        }
        catch(Exception e)
        {
                idadmin  = "null";
        }
        return idadmin;
    }
}
