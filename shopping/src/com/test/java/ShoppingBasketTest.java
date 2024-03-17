package com.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.main.java.ShoppingBasket;

public class ShoppingBasketTest {
	private ShoppingBasket shoppingBasket;

	@BeforeEach
	void setup() {
		shoppingBasket = new ShoppingBasket();
	}

	@Test
	public void testCalculateTotalCostNoItemAdded() {
		List<String> basket = new ArrayList<String>();
		assertEquals(0, shoppingBasket.calculateTotalCost(basket));
	}

	@Test
	public void testCalculateTotalCostSingleItemAdded() {
		List<String> basket = Arrays.asList("apple");
		assertEquals(35, shoppingBasket.calculateTotalCost(basket));
	}

	@Test
	public void testCalculateTotalCostSameItemAdded() {
		List<String> basket = Arrays.asList("apple", "apple", "apple");
		assertEquals(105, shoppingBasket.calculateTotalCost(basket));
	}

	@Test
	public void testCalculateTotalCostWithOffer() {
		List<String> basket = Arrays.asList("Melon", "Melon", "Lime", "Lime", "Lime");
		assertEquals(80, shoppingBasket.calculateTotalCost(basket));
	}

	@Test
	public void testCalculateTotalCostWithInvalidItem() {
		List<String> basket = Arrays.asList("mango");
		assertThrows(IllegalArgumentException.class, () -> shoppingBasket.calculateTotalCost(basket));
	}
}
