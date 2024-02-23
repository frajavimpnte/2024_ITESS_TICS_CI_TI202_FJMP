package ci.unidad1.riemann;

public class SumaTareaEjercicio1 extends SumasRiemann {

    public SumaTareaEjercicio1(double[] x, double[] w) {
        super(x, w);
    }
    
    @Override
    public double funcion(double x) {
        return x*x;
    }
}
