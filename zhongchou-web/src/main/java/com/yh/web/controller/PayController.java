package com.yh.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

@Controller
public class PayController {
	private final String APP_ID = "2016101700709563";
    private final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgCXAzXfsEGxy7iF1RIZdcdiLrd7IMr+/GdUDd5SJOOtWhkuQ4qm+eLDV2/qSCi3RRLoaEbqg8J22OqvMZQi0UEV4uFy0g/CKvGQPwLcl1oA5pJ14Oc1LTyc+DbUf1TJngzenJyHHxz1Nzln/g7y7ANs8yS+1HE7sQ+fKJUeZnPStHvi7oGzvJ0dqjhuYudMBS/RYhhYH/XOqi1Zx+37scHVjyPlbxx1k+SIMWXPtcCRF6eNt2qFilj+pPiMFqc4DCIy8TwZyiv9o/wvJktehJ0HrBBLG9yr70Fr+FyBb+qWOfPxsmzniBzYP4ghIvhXEV2UKhLkxTV0QK6bU4JgvzAgMBAAECggEAUd7iNnUSsDQKi+mkC5hKrbOGA731KUZsPLPJXnsVBL5WgdT6yf5vIZTuORTmJh6ff9R0XpWZnURyaLUNrlNLamPEMYILxT8Xo0oB2MIjuPgLx0GrfWsD6XLppQun71ajtfzBaEgR+qmcwJoyi2jxGsYvU0TCe0Udwv6LVDLA0vkHduBjbSzCUdeGUKgHld0IDTxZBixHfYAT1dMIfyvMsejHl1kSxCi69m+9qUkzRt9yDyZvih7fxbllW5X6TD9qJ8cCzdp1WAjKGlY2PD9ZjtLyzjVmb/zBp4PMx2gJBCGhPT8hHTJ0epT+fubBJUKQdSv5K2OnmpANPhrIXLoQeQKBgQDsHtGeOyZczH/FNC7izEq3OTTHjuhxGhQFUKu+jiTJ+R5tiJbjRQSeT+Uk/cSETxGg82oRo7DtNvPbXfVTpFyX/j89IBktYSO7TzBRu9nthwIoNDuYYlqNIITibyUmgbQRiXLEhWb417HUt0O2PD4oc6Ezr0HnUxV9M/kX5iICrwKBgQCtgsQf3rtZGBO80HlfGI1MqprCJEit9GoMEpMwwzZCLQpoSuZ7sMP9OPe6LIxtTpjTr+G5p7r4GU2QOvt7AyN7Z/ip7vmtH8SHEOJmfOGV6HvkFYADcKAsDUTRW8dR6uYdgdEVw2TQPEYGCtSDfM5eMOsI/IfZOKvxsIpDTMor/QKBgAY5yc0iQiCwQ64vcg0I1e9+0qVwXzCcP2rkdaLQnKe2qda5g0D60ORbtu8Cweu7KfvUbzeH2WJn0IY4M//AlbBsQ76Y2hEYPpjxvZRqH5TjumrU9b1O2pReByLxS0l4ogbUWPJVkiF9jnLNYjur2ve2FMoIFPTEfAyREkBPERaBAoGAZd273yoYu7nS/Ks4VohHjJcsvIYo1VgFWokdOSeilz9yOMCgiEXDCsuDRR4aY6IdP0qnLyQ2NKpGS0MVmabCEhV8e+f9VZKtAs763Ei8+BHBiqrEuUBKCRLRMEi9wG40I2avpiNM8KQySCHbmkaPseTuWBxKdVE8QWzv/4r5ttECgYA1fAZxMNSeI2+Zv8+H4AekiY6Gt6kfU1K+xU1iBqUL0D65VEnVelM8yNYRK2d20w9KS0rgv6rzuE+o/7Nbdd999+5NRFwLshZM0Xenam4hyq7p7iDueblw7/nTPun4Z5pVFWVKqB45WvBoPyotss7uG15+PfP3mXR0qsIPiGnp4Q==";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkGur4BjClN3gI+8pIlXfbReucxgopMzWLGpdF/SxX90ZTNwazXz3p1lR/ZTebpi5U4HYcWXrQSIqXW0uJpsUG/uaOK3YB1MELJn0So2KGRrvRh2TPBKNp1FtkoLjR4WNCEX6SRi+bpbUiTfE9tR6JkaehwANUabvS9eBfV/YlaaXTV7r+GjwkS9O34c/9wUXJbGzFsSEHldBvoxnSBhqDVyvmtmEod4QZ8xQfHgMmkwdLn7GV8emyyApqX9DDd42TdoFVdr9j1Sx6u8Se/XjlkbW51jIrmvUOwQS4LBuaeW3oBIHAXjFi2mqYcMtwHdGhMbvwajgxj/jARcbOo0SRwIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://127.0.0.1:8081/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://127.0.0.1:8081/returnUrl";
    @RequestMapping("alipay")
  
    public void alipay(HttpServletResponse httpResponse) throws IOException {

        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(5);
       // r.nextInt(9)
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("付款金额=" + total_amount);

            //支付成功，修复支付状态
//            payService.updateById(Integer.valueOf(out_trade_no));
            return "ok";//跳转付款成功页面
        } else {
            return "no";//跳转付款失败页面
        }

    }
    
    
/*    @RequestMapping("/alipay")
    public void alipay(HttpServletResponse httpResponse,HttpServletRequest req) throws IOException {
       // Object userId = req.getSession().getAttribute("userId");
       // Object courseId= req.getSession().getAttribute("courseId");
        //int tt=Integer.parseInt(String.valueOf(courseId));
       // EduCourse course = eduCourseService.ses(tt);
      //  String a = course.getCurrentPrice().toString();
        Random r=new Random();
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = UUID.randomUUID().toString();
        //付款金额，必填
        String total_amount =Integer.toString(5);
       // r.nextInt(9)
        //订单名称，必填
        String subject ="奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        //商品描述，可空
        String body = "尊敬的会员欢迎购买奥迪A8 2016款 A8L 60 TFSl quattro豪华型";
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
       // req.getSession().setAttribute("courseId",courseId);
       // req.getSession().setAttribute("userId",userId);
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);
            Object userId = request.getSession().getAttribute("userId");
            Object courseId = request.getSession().getAttribute("courseId");
            int tt=Integer.parseInt(String.valueOf(userId));
            int ttt=Integer.parseInt(String.valueOf(courseId));
            //eduCourseService.insertAdd(tt,ttt);
            System.out.println(ttt);

            return "www.baidu.com";//跳转付款成功页面
        }else{
            return "no";//跳转付款失败页面
        }
    }
    */
    
}