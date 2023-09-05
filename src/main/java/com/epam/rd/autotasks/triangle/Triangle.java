package com.epam.rd.autotasks.triangle;

import java.io.FileNotFoundException;

class Triangle {
    private Point a;
    private Point b;
    private Point c;
    public Triangle(Point a, Point b, Point c) {
        //TODO
        this.a = a;
        this.b = b;
        this.c = c;
        if(!isNotDegenerative()) throw new RuntimeException();
    }

    public double area() {
        //TODO
        double halfPerimeter = (side(a, b) + side(b, c) + side(a, c))/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - side(a, b)) * (halfPerimeter - side(a, c)) * (halfPerimeter - side(b, c)));
    }

    public Point centroid(){
        //TODO
        return new Point( 1.0 /3 * (a.getX() + b.getX() + c.getX()),  1.0 /3 *(a.getY() + b.getY() + c.getY()));
    }

    /*
    Checks if triangle with given sides can exist or not.
     */
    private boolean isNotDegenerative() {
        return (side(a, b) + side(b, c) > side(a, c))&&(side(a, b) + side(a, c) >=side(b, c))&&(side(a, c) + side(b, c) > side(a, b));
    }

    /*
    Calculates side length with given start and end point
     */
    private double side(Point first, Point second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }


}
