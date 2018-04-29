package beans;

import beans.Movimientos;
import beans.Transferencia;
import beans.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-29T12:32:30")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile SingularAttribute<Usuario, Date> fechaNacimiento;
    public static volatile CollectionAttribute<Usuario, Movimientos> movimientosCollection;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, Usuario> usuariodni;
    public static volatile SingularAttribute<Usuario, Integer> numeroCuenta;
    public static volatile CollectionAttribute<Usuario, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, Double> efectivo;
    public static volatile SingularAttribute<Usuario, Short> tipoUsuario;
    public static volatile CollectionAttribute<Usuario, Transferencia> transferenciaCollection;
    public static volatile SingularAttribute<Usuario, String> dni;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}