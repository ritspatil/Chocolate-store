package com.example.stride.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   ChocolateFactoryGeneralTest.class ,ChocolateFactoryTestSpecs.class, TestNullValue.class, ChocoStoreTestSpecs.class
})

public class ChocoloateStoreTestSuite {
}