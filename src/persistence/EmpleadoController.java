
package persistence;

import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Empleado;
import persistence.exceptions.NonexistentEntityException;


public class EmpleadoController {
    EmpleadoJpaController empJPA = new EmpleadoJpaController();

    public void crearEmpleado(Empleado empleado){
        try {
            empJPA.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarEmpleado(int id){
        try {
            empJPA.destroy(0);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
