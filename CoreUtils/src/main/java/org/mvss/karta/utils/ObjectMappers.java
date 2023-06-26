package org.mvss.karta.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.Serializable;
import java.util.HashMap;

public class ObjectMappers {
    public static final TypeReference<HashMap<String, Serializable>> GENERIC_OBJECT_TYPEREFERENCE = new TypeReference<>() {
    };

    public static final ObjectMapper jsonObjectMapper = new ObjectMapper();
    public static final ObjectMapper yamlObjectMapper = new ObjectMapper(new YAMLFactory());
    public static final ObjectMapper xmlObjectMapper = new XmlMapper();

    static {
        jsonObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        jsonObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        jsonObjectMapper.findAndRegisterModules();

        yamlObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        yamlObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        yamlObjectMapper.findAndRegisterModules();

        xmlObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        xmlObjectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlObjectMapper.findAndRegisterModules();
    }
}
