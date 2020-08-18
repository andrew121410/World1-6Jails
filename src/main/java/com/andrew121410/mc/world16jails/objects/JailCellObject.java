package com.andrew121410.mc.world16jails.objects;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.HashMap;
import java.util.Map;

@SerializableAs("JailCellObject")
public class JailCellObject implements ConfigurationSerializable {

    private int number;
    private Location spawnLocation;
    private Location doorLocation;
    private JailPlayerObject jailPlayerObject;

    public JailCellObject(int number, Location spawnLocation, Location doorLocation, JailPlayerObject jailPlayerObject) {
        this.number = number;
        this.spawnLocation = spawnLocation;
        this.doorLocation = doorLocation;
        this.jailPlayerObject = jailPlayerObject;
    }

    public int getNumber() {
        return number;
    }

    public JailPlayerObject getJailPlayerObject() {
        return jailPlayerObject;
    }

    public void setJailPlayerObject(JailPlayerObject jailPlayerObject) {
        this.jailPlayerObject = jailPlayerObject;
    }

    public Location getDoorLocation() {
        return doorLocation;
    }

    public void setDoorLocation(Location doorLocation) {
        this.doorLocation = doorLocation;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("Number", this.number);
        map.put("SpawnLocation", this.spawnLocation);
        map.put("DoorLocation", this.doorLocation);
        map.put("JailPlayer", this.jailPlayerObject);
        return map;
    }

    public static JailCellObject deserialize(Map<String, Object> map) {
        return new JailCellObject((int) map.get("Number"), (Location) map.get("SpawnLocation"), (Location) map.get("DoorLocation"), (JailPlayerObject) map.get("JailPlayer"));
    }
}
