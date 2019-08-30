package com.rootrl.androidsamples.Data;

import com.rootrl.androidsamples.R;

import java.util.ArrayList;

public class DataUtils {

    private static ArrayList<Data> datas = new ArrayList<>();

    static {
        for (int i = 0; i < 100; i++) {
            Data data = new Data();
            data.setNum("number is " + i);
            data.setTime("2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx2016-01-01 xxx" + i);

            data.setResImage(R.drawable.ic_launcher_background);
            datas.add(data);
        }
    }


    public static ArrayList<Data> getDatas() {
        return datas;
    }

    public static void setDatas(ArrayList<Data> datas) {
        DataUtils.datas = datas;
    }
}