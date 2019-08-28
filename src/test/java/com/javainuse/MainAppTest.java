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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

import org.springframework.core.log.LogDelegateFactory;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

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
          .inCaptureOrSimulationMode("requests.json", HoverflyConfig.configs().proxyLocalHost()).printSimulationData();

  /**
   * Test of main method, of class MainApp.
   */
  @Test
  public void testRestTemplateRequest() throws IOException {
    System.out.println("testRestTemplateRequest");

    //String fileString = new String(Files.readAllBytes(Paths.get("./experiments/in.txt")), StandardCharsets.UTF_8);
    //System.out.println("Contents (Java 7 with character encoding ) : " + fileString);

    //String outFileContents = new String(Files.readAllBytes(Paths.get("./experiments/out.txt")), StandardCharsets.UTF_8);
    //System.out.println("Contents (Java 7 with character encoding ) : " + outFileContents);
 
    RestTemplate restTemplate = new RestTemplate();

    String result = restTemplate.getForObject("http://ip.jsontest.com", String.class);
 
    //System.out.println(result);
    
    assertEquals("{\"ip\": \"80.87.30.34\"}", result);
  }
  
  @Test
  public void testCamelRoutes() throws IOException, InterruptedException {
    System.out.println("testCamelRoutes");
    String[] args = null;
    MainApp.main(args);

    //String fileString = new String(Files.readAllBytes(Paths.get("./experiments/in.txt")), StandardCharsets.UTF_8);
    //System.out.println("Contents (Java 7 with character encoding ) : " + fileString);

    Thread.sleep(3000);
    
    String outFileContents = new String(Files.readAllBytes(Paths.get("./experiments/out.txt")), StandardCharsets.UTF_8);
    System.out.println("./experiments/out.txt: " + outFileContents);

    System.out.println(outFileContents);
    String expectedContent = "{\"ip\": \"80.87.30.34\"}";
    assertEquals(expectedContent, outFileContents);
  }

}
