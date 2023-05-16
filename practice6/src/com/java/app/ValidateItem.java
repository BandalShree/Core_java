package com.java.app;

import java.util.List;

public interface ValidateItem {
	static void validateItem(List<Item> items,Item item) throws Exception{
		if(items.contains(item))
			throw new RuntimeException("item Id Must be uniq");
	}
}
