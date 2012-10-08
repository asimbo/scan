package org.opencv.core;

/**
 * Template class for 3D points specified by its coordinates x, y and z.
 * An instance of the class is interchangeable with the C structure
 * "CvPoint2D32f". Similarly to "Point_", the coordinates of 3D points can be
 * converted to another type. The vector arithmetic and comparison operations
 * are also supported.
 *
 * The following "Point3_<>" aliases are available:
 *
 * @see <a href="http://opencv.itseez.com/modules/core/doc/basic_structures.html#point3">org.opencv.core.Point3_</a>
 */
public class Point3 {

    public double x, y, z;

    public Point3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3() {
        this(0, 0, 0);
    }

    public Point3(Point p) {
        x = p.x;
        y = p.y;
        z = 0;
    }

    public Point3(double[] vals) {
        this();
        set(vals);
    }
    public void set(double[] vals) {
        if(vals!=null) {
            x = vals.length>0 ? vals[0] : 0;
            y = vals.length>1 ? vals[1] : 0;
            z = vals.length>2 ? vals[2] : 0;
        } else {
            x = 0;
            y = 0;
            z = 0;
    }
    }

    public Point3 clone() {
        return new Point3(x, y, z);
    }

    public double dot(Point3 p) {
        return x * p.x + y * p.y + z * p.z;
    }

    public Point3 cross(Point3 p) {
        return new Point3(y * p.z - z * p.y, z * p.x - x * p.z, x * p.y - y * p.x);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point3)) return false;
        Point3 it = (Point3) obj;
        return x == it.x && y == it.y && z == it.z;
    }
}
