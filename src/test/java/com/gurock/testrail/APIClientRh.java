package com.gurock.testrail;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.*;

/**
 * Created by Kalinin.S on 22.11.2016.
 */
public class APIClientRh extends APIClient {
    public APIClientRh(String base_url) {
        super(base_url);
    }

    @Override
    protected Object sendRequest(String method, String uri, Object data) throws IOException, APIException {
        {
            URL url = new URL(this.m_url + uri);

            // Create the connection object and set the required HTTP method
            // (GET/POST) and headers (content type and basic auth).
            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("inetav51",8080));
            Authenticator authenticator = new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication("corp\\beshkomy",
                            "Abc876".toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection(proxy);
            conn.addRequestProperty("Content-Type", "application/json");

            String auth = getAuthorization(this.m_user, this.m_password);
            conn.addRequestProperty("Authorization", "Basic " + auth);

            if (method == "POST")
            {
                // Add the POST arguments, if any. We just serialize the passed
                // data object (i.e. a dictionary) and then add it to the
                // request body.
                if (data != null)
                {
                    byte[] block = JSONValue.toJSONString(data).
                            getBytes("UTF-8");

                    conn.setDoOutput(true);
                    OutputStream ostream = conn.getOutputStream();
                    ostream.write(block);
                    ostream.flush();
                }
            }

            // Execute the actual web request (if it wasn't already initiated
            // by getOutputStream above) and record any occurred errors (we use
            // the error stream in this case).
            int status = conn.getResponseCode();

            InputStream istream;
            if (status != 200)
            {
                istream = conn.getErrorStream();
                if (istream == null)
                {
                    throw new APIException(
                            "TestRail API return HTTP " + status +
                                    " (No additional error message received)"
                    );
                }
            }
            else
            {
                istream = conn.getInputStream();
            }

            // Read the response body, if any, and deserialize it from JSON.
            String text = "";
            if (istream != null)
            {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                istream,
                                "UTF-8"
                        )
                );

                String line;
                while ((line = reader.readLine()) != null)
                {
                    text += line;
                    text += System.getProperty("line.separator");
                }

                reader.close();
            }

            Object result;
            if (text != "")
            {
                result = JSONValue.parse(text);
            }
            else
            {
                result = new JSONObject();
            }

            // Check for any occurred errors and add additional details to
            // the exception message, if any (e.g. the error message returned
            // by TestRail).
            if (status != 200)
            {
                String error = "No additional error message received";
                if (result != null && result instanceof JSONObject)
                {
                    JSONObject obj = (JSONObject) result;
                    if (obj.containsKey("error"))
                    {
                        error = '"' + (String) obj.get("error") + '"';
                    }
                }

                throw new APIException(
                        "TestRail API returned HTTP " + status +
                                "(" + error + ")"
                );
            }

            return result;
        }
    }
}
