package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Titular;
import clasesDeTablas.TitularPK;

public class DAOTitular implements Repositorio<Titular> {

	@Override
	public void save(Titular objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Titular objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	@Override
	public Titular getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Titular getByDocumentoYTipo(TitularPK documento) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Titular objeto = (Titular) session.get(Titular.class, documento);
        Hibernate.initialize(objeto.getClasesSolicitadas());
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Titular> getAll() {
		// TODO Auto-generated method stub
		List<Titular> listF = new ArrayList<Titular>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Titular> list = session.createCriteria(Titular.class).list();
        session.getTransaction().commit();
        for(Titular o : list) {
            listF.add((Titular)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Titular> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Titular loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Titular objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

}
