package com.security;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.SecurityDomain;

import com.db.Anwender;


/**
 * Created by mtc on 29.05.16.
 */
@Stateless
@DeclareRoles(value={"admin", "mitarbeiter"})
@SecurityDomain(value="mydbsecurity")
public class SecuredBean implements SecuredRemote
{
    private static final Logger logger = Logger.getLogger (SecuredBean.class.getName() );

    @PersistenceContext(unitName="MyPersistenceUnit")
    private EntityManager entityManager = null;

    @Resource()
    private SessionContext sessionContext = null;

    @RolesAllowed(value={"admin"} )
    public void forAdminOnly()
    {
        logger.info("forAdminOnly");
    }

    @RolesAllowed(value={"mitarbeiter"} )
    public void forMitarbeiterOnly()
    {
        logger.info("forMitarbeiterOnly");
    }

    @RolesAllowed(value={"admin", "mitarbeiter"} )
    public void forBoth()
    {
        logger.info("forBoth");

        logger.info ("Caller: '" + this.sessionContext.getCallerPrincipal().getName() +"'");
        logger.info ("Caller in Rolle 'mitarbeiter' ? " + this.sessionContext.isCallerInRole("mitarbeiter"));
        logger.info ("Caller in Rolle 'admin' ? " + this.sessionContext.isCallerInRole("admin"));

        //Jetzt einen Datenbankzugriff versuchen:
        Query query = this.entityManager.createQuery("select o from Anwender o");
        List<Anwender> anwenderList = query.getResultList();
        Iterator<Anwender> anwenderIterator = anwenderList.iterator();
        while (anwenderIterator.hasNext() == true)
        {
            Anwender benutzerAktuell = anwenderIterator.next();
            logger.info("Benutzer-Login: {}'" + benutzerAktuell.getBenutzername() + "'");
        }
    }
}
