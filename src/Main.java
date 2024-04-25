
//importamos los recursos necesarios
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

//En esta parte iniciamos los protocolos HTTP para consumir la api de la direccion uri)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/e8b18376176fb37dadac7983/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

//el respose.body() es el arvhivo json q consumimos de la api y lo guardamos en una variable.
                    String stringJson = response.body();

//aca creamos un objeto perteneciente a la clase Gson y lo llamamos archivoGson. Lo usamos para iniciar el metodo "fromJson()"
        //Luego guardamos esos datos en un objeto, en este caso, de la clase "ValorMoneda" obj.
        //El cual tiene los atributos necesarios para recibir los valores segun la key de cada elemento del archivo json.
                    Gson archivoGson = new Gson();
                    ValorMoneda obj = archivoGson.fromJson(stringJson, ValorMoneda.class);
        //UNA VEZ CONVERTIDO EL ARCHIVO JSON A UN OBJETO, PODEMOS USAR LOS METODOS DE LA CLASE PARA MANIPULAR SUS ATRIBUTOS.
         //Creamos un objeto de la clase Mensajes para nuestroa mensajes personalizados
        Mensajes msj= new Mensajes();
        //AHORA EMPEZAMOS LA CREACION DEL PROGRAMA COMO TAL CON UN BUCLE WHILE COMPUESTO DE UN MENU
        Scanner entrada= new Scanner(System.in);
        int opcion=0;
        double userAmount;
        double result;
        while (opcion != 7){
            //llamamos a un metodo para mostrar al usuario el menu principal.
            System.out.println(msj.getMenuPrinpipal());
            //ahora esperamos que nuestro usuario elija una opcion del menu, la cual lo llevara
            // a uno de los casos del condicional switch.
            opcion=entrada.nextInt();
            switch (opcion){
                case 1 :
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result=  (userAmount*obj.getConversion_rates().get("ARS"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Dolares equivalen a $"+result+" Pesos argentinos.");
                    break;
                case 2:
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result= (userAmount/obj.getConversion_rates().get("ARS"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Pesos argentino equivalen a $"+result+" Dolares.");
                    break;
                case 3:
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result= (userAmount*obj.getConversion_rates().get("BRL"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Dolares equivalen a $"+result+" Reales.");
                    break;
                case 4:
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result= (userAmount/obj.getConversion_rates().get("BRL"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Reales equivalen a $"+result+" Dolares.");
                    break;
                case 5:
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result=  (userAmount*obj.getConversion_rates().get("COP"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Dolares equivalen a $"+result+" Pesos colombianos.");
                    break;
                case 6:
                    System.out.println(msj.getInstruccion1());
                    userAmount=entrada.nextDouble();
                    result= (userAmount/obj.getConversion_rates().get("COP"));
                    System.out.println();
                    System.out.println("$"+userAmount+" Pesos colombianos equivalen a $"+result+" Dolares.");
                    break;
                case 7:
                    System.out.println("Gracias por usar nuestro servicio");
                    break;
                default:
                    System.out.println("Opcion no valida, vuelva a intentarlo!");
                    break;
            }
        }
    }
}