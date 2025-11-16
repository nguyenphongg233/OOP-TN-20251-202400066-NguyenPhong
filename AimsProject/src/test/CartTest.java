package test;

import models.Cart;
import models.DigitalVideoDisc;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CartTest {

	public static void main(String[] args) {
		int passed = 0;
		int failed = 0;

		if (run(() -> testAddMax20AndRejectExtra())) passed++; else failed++;
		if (run(() -> testRemoveWhenEmpty())) passed++; else failed++;
		if (run(() -> testRemoveNonExisting())) passed++; else failed++;
		if (run(() -> testPrintAfterAddAndRemove())) passed++; else failed++;

		System.out.println();
		System.out.println("Test summary: " + passed + " passed, " + failed + " failed.");
	}

	private static boolean run(Runnable test) {
		try {
			test.run();
			System.out.println("PASS");
			return true;
		} catch (AssertionError ae) {
			System.out.println("FAIL: " + ae.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("ERROR: uncaught exception: " + e);
			e.printStackTrace(System.out);
			return false;
		}
	}

	private static String captureOutput(Runnable action) {
		PrintStream original = System.out;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bout));
		try {
			action.run();
		} finally {
			System.out.flush();
			System.setOut(original);
		}
		return bout.toString();
	}

	private static void assertTrue(boolean cond, String message) {
		if (!cond) throw new AssertionError(message);
	}

	private static void assertEquals(double expected, double actual, double eps, String message) {
		if (Double.isNaN(expected) && Double.isNaN(actual)) return;
		if (Math.abs(expected - actual) > eps) throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
	}

	// Tests
	private static void testAddMax20AndRejectExtra() {
		Cart cart = new Cart();

		// Add 18 single DVDs
		for (int i = 0; i < 18; i++) {
			DigitalVideoDisc d = new DigitalVideoDisc("Category", "Title" + i, 1.0);
			cart.addDVD(d);
		}

		// Add two DVDs using the two-arg overload to reach 20
		DigitalVideoDisc d19 = new DigitalVideoDisc("Category", "Title18", 1.0);
		DigitalVideoDisc d20 = new DigitalVideoDisc("Category", "Title19", 1.0);
		cart.addDVD(d19, d20);

		// Total cost should be 20.0 (20 items * 1.0)
		assertEquals(20.0, cart.calculateTotalCost(), 0.0001, "Total cost mismatch after adding 20 items");

		// Attempt to add one more (array overload) and capture output
		String output = captureOutput(() -> {
			DigitalVideoDisc extra = new DigitalVideoDisc("Category", "Extra", 1.0);
			cart.addDVD(new DigitalVideoDisc[]{extra});
		});

		assertTrue(output.contains("The cart is almost full"), "Cart should report it's almost full when adding 21st item");
	}

	private static void testRemoveWhenEmpty() {
		Cart cart = new Cart();
		String output = captureOutput(() -> {
			DigitalVideoDisc dvd = new DigitalVideoDisc("Category", "Nope", 2.0);
			cart.removeDVD(dvd);
		});
		assertTrue(output.contains("The cart is empty"), "Removing from empty cart should print 'The cart is empty'");
		assertEquals(0.0, cart.calculateTotalCost(), 0.0001, "Total cost should be 0 for empty cart");
	}

	private static void testRemoveNonExisting() {
		Cart cart = new Cart();
		DigitalVideoDisc inCart = new DigitalVideoDisc("Category", "Present", 3.0);
		cart.addDVD(inCart);

		String output = captureOutput(() -> {
			DigitalVideoDisc notInCart = new DigitalVideoDisc("Category", "Absent", 3.0);
			cart.removeDVD(notInCart);
		});

		assertTrue(output.contains("The disc does not exist"), "Removing non-existing disc should print 'The disc does not exist'");
	}

	private static void testPrintAfterAddAndRemove() {
		Cart cart = new Cart();
		DigitalVideoDisc a = new DigitalVideoDisc("Category", "A", 4.0);
		DigitalVideoDisc b = new DigitalVideoDisc("Category", "B", 5.0);

		String out1 = captureOutput(() -> {
			cart.addDVD(a);
			cart.print();
		});
		assertTrue(out1.contains("Ordered Items (1)"), "After adding one DVD, print should show 1 item");

		String out2 = captureOutput(() -> {
			cart.addDVD(b);
			cart.print();
		});
		assertTrue(out2.contains("Ordered Items (2)"), "After adding second DVD, print should show 2 items");

		String out3 = captureOutput(() -> {
			cart.removeDVD(a);
			cart.print();
		});
		assertTrue(out3.contains("Ordered Items (1)"), "After removal, print should show 1 item");
	}
}
