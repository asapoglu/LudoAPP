/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludoapp;

/**
 *
 * @author Abdurrahman
 */
public class Point {

    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point point) {
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        return false;
    }

}
