package br.com.senac;

import java.util.ArrayList;

/**
 * SalarioDAO
 */
public class SalarioDAO {

    private static ArrayList<Salario> repository;
    
    public SalarioDAO() {
        super();
        SalarioDAO.repository = new ArrayList<Salario>();
    }

    public ArrayList<Salario> getSalario() {
        return SalarioDAO.repository;
    }


}