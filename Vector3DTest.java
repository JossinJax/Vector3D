package cen4010.pa1;

import java.lang.Math;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Vector3DTest {
	protected double x, y, z;
	
	
	@Test
	protected void setup() {
		x = 3.0;
		y = 5.0;
		z = 2.0;
	}
	
	public void testToString() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		String exp = "3.0 5.0 2.0";
		assertEquals(exp, vector.toString());
	}

	public void testEquals() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		if(vector.equals(vector)) {
			Vector3D vector2 = new Vector3D(x+1.0, y, z);
			if(vector.equals(vector2)) {
				fail("Does not equal, but indicates equal");
			}else {
				assertEquals(1, 1);
			}
		}else {
			fail("Is equal but does not indicate equal");
		}
	}

	public void testScale() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		double s = 2.0;
		Vector3D result = vector.scale(s);
		assertEquals(result.x(), (vector.x() * 2.0));
		assertEquals(result.y(), (vector.y() * 2.0));
		assertEquals(result.z(), (vector.z() * 2.0));
	}

	public void testAdd() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		Vector3D s = new Vector3D(2.0, 0.0, 3.0);
		Vector3D result = vector.add(s);
		assertEquals(result.x(), (vector.x() + 2.0));
		assertEquals(result.y(), (vector.y() + 0.0));
		assertEquals(result.z(), (vector.z() + 3.0));
	}

	public void testSubtract() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		Vector3D s = new Vector3D(2.0, 0.0, 3.0);
		Vector3D result = vector.subtract(s);
		assertEquals(result.x(), (vector.x() - 2.0));
		assertEquals(result.y(), (vector.y() - 0.0));
		assertEquals(result.z(), (vector.z() - 3.0));
	}

	public void testNegate() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		Vector3D result = vector.negate();
		assertEquals(result.x(), (vector.x() * (-1.0)));
		assertEquals(result.y(), (vector.y() * (-1.0)));
		assertEquals(result.z(), (vector.z() * (-1.0)));
	}

	public void testDot() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		Vector3D vector2 = new Vector3D(2.0, 6.0, 0.0);
		double result = vector.dot(vector2);
		assertEquals(result, ((vector.x() * vector2.x()) + (vector.y() * vector2.y()) + (vector.z() * vector2.z())));
	}

	public void testMagnitude() {
		setup();
		Vector3D vector = new Vector3D(x, y, z);
		double result = vector.magnitude();
		assertEquals(result, (Math.sqrt((vector.x() * vector.x()) + (vector.y() * vector.y()) + (vector.z() * vector.z()))));
	}
	

}
