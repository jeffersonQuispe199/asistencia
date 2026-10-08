package asistencias2.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import asistencias2.dominio.Asistencia;
import asistencias2.dominio.Estudiante;
import asistencias2.dominio.RegistroAsistencia;

@Service
public class ServicioAsistencia {
    private ArrayList<RegistroAsistencia> registros = new ArrayList<>();
    private final ServicioEstudiantes servicioEstudiantes;

    public ServicioAsistencia(ServicioEstudiantes servicioEstudiantes) {
        this.servicioEstudiantes = servicioEstudiantes;
    }

    public RegistroAsistencia registrarAsistencia(String cedula) {
        Estudiante estudiante = servicioEstudiantes.buscarPorCedula(cedula);
        if (estudiante == null) {
            return null;
        }

        Asistencia asistencia = new Asistencia(
                LocalDate.now(),
                LocalDateTime.now(),
                "A"
        );

        RegistroAsistencia registro = new RegistroAsistencia(estudiante, asistencia);
        registros.add(registro);
        return registro;
    }

    public ArrayList<Asistencia> consultarAsistencia(String cedula) {
        ArrayList<Asistencia> listaAsistencias = new ArrayList<>();
        for (RegistroAsistencia r : registros) {
            if (r.getEstudiante().getCedula().equals(cedula)) {
                listaAsistencias.add(r.getAsistencia());
            }
        }
        return listaAsistencias;
    }
}