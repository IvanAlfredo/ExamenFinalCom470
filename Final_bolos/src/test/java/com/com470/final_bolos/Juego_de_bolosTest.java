
package com.com470.final_bolos;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Juego_de_bolosTest {
    Juego_de_bolos bolos;
    public Juego_de_bolosTest() {
    }
    private void tiros(int pinos, int numeroTurno){
        for(int i=0;i<numeroTurno;i++){
            bolos.lanzar(pinos);
        }
    }
    @Before
    public void Iniciar() {
        bolos = new Juego_de_bolos();
    }
    
    //Si todos los lanzamientos van al canal el puntaje deberia ser cero
    @Test
    public void lanzamientosMalos() throws Exception {
        tiros(0,20);
        int resultado = bolos.puntuacion();
        int esperado = 0;
        assertEquals(esperado, resultado);
    }
    
    //Si los dos primeros lanzamientos son 2 y 8 entonces la jugada es un spare
    @Test
    public void jugadaSpare() throws Exception {
        bolos.lanzar(2);
        bolos.lanzar(8);
        tiros(0,12);
        assertTrue(bolos.esSpare(0));
    }
    
    //Si los dos primeros lanzamientos son 3 y 5 entonces la jugada no es un spare
    @Test
    public void jugadaNoSpare() throws Exception {
        bolos.lanzar(3);
        bolos.lanzar(5);
        tiros(0,12);
        assertFalse(bolos.esSpare(0));
    }
    
    //Si en todos los lanzamientos solo se derriba un bolo, entonces el puntaje debera ser 20
    @Test
    public void unBoloDerribado() throws Exception {
        tiros(1,20);
        int esperado = bolos.puntuacion();
        System.out.println("El resultado esperado es: "+esperado);
        int resultado = 20;
        assertEquals(esperado, resultado);
    }
    
    //Si en el primer tiro de un turno se derriban los 10 pinos entonces la jugada es un Strike
    @Test
    public void jugadaStrike(){
        bolos.lanzar(10);
        tiros(0,7);
        assertTrue(bolos.esStrike(0));     
    }
    
    //Si en el primer tiro de un turno no se derriban los 10 pinos entobces la jugada no es un Strike
    @Test
    public void jugadaNoStrike(){
        bolos.lanzar(6);
        tiros(0,7);
        assertFalse(bolos.esStrike(0));
    }
    
    //Cuando en un turno no derriban los 10 pinos entonces no es un Strike, tampoco un Spare. ejempplo, si solo se derriban 8 pinos, el puntaje sera 8
    @Test
    public void jugadaNoSpareYNoStrike(){
        bolos.lanzar(8);
        tiros(0,7);
        int esperado = bolos.puntuacion();
        System.out.println("El resultado esperado es: "+esperado);
        int resultado = 8;
        assertEquals(esperado, resultado);
        
    }
}
