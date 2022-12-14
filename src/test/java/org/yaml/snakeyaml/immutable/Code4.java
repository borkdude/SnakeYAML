/**
 * Copyright (c) 2008, SnakeYAML
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.yaml.snakeyaml.immutable;

/**
 * Two constructors with 1 argument. None of them has String as the argument class.
 */
public class Code4 {

  private final Integer code;

  public Code4(Integer name) {
    this.code = name;
  }

  public Code4(Double name) {
    this.code = Integer.valueOf(name.intValue());
  }

  public Integer getCode() {
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Code4) {
      Code4 code = (Code4) obj;
      return code.equals(code.code);
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return code.hashCode();
  }

  @Override
  public String toString() {
    return "<Code4 code=" + code + ">";
  }
}
