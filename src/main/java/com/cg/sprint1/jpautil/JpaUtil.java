package com.cg.sprint1.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManager em;
	private static EntityManagerFactory emf;
    public static EntityManager getEntityManager()
    {
    	if(em==null || em.isOpen())
    	{
    	 emf=Persistence.createEntityManagerFactory("materialentity");
    		em=emf.createEntityManager();
    	}
    	return em;
    }
    private JpaUtil()
    {}
	public static void close() {
  if(emf!=null)
	  emf.close();
		
	}


}
