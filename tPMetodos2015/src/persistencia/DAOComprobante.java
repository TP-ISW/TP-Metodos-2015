package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Comprobante;

public class DAOComprobante implements Repositorio<Comprobante> {

	@Override
	public void save(Comprobante objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Comprobante objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Comprobante getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Comprobante objeto = (Comprobante) session.get(Comprobante.class, id);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Comprobante> getAll() {
		// TODO Auto-generated method stub
		List<Comprobante> listF = new ArrayList<Comprobante>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Comprobante> list = session.createCriteria(Comprobante.class).list();
        session.getTransaction().commit();
        for(Comprobante o : list) {
            listF.add((Comprobante)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Comprobante> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Comprobante loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Comprobante objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Comprobante getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
