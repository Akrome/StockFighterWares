package com.akrome;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class BaseTest {
    protected Injector injector = Guice.createInjector(new MainTestModule());
}
