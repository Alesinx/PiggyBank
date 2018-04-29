package beans;

import beans.MovimientosPK;
import beans.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:32:30")
@StaticMetamodel(Movimientos.class)
public class Movimientos_ { 

    public static volatile SingularAttribute<Movimientos, Date> fecha;
    public static volatile SingularAttribute<Movimientos, MovimientosPK> movimientosPK;
    public static volatile SingularAttribute<Movimientos, String> concepto;
    public static volatile SingularAttribute<Movimientos, Usuario> usuario;
    public static volatile SingularAttribute<Movimientos, Double> cantidad;

}