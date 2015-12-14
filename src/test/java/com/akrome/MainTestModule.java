package com.akrome;

import com.google.inject.AbstractModule;
import com.google.inject.util.Modules;

public class MainTestModule extends AbstractModule {
    @Override
    protected void configure() {
        install(Modules.override(new MainModule()).with(

        ));
    }
}
