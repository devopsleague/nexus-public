/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.crypto.secrets;

import org.sonatype.nexus.crypto.internal.CryptoHelperImpl;
import org.sonatype.nexus.crypto.internal.PbeCipherFactoryImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptDecryptServiceTest
{

  EncryptDecryptService encryptDecryptService = new EncryptDecryptService(new PbeCipherFactoryImpl(new CryptoHelperImpl()));

  @Test
  public void testEncryptionDecryption() {
    String testString = "test 123 ==== <>?/.,";
    String encoded = encryptDecryptService.encryptAndEncode(testString);
    String decoded = encryptDecryptService.decodeAndDecrypt(encoded);
    assertEquals(testString, decoded);
  }
}