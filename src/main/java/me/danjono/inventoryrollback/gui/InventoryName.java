package me.danjono.inventoryrollback.gui;

import me.danjono.inventoryrollback.config.ConfigData;

public enum InventoryName {
	
    MAIN_MENU("库存回滚", 36),
	PLAYER_MENU("玩家数据", 9),
	ROLLBACK_LIST("回滚记录", ConfigData.getBackupLinesVisible() * 9 + 9),
	MAIN_BACKUP("主背包备份", 54),
    ENDER_CHEST_BACKUP("末影箱备份", 36);
	
	private final String menuName;
	private final int size;
	
	private InventoryName(String name, int size) {
		this.menuName = name;
		this.size = size;
	}
	
	public String getName() {
		return this.menuName;
	}
	
	public int getSize() {
	    return this.size;
	}

}
