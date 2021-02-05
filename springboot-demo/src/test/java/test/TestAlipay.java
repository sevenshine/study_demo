package test;

import com.alipay.api.CertAlipayRequest;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;

public class TestAlipay {
	@Test
	public void test1() throws AlipayApiException{
		CertAlipayRequest certAlipayRequest   =   new   CertAlipayRequest ();
		certAlipayRequest . setServerUrl ( "https://openapi.alipaydev.com/gateway.do" );
		certAlipayRequest . setAppId ( "2021000117608262" );
		certAlipayRequest . setPrivateKey ( "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDL+BI+OwXdxT9hK5BoUzuq3Nzu2fVgkmf8J4ysWOajK2fUpfRPGWrb49UyPwzvJcniKq442NMRorvrnBlOg8qTOUjGyWTjtiMBKLFgFNUlW3RFJGOP2mnL3UeUk8mFftRy0wtw3Y64a75Z9p/e3owF4jA2NAWevZ6YXPohD82x/cVTlBlVb+0PG6+L8Pt6enf1UITUNOUA+C00rtJ870XFFowWhdsPOKBk31PXAKgziVbULALhPxF/IMR79C9ahsJeshilPD+pErp0Uw6fuEHnV1C2wtOQlOenOSAsWNHSVg2sUscKWrIg0dpLZ3e3UfUaHRJZ88Wekvp84D3GFLlxAgMBAAECggEAUV+c15rwkjN5P6kDqbtbGKWYtunZzTdbqOuWYcPt77cHa3zx5QS87xEMI0moPViUHFjuvNs0CdskobDbH8nQbb/y2uvKBlbJzFKRwUVOa+L6lgMYfXGjt6OGRS5YvZuF4nF0JQkfQVAq1vVffqjGsCo3FcjXXSdFOIAPglUtuQ5QGgUNhH4Z8WkdrH+VWsCIbT06F8ZSgRUHXTDJ+0TMxJg67w/TohgddGzsjGq0els8y8EEHRPs2sgPEwEswYZey5fp+BvrDOnN38mT5/52sn5eMjPo1yz8kmhq4Mw5+YBK4WVxnTqdpne4sQQ3pBR+mSmCdAJNkvoTv8c+448GSQKBgQD7gX/viSabdMiJZcbIVspyo+9JrOmfUw/aYNR3qT/c3r6kXzM5LUZ3fhH+w2GwZkWDVGXcAMx9bMdU7H55vSTB8Wh52945saBfl1ML1E3Q/NoWyfpnCdmwQ1qZwsbp+bfktAFW+WJ9JbOp/Uk2FDRvwM7rq/YaeJyBsm3PoB64rwKBgQDPnR3mdXFDMevDYSd1rUs4CdRNsCup3lHUL7ZU1YmxnW20dNpUyaWO3I6KsxZaT2l4w6/8ZtdAfMA5lL6d6c07QKwLoAKuDaULwS3MJPtX+nA3gr5ULMCLlJ6dgfVvZdfTiQdKAt42a169hpq3INorqkH0fqwrwKquWZWN8S/33wKBgBcxzjatE15q2sOxGzAGsQz5iWvmAnWrF18wZufSOA2KjVJjZTn0rvb+LXKtWikGhYqjEfHEMRewHIH8fX2EsAsi1FvIpyny87NdJU+F+Nc5OnO3lNxD0EutKoHbsLSLTyZMY4M95JNeEr+umD3ghyV3Rp39cejnDqf3aKEpRywJAoGBAJ0a3vp7GsdnampCBbM1/LqeLYrQamoz8yYnKMmPgY/nepHY7zLEGMU/v5nTpXGXsE+TfYP5ap/BB1FLbudeelCBQu/VGNIPPzri5z4ZKh3MRMis5kwaRWYag+Da7BhtL+JCSkLGYtM5csrmpgM4GAB86UYT6UN+m2ouHk74GX1vAoGAAqXvRlQpjIedLGFq+ylojdrhOh87pglKtNFSwnXpXlFuyUtBPmUSXOBJmW/SI6afi2mWCAJNJnMVuaWHx8j6gi3fxTF8hycJaRQrqVCKRb8wpi17fD40CgOtzf7VPo0RIyp0PweTcKSztA7e2tGuZ+kEt37kqBv4eCSJPxiMIII=");
		certAlipayRequest . setFormat ( "json" );
		certAlipayRequest . setCharset ( "utf-8" );
		certAlipayRequest . setSignType ( "RSA2" );
		certAlipayRequest . setCertPath ( "E:/csrkey/testcsr/appCertPublicKey_2021000117608262.crt" );
		certAlipayRequest . setAlipayPublicCertPath ( "E:/csrkey/testcsr/alipayCertPublicKey_RSA2.crt" );
		certAlipayRequest . setRootCertPath ( "E:/csrkey/testcsr/alipayRootCert.crt" );
		DefaultAlipayClient   alipayClient   =   new   DefaultAlipayClient ( certAlipayRequest );
		AlipayFundTransUniTransferRequest   request   =   new   AlipayFundTransUniTransferRequest ();
		request . setBizContent ( "{\"out_biz_no\":\"ALI202102010008001\","
				+ "\"payee_info\":{\"identity\":\"jcgtgb6840@sandbox.com\","
				+ "\"identity_type\":\"ALIPAY_LOGON_ID\",\"name\":\"jcgtgb6840\"},"
				+ "\"product_code\":\"TRANS_ACCOUNT_NO_PWD\",\"trans_amount\":\"0.02\",\"biz_scene\":\"DIRECT_TRANSFER\"}");
		AlipayFundTransUniTransferResponse   response   =   alipayClient . certificateExecute ( request );
		if ( response . isSuccess ()){
			System . out . println ( "调用成功" );
		}  else  {
			System . out . println ( "调用失败" );
		}
	}



