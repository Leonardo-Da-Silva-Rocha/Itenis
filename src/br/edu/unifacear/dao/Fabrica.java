// http://hibernate.org/orm/releases/5.4/
package br.edu.unifacear.dao;

import javax.persistence.*;

public class Fabrica {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nome_Da_Unit_De_Persistencia");
	
	// getConnection
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
