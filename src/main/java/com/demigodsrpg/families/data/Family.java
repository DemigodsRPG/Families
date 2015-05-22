/*
 * Copyright 2015 Demigods RPG
 * Copyright 2015 Alexander Chauncey
 * Copyright 2015 Alex Bennett
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.demigodsrpg.families.data;

import com.demigodsrpg.util.datasection.AbstractPersistentModel;
import com.demigodsrpg.util.datasection.DataSection;
import org.bukkit.ChatColor;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Family extends AbstractPersistentModel<String> {

    // -- ALWAYS EXISTING FACTIONS -- //

    public static final Family NEUTRAL = new Family("Neutral", ChatColor.GRAY, "N", "Welcome to neutral ground.");
    public static final Family EXCOMMUNICATED = new Family("Excommunicated", ChatColor.DARK_GRAY, "X", "Something has gone horribly wrong, alert an admin.");

    // -- FACTION META DATA -- //

    private String name;
    private String color;
    private String chatSymbol;
    private String welcomeMessage;

    // -- CONSTRUCTORS -- //

    public Family(String name, ChatColor color, String chatSymbol, String welcomeMessage) {
        this(name, color.toString(), chatSymbol, welcomeMessage);
    }

    public Family(String name, String color, String chatSymbol, String welcomeMessage) {
        this.name = name;
        this.color = color;
        this.chatSymbol = chatSymbol;
        this.welcomeMessage = welcomeMessage;
    }

    public Family(String stringKey, DataSection conf) {
        name = stringKey;
        color = conf.getString("color");
        chatSymbol = conf.getString("chat-symbol");
        welcomeMessage = conf.getString("welcome-message");
    }

    // -- GETTERS -- //

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getChatSymbol() {
        return chatSymbol;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public String getPersistentId() {
        return name;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("color", color);
        map.put("chat-symbol", chatSymbol);
        map.put("welcome-message", welcomeMessage);
        return map;
    }
}
