package org.example.openClosedPrinciple;

import org.example.afterocp.Shape;


public class ShapeCircle implements Shape {
  double radius;

  public ShapeCircle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() throws Exception {
    return Math.PI * radius * radius;
  }
}
