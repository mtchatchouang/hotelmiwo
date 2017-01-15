package db;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.security.Base64Encoder;

import com.db.Anwender;
import com.db.AnwenderRolle;
import com.db.Rolle;

/**
 * Created by mtc on 28.05.16.
 */
public class AnwenderTest {
    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        em = emf.createEntityManager();

        try {
            createAnwender("mtc", Base64Encoder.encode(MessageDigest.getInstance("SHA-256").digest("change".getBytes())), "mtc@adorsys.de", "Maturin", "Tchatchouang", "Entwickler");
            createAnwender("stc", Base64Encoder.encode(MessageDigest.getInstance("SHA-256").digest("change".getBytes())), "stc@adorsys.de", "Simplice", "Tchoupkoua", "J2EE Entwickler");
            createAnwender("wch", Base64Encoder.encode(MessageDigest.getInstance("SHA-256").digest("change".getBytes())), "wch@adorsys.de", "Willie", "Chieukam", "Projektleiter & Entwickler");
            createAnwender("sha", Base64Encoder.encode(MessageDigest.getInstance("SHA-256").digest("change".getBytes())), "sha@adorsys.de", "Stefan", "Hamm", "Geschäftsführer");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        createRolle("admin");
        createRolle("mitarbeiter");
        createRolle("gast");

        createAnwenderRolle("mtc", 1);
        createAnwenderRolle("stc", 2);
        createAnwenderRolle("wch", 3);
        createAnwenderRolle("sha", 2);
    }

    private static void createAnwender(String benutzername, String passwort, String email, String vorname, String nachname, String job_beschreibung) {
        em.getTransaction().begin();
        Anwender anwender = null;
        List<Anwender> anwenderList = em.createQuery("from Anwender WHERE benutzername = :name")
                .setParameter("name", benutzername)
                .getResultList();
        if(anwenderList.isEmpty()){
            anwender = new Anwender(benutzername, passwort, email, vorname, nachname, job_beschreibung);
            em.persist(anwender);
        } else {
            anwender = anwenderList.get(0);
            anwender.setPasswort(passwort);
            anwender.setEmail(email);
            anwender.setVorname(vorname);
            anwender.setNachname(nachname);
            anwender.setJob_beschreibung(job_beschreibung);
        }
        em.getTransaction().commit();
    }

    private static void createRolle(String rolle) {
        em.getTransaction().begin();
        Rolle rolleBean = new Rolle(rolle);
        em.persist(rolleBean);
        em.getTransaction().commit();
    }

    private static void createAnwenderRolle(String anwender, int rolle) {
        em.getTransaction().begin();
        AnwenderRolle anwenderRolle = new AnwenderRolle(anwender, rolle);
        em.persist(anwenderRolle);
        em.getTransaction().commit();
    }
}
