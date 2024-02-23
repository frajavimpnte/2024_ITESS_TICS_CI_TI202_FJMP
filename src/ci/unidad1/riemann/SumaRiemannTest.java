
package ci.unidad1.riemann;


public class SumaRiemannTest {
    public static void main(String ...args) {
        double x[] = {0.25, 1, 1.5, 1.75, 2.25, 3};
        double w[] = {0.5, 1.25, 1.75, 2, 2.75};
        
        SumasEjemplo1 sej1 = new SumasEjemplo1(x, w);
        sej1.calcular();
        sej1.print();
    }
}
