package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Licenciaexpirada;

public class DAOLicenciaExpirada implements Repositorio<Licenciaexpirada> {

	@Override
	public void save(Licenciaexpirada objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Licenciaexpirada objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Licenciaexpirada getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Licenciaexpirada objeto = (Licenciaexpirada) session.get(Licenciaexpirada.class, id);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Licenciaexpirada> getAll() {
		// TODO Auto-generated method stub
		List<Licenciaexpirada> listF = new ArrayList<Licenciaexpirada>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Licenciaexpirada> list = session.createCriteria(Licenciaexpirada.class).list();
        session.getTransaction().commit();
        for(Licenciaexpirada o : list) {
            listF.add((Licenciaexpirada)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Licenciaexpirada> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Licenciaexpirada loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Licenciaexpirada objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Licenciaexpirada getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
