package com.example.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Zestaw: Tylko Testy Jednostkowe (Zadanie 1)")
@SelectPackages("com.example.tests")
@IncludeTags("Unit")
public class SuiteUnitTests {
}