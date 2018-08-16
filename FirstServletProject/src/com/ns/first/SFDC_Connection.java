package com.ns.first;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SFDC_Connection {
	public static void main(String[] args) {

		try {
			OkHttpClient client = new OkHttpClient.Builder().connectTimeout(300, TimeUnit.SECONDS).readTimeout(300, TimeUnit.SECONDS).writeTimeout(300, TimeUnit.SECONDS).build();

			RequestBody formBody = new FormBody.Builder().add("username", "los.crm@ltfs.com.los")
					.add("password", "Welcome@1234")
					.add("client_id",
							"3MVG959Nd8JMmavTHb0IytJHhF3CC4fyxoJ8OXds3GYznG_7gqBW3Z5snEV7ukDv7Ni74v.rV55QNhW8jtVDy")
					.add("client_secret", "1379156177461925385").add("grant_type", "password").build();

			Request request = new Request.Builder().url("https://test.salesforce.com/services/oauth2/token")
					.post(formBody).addHeader("Content-type", "multipart/form-data").build();

			Response response = client.newCall(request).execute();
			InputStream is = response.body().byteStream();

			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			StringBuffer res = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();

			// print result
			 System.out.println("FINAL Resonse " + res.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
