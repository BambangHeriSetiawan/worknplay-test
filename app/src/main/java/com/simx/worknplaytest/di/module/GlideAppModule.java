package com.simx.worknplaytest.di.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import dagger.Module;

@Module
@GlideModule
public class GlideAppModule  extends AppGlideModule{

  @Override
  public void applyOptions (Context context, GlideBuilder builder) {
    super.applyOptions (context, builder);
  }
}
