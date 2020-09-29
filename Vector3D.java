package cen4010.pa1;

import java.lang.Math;

public class Vector3D{
    double x;
    double y;
    double z;
    
    public Vector3D(double xx, double yy, double zz){
        this.x = xx;
        this.y = yy;
        this.z = zz;
    } 
    
    public double x(){
        return x;
    }
    
    public double y(){
        return y;
    }
    
    public double z(){
        return z;
    }
    
    public Vector3D scale(double f){
        x *= f;
        y *= f;
        z *= f;
        Vector3D n = new Vector3D(x, y, z);
        return n;
    }
    
    public Vector3D add(Vector3D v){
        x += v.x();
        y += v.y();
        z += v.z();
        Vector3D n = new Vector3D(x, y, z);
        return n;
    }
    
    public Vector3D subtract(Vector3D v){
        x -= v.x();
        y -= v.y();
        z -= v.z();
        Vector3D n = new Vector3D(x, y, z);
        return n;
    }
    
    public Vector3D negate(){
        x *= -1;
        y *= -1;
        z *= -1;
        Vector3D n = new Vector3D(x, y, z);
        return n;
    }
    
    public double dot(Vector3D v){
        return (x * v.x() + y * v.y() + z * v.z());
    }
    
    public double magnitude(){
        return (Math.sqrt(x * x + y * y + z * z));
    }
    
    public String toString(){
        String str = Double.toString(x) + " " + Double.toString(y) + " " + Double.toString(z);
        return str;
    }
    
    public boolean equals(Vector3D v){
        if(x == v.x() && y == v.y() && z == v.z()){
            return true;
        }else{
            return false;
        }
    }
}
