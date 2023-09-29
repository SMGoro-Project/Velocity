/*
 * Copyright (C) 2018-2023 Velocity Contributors
 *
 * The Velocity API is licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in the api top-level directory.
 */

package com.velocitypowered.api.event.player;

import com.velocitypowered.api.event.annotation.AwaitingEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.util.GameProfile;
import java.util.List;

/**
 * This event is fired after the {@link com.velocitypowered.api.event.player.ServerPreConnectEvent}
 * in order to set up the game profile for the user. This can be used to configure a custom profile
 * for a user, i.e. skin replacement.
 */
@AwaitingEvent
public class ForwardingGameProfileCreateEvent {
  private final Player player;

  private List<GameProfile.Property> gameProfile;

  public ForwardingGameProfileCreateEvent(Player player, List<GameProfile.Property> gameProfile) {
    this.player = player;
    this.gameProfile = gameProfile;
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
