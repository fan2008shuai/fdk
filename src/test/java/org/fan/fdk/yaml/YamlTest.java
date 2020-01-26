package org.fan.fdk.yaml;

import com.alibaba.fastjson.JSON;
import org.fan.fdk.yaml.aft.AftConfig;
import org.fan.fdk.yaml.bean.Customer;
import org.fan.fdk.yaml.task.Resources;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by fan.shuai on 2019/11/16.
 */
public class YamlTest {

    @Test
    public void test() {
//        Yaml yaml = new Yaml();
        Yaml yaml = new Yaml(new Constructor(Customer.class));
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("customer.yaml");
//        Map<String, Object> customer = yaml.load(inputStream);
        Customer customer = yaml.load(inputStream);
        System.out.println(customer);
    }

    @Test
    public void testYaml() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("customer.yaml");
        Customer customer = YamlParser.parse(inputStream, Customer.class);
        System.out.println(customer);
    }

    @Test
    public void testTask() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("task.yaml");
        Map<String, Resources> map = YamlParser.parse(inputStream, Map.class);
        System.out.println(JSON.toJSON(map));
    }

    @Test
    public void testAft() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("aft.yaml");
        AftConfig aftConfig = YamlParser.parse(inputStream, AftConfig.class);
        System.out.println(JSON.toJSONString(aftConfig));
    }
}
