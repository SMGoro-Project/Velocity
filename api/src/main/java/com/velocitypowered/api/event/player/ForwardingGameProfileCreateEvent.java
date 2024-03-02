/*
 * Copyright (C) 2018-2023 Velocity Contributors
 *
 * The Velocity API is licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in the api top-level directory.
 */

package com.velocitypowered.api.event.player;

import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import com.velocitypowered.api.util.GameProfile;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * This event is fired after the {@link com.velocitypowered.api.event.player.ServerPreConnectEvent}
 * in order to set up the game profile for the user. This can be used to configure a custom profile
 * for a user, i.e. skin replacement.
 */

@AwaitingEvent
public class ForwardingGameProfileCreateEvent {
  private final Player player;

  private final RegisteredServer previousServer;
  private final RegisteredServer nextServer;
  private List<GameProfile.Property> gameProfile;

  /**
   * Creates the ServerPreConnectEvent.
   *
   * @param player the player who is connecting to a server
   * @param nextServer the server the player was trying to connect to
   * @param previousServer the server the player is connected to
   */
  public ForwardingGameProfileCreateEvent(Player player, RegisteredServer previousServer, RegisteredServer nextServer,  List<GameProfile.Property> gameProfile) {
    this.player = player;
    this.previousServer = previousServer;
    this.nextServer = nextServer;
    this.gameProfile = gameProfile;
  }

  /**
   * Returns the server that the player originally tried to connect to. To get the server the
   * player will connect to, see the {@link ServerPreConnectEvent.ServerResult} of this event. To get the server the
   * player is currently on when this event is fired, use {@link #getPreviousServer()}.
   *
   * @return the server that the player originally tried to connect to
   */
  public RegisteredServer getNextServer() {
    return nextServer;
  }

  /**
   * Returns the server that the player is currently connected to. Prefer this method over using
   * {@link Player#getCurrentServer()} as the current server might get reset after server kicks to
   * prevent connection issues. This is {@code null} if they were not connected to another server
   * beforehand (for instance, if the player has just joined the proxy).
   *
   * @return the server the player is currently connected to.
   */
  public @Nullable RegisteredServer getPreviousServer() {
    return previousServer;
  }


  public void setGameProfile(List<GameProfile.Property> gameProfile) {
    this.gameProfile = gameProfile;
  }

  public List<GameProfile.Property> getGameProfile() {
    return gameProfile;
  }

  public Player getPlayer() {
    return player;
  }
}