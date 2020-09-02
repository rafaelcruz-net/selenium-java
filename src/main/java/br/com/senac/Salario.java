package br.com.senac;

/**
 * Salario
 */
public class Salario {

    private double salarioBruto;
    private double salarioLiquido;

    public Salario(double salario) {
        super();

        this.salarioBruto = salario;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public void calcularSalario() {
        CalculadoraImposto imposto = new CalculadoraImposto();
        CalculadoraInss contruibicao = new CalculadoraInss();

        this.salarioLiquido = this.salarioBruto - (imposto.calcularImposto(this.salarioBruto) + (contruibicao.calcularContribuicao(this.salarioBruto)));
    }
    
}