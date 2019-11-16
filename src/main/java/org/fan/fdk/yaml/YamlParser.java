package org.fan.fdk.yaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by zhu.xiaoliu on 2019/11/16.
 */
public class YamlParser {

    public static <T> T parse(String file, Class<? extends Object> clazz) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(file);
        return parse(inputStream, clazz);
    }

    public static <T> T parse(InputStream inputStream, Class<? extends Object> clazz) {
        Yaml yaml = new Yaml(new Constructor(clazz));
        return yaml.load(inputStream);
    }
}
