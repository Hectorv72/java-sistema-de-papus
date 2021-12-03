package persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Peluqueria;
import persistence.exceptions.NonexistentEntityException;


public class PeluqueriaController {
    PeluqueriaJpaController peluJPA = new PeluqueriaJpaController();

    public void crearDatos(Peluqueria peluqueria){
        try {
            peluJPA.create(peluqueria);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List <Peluqueria> ListarDatos(){
        List<Peluqueria> ListarDatos = peluJPA.findPeluqueriaEntities();
        return ListarDatos;
    }
    
    public void eliminarDatos(int id){
        try {
            peluJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EmpleadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}