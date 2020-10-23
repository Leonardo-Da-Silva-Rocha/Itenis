package util.copy;

import javax.persistence.*;

public class Conexao {
	private static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("Nome_Da_Unit_De_Persistencia");
	}	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}	
}
