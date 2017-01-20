package com.gurock.testrail;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import ru.dserg.autotest.Utils.Util;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kalinin.S on 20.09.2016.
 */
public class DDtestrail {
    private  boolean startTestreil;
    public DDtestrail(int projectId,int testSuitId,boolean isDD) throws IOException {
        if (isDD)
        this.client = new APIClient("http://testrail.digdes.com/testrail/");
        else
        this.client = new APIClientRh("http://testrail.digdes.com/testrail/");
        try {
            client.setUser(Util.loadProperty("user"));
            client.setPassword(Util.loadProperty("password"));
            startTestreil=Boolean.getBoolean(Util.loadProperty("startTestrail"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.projectId = projectId;
        this.testSuitId = testSuitId;
    }

    private APIClient client ;
    private int projectId;
    private int testSuitId;


    public void  completeTest(HashMap dadaTest,HashMap dataError,String name) throws IOException, APIException {
       //(new SSLTool()).disableCertificateValidation();
        if (!startTestreil) return;

        Map data = new HashMap();

        int i = 0;
        JSONArray arr = new JSONArray();
        data.put("suite_id", testSuitId);
        data.put("name",name);
        JSONObject s = null;
        try {
            s = (JSONObject)client.sendPost("add_run/"+projectId,data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }



        String runId= s.get("id").toString();
        JSONArray testlist = null;
        try {
            testlist = (JSONArray) client.sendGet("get_tests/"+runId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }



        for (Object o: testlist){
            Map testcase = new HashMap();
            testcase.put("test_id",((JSONObject) o).get("id"));
            testcase.put("status_id",dadaTest.get(i));
            testcase.put("comment",dataError.get(i));
            //testcase.put("comment":);
            arr.add(testcase);
            i++;
        }


        HashMap dataFinal=new HashMap();
        dataFinal.put("results",arr);
        client.sendPost("add_results/"+runId,dataFinal);




    }
}
