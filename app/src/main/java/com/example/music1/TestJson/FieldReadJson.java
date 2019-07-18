package com.example.music1.TestJson;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.music1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by 李利红 on 2019/5/29.
 */

public class FieldReadJson extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_myjson);

//        try {
//            //打开Myjson,并且将读取文本的编码设置成了UTF-8
//            InputStreamReader isr = new InputStreamReader(getAssets().open("Myjson.json"),"UTF-8");
//            //包装InputStreamReader
//            BufferedReader br = new BufferedReader(isr);
//            //读取文本中的所有数据到builder中
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while ((line = br.readLine())!=null){
//                builder.append(line);
//            }//while循环完后说明这个数据读取完了
//            //关闭BufferedReader,InputStreamReader
//            br.close();
//            isr.close();
//            //创建一个JSONObject
//            JSONObject root = new JSONObject(builder.toString());
//            //可以直接使用get+数据类型的方式，然后指定它的键就可以获得对应的数据了
//            System.out.println("cat="+root.getString("cat"));
//
//            //处理JSON中的数组                            直接指定JSON的键名，就可以返回回来JSON数组
//            JSONArray array = root.getJSONArray("employees");
//            //创建一个for循环，将数组中的内容循环的输出
//            for (int i=0;i<array.length();i++){
//                //因为每一个数组中的元素也是一个新的JSON的对象
//                JSONObject lan = array.getJSONObject(i);
//                System.out.println("………………………………");
//                System.out.println("id="+lan.getInt("id"));
//                System.out.println("firstName="+lan.getString("firstName"));
//                System.out.println("lastName="+lan.getString("lastName"));
//
//
//            }
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }



        JSONObject root = new JSONObject();
        //传入键值对
        try {


            //
            JSONObject lan1 = new JSONObject();
            //为lan1添加属性
            lan1.put("id",1);
            lan1.put("ide","Eclipse");
            lan1.put("name","java");
            //
            JSONObject lan2 = new JSONObject();
            //为lan1添加属性
            lan2.put("id",2);
            lan2.put("ide","Xcode");
            lan2.put("name","Swift");

            JSONObject lan3 = new JSONObject();
            //为lan1添加属性
            lan3.put("id",3);
            lan3.put("ide","Visual Studio");
            lan3.put("name","C#");
            //创建一个JSO数组
            JSONArray array = new JSONArray();
            array.put(lan1);
            array.put(lan2);
            array.put(lan3);
            //root在put的时候需要为数组指定一个键，因为对于数组来说，它的数组内容是它的值
            //它的value就是array
            root.put("language",array);/////////////////////////////////////////
            //为root添加属性
            root.put("cat","it");///////////////////////////////////////
            System.out.println(root.toString());//将他转化为可见的文件
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
