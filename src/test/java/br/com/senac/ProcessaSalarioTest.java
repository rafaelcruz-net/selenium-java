package br.com.senac;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * ProcessaSalarioTest
 */

 @RunWith(MockitoJUnitRunner.class)
public class ProcessaSalarioTest {

    @Test()
    public void DeveProcessarSalarioCorremente() {

        SalarioDAO mockSalarioDAO = Mockito.mock(SalarioDAO.class);

        ArrayList<Salario> arrange = new ArrayList<Salario>();

        arrange.add(new Salario(1500));
        arrange.add(new Salario(4500));
        arrange.add(new Salario(6500));
        arrange.add(new Salario(8500));

        Mockito.when(mockSalarioDAO.getSalario()).thenReturn(arrange);

        ProcessaSalarioService service = new ProcessaSalarioService(mockSalarioDAO);

        ArrayList<Salario> result = service.processaFolha();

        assertTrue(result.size() > 0);

        for (Salario salario : result) {
            assertTrue(salario.getSalarioLiquido() > 0);
        }

        Mockito.verify(mockSalarioDAO, times(1)).getSalario();
    }
    
}