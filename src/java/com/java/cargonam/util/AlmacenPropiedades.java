/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.java.cargonam.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * 
 * @author furibe
 */
public class AlmacenPropiedades {

    private static final String CONFIGURATION_FILE = "cargonam.properties";
    private static HashMap propiedades;

    static {
        try {
            
            Class almacenPropiedadesClass = AlmacenPropiedades.class;
            ClassLoader classLoader = almacenPropiedadesClass.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(CONFIGURATION_FILE);
            Properties propiedadesTemporales = new Properties();
            propiedadesTemporales.load(inputStream);
            inputStream.close();
            

            propiedades = new HashMap(propiedadesTemporales);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AlmacenPropiedades() {
    }

    /**
     * Obtiene el valor de una propiedad del properties
     *
     * @param nombre de la propiedad
     * @return
     */
    public static String getPropiedad(String nombre) {
        String valor = null;
        System.out.println("nombre = " + nombre);
        if (propiedades != null) {
            valor = (String) propiedades.get(nombre);
        }
        System.out.println("valor = " + valor);
        return valor;

    }

}
