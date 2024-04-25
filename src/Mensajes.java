public class Mensajes {

    private String menuPrinpipal = """
                    *********************************************************
                    
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    1)Dólar =>> Peso Argentino
                    2)Peso argentino =>> Dólar
                    3)Dólar =>> Real brasileño
                    4)Real brasileño =>> Dólar
                    5)Dólar =>> Peso colombiano
                    6)Peso colombiano =>> Dólar
                    7)Salir
                    
                    Elija una opcion válida:
                    """;
    //itn1 es una abreviacion de "instruccion 1"
    private String instruccion1 = "ingrese el valor que desea convertir";

    public String getMenuPrinpipal() {
        return menuPrinpipal;
    }

    public String getInstruccion1() {
        return instruccion1;
    }
}
