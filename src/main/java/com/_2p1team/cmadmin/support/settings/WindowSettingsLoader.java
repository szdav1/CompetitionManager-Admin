package com._2p1team.cmadmin.support.settings;

import com._2p1team.cmadmin.support.util.ResourceManager;
import lombok.Getter;
import org.json.JSONObject;

import java.io.File;
import java.io.RandomAccessFile;

@Getter
public final class WindowSettingsLoader {
    private JSONObject windowSettings;

    public WindowSettingsLoader(final String filePath) {
        try (RandomAccessFile reader = new RandomAccessFile(new File(ResourceManager.get(filePath)), "r")) {
            String line = reader.readLine();
            StringBuilder fileContents = new StringBuilder();

            while (line != null) {
                fileContents.append(this.removeWhiteSpace(line));

                line = reader.readLine();
            }

            JSONObject jsonObject = new JSONObject(fileContents.toString());
            this.windowSettings = jsonObject.getJSONObject("window");
        }
        catch (Exception exc) { // TODO: Replace with UI error display
            exc.printStackTrace();
        }
    }

    private String removeWhiteSpace(final String string) {
        return string.replaceAll("\\n", "")
            .replaceAll("\\t", "")
            .replaceAll(" ", "");
    }
}