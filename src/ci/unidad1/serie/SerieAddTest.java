/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 16 febrero 2024
* Series Test
* famontecillo@itess.edu.mx
*/
package ci.unidad1.serie;


public class SerieAddTest {
    public static void main(String ... args) {
        SerieAdd sa = new SerieAdd(1,7);
        
        sa.compute();
        sa.print();
    }
}
