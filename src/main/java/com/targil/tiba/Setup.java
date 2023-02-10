package com.targil.tiba;
import org.aeonbits.owner.Config;
public interface Setup extends Config {

    @DefaultValue("Chrome") // Choose you browser: Chrome | Firefox | Edge | Opera
    String browser();

    @DefaultValue("")
    String username();

    @DefaultValue("")
    String password();

    @DefaultValue("")
    String key();
}
