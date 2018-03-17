package vector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Vector2fTest {

	@Test
	void testVector2fFloat() {
		Vector2f vec = new Vector2f(2.0f);
		assertEquals(2.0f, vec.get(0));
		assertEquals(2.0f, vec.get(1));
	}

	@Test
	void testVector2fFloatFloat() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		assertEquals(2.0f, vec.get(0));
		assertEquals(3.0f, vec.get(1));
	}

	@Test
	void testAddFloat() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = vec.add(5.0f);
		assertEquals(7.0f, vec2.get(0));
		assertEquals(8.0f, vec2.get(1));
		
	}

	@Test
	void testSubFloat() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = vec.sub(1.0f);
		assertEquals(1.0f, vec2.get(0));
		assertEquals(2.0f, vec2.get(1));
	}

	@Test
	void testDivFloat() {
		Vector2f vec = new Vector2f(8.0f, 10.0f);
		Vector2f vec2 = vec.div(2.0f);
		assertEquals(4.0f, vec2.get(0));
		assertEquals(5.0f, vec2.get(1));
	}

	@Test
	void testDivI() {
		Vector2f vec = new Vector2f(6.0f, 10.0f);
		vec.divI(2.0f);
		assertEquals(3.0f, vec.get(0));
		assertEquals(5.0f, vec.get(1));
	}

	@Test
	void testMult() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = vec.mult(2.0f);
		assertEquals(4.0f, vec2.get(0));
		assertEquals(6.0f, vec2.get(1));
	}

	@Test
	void testMultI() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		vec.multI(5.0f);
		assertEquals(10.0f, vec.get(0));
		assertEquals(15.0f, vec.get(1));
	}

	@Test
	void testAddVector2f() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = new Vector2f(5.0f);
		vec = vec.add(vec2);
		assertEquals(7.0f, vec.get(0));
		assertEquals(8.0f, vec.get(1));
	}

	@Test
	void testAddI() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = new Vector2f(4.0f);
		vec.addI(vec2);
		assertEquals(6.0f, vec.get(0));
		assertEquals(7.0f, vec.get(1));
	}

	@Test
	void testSubVector2f() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = new Vector2f(5.0f);
		vec = vec.sub(vec2);
		assertEquals(-3.0f, vec.get(0));
		assertEquals(-2.0f, vec.get(1));
	}

	@Test
	void testDivVector2f() {
		Vector2f vec = new Vector2f(10.0f, 15.0f);
		Vector2f vec2 = new Vector2f(5.0f);
		vec = vec.div(vec2);
		assertEquals(2.0f, vec.get(0));
		assertEquals(3.0f, vec.get(1));
	}

	@Test
	void testDot() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = new Vector2f(5.0f);
		float res = vec.dot(vec2);
		assertEquals(25.0f, res);
	}

	@Test
	void testNormSquared() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		float res = vec.normSquared();
		assertEquals(13.0f, res);
	}

	@Test
	void testNegate() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		Vector2f vec2 = vec.negate();
		assertEquals(-2.0f, vec2.get(0));
		assertEquals(-3.0f, vec2.get(1));
	}

	@Test
	void testSum() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		float res = vec.sum();
		assertEquals(5.0f, res);
	}

	@Test
	void testGet() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		assertEquals(2.0f, vec.get(0));
		assertEquals(3.0f, vec.get(1));
	}

	@Test
	void testGetSize() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		assertEquals(2, vec.getSize());
	}

	@Test
	void testClear() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		vec.clear();
		assertEquals(0.0f, vec.get(0));
		assertEquals(0.0f, vec.get(1));
	}

	@Test
	void testToString() {
		Vector2f vec = new Vector2f(2.0f, 3.0f);
		String str = vec.toString();
		String strToCompare = String.format("Float2[%.8f, %.8f]", 2.0f, 3.0f);
		assertEquals(strToCompare, str);
	}

}
