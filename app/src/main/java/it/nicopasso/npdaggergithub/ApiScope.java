package it.nicopasso.npdaggergithub;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by niccolo on 23/06/15.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiScope {
}
