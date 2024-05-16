import dao.BD;
import dao.OdontologoDaoH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {
    @Test
    public void buscarUnPaciente(){
        BD.crearTablas();
        OdontologoService pacienteService= new OdontologoService();
        Integer busqueda= 1;
        Odontologo paciente= pacienteService.buscarTodos(busqueda);
        Assertions.assertTrue(paciente!=null);
    }
}