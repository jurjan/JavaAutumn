package coursework.fxControllers;

import coursework.hibenateControllers.GenericHibernate;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductWindow {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("coursework");
    GenericHibernate hibernate = new GenericHibernate(entityManagerFactory);


}
