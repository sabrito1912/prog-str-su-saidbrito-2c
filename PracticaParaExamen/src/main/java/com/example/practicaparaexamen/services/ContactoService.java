package com.example.practicaparaexamen.services;
import com.example.practicaparaexamen.models.Contacto;
import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    private List<Contacto> listaContactos = new ArrayList<>();

    public List<Contacto> obtenerTodos() {
        return listaContactos;
    }

    public void agregarContacto(String nombre, String telefono, String parentesco) {
        validar(nombre, telefono, parentesco);

        if (buscarPorNombre(nombre) != null) {
            throw new IllegalArgumentException("Ya existe un contacto con ese nombre.");
        }

        Contacto nuevo = new Contacto(nombre, telefono, parentesco);
        listaContactos.add(nuevo);
    }

    public Contacto buscarPorNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) return null;

        for (Contacto c : listaContactos) {
            if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                return c;
            }
        }
        return null;
    }

    public void actualizarContacto(String nombreOriginal, String nuevoTelefono, String nuevoParentesco) {
        Contacto contacto = buscarPorNombre(nombreOriginal);
        if (contacto == null) {
            throw new IllegalArgumentException("No se encontró el contacto para actualizar.");
        }

        validar(nombreOriginal, nuevoTelefono, nuevoParentesco);

        contacto.setTelefono(nuevoTelefono);
        contacto.setParentesco(nuevoParentesco);
    }

    public void eliminarContacto(String nombre) {
        Contacto contacto = buscarPorNombre(nombre);
        if (contacto == null) {
            throw new IllegalArgumentException("No se encontró el contacto para eliminar.");
        }
        listaContactos.remove(contacto);
    }

    private void validar(String nombre, String telefono, String parentesco) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no debe estar vacío.");
        }
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no debe estar vacío.");
        }
        if (telefono.length() != 10) {
            throw new IllegalArgumentException("El teléfono debe tener exactamente 10 dígitos.");
        }
        try {
            Long.parseLong(telefono);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El teléfono solo debe contener números.");
        }
        if (parentesco == null || parentesco.isBlank()) {
            throw new IllegalArgumentException("El parentesco debe seleccionarse obligatoriamente.");
        }
    }
}