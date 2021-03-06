package com.mcmoddev.basegems.init;

import com.mcmoddev.basegems.data.MaterialNames;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.util.ConfigBase.Options;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.init.MMDCreativeTab;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.TabContainer;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * This class initializes all item groups in Base Gems.
 *
 * @author Jasmine Iwanek
 *
 */
public class ItemGroups extends com.mcmoddev.lib.init.ItemGroups {

	private static boolean initDone = false;

	private static final int BLOCKS_TAB_ID = addTab("blocks", true);
	private static final int ITEMS_TAB_ID = addTab("items", true);
	private static final int TOOLS_TAB_ID = addTab("tools", true);
	private static final MMDCreativeTab blocksTab = getTab(BLOCKS_TAB_ID);
	private static final MMDCreativeTab itemsTab = getTab(ITEMS_TAB_ID);
	private static final MMDCreativeTab toolsTab = getTab(TOOLS_TAB_ID);
	public static final TabContainer myTabs = new TabContainer(blocksTab, itemsTab, toolsTab);

	private ItemGroups() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	/**
	 *
	 */
	public static void init() {
		if (initDone) {
			return;
		}

		initDone = true;
	}

	public static void setupIcons() {
		MMDMaterial material = Materials.EMPTY;
		Block blocksTabIconItem;
		Item itemsTabIconItem;
		Item toolsTabIconItem;

		if (Materials.hasMaterial(MaterialNames.BLACKDIAMOND)) {
			material = Materials.getMaterialByName(MaterialNames.BLACKDIAMOND);
		} else	if (Materials.hasMaterial(com.mcmoddev.basemetals.data.MaterialNames.IRON)) {
			material = Materials.getMaterialByName(com.mcmoddev.basemetals.data.MaterialNames.IRON);
		}

		if (material.equals(Materials.EMPTY)) {
			return;
		}

		if (material.hasBlock(Names.BLOCK)) {
			blocksTabIconItem = material.getBlock(Names.BLOCK);
		} else {
			blocksTabIconItem = net.minecraft.init.Blocks.IRON_BLOCK;
		}

		if (material.hasItem(Names.GEAR)) {
			itemsTabIconItem = material.getItem(Names.GEAR);
		} else {
			itemsTabIconItem = net.minecraft.init.Items.STICK;
		}

		if (material.hasItem(Names.SWORD)) {
			toolsTabIconItem = material.getItem(Names.SWORD);
		} else {
			toolsTabIconItem = net.minecraft.init.Items.DIAMOND_SWORD;
		}

		blocksTab.setTabIconItem(blocksTabIconItem);
		itemsTab.setTabIconItem(itemsTabIconItem);
		toolsTab.setTabIconItem(toolsTabIconItem);
	}
}
