package com.example.android.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    /** Create a function to get EarthquakeData from the website */
    public static List<Quake> fetchEarthquakeData(String RequestUrl)
    {
        String JsonResponse=null;
        try{
        URL url = new URL(RequestUrl);
        JsonResponse=makeHttpRequest(url);
    }
        catch (Exception e)
        {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }
        return extractEarthquakes(JsonResponse);
    }

        /** This function is responsible to send the http request create the connection and get input stream from the API*/
     public static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse="";
        if (url == null) {
            return null;
        } else {
            HttpsURLConnection urlConnection = null;
            InputStream inputStream=null;
            try {
                urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                if (urlConnection.getResponseCode() == 200) {
                        inputStream= urlConnection.getInputStream();
                        jsonResponse=readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG,"Error Response Code : "+ urlConnection.getResponseCode());
                }
            } catch (IOException e ) {
                Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) inputStream.close();
            }
            return jsonResponse;
        }
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Return a list of {@link Quake} objects that has been built up from
     * parsing a JSON response.
     */
    public static List<Quake> extractEarthquakes(String JSON_RESPONSE) {

        // Create an empty ArrayList that we can start adding earthquakes to
        List<Quake> earthquakes = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            //Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Earthquake objects with the corresponding data.
           JSONObject jsonObject = new JSONObject(JSON_RESPONSE);
          JSONArray features =  jsonObject.getJSONArray("features");
          for( int i =0;i<features.length();i++)
          {
              JSONObject quake = features.getJSONObject(i);
              JSONObject properties = quake.getJSONObject("properties");
              Long date = properties.getLong("time");
              double magnitude = properties.getDouble("mag");
              earthquakes.add(new Quake( magnitude, properties.getString("place"),date,properties.getString("url")));

          }


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

}
