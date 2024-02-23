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

public class SumasRiemann {
    protected double []x;
    protected double w[];
    protected double dx[];
    protected double fw[];
    protected double suma;

    public SumasRiemann(double[] x, double[] w) {
        this.x = x;
        this.w = w;
        
        dx = new double[w.length];
        fw = new double[w.length];
    }
    
    public void calcular() {
        // calcular dx
        for (int i = 0; i < dx.length; i++)
            dx[i] = x[i+1] - x[i];
        
        // calcular fw y suma
        suma = 0;
        for (int i = 0; i < dx.length; i++) {
            fw[i] = funcion(w[i]);
            suma += fw[i]*dx[i];
        }
    }
    
    public double funcion(double x) {
        return 1.0;
    }
    
    public void print() {
        System.out.println("i  |    wi   |   dxi  |   fwi  ");
        
        for (int i= 0; i < w.length; i++) 
            System.out.println(i +"  |    " + w[i] + "   |   " 
                    + dx[i] + "  |   " + fw[i]);
        
        System.out.println("Suma: " + suma);
        
    }
}
