package com.simx.dagger2starter.di.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by simx on 14/02/18.
 */
@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ActivityScope {
}
