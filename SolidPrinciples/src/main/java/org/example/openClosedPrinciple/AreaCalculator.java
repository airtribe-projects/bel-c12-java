package org.example.openClosedPrinciple;

public class AreaCalculator {

  public double calculateArea(Object object) {
    if (object instanceof ShapeSquare) {
      return Math.pow(((ShapeSquare) object).length, 2);
    } else if (object instanceof ShapeRectange) {
      return ((ShapeRectange) object).length * ((ShapeRectange) object).width;
    } else if (object instanceof ShapeCircle) {
      return Math.PI * Math.pow(((ShapeCircle) object).radius, 2);
    } else {
      System.out.println("Not supported");
    }

    return 0.0d;
  }
}
