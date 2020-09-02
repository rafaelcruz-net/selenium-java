package br.com.senac;
import static org.junit.Assert.*;

import org.junit.Test;


/**
 * CalculadoraInss
 */
public class CalculadoraInssTest {
    
    @Test
    public void DeveCalcularContribuicaoPrimeiraFaixa() {
        final CalculadoraInss calculadora = new CalculadoraInss();
        final double salario = 1500;
        final double result = calculadora.calcularContribuicao(salario);
        final double expected = 120.00;
        
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void DeveCalcularContribuicaoSegundaFaixa() {
        final CalculadoraInss calculadora = new CalculadoraInss();
        final double salario = 1678.09;
        final double result = calculadora.calcularContribuicao(salario);
        final double expected = 134.24;
        
        assertEquals(expected, result, 0.01);
    }


    
    @Test
    public void DeveCalcularContribuicaoTerceiraFaixa() {
        final CalculadoraInss calculadora = new CalculadoraInss();
        final double salario = 4541.00;
        final double result = calculadora.calcularContribuicao(salario);
        final double expected = 499.51;
        
        assertEquals(expected, result, 0.01);
    }
    
    
}