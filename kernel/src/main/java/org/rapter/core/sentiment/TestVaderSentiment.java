package org.rapter.core.sentiment;

import com.algorithmia.APIException;
import com.algorithmia.AlgorithmException;
import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import com.algorithmia.algo.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.rapter.core.RapterKernelRuntime;
import org.rapter.core.VaderResultUnit;
import org.rapter.core.config.KernelConfiguration;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Pubudu Dissanayake on 1/22/16.
 * Project : sentiment-engine
 */
public class TestVaderSentiment {

    public static String run(Properties properties, String input){
        AlgorithmiaClient client = Algorithmia.client(properties.getProperty("ALOGORITHMIA_API_KEY"));
        Algorithm algo = client.algo(properties.getProperty("ALOGORITHMIA_API_NAME"));
        VaderResultUnit vaderResultUnit ;
        ObjectMapper mapper = new ObjectMapper();
        String prettyPrinter = null;

        AlgoResponse result = null;
        try {
            result = algo.pipeJson(input);
            String value = result.asJsonString().replace("[","");
            value = value.replace("]", "");
            vaderResultUnit = mapper.readValue(value, VaderResultUnit.class);
            //System.out.println(vaderResultUnit);
            prettyPrinter = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(vaderResultUnit);

        } catch (APIException e) {
            e.printStackTrace();
        } catch (AlgorithmException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prettyPrinter;
    }
    public static void main(String[] args) {

        String input = "{\n"
                + "  \"sentence\": \"This old product sucks! But after the update it works like a charm!\"\n"
                + "  \n"
                + "}";
        RapterKernelRuntime rapterKernelRuntime = new RapterKernelRuntime();
        KernelConfiguration kernelConfiguration = rapterKernelRuntime.getConfiguration();
        Properties properties = kernelConfiguration.getProperties();
        TestVaderSentiment.run(properties,input);
    }
}
