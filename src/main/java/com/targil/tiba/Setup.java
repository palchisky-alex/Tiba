package com.targil.tiba;
import org.aeonbits.owner.Config;
public interface Setup extends Config {

    @DefaultValue("Firefox") // Chrome | Firefox | Edge | Opera |
    String browser();
}
