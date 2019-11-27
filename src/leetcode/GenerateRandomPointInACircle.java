package leetcode;

public class GenerateRandomPointInACircle {

  private double radius;
  private double x_center;
  private double y_center;

  public GenerateRandomPointInACircle(double radius, double x_center, double y_center) {
    this.radius = radius;
    this.x_center = x_center;
    this.y_center = y_center;
  }

  public double[] randPoint() {
    double r = radius * Math.sqrt(Math.random());
    double angle = Math.PI * 2 * Math.random();
    double[] loc = new double[2];
    loc[0] = r * Math.cos(angle) + x_center;
    loc[1] = r * Math.sin(angle) + y_center;
    return loc;
  }
}
