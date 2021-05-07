package com.ataraxy.breadpack.init;

import java.util.ArrayList;
import java.util.List;

import com.ataraxy.breadpack.objects.items.Coffee;
import com.ataraxy.breadpack.objects.items.FoodBase;
import com.ataraxy.breadpack.objects.items.IceCream;
import com.ataraxy.breadpack.objects.items.ItemBase;
import com.ataraxy.breadpack.objects.items.Soda;

import net.minecraft.item.Item;

public class ItemInit 
{
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Items
	public static final Item CHIP = new ItemBase("chip");
	public static final Item TOKEN = new ItemBase("token");
	public static final Item TOAST = new FoodBase("toast", 5, 6.0f, false);
	public static final Item CHEESEBURGER = new FoodBase("cheeseburger", 8, 12.8f, true);
	public static final Item COKE = new Soda("coke", 0, 0.0f, false);
	public static final Item DRPEPPER = new Soda("dr_pepper", 0, 0.0f, false);
	public static final Item MTNDEW = new Soda("mtn_dew", 0, 0.0f, false);
	public static final Item PEPSI = new Soda("pepsi", 0, 0.0f, false);	
	public static final Item COFFEECUP = new Coffee("coffee_cup", 0, 0.0f, false);
	public static final Item COFFEEMUG = new Coffee("coffee_mug", 0, 0.0f, false);
	public static final Item CHOCOLATEICECREAM = new IceCream("chocolate_ice_cream", 2, 0.4f, false);
	public static final Item VANILLAICECREAM = new IceCream("vanilla_ice_cream", 2, 0.4f, false);
	public static final Item MINTICECREAM = new IceCream("mint_ice_cream", 2, 0.4f, false);
	public static final Item STRAWBERRYICECREAM = new IceCream("strawberry_ice_cream", 2, 0.4f, false);
	public static final Item RAISINETS = new IceCream("raisinets", 2, 0.4f, false);
	public static final Item CHICKENNOODLESOUP = new FoodBase("chicken_noodle_soup", 6, 7.2f, false);
	public static final Item EMPTYGASCAN = new ItemBase("empty_gas_can");
	public static final Item GASCAN = new ItemBase("gas_can");
	public static final Item HOTDOG = new FoodBase("hotdog", 7, 8f, true);
	public static final Item PIZZA = new FoodBase("pizza", 7, 8f, true);
	public static final Item POPCORN = new FoodBase("popcorn", 3, 0.5f, true);
	public static final Item SPLINT = new ItemBase("splint");
	public static final Item GARLICBREAD = new FoodBase("garlic_bread", 5, 6.0f, false);
	public static final Item BISCUIT = new FoodBase("biscuit", 5, 6.0f, false);
	public static final Item BAGEL = new FoodBase("bagel", 5, 6.0f, false);
	public static final Item PRETZEL = new FoodBase("pretzel", 5, 6.0f, false);
	public static final Item CROSSAINT = new FoodBase("crossaint", 5, 6.0f, false);
	public static final Item BREADLOAF = new FoodBase("bread_loaf", 5, 6.0f, false);
}
