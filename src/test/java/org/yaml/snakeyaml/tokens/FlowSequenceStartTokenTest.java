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
package org.yaml.snakeyaml.tokens;

import junit.framework.TestCase;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.tokens.Token.ID;

public class FlowSequenceStartTokenTest extends TestCase {

  public void testGetTokenId() {
    Mark mark = new Mark("test1", 0, 0, 0, "*The first line.\nThe last line.".toCharArray(), 0);
    FlowSequenceStartToken token = new FlowSequenceStartToken(mark, mark);
    assertEquals(ID.FlowSequenceStart, token.getTokenId());
  }
}
