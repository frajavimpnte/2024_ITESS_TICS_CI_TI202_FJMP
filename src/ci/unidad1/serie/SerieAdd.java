/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 16 febrero 2024
* Series
* famontecillo@itess.edu.mx
*/
package ci.unidad1.serie;

public class SerieAdd {
    private int iIni;
    private int iEnd;
    private int n;
    private int i[];
    private int f[];
    private int total;

    public SerieAdd(int iIni, int iEnd) {
        this.iIni = iIni;
        this.iEnd = iEnd;
        
        n = iEnd - iIni + 1;
        i = new int[n];
        f = new int[n];
    }

    public void compute() {
        int index = 0;
        total = 0;
        for (int i = iIni; i <= iEnd; i++) {
            this.i[index] = i;
            
            // modificar para una nueva serie
            f[index] = i*i + 1;
            
            total += f[index];
            index++;
        }
    }
    
    public void print() {
        System.out.println("index  |    i   |   f  ");
        
        for (int index = 0; index < n; index++) 
            System.out.println(index +"    |    " + i[index] + "   |   " + f[index]);
        
        System.out.println("Total: " + total);
        
    }
    
    
    
    
    
    
}
