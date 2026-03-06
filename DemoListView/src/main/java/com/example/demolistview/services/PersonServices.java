package com.example.demolistview.services;

import com.example.demolistview.repositores.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonServices {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataForList() throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las lineas de archivo
        List<String> result = new ArrayList<>();//Listado de resultado con el formato deseado
        for (String line : lines){
            if (line==null || line.isBlank()) continue; //Ignora las lineas nulas

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); // Obtiee el nombre del arreglo
            String correo = parts[1].trim(); //Obtiene el correo del arreglo
            result.add(name+"-"+correo);//Se agrega a la lista de resultados con el formato
        }
        return result;
    }
}
