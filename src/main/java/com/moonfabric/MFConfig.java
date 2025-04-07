package com.moonfabric;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class MFConfig {
    private boolean enableOrDisableDynamicLightsInTheModule = true;

    public void setLight(boolean light) {
        this.enableOrDisableDynamicLightsInTheModule = light;
    }

    public boolean isLight() {
        return enableOrDisableDynamicLightsInTheModule;
    }

    public void save(File configFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("enableOrDisableDynamicLightsInTheModule", this.enableOrDisableDynamicLightsInTheModule);


        try (FileWriter writer = new FileWriter(configFile)) {
            gson.toJson(map, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MFConfig load(File configFile) {
        Gson gson = new Gson();
        MFConfig config = new MFConfig();
        try (FileReader reader = new FileReader(configFile)) {
            Type type = new TypeToken<HashMap<String, Boolean>>(){}.getType();
            HashMap<String, Boolean> map = gson.fromJson(reader, type);
            if (map != null && map.containsKey("enableOrDisableDynamicLightsInTheModule")) {
                config.setLight(map.get("enableOrDisableDynamicLightsInTheModule"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }

}
