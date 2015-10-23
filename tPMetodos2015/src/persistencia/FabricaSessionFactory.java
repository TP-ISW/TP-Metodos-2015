package persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import clasesDeTablas.Clase;
import clasesDeTablas.Comprobante;
import clasesDeTablas.Contribuyente;
import clasesDeTablas.Licenciaexpirada;
import clasesDeTablas.Licenciavigente;
import clasesDeTablas.Titular;
import clasesDeTablas.Usuario;

public class FabricaSessionFactory {
        
        static SessionFactory factory;
        
        public FabricaSessionFactory(){

        }

        public static SessionFactory getFactory() {
                if (factory==null){
                        AnnotationConfiguration config = new AnnotationConfiguration();
                        config.addAnnotatedClass(Clase.class); 
                        config.addAnnotatedClass(Comprobante.class); //se tienen que agregar todas las clases que tienen el entity
                        config.addAnnotatedClass(Contribuyente.class);
                        config.addAnnotatedClass(Licenciaexpirada.class);
                        config.addAnnotatedClass(Licenciavigente.class);
                        config.addAnnotatedClass(Titular.class);
                        config.addAnnotatedClass(Usuario.class);
                       

                        config.configure("hibernate.cfg.xml");//la linea que lee el archivo de configuracion entre hibernate y la BD, el string que tiene dentro no es necesario
                        
                        factory = config.buildSessionFactory();//instancia la BD? hay que intentar tener muy pocas de estas

                        return factory;
                }
                else return factory;
        }
        
        
}
