import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Request {
    public static Request parse(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        parseReadLine(is);

        Request request = Request.parse(is);


    }

    private static void parseReadLine(BufferedReader reader) throws IOException {


        String line =  reader.readLine();
        String[] fragments = line.split(" ");
        String method = fragments[0];
        String url = URLDecoder.decode(fragments[1],"UTF-8");
        String protocol =fragments[2];
        Map<String,String> requestParams = new HashMap<String, String>();
        String[] qFrgements = line.split("\\?");
        url = qFrgements[0];
        if(qFrgements.length > 1) {
            for (String kv : qFrgements[1].split("&")) {
                String[] keyValue = kv.split("=");
                String key = keyValue[0];
                String value = "";
                if (keyValue.length > 1) {
                    value = URLDecoder.decode(keyValue[1], "UTF-8");
                }
                requestParams.put(key, value);
            }
        }
    }

    private void setMethod(String method) throws IOException {

    }

    private void setUri(String url) throws UnsupportedEncodingException {
        String[] fragments =url.split("\\?");
        this.url =URLDecoder.decode(fragments[0],"UTF-8");

    }



    private static void parseRequestHeaders(BufferedReader reader,Request request) throws IOException {
        while (!reader.readLine().isEmpty()&&reader.readLine().length()!=0) {
            String[] fragments = reader.readLine().split(":");
            String key = fragments[0].trim();
            String value = fragments[1].trim();
            request.setHerder(key,value);
        }
    }

    private void setHerder(String key, String value) {

    }


}
