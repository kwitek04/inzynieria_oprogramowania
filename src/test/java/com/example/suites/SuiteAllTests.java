package com.example.suites;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Zestaw: Wszystkie Testy (Zadanie 1 i 2)")
@SelectPackages("com.example.tests")
public class SuiteAllTests {
}