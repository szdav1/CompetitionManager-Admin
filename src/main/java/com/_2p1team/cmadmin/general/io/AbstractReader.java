package com._2p1team.cmadmin.general.io;

import com._2p1team.cmadmin.general.constants.BeforeLaunchExceptionType;
import com._2p1team.cmadmin.general.util.BeforeLaunchExceptionQueue;
import com._2p1team.cmadmin.general.util.ResourceManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReader {

    protected final Gson converter = new Gson();

    public Map<String, String> read(final String fileName) {
        final Map<String, String> languageValues = new HashMap<>();
        StringBuilder data = new StringBuilder();

        try (RandomAccessFile reader = new RandomAccessFile(new File(ResourceManager.get(fileName)), "r")) {
            String line = reader.readLine();

            while (line != null) {
                data.append(line);
                line = reader.readLine();
            }
        }
        catch (Exception exception) {
            BeforeLaunchExceptionQueue.setExceptionType(BeforeLaunchExceptionType.RESOURCE_NOT_FOUND_EXCEPTION);
        }

        JsonObject jsonObject = this.converter.fromJson(data.toString(), JsonObject.class);
        jsonObject.entrySet().forEach(entry -> languageValues.put(entry.getKey(), entry.getValue().getAsString()));

        return languageValues;
    }

    public Map<String, String> rawRead(final String fileName) {
        final Map<String, String> languageValues = new HashMap<>();
        StringBuilder data = new StringBuilder();

        try (RandomAccessFile reader = new RandomAccessFile(new File(fileName), "r")) {
            String line = reader.readLine();

            while (line != null) {
                data.append(line);
                line = reader.readLine();
            }
        }
        catch (Exception exception) {
            BeforeLaunchExceptionQueue.setExceptionType(BeforeLaunchExceptionType.RESOURCE_NOT_FOUND_EXCEPTION);
        }

        JsonObject jsonObject = this.converter.fromJson(data.toString(), JsonObject.class);
        jsonObject.entrySet().forEach(entry -> languageValues.put(entry.getKey(), entry.getValue().getAsString()));

        return languageValues;
    }

}