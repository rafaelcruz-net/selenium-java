package br.com.senac;
import static org.junit.Assert.*;

import org.junit.Test;
/**
 * CalculadoraImpostoTest
 */
public class CalculadoraImpostoTest {

    @Test
    public void DeveCalcularImpostoCorretamenteQuandoNaoSalarioEntrarNasFaixas() {
        final CalculadoraImposto calculadora = new CalculadoraImposto();
        final double salario = 1500;
        final double result = calculadora.calcularImposto(salario);
        final double expected = 0.0;
        assertEquals(expected, result, 0);
    }

    @Test
    public void DeveCalcularImpostoCorretamenteQuandoSalarioEntraNaPrimeiraFaixa() {
        final CalculadoraImposto calculadora = new CalculadoraImposto();
        final double salario = 2500.0;
        final double result = calculadora.calcularImposto(salario);
        final double expected = 44.69;
        
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void DeveCalcularImpostoCorretamenteQuandoSalarioEntraNaSegundaFaixa() {
        final CalculadoraImposto calculadora = new CalculadoraImposto();
        final double salario = 3478.10;
        final double result = calculadora.calcularImposto(salario);
        final double expected = 166.91;
        
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void DeveCalcularImpostoCorretamenteQuandoSalarioEntraNaTerceiraFaixa() {
        final CalculadoraImposto calculadora = new CalculadoraImposto();
        final double salario = 4228.01;
        final double result = calculadora.calcularImposto(salario);
        final double expected = 315.17;
        
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void DeveCalcularImpostoCorretamenteQuandoSalarioEntraNaQuartaFaixa() {
        final CalculadoraImposto calculadora = new CalculadoraImposto();
        final double salario = 4857.00;
        final double result = calculadora.calcularImposto(salario);
        final double expected = 466.31;
        
        assertEquals(expected, result, 0.01);
    }
}