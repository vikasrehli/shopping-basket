package com.main.java;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingBasket {
	private static final CaseInsensitiveMap itemPrices = new CaseInsensitiveMap();

	static {
		itemPrices.put("Apple", 35);
		itemPrices.put("Banana", 20);
		itemPrices.put("Melon", 50);
		itemPrices.put("Lime", 15);
	}

	public int calculateTotalCost(List<String> shoppingBasket) {
		Map<String, Long> itemCounts = shoppingBasket.stream()
				.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

		int totalCost = itemCounts.entrySet().stream().mapToInt(entry -> {
			String item = entry.getKey();
			long quantity = entry.getValue();
			int price = 0;

			if (null != itemPrices.get(item)) {
				price = itemPrices.get(item);
			} else {
				throw new IllegalArgumentException("Item " + item + " is not recongnized");
			}

			if (item.equalsIgnoreCase("Melon")) {
				return (int) ((quantity / 2 + quantity % 2) * price);
			} else if (item.equalsIgnoreCase("Lime")) {
				return (int) ((quantity / 3 * 2 + quantity % 3) * price);
			} else {
				return (int) (quantity * price);
			}
		}).sum();

		return totalCost;
	}
}
