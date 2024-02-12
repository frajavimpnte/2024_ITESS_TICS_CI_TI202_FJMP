/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 12 febrero 2024
* Aproximación de areas usando sumas, prueba
* famontecillo@itess.edu.mx
*/
package ci.unidad1.aproximation;

public class FunctionAproximationTest {
    public static void main(String[] args) {
        FunctionAproximation fa = new FunctionAproximation(0.0, 4.0, 4);
        
        fa.compute();
        System.out.println("area: " + fa.getArea());
    }
}
