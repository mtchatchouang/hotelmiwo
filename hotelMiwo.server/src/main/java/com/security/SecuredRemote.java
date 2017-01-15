package com.security;

import javax.ejb.Remote;

/**Remote Interface der "SecuredBean".
 *
 * Created by mtc on 29.05.16.
 */
@Remote
public interface SecuredRemote
{
    /**
     * Diese Methode darf nur vom Admin aufgerufen werden !
     */
    public void forAdminOnly();

    /**
     * Diese Methode darf nur vom Kunden aufgerufen werden !
     */
    public void forMitarbeiterOnly();

    /**
     * Diese Methode darf von Admin und Kunde aufgerufen werden !
     */
    public void forBoth();
}
