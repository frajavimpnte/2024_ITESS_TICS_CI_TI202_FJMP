
package ci.unidad1.riemann;


public class SumaRiemannTest {
    public static void main(String ...args) {
       aproximacion(0,Math.PI,1000000); 
    }
    
    public static void aproximacion(double a, double b, int n) {
        double  dx = (b-a)/n;
        double x[] = new double[n+1];
        double w[] = new double[n];
        
        for (int i = 0; i < n+1; i++)
            x[i] = a + i*dx;
        
        for (int i = 0; i < n; i++)
            w[i] = x[i];
        
        SumasTP03parte4 p4 = new SumasTP03parte4(x,w);
        p4.calcular();
        p4.print();
    }
    
    public static void ejemplo1() {
        double x[] = {0.25, 1, 1.5, 1.75, 2.25, 3};
        double w[] = {0.5, 1.25, 1.75, 2, 2.75};
        
        SumasEjemplo1 sej1 = new SumasEjemplo1(x, w);
        sej1.calcular();
        sej1.print();
    }
}
