/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 23 febrero 2024
* Series Riemman
* famontecillo@itess.edu.mx
*/
package ci.unidad1.riemann;


public class SumasEjemplo1 extends SumasRiemann {

    public SumasEjemplo1(double[] x, double[] w) {
        super(x, w);
    }
    
    @Override
    public double funcion(double x) {
        return 10 - x*x;
    }
}
