/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.unipar.hibernateTeste;

import br.com.unipar.hibernateteste.model.usuario.Agendamento;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author lucasmichalski
 */
public class ConsultarPetTeste {
    
    @Test
    public void testSoma(){
        int a = 2;
        int b = 3;
        
        int resultado = Agendamento.soma(a, b);
        
        Assert.assertEquals(5, resultado);
    }

}
