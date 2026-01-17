import java.util.Scanner;
public class Main{
  public static void main(String[]args){

    Scanner sc = new Scanner(System.in);
    int num=obtenerInt(sc, "Ingresa un número positivo: ");
    int resultado= calcularOperacion(num);
    System.out.println("El resultado es: " + resultado);
  }

  public static int obtenerInt(Scanner sc, String mensaje ){
    System.out.println(mensaje);
    int num=sc.nextInt();
    return num;
  }

  public static int calcularOperacion( int limite){
    int suma=0;
    for(int i=1;i<=limite;i++){
      suma+=i;
    }
  return suma;
  }
}