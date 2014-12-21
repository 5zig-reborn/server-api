package eu.the5zig.mod.server.api;

import org.bukkit.entity.Player;

/**
 * Created by 5zig.
 * All rights reserved © 2014
 */
public interface ModUser {

	/**
	 * Returns the Bukkit player of the Mod user.
	 *
	 * @return The Player
	 */
	public Player getPlayer();

	/**
	 * Gets the Stats Manager of the Player. The Stats Manager stores all Stats of a player and sends them to it
	 *
	 * @return The Stats Manager.
	 */
	public StatsManager getStatsManager();

	/**
	 * Checks if the ModUser is currently connected to the ServerAPI.
	 *
	 * @return If the ModUser is currently connected to the ServerAPI.
	 */
	public boolean isConnected();

}
