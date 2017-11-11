/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtocoleLUGAPM;

import java.io.Serializable;
import java.util.HashMap;
import requetepoolthreads.Reponse;

/**
 *
 * @author Philippe
 */
public class ReponseLUGAPM implements Reponse, Serializable 
{
    //public final static int STATUS_OK = 200;    
    public final static int FLIGHTS_LOADED = 203;    
    public final static String FLIGHTS_LOADED_MESSAGE = "Informations sur les vols envoyés";
    public final static int LUGAGES_LOADED = 204;    
    public final static String LUGAGES_LOADED_MESSAGE = "Informations sur les bagages envoyés";
    
    private int Code;
    private HashMap<String, Object> ChargeUtile;

    
    public ReponseLUGAPM(int Code, HashMap ChargeUtile) 
    {
        setCode(Code);
        setChargeUtile(ChargeUtile);
    }
    
    public ReponseLUGAPM(int Code) 
    {
        setCode(Code);
        setChargeUtile(new HashMap<>());
    }
    
    @Override
    public int getCode() {
        return this.Code;
    }    
    @Override
    public HashMap getChargeUtile() {
        return this.ChargeUtile;
    }    
    public void setChargeUtile(HashMap ChargeUtile) {
        this.ChargeUtile = ChargeUtile;
    }
    @Override
    public void setCode(int Code) {
        this.Code = Code;
    }
}
