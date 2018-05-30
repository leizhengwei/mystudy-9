# 使用案例
---

### 类加载

* [类加载器原理，如何做到隔离?](https://github.com/aalansehaiyang/technology-talk/blob/master/basic-knowledge/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8.md)

```
    /**
     * 清除类加载器
     *
     * @param classLoader
     */
    public static void clear(ClassLoader classLoader) {
        checkNotNull(classLoader, "classLoader is null");
        Introspector.flushCaches();
        //从已经使用给定类加载器加载的缓存中移除所有资源包
        ResourceBundle.clearCache(classLoader);
        //Clear the introspection cache for the given ClassLoader
        CachedIntrospectionResults.clearClassLoader(classLoader);
    }
```
* [对org.springframework.beans.CachedIntrospectionResults的再次解读](http://dennis-zane.iteye.com/blog/94235)


### spring

* [AnnotationConfigApplicationContext的实例化过程](https://blog.csdn.net/chr1sgong/article/details/79083770)
* [如何利用AnnotationConfigApplicationContext这个容器创建对象](https://www.cnblogs.com/1540340840qls/p/6951774.html)

