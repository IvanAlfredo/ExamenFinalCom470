
package com.com470.final_bolos;

public class Juego_de_bolos {
    private int puntaje = 0;
    private int[] tiros = new int[21];
    private int tiroActual = 0;
    
    public void lanzar(int bolos){
        tiros[tiroActual] = bolos;
        tiroActual++;
        puntaje+=bolos;
    }
    
    public int puntuacion(){
        int total = 0;
        int indiceJugada = 0;
        for(int jugada=0;jugada<10;jugada++){
            if(esStrike(indiceJugada)){
                //Si es strike, recibe bono de la suma de los dos proximos turnos
                total+=10+ultimoStrike(indiceJugada);
                indiceJugada++;
            }
            else{
                //Si es spare, recibe bono de la suma del siguiente turno
                if(esSpare(indiceJugada)){
                    total+=10+tiros[indiceJugada+2];
                }
                else{
                    total+=sumaDeLanzamientos(indiceJugada);
                }
                indiceJugada+=2;
            }
        }
        return total;
    }
    
    private int sumaDeLanzamientos(int indiceTurno){
        return tiros[indiceTurno]+tiros[indiceTurno+1];
    }
    
    //Es spare cuando en las dos oportunidades de un turno se derriban los 10 pinos
    public boolean esSpare(int indiceTurno){
        if(tiros[indiceTurno]+tiros[indiceTurno+1]==10){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int ultimoStrike(int indiceTurno){
        return tiros[indiceTurno+1]+tiros[indiceTurno+2];
    }
    
    //Es strike cuando en la primera oportunidad de un turno se derriban 10 pinos
    public boolean esStrike(int indiceTurno){
        if(tiros[indiceTurno]==10){
            return true;
        }
        else{
            return false;
        }
    }
}
