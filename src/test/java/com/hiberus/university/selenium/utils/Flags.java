package com.hiberus.university.selenium.utils;

public class Flags {

    private static final String BROWSER = "browser";
    private static final String HEADLESS = "headless";

    private final String browser = System.getProperty(BROWSER); //Obtiene de os parámetros de la configuración de ejecución el VM Options
    //Para elegir como navegador el Firefox, en segundo plano, pondríamos en VM Options lo siguiente:
    // -Dbrowser=firefox -Dheadless=true
    private final boolean isHeadless = this.parseBoolean(System.getProperty(BROWSER));
    //El modo headless es que lo hará en memoria, es decir, sin abrir el navegador (en segundo plano)

    private static Flags instance;

    private boolean parseBoolean(String string){

        String result = (string == null) ? "false" : string; //Si el string es nulo devuelve false. Si no devuelve el string
        result = result.toLowerCase().trim();
        return (result.equals("true") || result.equals("false")) && Boolean.parseBoolean(result);
    }

    private Flags(){

    }

    public static Flags getInstance(){

        if(instance == null) instance = new Flags();
        return instance;
    }

    public boolean isHeadless(){
        return this.isHeadless;
    }

    public String getBrowser(){
        return this.browser;
    }
}
