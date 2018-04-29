package beans;

import beans.TransferenciaPK;
import beans.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:32:30")
@StaticMetamodel(Transferencia.class)
public class Transferencia_ { 

    public static volatile SingularAttribute<Transferencia, Date> fecha;
    public static volatile SingularAttribute<Transferencia, String> concepto;
    public static volatile SingularAttribute<Transferencia, Usuario> usuario;
    public static volatile SingularAttribute<Transferencia, String> cantidad;
    public static volatile SingularAttribute<Transferencia, TransferenciaPK> transferenciaPK;

}