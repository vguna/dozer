/**
 * Copyright 2005-2013 Dozer Project
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
package org.dozer.vo;

/**
 * @author garsombke.franz
 * @author sullins.ben
 * @author tierney.matt
 * 
 */
public class SuperSuperSuperClassPrime extends BaseTestObject {
  private String superSuperSuperAttr;
  private HydrateTestObject3 dehydrate;
  private TestCustomConverterObjectPrime customConvert;

  public TestCustomConverterObjectPrime getCustomConvert() {
    return customConvert;
  }

  public void setCustomConvert(TestCustomConverterObjectPrime customConvert) {
    this.customConvert = customConvert;
  }

  public String getSuperSuperSuperAttr() {
    return superSuperSuperAttr;
  }

  public void setSuperSuperSuperAttr(String superSuperSuperAttr) {
    this.superSuperSuperAttr = superSuperSuperAttr;
  }

  public HydrateTestObject3 getDehydrate() {
    return dehydrate;
  }

  public void setDehydrate(HydrateTestObject3 dehydrate) {
    this.dehydrate = dehydrate;
  }
}