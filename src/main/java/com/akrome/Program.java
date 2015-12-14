package com.akrome;

import com.akrome.levels.Level1;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class Program {
    @Inject
    Level1 level1;

    public static void main(String[] args) throws Exception {
        Program p = Guice.createInjector(new MainModule()).getInstance(Program.class);
        p.run(args);
    }

    public void run(String[] args) throws Exception {
        level1.run();

    }
}
