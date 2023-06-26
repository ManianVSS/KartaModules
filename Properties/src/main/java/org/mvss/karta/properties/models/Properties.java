package org.mvss.karta.properties.models;

import lombok.Getter;
import lombok.Setter;
import org.mvss.karta.utils.ClassPathLoaderUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import static org.mvss.karta.utils.ObjectMappers.*;

@Getter
@Setter
public class Properties {

    public final HashMap<String, Serializable> map = new HashMap<>();

    public final HashMap<String, String> sysMap = new HashMap<>();
    public final HashMap<String, String> envMap = new HashMap<>();

    public Properties() {
        sysMap.putAll(System.getenv());
        System.getProperties().forEach((key, value) -> envMap.put(key.toString(), value.toString()));
    }

    public void loadProperties(HashMap<String, Serializable> propertiesToMerge) {
        if (propertiesToMerge == null) {
            return;
        }

        for (String propertyNameToMerge : propertiesToMerge.keySet()) {
            map.put(propertyNameToMerge, propertiesToMerge.get(propertyNameToMerge));
        }
    }

    public void loadJSONFile(String jsonFileName) throws IOException {
        String fileString = ClassPathLoaderUtils.readAllText(jsonFileName);
        HashMap<String, Serializable> propertiesToMerge = jsonObjectMapper.readValue(fileString, GENERIC_OBJECT_TYPEREFERENCE);
        loadProperties(propertiesToMerge);
    }

    public void loadYAMLFile(String yamlFileName) throws IOException {
        String fileString = ClassPathLoaderUtils.readAllText(yamlFileName);
        HashMap<String, Serializable> propertiesToMerge = yamlObjectMapper.readValue(fileString, GENERIC_OBJECT_TYPEREFERENCE);
        loadProperties(propertiesToMerge);
    }

    public void loadXMLFile(String xmlFileName) throws IOException {
        String fileString = ClassPathLoaderUtils.readAllText(xmlFileName);
        HashMap<String, Serializable> propertiesToMerge = xmlObjectMapper.readValue(fileString, GENERIC_OBJECT_TYPEREFERENCE);
        loadProperties(propertiesToMerge);
    }

    public void loadPropertiesFile(String javaPropertiesFile) throws IOException {
        java.util.Properties properties = new java.util.Properties();
        try (FileInputStream fileInputStream = new FileInputStream(javaPropertiesFile)) {
            properties.load(fileInputStream);
            properties.forEach((key, value) -> map.put(key.toString(), value.toString()));
        }
    }

    public void loadFiles(String... fileNames) {

        if (fileNames == null) {
            return;
        }

        //TODO
    }
}
