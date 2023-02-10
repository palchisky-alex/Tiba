package com.targil.tiba;
import org.aeonbits.owner.Config;
public interface Setup extends Config {

    @DefaultValue("PC") //PC / MAC
    String OS();
}
