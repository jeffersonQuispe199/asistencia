package asistencias2.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import asistencias2.dominio.Estudiante;

@Service
public class ServicioEstudiantes {
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public void agregar(Estudiante estudiante) {
        if (buscarPorCedula(estudiante.getCedula()) == null) {
            estudiantes.add(estudiante);
        }
    }

    public Estudiante buscarPorCedula(String cedula) {
        for (Estudiante e : estudiantes) {
            if (e.getCedula().equals(cedula)) {
                return e;
            }
        }
        return null;
    }

    public void eliminar(String cedula) {
        Estudiante e = buscarPorCedula(cedula);
        if (e != null) {
            estudiantes.remove(e);
        }
    }

    public void actualizar(String cedula, Estudiante nuevo) {
        Estudiante e = buscarPorCedula(cedula);
        if (e != null) {
            e.setNombre(nuevo.getNombre());
            e.setApellido(nuevo.getApellido());
        }
    }

    public ArrayList<Estudiante> listar() {
        return estudiantes;
    }
}