package com.java7developer.chapter13

import grails.test.*

class PlayerCharacterTests extends GrailsUnitTestCase {
    
  PlayerCharacter pc;
    
  protected void setUp() {
    super.setUp()
    mockForConstraintsTests(PlayerCharacter)
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testConstructorSucceedsWithValidAttributes() {
    pc = new PlayerCharacter(3, 5, 18)
    assert pc.validate()
  }

  void testConstructorFailsWithSomeBadAttributes() {
    pc = new PlayerCharacter(10, 19, 21)
    assertFalse pc.validate()
  }
}
