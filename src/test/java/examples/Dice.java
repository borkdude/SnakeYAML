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
package examples;

public class Dice {

  private final Integer a;
  private final Integer b;

  public Dice(Integer a, Integer b) {
    super();
    this.a = a;
    this.b = b;
  }

  public Integer getA() {
    return a;
  }

  public Integer getB() {
    return b;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Dice) {
      return toString().equals(obj.toString());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public String toString() {
    return "Dice " + a + "d" + b;
  }
}
