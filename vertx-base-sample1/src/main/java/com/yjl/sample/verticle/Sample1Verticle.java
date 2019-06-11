package com.yjl.sample.verticle;

import com.yjl.vertx.base.com.anno.initializer.ComponentInitializer;
import com.yjl.vertx.base.com.verticle.InitVerticle;
import com.yjl.vertx.base.dao.factory.AutoRouteDaoFactory;

@ComponentInitializer(factoryClass = AutoRouteDaoFactory.class, value = "com.yjl.sample.mapper")
public class Sample1Verticle extends InitVerticle {
}
