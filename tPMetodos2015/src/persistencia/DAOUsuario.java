package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import clasesDeTablas.Usuario;

public class DAOUsuario implements Repositorio<Usuario> {

	@Override
	public void save(Usuario objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.save(objeto);
         session.getTransaction().commit();
	}

	@Override
	public void delete(Usuario objeto) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        session.delete(objeto);
        session.getTransaction().commit();
	}

	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        Usuario objeto = (Usuario) session.get(Usuario.class, id);
        session.getTransaction().commit();
        return objeto;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		List<Usuario> listF = new ArrayList<Usuario>();
        SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Usuario> list = session.createCriteria(Usuario.class).list();
        session.getTransaction().commit();
        for(Usuario o : list) {
            listF.add((Usuario)o);
        }
        return listF;
	}

	@Override
	public void saveAll(List<Usuario> lista) {
		// TODO Auto-generated method stub
		SessionFactory factory= FabricaSessionFactory.getFactory();
        Session session = factory.getCurrentSession(); 
        session.beginTransaction();
        for (Usuario loc : lista) {
        session.save(loc);
        }               
        session.getTransaction().commit();
	}

	@Override
	public void update(Usuario objeto) {
		// TODO Auto-generated method stub
		 SessionFactory factory= FabricaSessionFactory.getFactory();
         Session session = factory.getCurrentSession(); 
         session.beginTransaction();
         session.update(objeto);
         session.getTransaction().commit();
	}

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
