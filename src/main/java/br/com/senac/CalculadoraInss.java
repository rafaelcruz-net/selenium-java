package br.com.senac;

/**
 * CalculadoraInss
 */
public class CalculadoraInss {

    public double calcularContribuicao(final double salario) {
        if (salario >= 1693.73 && salario <= 2822.90)
            return salario * 0.09;
        else if (salario >= 2822.91 && salario <= 5645.80)
            return salario * 0.11;

        return salario * 0.08;
    }

}