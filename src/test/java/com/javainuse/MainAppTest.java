/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse;

import io.specto.hoverfly.junit.core.HoverflyConfig;
import io.specto.hoverfly.junit.rule.HoverflyRule;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ClassRule;

/**
 *
 * @author krzyczak
 */
public class MainAppTest {

  public MainAppTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @ClassRule
  public static HoverflyRule hoverflyRule = HoverflyRule
          .inCaptureOrSimulationMode("account.json", HoverflyConfig.configs().proxyLocalHost()).printSimulationData();

  /**
   * Test of main method, of class MainApp.
   */
  @Test
  public void testMain() throws IOException {
    System.out.println("main");
    String[] args = null;
//    MainApp.main(args);
    // TODO review the generated test code and remove the default call to fail.
    // fail("The test case is a prototype.");
    assertEquals(2, 2);

    String fileString = new String(Files.readAllBytes(Paths.get("./experiments/in.txt")), StandardCharsets.UTF_8);
    System.out.println("Contents (Java 7 with character encoding ) : " + fileString);

    String outFileContents = new String(Files.readAllBytes(Paths.get("./experiments/out.txt")), StandardCharsets.UTF_8);
    System.out.println("Contents (Java 7 with character encoding ) : " + outFileContents);

//    assertEquals("Janusz", outFileContents);
    assertEquals(3, 3);
  }

}
