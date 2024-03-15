/*
* ITESS-TICS 
* Enero-Junio 2024
* Cálculo Integral
* TI202 FJMP
* 15 marzo 2024
* Convertir un punto a coordenadas pantalla
* famontecillo@itess.edu.mx
*/
package tools;

public class Coordinate {
    private double xmin;
    private double xmax;
    private double ymin;
    private double ymax;
    private double width;
    private double height;

    public Coordinate(double xmin, double xmax, double ymin, double ymax, double width, double height) {
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        this.width = width;
        this.height = height;
    }

    public double getXmin() {
        return xmin;
    }

    public void setXmin(double xmin) {
        this.xmin = xmin;
    }

    public double getXmax() {
        return xmax;
    }

    public void setXmax(double xmax) {
        this.xmax = xmax;
    }

    public double getYmin() {
        return ymin;
    }

    public void setYmin(double ymin) {
        this.ymin = ymin;
    }

    public double getYmax() {
        return ymax;
    }

    public void setYmax(double ymax) {
        this.ymax = ymax;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //xs = (xr  –  xmin) * width / (xmax – xmin)
    public double toScreenX(double xr) {
        return (xr - xmin) * width / (xmax - xmin);
    }
    
    //ys = height - (yr-ymin) * height / (ymax - ymin)
    public double toScreenY(double yr) {
        return height - (yr-ymin) * height / (ymax - ymin);
    }
}
