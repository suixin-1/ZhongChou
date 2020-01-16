package com.yh.pojo.f_common;

import java.io.FileInputStream;
import java.util.UUID;


import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiniuUtils {
	 public  static String qiniu_img_url_pre = "http://q3gkuynyz.bkt.clouddn.com/";
	    public  static String accessKey = "c1Rm_J2Ctj57mCWZa3w6FfDEwAtkv8uon7aWjN5r";
	    public  static String secretKey = "wNwMqw4tZiRBuOsIW3jJuZc3rn9YOrOoMnKaw3gT";
	    public  static String bucket = "likongjian";
	


	
 /**
  * 上传文件
  * @param bytes 文件内容，字节数组
  * @param uploadFileName 保存到服务端的文件名
  */
 public static String upload2Qiniu(byte[] bytes, String uploadFileName){
     //构造一个带指定Zone对象的配置类,Zone.zone0()代表华东地区
     Configuration cfg = new Configuration(Zone.zone1());
     //...其他参数参考类注释
     UploadManager uploadManager = new UploadManager(cfg);


     //默认不指定key的情况下，以文件内容的hash值作为文件名
     String key = uploadFileName;
     Auth auth = Auth.create(accessKey, secretKey);
     String upToken = auth.uploadToken(bucket);
     try {
         Response response = uploadManager.put(bytes, key, upToken);
         //解析上传成功的结果
         System.out.println(response.bodyString());
         // 访问路径
         System.out.println(qiniu_img_url_pre+uploadFileName);
     } catch (QiniuException ex) {
         Response r = ex.response;
         System.err.println(r.toString());
         try {
             System.err.println(r.bodyString());
         } catch (QiniuException ex2) {
             //ignore
             ex.printStackTrace();
         }
     }
	return qiniu_img_url_pre+uploadFileName;
 }
 // 测试上传
 public static void main(String args[]) throws Exception{
     // 测试上传
     String localFilePath = "D:/2.png";
     FileInputStream fileInputStream = new FileInputStream(localFilePath);
     byte[] data = new byte[1024*1024*5];
     fileInputStream.read(data);
     String saveFileName = UUID.randomUUID().toString().replace("-","");
     QiniuUtils.upload2Qiniu(data,saveFileName);
 }
}
