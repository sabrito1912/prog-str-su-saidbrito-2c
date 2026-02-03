import java.util.Random;
import java.util.Scanner;

public class MainAdivinaN {
    static int erroresRango = 0;
    static int erroresNoNumerico = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;
        int secreto= random.nextInt(100)+1;

        System.out.println("Adivina el número (1-100) "+" tienes: "+limiteIntentos+" para lograrlo" );

        while(intentos<limiteIntentos){
            int numero=obtenerNumeroValido("Intento: "+(intentos+1),sc,min,max); //vamos a crear metodo para pedir un número valido
            intentos++;
            if(numero==secreto){
                System.out.println("Felicidades ganaste en el intento: "+intentos);
                gano=true;
                break;
            } else if (numero> secreto) {
                System.out.println("El numero secreto es menor a "+numero);
            }else {
                System.out.println("El numero secreto es mayor a "+numero);
            }
        }
        if(gano){
            System.out.println("Ganaste");
        } else {
            System.out.println("Perdiste ff ;( ");
        }

        System.out.println("El número secreto era: " + secreto);
        System.out.println("Veces fuera de rango: " + erroresRango);
        System.out.println("Veces con dato no numérico: " + erroresNoNumerico);

    }

    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max){
        int entrada;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                entrada = sc.nextInt();
                if(entrada >= min && entrada <= max){
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera de rango (1-100)");
                erroresRango++;

            } else {
                System.out.println("El dato ingresado no es numerico");
                erroresNoNumerico++;
                sc.next();
            }
        }
    }
}