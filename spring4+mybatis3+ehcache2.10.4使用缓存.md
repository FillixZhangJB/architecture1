﻿**

## spring4+mybatis3+ehcache2.10.4使用缓存

**
参考网址： [ehcache官网](http://www.ehcache.org/)
1.加入依赖
  <!-- ehcache的jar -->

    <dependency>
        <groupId>net.sf.ehcache</groupId>
        <artifactId>ehcache</artifactId>
        <version>2.10.4</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis.caches</groupId>
        <artifactId>mybatis-ehcache</artifactId>
        <version>1.1.0</version>
    </dependency>

 2、在classpath路径下加入Ehcache配置文件ehcache.xml

    <?xml version="1.0" encoding="UTF-8"?>  
    <ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd">
        <defaultCache overflowToDisk="true" eternal="false" maxElementsInMemory="1"/>  
        <diskStore path="E:/cache" />
    </ehcache>  

3、在需要使用缓存的*mapper.xml中加入`<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>`，如下

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <mapper namespace="*Mapper">
    
        <cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
        <select id="selectByCondition" 

 4、需要缓存的对象必须实现序列化接口
 
 详细配置参考  [ehcache2.10.4官方文档](http://www.ehcache.org/documentation/2.10.4/pdf/index.html)
