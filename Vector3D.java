<<<<<<< HEAD

	Class Main{
		public static void main(String[] args) {
			while(true) {
				System.out.println("Vector in X, Y, Z format:");
				Scanner Vector = new Scanner(System.in);
				Vector.useDelimiter(", ");
				int x=Vector.nextInt();
				int y=Vector.nextInt();
				int z=Vector.nextInt();
				int X;
				int Y;
				int Z;
				String Resultant;
				System.out.printf("Available Functions:\nScale\nAdd\nSubtract\nNegate\nDot Product\nMagnitude\n");
				System.out.println("Which function do you need to perform?");
				Scanner Function = new Scanner(System.in);
				boolean options = true;
				while (options)
					switch(Function.toLowerCase()) {
						case "scale":
							System.out.println("What is the scalar multiplier?");
							Scanner Vector = new Scanner(System.in);
							Vector.useDelimiter(", ");
							int m = Vector.nextInt();
							X = x * m;
							Y = y * m;
							Z = z * m;
							Resultant = toString(X, Y, Z);
							options = false;
							break;
						case "add":
							System.out.println("What vector (in X, Y, Z format) do you need to add?");
							Scanner Vector = new Scanner(System.in);
							Vector.useDelimiter(", ");
							X = x + Vector.nextInt();
							Y = y + Vector.nextInt();
							Z = z + Vector.nextInt();
							Resultant = toString(X, Y, Z);
							options = false;
							break;
						case "subtract":
							System.out.println("What vector (in X, Y, Z format) do you need to subtract?");
							Scanner Vector = new Scanner(System.in);
							Vector.useDelimiter(", ");
							X = x - Vector.nextInt();
							Y = y - Vector.nextInt();
							Z = z - Vector.nextInt();
							Resultant = toString(X, Y, Z);
							options = false;
							break;
						case "negate":
							X = 0-x;
							Y = 0-y;
							Z = 0-z;
							Resultant = toString(X, Y, Z);
							options = false;
							break;
						case "dot product":
							System.out.println("What vector (in X, Y, Z format) do you need to add?");
							Scanner Vector = new Scanner(System.in);
							Vector.useDelimiter(", ");
							a = Vector.nextInt();
							b = Vector.nextInt();
							c = Vector.nextInt();
							int answer = Dot(x, y, z, a, b, c);
							Resultant = toString(answer);
							options = false;
							break;
						case "magnitude":
							answer = sqrt(x*x + y*y + z*z);
							Resultant = toString(answer);
							options = false;
							break;
						default:
							System.out.println("That is not an available function.  Please try again in approximately 3 hours.");
							break;

				System.out.printf("s%\n", Resultant);
				System.out.println("Would you like to perform another function?");
				Scanner newvector = new Scanner(System.in);
				if (newvector.toLowerCase == "no") {
					break;
				}else {
					
				}
			}
		}
	
		public String toString(int x, int y, int z) {
			return String.valueOf(x) + ", " + String.valueOf(y) + ", " + String.valueOf(z);
		}
		
		public String toString(int number) {
			return String.valueOf(number);
		}
	}//end class main

=======
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
        x += v.x;
        y += v.y;
        z += v.z;
        Vector3D n = new Vector3D(x, y, z);
        return n;
    }
    
    public Vector3D subtract(Vector3D v){
        x -= v.x;
        y -= v.y;
        z -= v.z;
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
        return (x * v.x + y * v.y + z * v.z);
    }
    
    public double magnitude(){
        return (Math.sqrt(x * x + y * y + z * z));
    }
    
    public String toString(){
        String str = Double.toString(x) + " " + Double.toString(y) + " " + Double.toString(z);
        return str;
    }
    
    public boolean equals(Vector3D v){
        if(x == v.x && y == v.y && z == v.z){
            return true;
        }else{
            return false;
        }
    }
}
>>>>>>> 3c1d727bb31b3904afed4626e4e9f1ee9859f23d
