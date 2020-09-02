package br.com.senac;

import java.util.ArrayList;

/**
 * ProcessaSalarioService
 */
public class ProcessaSalarioService {

    
    private SalarioDAO repository;

    public ProcessaSalarioService(SalarioDAO repository) {
        super();
        this.repository = repository;   
    }

    public ArrayList<Salario> processaFolha() {
        final ArrayList<Salario> salarios = this.repository.getSalario();

        for (Salario item : salarios) {
            item.calcularSalario();
        }

        return salarios;
    }
    
}