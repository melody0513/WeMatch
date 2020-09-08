package tw.eeit117.wematch.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory factory = createSessionFactory();
	
	private static SessionFactory createSessionFactory() {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		return factory;
	}
	
	public static SessionFactory getSessionFactory() {
		System.out.println("aaa");
		return factory;
	}
	
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}