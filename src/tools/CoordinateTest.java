/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 15 marzo 2024
* Convertir un punto a coordenadas pantalla TEST
* famontecillo@itess.edu.mx
*/
package tools;

public class CoordinateTest {
    public static void main(String ... args) {
        Coordinate coor = new Coordinate(-2,2,-2,2,1080, 960);
        
        // Test center 
        //Xr = 0       -->     Xs = 540                
        //Yr = 0       -->     Ys = 480
        System.out.println("Test center");
        System.out.println("xr: 0  -->  xs: " + coor.toScreenX(0));
        System.out.println("yr: 0  -->  ys: " + coor.toScreenY(0));
        
        // Test 
        
    }
}
