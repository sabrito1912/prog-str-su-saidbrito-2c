public class Perro extends Animal {
    public Perro(String name){
        super(name);
    }

    @Override
    public void hacerSonido() {
        System.out.println(name+ "hace Guau");
    }

    public void marcarTerritorio(){
        System.out.println(name+ "Está haciendo un sonido x");
    }
}
