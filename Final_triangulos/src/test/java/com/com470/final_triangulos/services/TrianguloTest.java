
package com.com470.final_triangulos.services;

import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TrianguloTest {
    
    @Parameterized.Parameters
    public static List<Object> datos() {
        //devolvera una lista
        return Arrays.asList(new Object[][]{
            {4,4,4}, {3,5,8}, {2,2,2}, {1,4,6}, {6,9,9}, {13,12,2}, {6,6,9}, {5,1,6}, {2,2,5}, {8,8,8}
        });
    }
    
    @Parameterized.Parameter(0)
    public int valor1;
    @Parameterized.Parameter(1)
    public int valor2;
    @Parameterized.Parameter(2)
    public int valor3;
    
    Triangulo triangulo;
    
    public TrianguloTest() {
    }
    
    @Before
    public void Iniciar() {
        triangulo = new Triangulo();
    }

    @Test
    public void testTipoTriangulo() {
        String esperado = triangulo.tipoTriangulo(valor1, valor2, valor3);
        System.out.println(esperado);
        String resultado1 = "Equilatero";
        String resultado2 = "Isoceles";
        String resultado3 = "Escaleno";
        
        if(valor1==valor2 && valor2==valor3){
            assertEquals(esperado, resultado1);
        }
        else if(valor1 == valor2 || valor1 == valor3 || valor2 == valor3){
            assertEquals(esperado, resultado2);
        }
        else if(valor1 != valor2 || valor3 != valor3 || valor3 != valor2){
            assertEquals(esperado, resultado3);
        }
    }
    
}