	@Test
    public void testAli(){
    	String bizContentJson="{\"out_biz_no\":\"ALI202102010008001\","
    			+ "\"payee_info\":{\"identity\":\"jcgtgb6840@sandbox.com\","
    			+ "\"identity_type\":\"ALIPAY_LOGIN_ID\",\"name\":\"jcgtgb6840\"},"
    			+ "\"product_code\":\"TRANS_ACCOUNT_NO_PWD\",\"trans_amount\":\"0.020000\"}";
    	
    	//应用id
    	String appId = "2088821584041050";
    	String appId2 = "2021002127681081";
    	String appId3 = "2021000117608262";

    	//Test
    	//银行私钥
    	String privateTestKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDL+BI+OwXdxT9hK5BoUzuq3Nzu2fVgkmf8J4ysWOajK2fUpfRPGWrb49UyPwzvJcniKq442NMRorvrnBlOg8qTOUjGyWTjtiMBKLFgFNUlW3RFJGOP2mnL3UeUk8mFftRy0wtw3Y64a75Z9p/e3owF4jA2NAWevZ6YXPohD82x/cVTlBlVb+0PG6+L8Pt6enf1UITUNOUA+C00rtJ870XFFowWhdsPOKBk31PXAKgziVbULALhPxF/IMR79C9ahsJeshilPD+pErp0Uw6fuEHnV1C2wtOQlOenOSAsWNHSVg2sUscKWrIg0dpLZ3e3UfUaHRJZ88Wekvp84D3GFLlxAgMBAAECggEAUV+c15rwkjN5P6kDqbtbGKWYtunZzTdbqOuWYcPt77cHa3zx5QS87xEMI0moPViUHFjuvNs0CdskobDbH8nQbb/y2uvKBlbJzFKRwUVOa+L6lgMYfXGjt6OGRS5YvZuF4nF0JQkfQVAq1vVffqjGsCo3FcjXXSdFOIAPglUtuQ5QGgUNhH4Z8WkdrH+VWsCIbT06F8ZSgRUHXTDJ+0TMxJg67w/TohgddGzsjGq0els8y8EEHRPs2sgPEwEswYZey5fp+BvrDOnN38mT5/52sn5eMjPo1yz8kmhq4Mw5+YBK4WVxnTqdpne4sQQ3pBR+mSmCdAJNkvoTv8c+448GSQKBgQD7gX/viSabdMiJZcbIVspyo+9JrOmfUw/aYNR3qT/c3r6kXzM5LUZ3fhH+w2GwZkWDVGXcAMx9bMdU7H55vSTB8Wh52945saBfl1ML1E3Q/NoWyfpnCdmwQ1qZwsbp+bfktAFW+WJ9JbOp/Uk2FDRvwM7rq/YaeJyBsm3PoB64rwKBgQDPnR3mdXFDMevDYSd1rUs4CdRNsCup3lHUL7ZU1YmxnW20dNpUyaWO3I6KsxZaT2l4w6/8ZtdAfMA5lL6d6c07QKwLoAKuDaULwS3MJPtX+nA3gr5ULMCLlJ6dgfVvZdfTiQdKAt42a169hpq3INorqkH0fqwrwKquWZWN8S/33wKBgBcxzjatE15q2sOxGzAGsQz5iWvmAnWrF18wZufSOA2KjVJjZTn0rvb+LXKtWikGhYqjEfHEMRewHIH8fX2EsAsi1FvIpyny87NdJU+F+Nc5OnO3lNxD0EutKoHbsLSLTyZMY4M95JNeEr+umD3ghyV3Rp39cejnDqf3aKEpRywJAoGBAJ0a3vp7GsdnampCBbM1/LqeLYrQamoz8yYnKMmPgY/nepHY7zLEGMU/v5nTpXGXsE+TfYP5ap/BB1FLbudeelCBQu/VGNIPPzri5z4ZKh3MRMis5kwaRWYag+Da7BhtL+JCSkLGYtM5csrmpgM4GAB86UYT6UN+m2ouHk74GX1vAoGAAqXvRlQpjIedLGFq+ylojdrhOh87pglKtNFSwnXpXlFuyUtBPmUSXOBJmW/SI6afi2mWCAJNJnMVuaWHx8j6gi3fxTF8hycJaRQrqVCKRb8wpi17fD40CgOtzf7VPo0RIyp0PweTcKSztA7e2tGuZ+kEt37kqBv4eCSJPxiMIII=";
		//银行公钥
    	String publicTestKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy/gSPjsF3cU/YSuQaFM7qtzc7tn1YJJn/CeMrFjmoytn1KX0Txlq2+PVMj8M7yXJ4iquONjTEaK765wZToPKkzlIxslk47YjASixYBTVJVt0RSRjj9ppy91HlJPJhX7UctMLcN2OuGu+Wfaf3t6MBeIwNjQFnr2emFz6IQ/Nsf3FU5QZVW/tDxuvi/D7enp39VCE1DTlAPgtNK7SfO9FxRaMFoXbDzigZN9T1wCoM4lW1CwC4T8RfyDEe/QvWobCXrIYpTw/qRK6dFMOn7hB51dQtsLTkJTnpzkgLFjR0lYNrFLHClqyINHaS2d3t1H1Gh0SWfPFnpL6fOA9xhS5cQIDAQAB";
    	//阿里公钥
		String alipayTestPublicKey = "MIIDszCCApugAwIBAgIQICECAtRasw1JPOK1AyapxTANBgkqhkiG9w0BAQsFADCBkTELMAkGA1UEBhMCQ04xGzAZBgNVBAoMEkFudCBGaW5hbmNpYWwgdGVzdDElMCMGA1UECwwcQ2VydGlmaWNhdGlvbiBBdXRob3JpdHkgdGVzdDE+MDwGA1UEAww1QW50IEZpbmFuY2lhbCBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eSBDbGFzcyAyIFIxIHRlc3QwHhcNMjEwMjAyMDcwNzE4WhcNMjQwMjAxMDcwNzE4WjCBhDELMAkGA1UEBhMCQ04xHzAdBgNVBAoMFnVtc290Yzg3MjVAc2FuZGJveC5jb20xDzANBgNVBAsMBkFsaXBheTFDMEEGA1UEAww65pSv5LuY5a6dKOS4reWbvSnnvZHnu5zmioDmnK/mnInpmZDlhazlj7gtMjA4ODYyMTk1NTIzOTMxNDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBk6JKCTVaPoC12MVJ9PMZdBpjTABw3OgIYBMkrPlOMXLHnslk6MvscfPzVyzh8b2TiHQQIOtF7z7YvPm0nHEFuehel4lz0fK01RfdU+4rAOBqldP+MxaQNC2Ahc1d1NwEJEqw+7a/bqG8okuX2J6JbOYLRT2ytXULBddAUE5EgctvHYfaFL+ebHtfkhnw78qRquRtDsJ0+QfGTGU/gcdTURRZZVMzighaJ3rXSzwJZKcF/xKI5dpsh3au/5/rPVQDHqATKjsYAAjZA5qwVt54cW8nw5WthCgCMq/7dTIr029CdpoA/wol9d5UzjtCqnmI4LnqtsrRZbmX+G8xBwZsCAwEAAaMSMBAwDgYDVR0PAQH/BAQDAgTwMA0GCSqGSIb3DQEBCwUAA4IBAQA3bI6LlFd+5WTsSNKkt/HgzWhL6x0baqoxA2iynWkAwPcbjfucCtcQFPjBJGh1zxWQhw/2dyovNR/QCqUOHUGT7pYmtpCcRhtKnYUkRqmfeuPWlqAYpAWiKA6ZGkideJRwUfiGTv7F07LRWCPYLSeWfA4RJ9wE0OxWES1/oBopYSoSdJzaJMRy1wGnYypmTOdLTAomA6kQEGB2F4/hz0VmoHLWvlocTAcgIqLSZBCUwzrzFeBcRy8WJk6SIioei/VGs1DzjLYXjyTnjg3uBAdQTShtrgBPmX1bDxTBpHuw58QxDqJJsrlZoWXrXoGyCMOYySaUuPf4cgRR82mrfdO7\n";

    	String gateWay="https://openapi.alipay.com/gateway.do";
    	String gateWay2="https://openapi.alipaydev.com/gateway.do";
    	
    	//ali sdk方式发送数据到对端
		AlipayClient alipayClient = new DefaultAlipayClient(gateWay2, appId3, privateTestKey,"json","utf-8", alipayTestPublicKey,"RSA2");
		AlipayFundTransUniTransferRequest alipayFundTransUniTransferRequest = new AlipayFundTransUniTransferRequest();
		alipayFundTransUniTransferRequest.setBizContent(bizContentJson);

		AlipayFundTransUniTransferResponse alipayFundTransUniTransferResponse=null;
		try {
			alipayFundTransUniTransferResponse = alipayClient.execute(alipayFundTransUniTransferRequest);
		} catch (AlipayApiException e) {
			e.printStackTrace();
			System.out.println("阿里sdk调用网关失败。");			
		}
		
		System.out.println(alipayFundTransUniTransferResponse.toString());
		System.out.println(alipayFundTransUniTransferResponse.getBody());
		System.out.println(alipayFundTransUniTransferResponse.getStatus());
		System.out.println(alipayFundTransUniTransferResponse.isSuccess());
		
		if(alipayFundTransUniTransferResponse != null && alipayFundTransUniTransferResponse.isSuccess()) {
			System.out.println("阿里sdk调用网关成功。");
			String alipayFundTransUniTransferResponseJson = JSONObject.toJSONString(alipayFundTransUniTransferResponse);
			
			System.out.println("对端应答业务数据：{}"+alipayFundTransUniTransferResponseJson);
			
			String status = alipayFundTransUniTransferResponse.getStatus();
			System.out.println("业务status:{}"+status);
			
		//发送网关失败	
		}else {
			System.out.println("阿里sdk调用网关失败。");			

		}
	}
}
