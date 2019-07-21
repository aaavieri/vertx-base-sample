package com.yjl.sample.verticle;

import com.yjl.vertx.base.com.anno.initializer.ComponentInitializer;
import com.yjl.vertx.base.com.anno.initializer.OverrideDependency;
import com.yjl.vertx.base.com.verticle.InitVerticle;
import com.yjl.vertx.base.web.factory.component.RestHandlerV2Factory;
import com.yjl.vertx.base.web.factory.component.RestRouteV2Factory;

@OverrideDependency(value = @ComponentInitializer(factoryClass = RestRouteV2Factory.class),
	customInclude = {@ComponentInitializer(factoryClass = RestHandlerV2Factory.class, value = "com.yjl.sample.handler")})
public class Sample4Verticle extends InitVerticle {
}
