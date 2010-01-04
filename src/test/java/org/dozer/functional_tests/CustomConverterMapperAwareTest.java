/*
 * Copyright 2005-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dozer.functional_tests;

import static junit.framework.Assert.assertTrue;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dmitry.buzdin
 */
public class CustomConverterMapperAwareTest extends AbstractFunctionalTest {

  @Override
  public void setUp() throws Exception {
    super.setUp();
    mapper = getMapper("customConverterMapperAware.xml");
  }

  @Test
  public void test_convert_withInjectedMapper() {
    List<BeanA> list = new ArrayList<BeanA>();
    BeanA b1 = new BeanA("1");
    BeanA b2 = new BeanA("2");
    BeanA b3 = new BeanA("3");

    list.add(b1);
    list.add(b2);
    list.add(b3);

    Map map = mapper.map(list, HashMap.class);
    
    assertNotNull(map);
    assertEquals(3, map.size());
    assertTrue(map.keySet().contains(b1));
    assertTrue(map.keySet().contains(b2));
    assertTrue(map.keySet().contains(b3));
    assertEquals(b1.getA(), ((BeanB) map.get(b1)).getA().toString());
    assertEquals(b2.getA(), ((BeanB) map.get(b2)).getA().toString());
    assertEquals(b3.getA(), ((BeanB) map.get(b3)).getA().toString());
  }

  public static class Converter extends DozerConverter <List, Map> implements MapperAware {

    private Mapper mapper;

    public Converter() {
      super(List.class, Map.class);
    }

    public Map convertTo(List source, Map destination) {
      Map result = new HashMap();
      for (Object item : source) {
        BeanB mappedItem = mapper.map(item, BeanB.class);
        result.put(item, mappedItem);
      }
      return result;
    }

    public List convertFrom(Map source, List destination) {
      return destination;
    }

    public void setMapper(Mapper mapper) {
      this.mapper = mapper;
    }

  }

  public static class BeanA {
    public BeanA(String a) {
      this.a = a;
    }

    private String a;

    public String getA() {
      return a;
    }

    public void setA(String a) {
      this.a = a;
    }
  }

  public static class BeanB {
    private Integer a;

    public Integer getA() {
      return a;
    }

    public void setA(Integer a) {
      this.a = a;
    }
  }

}
