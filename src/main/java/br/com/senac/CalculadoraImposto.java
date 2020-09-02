package br.com.senac;


public class CalculadoraImposto {

    public double calcularImposto(final double salario) {
        double impostoDevido = 0.0;
        
        if (salario >= 1903.99 && salario <= 2826.65) {
            impostoDevido = ((salario * 0.075) - 142.80);
        }
        else if (salario >= 2826.66 && salario <= 3751.05) {
            impostoDevido = ((salario * 0.15) - 354.80);
        }
        else if (salario >= 3751.06 && salario <= 4664.68) {
            impostoDevido = ((salario * 0.225) - 636.13);
        }
        else if (salario >= 4664.69) {
            impostoDevido = ((salario * 0.275) - 869.36);
        }
        

        return impostoDevido;
    }
    
}