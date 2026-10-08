package asistencias2.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asistencias2.dominio.Estudiante;
import asistencias2.dominio.RegistroAsistencia;
import asistencias2.servicios.ServicioEstudiantes;
@RestController
@RequestMapping("/estudiantes")
public class ControladorEstudiantes {

    private final ServicioEstudiantes servicioEstudiantes;

    public ControladorEstudiantes(ServicioEstudiantes servicioEstudiantes) {
        this.servicioEstudiantes = servicioEstudiantes;
    }

    @PostMapping
    public void agregar(@RequestBody Estudiante estudiante) {
        servicioEstudiantes.agregar(estudiante);
    }

    @GetMapping
    public ArrayList<Estudiante> listar() {
        return servicioEstudiantes.listar();
    }

    @GetMapping("/{cedula}")
    public Estudiante buscarPorCedula(@PathVariable String cedula) {
        return servicioEstudiantes.buscarPorCedula(cedula);
    }

    @PutMapping("/{cedula}")
    public void actualizar(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
        servicioEstudiantes.actualizar(cedula, estudiante);
    }

    @DeleteMapping("/{cedula}")
    public void eliminar(@PathVariable String cedula) {
        servicioEstudiantes.eliminar(cedula);
    }
}