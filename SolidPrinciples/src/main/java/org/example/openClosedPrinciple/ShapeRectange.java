package org.example.openClosedPrinciple;

import org.example.afterocp.Shape;


public class ShapeRectange implements Shape {

  double length;

  double width;

  public ShapeRectange(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  public double getArea() throws Exception {
    return length * width;
  }
}
