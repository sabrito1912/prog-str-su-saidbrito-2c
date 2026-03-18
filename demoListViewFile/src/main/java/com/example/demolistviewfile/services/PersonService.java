package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {

        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for(String line : lines){

            if(line == null || line.isBlank()) continue;

            String[] parts = line.split(",");

            String name = parts[0];
            String email = parts[1];

            String age = "N/A";
            if(parts.length > 2){
                age = parts[2];
            }

            result.add(name + " - " + email + " - " + age);
        }

        return result;
    }

    public void updatePerson(int index, String name, String email, String age) throws IOException{
        validate(name, email, age);
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for(String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        cleanLines.set(index, name + "," + email + "," + age);
        repo.saveFile(cleanLines);
    }
    public void delete(int index) throws IOException{
        List<String> listaOriginal = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for(String line : listaOriginal){
            if(line != null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines);
    }

    public void addPerson(String name, String email, String age) throws IOException {
        validate(name, email, age);
        repo.addNewLine(name + "," + email + "," + age);
    }

    private void validate(String name, String email, String age){

        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }

        String em = (email == null) ? "" : email.trim();

        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es invalido");
        }

        try {
            int ageInt = Integer.parseInt(age);

            if(ageInt < 0){
                throw new IllegalArgumentException("La edad no puede ser negativa");
            }

            if(ageInt < 18){
                throw new IllegalArgumentException("Solo se aceptan mayores de edad");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La edad debe ser un número válido");
        }
    }
}