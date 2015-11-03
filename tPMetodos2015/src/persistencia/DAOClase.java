package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Clase;

public class DAOClase implements Repositorio<Clase> {

	@Override
	public void save(Clase objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Clase objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Clase getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Clase objeto = (Clase) session.get(Clase.class, id);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Clase> getAll() {
		// TODO Auto-generated method stub
		List<Clase> listF = new ArrayList<Clase>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Clase> list = session.createCriteria(Clase.class).list();
        session.getTransaction().commit();
        for(Clase o : list) {
            listF.add((Clase)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Clase> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Clase loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Clase objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Clase getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
