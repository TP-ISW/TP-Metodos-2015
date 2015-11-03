package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Contribuyente;
import clasesDeTablas.ContribuyentePK;
public class DAOContribuyente implements Repositorio<Contribuyente> {

	@Override
	public void save(Contribuyente objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Contribuyente objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Contribuyente getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Contribuyente objeto = (Contribuyente) session.get(Contribuyente.class, id);
        session.getTransaction().commit();
        return objeto;
	}
	public Contribuyente getByDocumentoYTipo(ContribuyentePK documento) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Contribuyente objeto = (Contribuyente) session.get(Contribuyente.class, documento);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Contribuyente> getAll() {
		// TODO Auto-generated method stub
		List<Contribuyente> listF = new ArrayList<Contribuyente>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Contribuyente> list = session.createCriteria(Contribuyente.class).list();
        session.getTransaction().commit();
        for(Contribuyente o : list) {
            listF.add((Contribuyente)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Contribuyente> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Contribuyente loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Contribuyente objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Contribuyente getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
