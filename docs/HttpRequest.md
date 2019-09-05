## HttpRequest and convert Json Response data

#### 服务端返回的JSON数据结构

```json

{
        status: 0,
        message: "Data request ok",
        data: {
            count: 3,
            adList: [
            {
                type: 1,
                src: "http://baidu.com",
                date: "2018-09-15"
            },
            {
                 type: 2,
                 src: "http://baidu.com",
                 date: "2018-09-16"
            },
            {
                type: 3,
                src: "http://baidu.com",
                date: "2018-09-11"
            }
            ]
        }
}

```

#### 引入Gson

Link: https://github.com/google/gson

Gradle 配置引入:

```bash
dependencies {
  implementation 'com.google.code.gson:gson:2.8.5'
}
```

