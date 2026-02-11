public class Main{
    public static void main(String[] args){
        //sintaxis


        //Declaración
        int[]arr;

        int[] arr1 = new int[4]; //Inicialización
        int[] arr2 = {1,2,3,4};

        //Accesi (Get)
        System.out.println(arr1[0]);
        System.out.println(arr2[1]);

        //
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]);

        }
        for(int numero : arr1){
            System.out.println(numero);

        }
        System.out.println("_______________");
        Persona[]personas=new Persona[3];
        Persona persona1 =new Persona();
        persona1.setId(1);
        persona1.setName("Test");
        persona1.setActive(true);
        Persona persona2 =new Persona(2, "Said");
        Persona persona3 =new Persona(3, "Gera");
        personas[0]=persona1;
        personas[1]=persona2;
        personas[2]=persona3;

        personas[0]=null; //eliminar el primer elemento




        for (Persona persona: personas) {
            //System.out.println(persona)
            try {
                System.out.println("______________");
                System.out.println(persona.getId());
                System.out.println(persona.getName());
                System.out.println(persona.isActive());

            }catch (Exception e){
                System.out.println("Hay un null");
            }

        }




    }
}
