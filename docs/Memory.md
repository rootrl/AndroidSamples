# 内存相关

#### 获取APP运行的最大内存
```java
int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
Log.d("TAG", "Max memory is " + maxMemory + "KB");
```

#### 查看和修改APP运行内存
https://blog.csdn.net/weixin_34128411/article/details/91423593


#### 性能优化
https://www.jianshu.com/p/a5d022f01ee0


#### 加载大图片优化
https://blog.csdn.net/guolin_blog/article/details/9316683


#### LRU Cache算法
https://blog.csdn.net/guolin_blog/article/details/28863651

#### 性能最佳实践
https://blog.csdn.net/guolin_blog/article/details/42238627