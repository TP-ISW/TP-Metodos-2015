package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Licenciavigente;

public class DAOLicenciaVigente implements Repositorio<Licenciavigente> {

	@Override
	public void save(Licenciavigente objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Licenciavigente objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Licenciavigente getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Licenciavigente objeto = (Licenciavigente) session.get(Licenciavigente.class, id);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Licenciavigente> getAll() {
		// TODO Auto-generated method stub
		List<Licenciavigente> listF = new ArrayList<Licenciavigente>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Licenciavigente> list = session.createCriteria(Licenciavigente.class).list();
        session.getTransaction().commit();
        for(Licenciavigente o : list) {
            listF.add((Licenciavigente)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Licenciavigente> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Licenciavigente loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Licenciavigente objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Licenciavigente getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
