## HttpRequest and convert Json Response data

代码示例路径：com.rootrl.androidsamples.HttpRequestActivity

#### 服务端返回的JSON数据结构

```
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

#### 配置Json数据对应的Gson类

配置对应的Gson类主要根据数据的层级来，比如我们这里有三个层级：最外层的主体数据，data数据层，adList数据层。

于是我们很容易定义对应的类：

Class Ad

```java
public class Ad {
    public int status;

    @SerializedName("message")
    public String message;

    public Data data;
}

```

Class Data

```java
public class Data {
    public int count;

    public List<AdItem> adList;
}
```

Class AdItem

```java
public class AdItem {
    public int type;

    public String src;

    public String date;
}
```

### 封装Htttp请求

首先我们封装个Http请求方法

```java
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback)
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(address).build();

        client.newCall(request).enqueue(callback);
    }
}
```

#### 发起请求以及解析数据

代码示例：

```java
        HttpUtil.sendOkHttpRequest("http://45.76.152.173:8080/test", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: =====================" );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, "onResponse: =======================" );

                String responseText = response.body().string();

                Log.e(TAG, "onResponse: " + responseText );

                // 解析Json
                try {
                    JSONObject jsonObject = new JSONObject(responseText);

                    String weatherContent = jsonObject.toString();

                    Ad ad =  new Gson().fromJson(weatherContent, Ad.class);

                    Log.e(TAG, "onResponse: status" + ad.status );

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
```
