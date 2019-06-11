package com.yjl.sample.verticle;

import com.yjl.vertx.base.com.anno.initializer.ComponentInitializer;
import com.yjl.vertx.base.com.verticle.InitVerticle;
import com.yjl.vertx.base.webclient.factory.AutoRouteWebClientFactory;

@ComponentInitializer(factoryClass = AutoRouteWebClientFactory.class, value = "com.yjl.sample.client")
public class Sample2Verticle extends InitVerticle {
}
